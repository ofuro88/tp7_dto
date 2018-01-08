package com.mydigitalschool.dao_orm.sondage.controllers;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * - contrôleur jetable utilisé pour importer les données en base afin de générer _V1.0.1__donnees.sql
 *
 * - one-shot controller used to import the survey data and generate _V1.0.1__donnees.sql
 */
@RestController
public class RawDataImportController {
    private static final Logger LOGGER = LoggerFactory.getLogger(RawDataImportController.class);

    @Value("classpath:db/sources/environnement_developpement-post_traitements.csv")
    private Resource csvContent;

    @Value("classpath:db/migration/V1.0.0__structure.sql")
    private Resource databaseStructure;

    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @PostMapping("/import")
    public Map<String, Object> importRawData() throws IOException {
        final Map<String, Object> importReport = new HashMap<>();

        rebuildDb();

        try (InputStream csvIS = csvContent.getInputStream()) {
            List<String> csvLines = (List<String>) IOUtils.readLines(csvIS, "UTF-8");
            String[] headers = StringUtils.split(csvLines.get(0), "\t");

            // i = 1 -> skips first column of participant id
            final Map<Integer, Pair<String, Integer>> questionsAndIdsByHeaderRank = IntStream.range(1, headers.length).boxed()
                    .map(headerIndex -> Pair.of(headerIndex, saveHeader(headers[headerIndex])))
                    .collect(Collectors.toMap(Pair::getKey, Pair::getRight));
            importReport.put("questionsAndIdsByHeaderRank", questionsAndIdsByHeaderRank);

            // saves the responses of the participants
            final Map<Integer, Map<String, Integer>> itemWithIdByQuestionId = new HashMap<>();
            csvLines.stream()
                    // skips the headers
                    .skip(1)
                    .map(csvLine -> StringUtils.split(csvLine, "\t"))
                    .forEach(lineCells -> {
                        int participantId = saveParticipant(lineCells[0]);
                        // skips first column of participant id
                        for (int questionIndex = 1; questionIndex < lineCells.length; questionIndex++) {
                            Pair<String, Integer> questionAndId = questionsAndIdsByHeaderRank.get(questionIndex);
                            String question = questionAndId.getKey();
                            int questionId = questionAndId.getValue();

                            // gets the cache of response ids
                            final Map<String, Integer> responsesWithId = itemWithIdByQuestionId.computeIfAbsent(questionId, id -> new HashMap<>());
                            // iterates over the response options of each question, saves the option if unknown, saves the participant responses
                            Arrays.stream(StringUtils.split(lineCells[questionIndex], ","))
                                    .map(StringUtils::trim)
                                    .map(response -> {
                                        int optionId = responsesWithId.
                                                computeIfAbsent(response, responseToCache -> saveQuestionItem(questionId, responseToCache));
                                        LOGGER.debug("option \"{}\" ({}) de question \"{}\" ({})", response, optionId, question, questionId);
                                        return optionId;
                                    })
                                    .forEach(itemId -> saveResponse(participantId, questionId, itemId));
                        }
                    });
            importReport.put("itemWithIdByQuestionId", itemWithIdByQuestionId);
        }

        return importReport;
    }

    private void saveResponse(int participantId, int questionId, Integer itemId) {
        MapSqlParameterSource parameters = new MapSqlParameterSource("participantId", participantId)
                .addValue("questionId", questionId)
                .addValue("itemId", itemId);
        String SQL = "insert into reponse (participant_id, question_id, item_id) values (:participantId, :questionId, :itemId)";
        jdbcTemplate.update(SQL, parameters);
    }

    private Integer saveQuestionItem(int questionId, String itemContentToCache) {
        MapSqlParameterSource parameters = new MapSqlParameterSource("questionId", questionId)
                .addValue("contenu", itemContentToCache);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String SQL = "insert into item (question_id, contenu) values (:questionId, :contenu)";
        jdbcTemplate.update(SQL, parameters, keyHolder);
        return keyHolder.getKey().intValue();
    }

    private int saveParticipant(String pseudo) {
        MapSqlParameterSource parameters = new MapSqlParameterSource("pseudo", pseudo);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String SQL = "insert into participant (pseudo) values (:pseudo)";
        jdbcTemplate.update(SQL, parameters, keyHolder);
        return keyHolder.getKey().intValue();
    }

    private Pair<String, Integer> saveHeader(String question) {
        MapSqlParameterSource parameters = new MapSqlParameterSource("intitule", question);
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String SQL = "insert into question (intitule) values (:intitule)";
        jdbcTemplate.update(SQL, parameters, keyHolder);
        return Pair.of(question, keyHolder.getKey().intValue());
    }

    private void rebuildDb() throws IOException {
        try (InputStream databaseStructureIS = databaseStructure.getInputStream()) {
            jdbcTemplate.batchUpdate(IOUtils.toString(databaseStructureIS), new SqlParameterSource[0]);
        }
    }
}

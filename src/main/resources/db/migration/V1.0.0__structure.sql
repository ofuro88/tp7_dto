USE daoormdto;

DROP TABLE IF EXISTS `reponse` CASCADE;
DROP TABLE IF EXISTS `item` CASCADE;
DROP TABLE IF EXISTS `question` CASCADE;
DROP TABLE IF EXISTS `participant` CASCADE;

CREATE TABLE IF NOT EXISTS `participant` (
    id INTEGER unsigned NOT NULL AUTO_INCREMENT,
    pseudo VARCHAR(512),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `question` (
    id INTEGER unsigned NOT NULL AUTO_INCREMENT,
    intitule VARCHAR(512),
    PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `item` (
    id INTEGER unsigned NOT NULL AUTO_INCREMENT,
    question_id INTEGER unsigned NOT NULL,
    contenu VARCHAR(512),
    PRIMARY KEY (id),
    CONSTRAINT fk_i_q FOREIGN KEY (question_id)
        REFERENCES question(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `reponse` (
    id INTEGER unsigned NOT NULL AUTO_INCREMENT,
    participant_id INTEGER unsigned NOT NULL,
    question_id INTEGER unsigned NOT NULL,
    item_id INTEGER unsigned NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT fk_r_p FOREIGN KEY (participant_id)
        REFERENCES participant(id) ON DELETE CASCADE,
    CONSTRAINT fk_r_q FOREIGN KEY (question_id)
        REFERENCES question(id) ON DELETE CASCADE,
    CONSTRAINT fk_r_i FOREIGN KEY (item_id)
        REFERENCES item(id) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

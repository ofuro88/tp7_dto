# TP sondage

L'objectif du TP est d'utiliser les DataTransferObjects dans l'analyse des résultats d'un sondage.


## Initialiser l'utilisateur et la BDD du TP

**À ne faire qu'une fois** pour créer l'utilisateur MySQL et sa base dédiée au TP.

* se connecter au client MySQL avec l'utilisateur MySQL root:

```bash
mysql -u root -p
```

* créer l'utilisateur et sa base :

```sql
CREATE USER "daoormdtouser"@"localhost";
SET password FOR "daoormdtouser"@"localhost" = password('daoormdtopwd');
CREATE DATABASE daoormdto DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
GRANT ALL ON daoormdto.* TO "daoormdtouser"@"localhost";
exit;
```

Selon votre environnement :

* renommez "daoormdtouser"@"localhost" en "daoormdtouser" dans les requêtes, mais rajoutez l'accès `localhost` dans PhpMyAdmin ensuite
* adaptez le port utilisé par MySQL (`3306` en général, parfois `8889` dans PhpMyAdmin)
* adaptez la configuration MySQL dans `src/main/resources/application.yml`

Assurez-vous que le projet soit importé dans votre IDE en UTF-8 pour que les données du sondage soient bien importées.

## Étape 1

Au 1er démarrage de l'application, Flyway va générer les tables de stockage des données d'un sondage sur le thème des environnements de développement. Le script d'insertion des données prenant trop de temps à s'exécuter, appeler le endpoint suivant en requête HTTP POST pour lancer l'import des données du sondage :

```sh
curl -i -X POST localhost:9090/import
```

Vérifier que le endpoint racine des `Queries` répond bien : [localhost:9090/api/queries](http://localhost:9090/api/queries)

## Étape 2

Pour découvrir les questions et les options de réponses proposées aux participants, implémenter le corps des méthodes nécessaires aux endpoints :
* [http://localhost:9090/api/queries/questions](http://localhost:9090/api/queries/questions)
* [http://localhost:9090/api/queries/options-by-question?questionId=1](http://localhost:9090/api/queries/options-by-question?questionId=1) : attention, l'application NE DOIT PAS produire de NullPointerException pour un identifiant de question inconnu en base
* ajouter la gestion du endpoint `/api/queries/participants` pour lister les participants (cf. `Participant`)

Applications :
* combien y a-t-il des participants au sondage ?
* combien y a-t-il des questions dans le sondage ?

# Étape 3 - analyse globale

Ajouter :

* la gestion du endpoint `/api/queries/item-responses` pour lister le nombres de réponses par item (cf. `NbReponseParItem`)
* la gestion du endpoint `/api/queries/item-responses-of-question?questionId=1` pour lister le nombres de réponses de réponse par item à une question donnée (cf. `NbQuestionReponsesParItem`), par ordre décroissant

Application :
* quel est le système d'exploitation le plus populaire ?
* quel l'IDE majoritaire ?
* quel est le système de build le plus populaire ?

# Étape 3 - analyse fine

Ajouter la gestion du endpoint `/api/queries/responses-of-two-items?itemId=1&itemId=2` pour lister le nombre de participants ayant répondu à deux items donnés (`ItemDuo`)
 
Application :
* combien y a-t-il de développeurs Java qui travaillent avec Eclipse ?
* combien y a-t-il de développeurs Java qui travaillent avec IntelliJ ?
* combien y a-t-il de développeurs Javascript qui travaillent avec Atom ?
* combien y a-t-il de développeurs Javascript qui travaillent avec VisualstudioCode ?
* quelle est l'activité principale des développeurs Javascript ?
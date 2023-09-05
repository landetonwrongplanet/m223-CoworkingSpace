# Übungsprojekt: CowrokingSpace

Coworking-Space ist ein Projekt, welches mit Quarkus entwickelt wird. Dabei soll es möglich sein, sich einen Arbeitsplatz zu reservieren. 

## Wie startet man die Applikation


1. Öffnen Sie das Projekt mit Visual Studio Code.
1. Öffnen Sie das Projekt im Entwicklungscontainer.
1. Starten Sie das Projekt mit dem Kommando
 `Quarkus: Debug current Quarkus Project`
1. Probiere die Client-Applikation unter http://localhost:8080 aus.
1. Schaue die API auf http://localhost:8080/q/swagger-ui/ an.

## Datenbank

Die Daten werden in einer PostgreSQL-Datenbank gespeichert. In der Entwicklungsumgebung wird diese in der [docker-compose-yml](./.devcontainer/docker-compose.yml) konfiguriert.

### Datenbankadministration

Über http://localhost:5050 ist PgAdmin4 erreichbar. Damit lässt sich die Datenbank komfortabel verwalten. Der Benutzername lautet `zli@example.com` und das Passwort `zli*123`. Die Verbindung zur PostgreSQL-Datenbank muss zuerst mit folgenden Daten konfiguriert werden:
 - Host name/address: `db`
 - Port: `5432`
 - Maintenance database: `postgres`
 - Username: `postgres`
 - Password: `postgres`

## Automatische Tests

Die automatischen Tests können mit `./mvnw quarkus:test` ausgeführt werden. Für die automatischen Tests wird nicht die PostgreSQL-Datenbank verwendet, sondern eine H2-Datenbank, welche sich im Arbeitsspeicher während der Ausführung befindet.

## Repo

https://github.com/landetonwrongplanet/m223-CoworkingSpace/tree/main/src

## Abweichungen zur Planung

Ich habe gestern nochmals gestartet, meine Planung ist auf Deutsch, der Code auf Englisch. Auch konnte ich nicht alles so umsetzen, wie ich es geplant habe. 

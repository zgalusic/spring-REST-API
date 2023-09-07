# spring-REST-API
Assignment #1: Spring REST API

1. git clone https://github.com/zgalusic/spring-REST-API.git
2. otvoriti projekt u željenom IDE-u
3. na lokaciji prerequisite/datebase se nalazi datoteka Product-dll.sql koja sadrži naredbu za kreiranje Product tablice. Izvršiti naredbu na željenoj instanci postgres baze
4. u business modulu otvoriti datoteku application-develop.properties i prilagoditi parametre za spajanje na bazu
5. startati aplikaciju preko IDE-a
6. funkcionalnost se može isprobati preko izloženih endpointa na http://localhost:8080/swagger-ui/index.html

Opcionalno:
Ukoliko se aplikacija ne želi pokretati preko IDE-a, nakon 1. točke potrebno je:
- izvršiti akciju opisanu u točki 3
- izvršiti akciju opisanu u točki 4
- na lokaciji u kojoj je kloniran projekt izvršiti: maven clean install -DskipTests
- pozicionirati se u target folder business modula, te pokrenuti aplikaciju pomoću: java -jar business-0.0.1-SNAPSHOT.jar
- nakon što se aplikacija starta, funkcioniranje s može isprobati kao u točki 6

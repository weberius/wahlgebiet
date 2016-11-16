#Wahlgebiet

Das Projekt _wahlgebiet_ stellt Informationen zum Wahlgebiet zur Verfügung. Die Grundlage bieten Resourcen von den [Offenen Daten Köln](https://www.offenedaten-koeln.de/). Zunächst werden die Information zu Stimmbezirk und Wahllokal zur Verfügung gestellt. Perspektivisch sind aber auch Informationen zu Landtagswahlkreis, Stadtteilen und Stadtbezirken möglich. 

## Stimmbezirk

Der Stimmbezirk ist die kleinste "organisatorische Einheit bei politischen Wahlen" (vgl. Wikipedia [Wahlbezirk](https://de.wikipedia.org/wiki/Wahlbezirk)). Grundlage für den Service _/wahlgebiet/service/stimmbezirke_ ist der Datensatz [Stimmbezirke zur Bundestagswahl](https://www.offenedaten-koeln.de/dataset/stimmbezirk). Zur Verwendung in Webapplikationen werden die Informationen dieses Datensatzes in das [GeoJson](http://geojson.org/) Format umgewandelt.

# Entwicklungsstand

Dieser Service befinded sich in Entwicklung.

[![Build Status](https://api.travis-ci.org/codeforcologne/wahlgebiet.svg?branch=master)](https://travis-ci.org/codeforcologne/wahlgebiet)

[![Codacy Badge](https://api.codacy.com/project/badge/Grade/54c094fd6e2149719a9fe54970227f46)](https://www.codacy.com/app/eberius/wahlgebiet?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=codeforcologne/wahlgebiet&amp;utm_campaign=Badge_Grade)


# Schnittstellen

## /wahlgebiet/service/stimmbezirke?geojson

Der Service _/wahlgebiet/service/stimmbezirke_ liefert alle Stimmbezirke im GeoJson Format. Er steht unter [https://tom.cologne.codefor.de/wahlgebiet/service/stimmbezirke?geojson](https://tom.cologne.codefor.de/wahlgebiet/service/stimmbezirke?geojson) zu Benutzung zur Verfügung. Einen grafischen Überblick liefert [https://tom.cologne.codefor.de/wahlgebiet/](https://tom.cologne.codefor.de/wahlgebiet/).

## /wahlgebiet/service/landtagswahlkreise?geojson

Der Service _/wahlgebiet/service/landtagswahlkreise_ liefert alle Landtagswahlkreise im GeoJson Format. Er steht unter [https://tom.cologne.codefor.de/wahlgebiet/service/landtagswahlkreise?geojson](https://tom.cologne.codefor.de/wahlgebiet/service/landtagswahlkreise?geojson) zu Benutzung zur Verfügung.

## /wahlgebiet/service/stimmbezirk/{lat}/{lng}

Der Service _/wahlgebiet/service/stimmbezirk/{lat}/{lng}_ liefert die Information zu einem Stimmbezirk in Abhängigkeit einer geolocation. Die Position Information wird im Format EPSG:4326 erwartet.

Bsp.: Der Stimmbezirk für den Kölner Dom läßt sich über folgende Abfrage ermitteln: [Stimmbezirk für den Kölner Dom](https://tom.cologne.codefor.de/wahlgebiet/service/stimmbezirk/6.958307/50.941357)

## /wahlgebiet/service/load/stimmbezirk

Service zum Einlesen der Stimmbezirke. Der Vorgang kann jederzeit wiederholt werden. Bereits existierende Daten werden vorher gelöscht.

Der Aufruf lautet:

    curl -X PUT http://localhost:8080/wahlgebiet/service/load/stimmbezirk

## /wahlgebiet/service/load/wahllokal

Service zum Einlesen der Wahllokale. Der Vorgang kann jederzeit wiederholt werden. Bereits existierende Daten werden vorher gelöscht.

Der Aufruf lautet:

    curl -X PUT http://localhost:8080/wahlgebiet/service/load/wahllokal

## /wahlgebiet/service/load/landtagswahlkreis

Service zum Einlesen der Landtagswahlkreise. Der Vorgang kann jederzeit wiederholt werden. Bereits existierende Daten werden vorher gelöscht.

Der Aufruf lautet:

    curl -X PUT http://localhost:8080/wahlgebiet/service/load/landtagswahlkreis

## /wahlgebiet/service/wahllokale

Der Service _/wahlgebiet/service/wahllokale_ liefert alle Wahllokale im GeoJson Format Er steht unter [https://tom.cologne.codefor.de/wahlgebiet/service/wahllokale](https://tom.cologne.codefor.de/wahlgebiet/service/wahllokale) zur Benutzung zur Verfügung. 

# Datenbank

## DB User auf Postgres einrichten

    sudo -u postgres createuser -P wahlgebiet
    
## Datenbank wahlergebnis anlegen

    sudo -u postgres createdb -O wahlgebiet wahlgebiet
    
## Postgis topology

    sudo -u postgres psql -c "CREATE EXTENSION postgis; CREATE EXTENSION postgis_topology;" wahlgebiet

## Tabellen anlegen

### stimmbezirk

	CREATE TABLE stimmbezirk (
	    id           varchar(256),
	    nummber      integer,
	    K_WAHL       integer,
	    L_Wahl       integer,
	    B_Wahl       integer,
	    NR_STB       integer,
	    STB          varchar(256),
	    NR_STT       integer,
	    STT          varchar(256),
	    SHAPE_AREA   double precision,
	    SHAPE_LEN    double precision,
	    modtime      timestamp DEFAULT current_timestamp
	);
	SELECT AddGeometryColumn ('public','stimmbezirk','geom',4326,'MULTIPOLYGON',2);
	
### wahllokal
	
	CREATE TABLE wahllokal (
        id                   integer,
    	stimmbezirk          integer,
    	name                 varchar(256),
    	adresse              varchar(1024),
    	rollstuhlgerecht     integer,
    	bemerkung            varchar(1024),
    	abstimmbezirk        integer,
    	stadtteil            varchar(128),
    	postzustellbezirk    integer,
    	adNummer             integer,
    	stimmbezirkStadtteil varchar(128),
    	kommunalwahlbezirk   integer,
    	landtagswahlkreis    integer,
    	bundestagswahlkreis  integer,
    	modtime              timestamp DEFAULT current_timestamp
    );
    SELECT AddGeometryColumn ('public','wahllokal','geom',4326,'POINT',2);

### landtagswahlkreis

    CREATE TABLE landtagswahlkreis (
        id                   integer,
	    nummer               integer,
        bezeichnung          varchar(256),
        modtime              timestamp DEFAULT current_timestamp
    );
    SELECT AddGeometryColumn ('public','landtagswahlkreis','geom',4326,'MULTIPOLYGON',2);
	
	
## DB-Tabellen initial einrichten

    psql -h localhost -U wahlgebiet -d wahlgebiet -a -f src/main/sql/wahlgebiet.init.sql


## Verbindungsparameter

Die Datenbankverbindungsparameter werden per JNDI zur Verfügung gestellt. Dies bedeutet, dass sie im Container definiert sein müssen. Für den Online-Betrieb mit
Tomcat sind folgende Parameter zu setzen:

context.xml

    <Context>
        <ResourceLink 
             name="jdbc/wahlgebiet" 
             global="jdbc/wahlgebiet"
             type="javax.sql.DataSource" />
    </Context> 

server.xml

    <GlobalNamingResources>
        <Resource 
            name="jdbc/wahlgebiet"
            auth="Container"
            driverClassName="org.postgresql.Driver"
            maxTotal="25" 
            maxIdle="10"
            username="username"
            password="password"
            type="javax.sql.DataSource"
            url="jdbc:postgresql://localhost:5432/wahlgebiet"
            validationQuery="select 1"/>

Zu Testzwecken muss die Datei _src/test/resources/jndi.properties.template_ in _jndi.properties_ umbenannt und die Verbindungsparameter angepasst werden.

# Test

## Tests mit Datenbank

Da zur Zeit keine Integration Test Stage zur Verfügung steht, sind alle Tests, die eine Datenbank voraussetzt als main codiert. Um eine Datenbankverbindung hierfür zur Verfügung stellen zu können, muss die Datei src/test/resources/jndi.properties.template in src/test/resources/jndi.properties kopiert und die entsprechenden Parameter zur Datenbank gesetzt werden.

# Installation

1. git clone
2. mvn clean install
3. jetty run

## Dependencies

### tomcat

Die Webapplikation benötigt folgende PostGresSQL - Bibliotheken:

- postgis-jdbc-2.1.7.2.jar
- postgresql-9.1-901-1.jdbc4.jar
- postgresql-9.3-1104-jdbc41.jar

Für Entwicklungszwecke werden die Bibliotheken über den build-Mechanismus gezogen. Für die Ausführung auf dem Tomcat müssen sie im _tomcat/lib_ Verzeichnis liegen und dürfen nicht mit der Webapplikation ausgeliefert werden. Aus diesem Grund wird in den dependencies der scope 'provided' verwendet:

		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>9.3-1104-jdbc41</version>
			<scope>provided</scope>
		</dependency>
		<dependency>
			<groupId>net.postgis</groupId>
			<artifactId>postgis-jdbc</artifactId>
			<version>2.1.7.2</version>
			<scope>provided</scope>
		</dependency>


Die Bibliotheken können von [PostGres JDBC Driver](https://jdbc.postgresql.org/download.html) bezogen werden und müssen manuell in das Verzeichnis _&lt;tomcat-home&gt;/lib_ kopiert werden.

Anmerkung: Die Bibliothek 'postgresql-9.1-901-1.jdbc4.jar' wird über den Maven Mechanismus gezogen.

# License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons Lizenzvertrag" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Dieses Werk ist lizenziert unter einer <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Namensnennung - Weitergabe unter gleichen Bedingungen 4.0 International Lizenz</a>.

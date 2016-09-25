#Wahlgebiet

Das Projekt _wahlgebiet_ stellt Informationen zum Wahlgebiet zur Verfügung. Die Grundlage bieten Resourcen von den [Offenen Daten Köln](https://www.offenedaten-koeln.de/). Zunächst werden die Information zu Stimmbezirk und Wahllokal zur Verfügung gestellt. Perspektivisch sind aber auch Informationen zu Landtagswahlkreis, Stadtteilen und Stadtbezirken möglich. 

## Stimmbezirk

Der Stimmbezirk ist die kleinste "organisatorische Einheit bei politischen Wahlen" (vgl. Wikipedia [Wahlbezirk](https://de.wikipedia.org/wiki/Wahlbezirk)). Grundlage für den Service _/wahlgebiet/service/stimmbezirke_ ist der Datensatz [Stimmbezirke zur Bundestagswahl](https://www.offenedaten-koeln.de/dataset/stimmbezirk). Zur Verwendung in Webapplikationen werden die Informationen dieses Datensatzes in das [GeoJson](http://geojson.org/) Format umgewandelt.

# Entwicklungsstand

Dieser Service ist in Entwicklung.

# Schnittstellen

## /wahlgebiet/service/stimmbezirke

Der Service _/wahlgebiet/service/stimmbezirke_ liefert alle Stimmbezirke im GeoJson Format. Er steht unter [https://tom.cologne.codefor.de/wahlgebiet/service/stimmbezirke](https://tom.cologne.codefor.de/wahlgebiet/service/stimmbezirke) zu Benutzung zur Verfügung. Einen grafischen Überblick liefert [https://tom.cologne.codefor.de/wahlgebiet/](https://tom.cologne.codefor.de/wahlgebiet/).

## /wahlgebiet/service/wahllokale

Der Service _/wahlgebiet/service/wahllokale_ liefert alle Wahllokale im GeoJson Format Er steht unter [https://tom.cologne.codefor.de/wahlgebiet/service/wahllokale](https://tom.cologne.codefor.de/wahlgebiet/service/wahllokale) zur Benutzung zur Verfügung. 

# Datebank

## DB User auf Postgres einrichten

    sudo -u postgres createuser -P wahlgebiet
    
## Datenbank wahlergebnis anlegen

    sudo -u postgres createdb -O wahlgebiet wahlgebiet

## Tabellen anlegen

	CREATE TABLE wahlgebiet (
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
	SELECT AddGeometryColumn ('public','wahlgebiet','geom',4326,'MULTIPOLYGON',2);
	
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

# License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons Lizenzvertrag" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Dieses Werk ist lizenziert unter einer <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Namensnennung - Weitergabe unter gleichen Bedingungen 4.0 International Lizenz</a>.

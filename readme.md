#Wahlgebiet

Das Projekt _wahlgebiet_ stellt Informationen zum Wahlgebiet zur Verfügung. Die Grundlage bieten Resourcen von den [Offenen Daten Köln](https://www.offenedaten-koeln.de/). Zunächst werden die Information zu Stimmbezirk und Wahllokal zur Verfügung gestellt. Perspektivisch sind aber auch Informationen zu Landtagswahlkreis, Stadtteilen und Stadtbezirken möglich. 

## Stimmbezirk

Der Stimmbezirk ist die kleinste "organisatorische Einheit bei politischen Wahlen" (vgl. Wikipedia [Wahlbezirk](https://de.wikipedia.org/wiki/Wahlbezirk)). Grundlage für den Service _/wahlgebiet/service/stimmbezirke_ ist der Datensatz [Stimmbezirke zur Bundestagswahl](https://www.offenedaten-koeln.de/dataset/stimmbezirk). Zur Verwendung in Webapplikationen werden die Informationen dieses Datensatzes in das [GeoJson](http://geojson.org/) Format umgewandelt.

# Entwicklungsstand

Dieser Service ist in Entwicklung.

# Schnittstellen

## /wahlgebiet/service/stimmbezirke

Der Service _/wahlgebiet/service/stimmbezirke_ liefert alle Stimmbezirke im GeoJson Format.

# Installation

1. git clone
2. mvn clean install
3. jetty run

# License

<a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/"><img alt="Creative Commons Lizenzvertrag" style="border-width:0" src="https://i.creativecommons.org/l/by-sa/4.0/88x31.png" /></a><br />Dieses Werk ist lizenziert unter einer <a rel="license" href="http://creativecommons.org/licenses/by-sa/4.0/">Creative Commons Namensnennung - Weitergabe unter gleichen Bedingungen 4.0 International Lizenz</a>.

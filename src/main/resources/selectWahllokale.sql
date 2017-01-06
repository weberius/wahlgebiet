select 
  id as objectid,
  stimmbezirk,
  name,
  adresse,
  rollstuhlgerecht,
  bemerkung,
  abstimmbezirk,
  stadtteil,
  postzustellbezirk,
  adnummer,
  stimmbezirkstadtteil,
  kommunalwahlbezirk,
  landtagswahlkreis,
  bundestagswahlkreis,
  modtime,
  ST_AsGeoJSON(geom) as geojson
from 
  wahllokal
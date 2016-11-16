select 
  id,
  nummer,
  bezeichnung,
  ST_AsGeoJSON(geom) as geojson
from 
  landtagswahlkreis
select 
  id, 
  nummer, 
  K_WAHL as kWahl, 
  L_Wahl as lWahl, 
  B_Wahl as bWahl, 
  NR_STB as nrStb, 
  STB as stb, 
  NR_STT as nrStt, 
  STT as stt,
  ST_AsGeoJSON(geom) as geojson
from 
  stimmbezirk 
where 
  nummer = ?
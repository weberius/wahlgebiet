select 
  id, 
  nummer, 
  k_wahl as nummerKommunalwahl,
  L_Wahl as nummerLandtagswahl,
  B_Wahl as nummerBundestagswahl,
  NR_STB as nummerStadtbezirk,
  STB as stadtbezirk,
  NR_STT as nummerStadtteil,
  STT as stadtteil,
  SHAPE_AREA as flaeche,
  SHAPE_LEN as umfang
from 
  stimmbezirk 
where 
  ST_Contains(geom, ST_SetSRID(ST_MakePoint(?, ?), ?))
  

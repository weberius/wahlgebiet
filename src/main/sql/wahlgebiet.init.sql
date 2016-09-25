CREATE TABLE stimmbezirk (
    id           varchar(256),
    nummer       integer,
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

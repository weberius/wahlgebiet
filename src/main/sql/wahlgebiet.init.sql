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
    modtime      timestamp DEFAULT current_timestamp
);
SELECT AddGeometryColumn ('public','stimmbezirk','geom',4326,'MULTIPOLYGON',2);

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

CREATE TABLE landtagswahlkreis (
    id                   integer,
	nummer               integer,
    bezeichnung          varchar(256),
    modtime              timestamp DEFAULT current_timestamp
);
SELECT AddGeometryColumn ('public','landtagswahlkreis','geom',4326,'MULTIPOLYGON',2);

DROP SEQUENCE IF EXISTS layer_id_seq;
DROP SEQUENCE IF EXISTS file_info_id_seq;

CREATE SEQUENCE layer_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 999999999999 START 1 CACHE 1;
CREATE SEQUENCE file_info_id_seq INCREMENT 1 MINVALUE 1 MAXVALUE 999999999999 START 1 CACHE 1;

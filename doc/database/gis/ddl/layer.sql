SET client_encoding = "UTF-8";

DROP SEQUENCE IF EXISTS public.layer_id_seq;
DROP TABLE IF EXISTS public.layer;

CREATE TABLE public.layer(
	layer_id			integer						NOT NULL,
	layer_name			character varying(100)		NOT NULL,
	user_id				character varying(32)		NOT NULL,
	coordinate			character varying(100)		NOT NULL,
	description			character varying(3000),
	update_date			timestamp with time zone,
	insert_data			timestamp with time zone 	DEFAULT now(),
	CONSTRAINT layer_pk PRIMARY KEY (layer_id)
);

COMMENT ON TABLE public.layer IS '레이어 관리';
COMMENT ON COLUMN public.layer.layer_id IS '레이어 고유번호';
COMMENT ON COLUMN public.layer.layer_name IS '레이어명';
COMMENT ON COLUMN public.layer.user_id IS '사용자 ID';
COMMENT ON COLUMN public.layer.coordinate IS '좌표계 정보';
COMMENT ON COLUMN public.layer.description IS '설명';
COMMENT ON COLUMN public.layer.update_date IS '갱신일';
COMMENT ON COLUMN public.layer.insert_data IS '등록일';

CREATE SEQUENCE public.layer_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	NO MAXVALUE
	CACHE 1;
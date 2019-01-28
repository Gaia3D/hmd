SET client_encoding = "UTF-8";

DROP TABLE IF EXISTS public.layer;

CREATE TABLE public.layer(
	layer_id			integer,
	layer_name			varchar(100)					NOT NULL,
	user_id				varchar(32)						NOT NULL,
	coordinate			varchar(100)					NOT NULL,
	description			varchar(3000),
	update_date			timestamp with time zone,
	insert_data			timestamp with time zone 		DEFAULT now(),
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

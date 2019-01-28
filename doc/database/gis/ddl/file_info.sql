SET client_encoding = "UTF-8";

DROP SEQUENCE IF EXISTS public.file_info_id_seq;
DROP TABLE IF EXISTS public.file_info;

CREATE TABLE public.file_info(
	file_info_id			integer			  					NOT NULL,
	layer_id				integer								NOT NULL,
	user_id					character varying(32)				NOT NULL,
	file_name				character varying(100)				NOT NULL,
	file_real_name			character varying(100)				NOT NULL,
	file_path				character varying(256)				NOT NULL,
	file_size				character varying(12)				NOT NULL,
	file_ext				character varying(10)				NOT NULL,
	comment					character varying(3000),
	update_date				timestamp with time zone,
	insert_date				timestamp with time zone			DEFAULT now(),
	CONSTRAINT file_info_pk PRIMARY KEY (file_info_id)
);

COMMENT ON TABLE public.file_info IS '파일 관리';
COMMENT ON COLUMN public.file_info.file_info_id IS '파일 고유번호';
COMMENT ON COLUMN public.file_info.user_id IS '사용자 ID';
COMMENT ON COLUMN public.file_info.file_name IS '파일 이름';
COMMENT ON COLUMN public.file_info.file_real_name IS '파일 실제 이름';
COMMENT ON COLUMN public.file_info.file_path IS '파일 경로';
COMMENT ON COLUMN public.file_info.file_size IS '파일 용량';
COMMENT ON COLUMN public.file_info.file_ext IS '파일 확장자';
COMMENT ON COLUMN public.file_info.file_ext IS '수정 사항';
COMMENT ON COLUMN public.file_info.update_date IS '갱신일';
COMMENT ON COLUMN public.file_info.insert_date IS '등록일';

CREATE SEQUENCE public.file_info_id_seq
	START WITH 1
	INCREMENT BY 1
	NO MINVALUE
	NO MAXVALUE
	CACHE 1;
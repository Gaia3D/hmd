-- FK, Index 는 별도 파일로 분리. 맨 마지막에 작업 예정
drop table if exists facility cascade;

-- 시설물 관리
create table facility(
	facility_id				int,
	facility_name			varchar(256)						not null,
	description				varchar(256),
	update_date				timestamp with time zone,
	insert_date				timestamp with time zone			default now(),
	constraint facility_pk 	primary key (facility_id)	
);

comment on table facility is '시설물';
comment on column facility.facility_id is '고유번호';
comment on column facility.facility_name is '시설물명';
comment on column facility.description is '설명';
comment on column facility.update_date is '수정일';
comment on column facility.insert_date is '등록일';

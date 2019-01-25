1 사용자 정보 관련
tb_user : 6041
vuser_password : 6898

 1) 두 테이블의 아이디가 같은 건수 : 5057
 select count(A.user_id) 
 from tb_users A, vuser_password B
 where A.user_id = B.user_id;

 2) 아이디 비밀번호가 같은 건수 : 1325
 select count(A.user_id) 
 from tb_users A, vuser_password B
 where A.user_id = B.user_id and A.password = B.password
 
2 그룹
id_group(1:본사직영, 2:사내협력사, 3:사외협력사)
select id_group, count(user_id) from tb_users group by id_group;
null : 3381, 3: 2660
왜 null이 들어가 있을까?


3 Role
4 메뉴





* 시스템 정보관리와 그룹 관리 join
select B.system_code, A.system_name, B.group_id, B.group_name 
from tb_system A, tb_usergroup B
where A.system_code = B.system_code
order by B.system_code, B.group_id


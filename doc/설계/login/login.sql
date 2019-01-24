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
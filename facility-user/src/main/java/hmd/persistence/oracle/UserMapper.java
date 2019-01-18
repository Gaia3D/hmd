package hmd.persistence.oracle;

import org.springframework.stereotype.Repository;

import hmd.domain.User;


/**
 * 시설물 관리
 * @author jeongdae
 *
 */
@Repository
public interface UserMapper {

	/**
	 * 시설물 총 건수
	 * @param facility
	 * @return
	 */
	Long getUserTotalCount(User user);

	int insertUser(User user);
}

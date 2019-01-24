package hmd.service;

import hmd.domain.User;

public interface UserService {

	/**
	 * 시설물 총 건수
	 * @param facility
	 * @return
	 */
	Long getUserTotalCount(User user);

	int insertUser(User user);
}

package hmd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hmd.domain.Facility;
import hmd.domain.User;
import hmd.persistence.oracle.UserMapper;
import hmd.service.FacilityService;
import hmd.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private FacilityService facilityService;

	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 시설물 총 건수
	 * @param facility
	 * @return
	 */
	@Transactional(readOnly=true)
	public Long getUserTotalCount(User user) {
		return userMapper.getUserTotalCount(user);
	}

	@Transactional
	public int insertUser(User user) {
		facilityService.insertFacility(new Facility());
		return userMapper.insertUser(user);
	}
}

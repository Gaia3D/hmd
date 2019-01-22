package hmd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hmd.domain.Bus;
import hmd.persistence.maria.BusMapper;
import hmd.service.BusService;

@Service
public class BusServiceImpl implements BusService {

	@Autowired
	private BusMapper busMapper;
	
	/**
	 * 버스 총 건수
	 * @param bus
	 * @return
	 */
	public Long getBusTotalCount(Bus bus) {
		return busMapper.getBusTotalCount(bus);
	}
}

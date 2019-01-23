package hmd.service;

import hmd.domain.Bus;

public interface BusService {

	/**
	 * 버스 총 건수
	 * @param bus
	 * @return
	 */
	Long getBusTotalCount(Bus bus);
}

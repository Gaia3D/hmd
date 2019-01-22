package hmd.service;

import hmd.domain.Facility;

public interface FacilityService {

	/**
	 * 시설물 총 건수
	 * @param facility
	 * @return
	 */
	Long getFacilityTotalCount(Facility facility);

	int insertFacility(Facility facility);
}

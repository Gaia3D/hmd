package hmd.service;

import hmd.domain.Facility;

public interface FacilityService {

    /**
    * 시설물 총 건수
    * @param facility
    * @return
    */
    int getFacilityTotalCount();

    int insertFacility(Facility facility);
}

package hmd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import hmd.domain.Facility;
import hmd.persistence.postgresql.FacilityMapper;
import hmd.service.FacilityService;

@Service
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityMapper facilityMapper;

    /**
    * 시설물 총 건수
    *
    * @param facility
    * @return
    */
    @Transactional(readOnly = true)
    public int getFacilityTotalCount() {
        return facilityMapper.getFacilityTotalCount();
    }

    @Transactional
    public int insertFacility(Facility facility) {
        return facilityMapper.insertFacility(facility);
    }
}

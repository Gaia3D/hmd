package hmd.persistence.postgresql;

import org.springframework.stereotype.Repository;

import hmd.domain.Facility;


/**
 * 시설물 관리
 * @author jeongdae
 *
 */
@Repository
public interface FacilityMapper {

    /**
    * 시설물 총 건수
    * @param facility
    * @return
    */
    int getFacilityTotalCount();

    int insertFacility(Facility facility);
}

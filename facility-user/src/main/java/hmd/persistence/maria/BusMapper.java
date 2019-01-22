package hmd.persistence.maria;

import org.springframework.stereotype.Repository;

import hmd.domain.Bus;


/**
 * 버스 관리
 * @author jeongdae
 *
 */
@Repository
public interface BusMapper {
	
	/**
	 * 버스 총 건수
	 * @param bus
	 * @return
	 */
	Long getBusTotalCount(Bus bus);
}

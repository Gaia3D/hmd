package hmd.persistence;

import org.springframework.stereotype.Repository;

import hmd.domain.Block;

@Repository
public interface RefQueryMapper {
	/**
	 * test
	 * @param test
	 * @return
	 */
	Block select_02(Block block);
}

package hmd.persistence;

import java.util.List;

import org.springframework.stereotype.Repository;

import hmd.domain.Block;

@Repository
public interface RefQueryMapper {
	/**
	 * test
	 * @param test
	 * @return
	 */
	List<Block> select_02(Block block);
}

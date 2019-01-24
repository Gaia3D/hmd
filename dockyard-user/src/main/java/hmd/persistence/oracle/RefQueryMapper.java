package hmd.persistence.oracle;

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

	List<Block> select_02_except_style(Block block);

	List<Block> select_02_correct_lonlat(Block block);
}

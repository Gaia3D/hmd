package hmd.service;

import java.util.List;

import hmd.domain.Block;

public interface RefQueryService {

	List<Block> select_02(Block block);

	List<Block> select_02_except_style(Block block);

	List<Block> select_02_correct_lonlat(Block block);
}

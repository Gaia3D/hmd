package hmd.service;

import java.util.List;

import hmd.domain.Block;
import hmd.domain.BlockPoint;

public interface BlockService {

	/** 블록 개수 조회  **/
	int blockCount();

	/** 블록 리스트 조회  **/
	List<BlockPoint> getBlockListTmp();
	List<Block> getBlockList(Block block);

	/** 블록명으로 해당 그룹의 경위도값 조회  **/
	List<BlockPoint> getPointByBlock(String block);

}

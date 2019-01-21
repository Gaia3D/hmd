package hmd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hmd.domain.Block;
import hmd.domain.BlockPoint;
import hmd.persistence.BlockMapper;
import hmd.service.BlockService;

@Service
public class BlockServiceImpl implements BlockService {
	
	@Autowired
	BlockMapper blockMapper;

	@Override
	public int blockCount() {
		return blockMapper.blockCount();
	}

	@Override
	public List<BlockPoint> getBlockList() {
		return blockMapper.getBlockList();
	}

	@Override
	public List<BlockPoint> getPointByBlock(String block) {
		return blockMapper.getPointByBlock(block);
	}
		
}

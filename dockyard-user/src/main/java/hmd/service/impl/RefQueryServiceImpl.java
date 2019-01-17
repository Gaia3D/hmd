package hmd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hmd.domain.Block;
import hmd.persistence.RefQueryMapper;
import hmd.service.RefQueryService;

@Service
public class RefQueryServiceImpl implements RefQueryService {

	@Autowired
	RefQueryMapper refBlockMapper;

	public List<Block> select_02(Block block) {
		return refBlockMapper.select_02(block);
	}
}

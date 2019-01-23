package hmd;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import hmd.domain.BlockPoint;
import hmd.domain.BlockTransferData;
import hmd.service.BlockService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class BlockTest {
	
	@Autowired
	BlockService blockService;
	
	ObjectMapper mapper = new ObjectMapper();
	
	@Test
	@Description("블록 정보 조회")
	public void blockJson() throws Exception {
		List<BlockPoint> blockList = new ArrayList<>();
		blockList = blockService.getBlockList();
		log.info("@@ blockList = {}", blockList);
		
		List<BlockPoint> blockPoints = new ArrayList<>();
		BlockTransferData blockTransferData= new BlockTransferData();
		
		for(BlockPoint blockPoint : blockList) {
			blockPoints = blockService.getPointByBlock(blockPoint.getBlock());
			
			blockTransferData.setBlock(blockPoint.getBlock());
			blockTransferData.setBlockPoints(blockPoints);
			
			String json = mapper.writeValueAsString(blockTransferData);getClass();
			log.info("@@ json = {}", json);
		}
	}

}

package hmd;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Description;
import org.springframework.test.context.junit4.SpringRunner;

import hmd.domain.Block;
import hmd.service.RefQueryService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OracleQueryExecuteTests {

	@Autowired
	private RefQueryService refQueryService;

	@Test
	@Description("블록 정보 조회")
	public void select_02() {
		Block param = new Block();
		param.setMfgInd("1");
		param.setTranMfgInd("8");
		param.setAreagrp("A100");
		param.setPlnwrkdte("20181224");
		List<Block> results = refQueryService.select_02(param);
		results.forEach(block -> log.info("{}", block));
	}

	@Test
	@Description("진행 정보 조회")
	public void select_02_1() {
		log.info("test");
	}
}


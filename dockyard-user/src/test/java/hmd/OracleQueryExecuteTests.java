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
@SpringBootTest(classes = DockyardUserApplication.class)
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
	@Description("블록 정보 조회_스타일 제외")
	public void select_02_except_style() {
		Block param = new Block();
		param.setMfgInd("1");
		param.setTranMfgInd("8");
		param.setAreagrp("A100");
		param.setPlnwrkdte("20181224");
		List<Block> results = refQueryService.select_02_except_style(param);
		results.forEach(block -> log.info("{}", block));
	}

	@Test
	@Description("블록 정보 조회_경위도 보정")
	public void select_02_correct_lonlat() {
		Block param = new Block();
		param.setMfgInd("1");
		param.setTranMfgInd("8");
		param.setAreagrp("A100");
		param.setPlnwrkdte("20181224");
		/**
		   *  ★ 중요
		 * 아래의 쿼리를 실행하면
		 * 경위도 값이 129, 43로 나온다. (울산은 129, 35)
		 * 위도의 값이 잘못 나옴
		 *
		 * 쿼리 중에 위도 보정값을 삭제 하면
		 * 경위도 값이 129, 35로 잘 나온다.
		 * (SELECT MULUSE1 FROM TB0 WHERE DTLCOD = 'LA') <-- 삭제
		 */
		List<Block> results = refQueryService.select_02_correct_lonlat(param);
		results.forEach(block -> log.info("{}", block));
	}

	@Test
	@Description("지번 구분 조회")
	public void select_02_1() {
		log.info("test");
		/*
		 * SELECT gbn1, count(*)
		 * FROM pm07_a70
		 * GROUP BY gbn1
		 */

		/*
		 SELECT a.ship_no, a.block, a.jibun, tp, gbn1, COUNT(*)
		 FROM pm07_d20 a
		 JOIN pm07_a70 b ON a.jibun = b.jibun AND a.mfg_ind = b.mfg_ind AND b.ynuse = 'Y'
		 WHERE curgbn = 'P'
		 AND a.mfg_ind = '1' -- 전체 사업장은 블록 2000개 미만, 사업장 본사는 800여개
		 GROUP BY a.ship_no, a.block, a.jibun, gbn1, tp;
		 */
	}
}


package hmd.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Block {
	private String shipNo;
	private String mfgInd;
	private String tranMfgInd;
	private String areagrp;
	private String plnwrkdte;

	private BigDecimal wgs84Lati;
	private BigDecimal wgs84Longi;
	private BigDecimal wgs84LatiExceptCorrect;	// 임시 추가
	private BigDecimal wgs84LongiExceptCorrect;	// 임시 추가
	private String ctipointa;
	private String ctipointb;
}

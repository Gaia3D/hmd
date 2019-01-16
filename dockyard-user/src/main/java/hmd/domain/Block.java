package hmd.domain;

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
}

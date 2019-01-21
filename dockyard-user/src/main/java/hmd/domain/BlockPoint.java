package hmd.domain;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BlockPoint {
	
	String block;

	private BigDecimal lat;
	private BigDecimal lon;
	
//	private float garo;
//	private float sero;
//	private float nopi;
	
}

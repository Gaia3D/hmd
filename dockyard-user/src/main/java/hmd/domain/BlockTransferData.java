package hmd.domain;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BlockTransferData {

	private String ship_no;
	private String block;
	private List<BlockPoint> blockPoints;
	
}

package hmd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Layer {
	
	private int layer_id; 
	private String layer_name;
	private String user_id;
	private String coordinate;
	private String description;
	private String update_date;
	private String insert_data;

}

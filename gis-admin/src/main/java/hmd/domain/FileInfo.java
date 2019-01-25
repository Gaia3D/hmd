package hmd.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class FileInfo {

	private int file_id;
	private int layer_id;
	private String user_id;
	private String file_name;
	private String file_real_name;
	private String file_path;
	private String file_size;
	private String file_ext;
	private String commnet;
	private String update_date;
	private String insert_date;
}

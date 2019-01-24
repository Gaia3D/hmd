package hmd.domain;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User implements Serializable {/**
	 * 
	 */
	private static final long serialVersionUID = 1998405982378412660L;

	private String user_id;
	private String kor_nm;
}

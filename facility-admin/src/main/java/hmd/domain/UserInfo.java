package hmd.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserInfo implements Serializable {

	private static final long serialVersionUID = 8349597082356588759L;
	
	private String userId;
	private String password;
	private String empNo;
	private String empName;
	private Integer pwErrorChk;
	private String accessChk;
	private String infoChk;
	private String treeExpand;
	
	private String sosog;
	private String cellPhone;
	private String email;
	private String dormancyYn;
	private String deptCd;
	private String twxYn;
	
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date lastLoginDt;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date insertDate;
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	private Date replDate;
}

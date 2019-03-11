package login.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	private String userId;
	private String password;
	private String name;
	private String email;
	private String phone;
	private String gender;
	private Date   regDate;
}

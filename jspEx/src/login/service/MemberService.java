package login.service;

import login.domain.Member;
import login.domain.PageInfo;

public interface MemberService {
	PageInfo<Member> getPage(int page);
	int getTotalPage();
	int getTotalCount();
}

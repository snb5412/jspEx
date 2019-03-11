package login.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import login.domain.Member;
import login.domain.PageInfo;

public class MemberServiceImpl implements MemberService {
	public List<Member> memberList;
	final private int PER_PAGE_COUNT = 10;
	
	//싱글톤 패턴 ------------------------------------------------------
	private static MemberService service = new MemberServiceImpl();
	
	private MemberServiceImpl() {
		memberList = Collections.synchronizedList(new ArrayList<>());
		
		for (int i = 0; i < 45; i++) {
			memberList.add(new Member("hong"+i, "1234", "홍길동"+i,
						"hong"+i+"@naver.com", "010-1111-1111", "M", new Date()));
		}
	}
	
	public static MemberService getInstance() {
		return service;
	}
	//싱글톤 패턴 ------------------------------------------------------

	@Override
	public PageInfo<Member> getPage(int page) {
				
		List<Member> list= new ArrayList<Member>();
		int start = (page - 1) * PER_PAGE_COUNT;
		int end = start + PER_PAGE_COUNT;
		
		if(memberList.size() < end) {
			end = memberList.size();
		}
		for (int i = start; i < end; i++) {
			list.add(memberList.get(i));
		}
		
		return new PageInfo<Member>(
				memberList.size(), getTotalPage(), page, PER_PAGE_COUNT, list);
	}

	@Override
	public int getTotalPage() {
		return (int)Math.ceil(memberList.size() / (double)PER_PAGE_COUNT);
	}

	@Override
	public int getTotalCount() {
		return memberList.size();
	}
}

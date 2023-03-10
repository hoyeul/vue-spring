package com.vue1.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberService {

	@Autowired
	MemberDao dao;
	
	public MemberService() {}

	public MemberService(MemberDao dao) {
		super();
		this.dao = dao;
	}
	
	public List<MemberDto> searchMember(MemberSearchDto dto) throws Exception{
		return dao.searchMember(dto);
	}
	
	public int selectAllCountMember(MemberSearchDto dto) throws Exception{
		return Integer.parseInt(dao.selectAllCountMember(dto));
	}
	
	public List<MemberDto> selectGenderMember(String gender) throws Exception{
		return dao.selectGenderMember(gender);
	}
	
	public MemberNumDto searchUpdateMember(String id) throws Exception{
		return dao.searchUpdateMember(id);
	}
	
	public int insertMember(MemberDto dto) throws Exception{
		String checkId = dao.searchId(dto.getId());
		if(checkId != null)	return 1;
		else {
			dao.insertMember(dto);
			return	0;
		}
	}
	
	public void updateMember(MemberDto dto) throws Exception{
		dao.updateMember(dto);
	}
	
	public int deleteMember(String id) throws Exception{
		if(id == "")		return 0;
		else {
			String userId[] = id.split(",");
			List<String> userList = new ArrayList<String>();
			for(int i = 0; i < userId.length; i++) {
				userList.add(userId[i]);
			}
			dao.deleteMember(userList);
			return 1;
		}
	}
	
}

package com.vue1.Controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberDao {
	
	@Autowired
	private SqlSession session;
	private static String namespace = "com.vue1.Controller.memberMapper.";
	
	public List<MemberDto> searchMember(MemberSearchDto dto) throws Exception{
		return session.selectList(namespace + "searchMember", dto);
	}
	
	public MemberNumDto searchUpdateMember(String id) throws Exception{
		return session.selectOne(namespace + "searchUpdateMember", id);
	}
	
	//insert 전 중복 아이디 검사
	public String searchId(String userId) throws Exception{
		return session.selectOne(namespace + "searchId", userId);
	}
	
	public String selectAllCountMember(MemberSearchDto dto) throws Exception{
		return session.selectOne(namespace + "selectAllCountMember", dto);
	}
	
	public List<MemberDto> selectGenderMember(String gender) throws Exception{
		return session.selectList(namespace + "selectGenderMember", gender);
	}
	
	//insert 멤버
	public void insertMember(MemberDto dto) throws Exception{
		session.selectOne(namespace + "insertMember", dto);
	}
	
	//update 멤버
	public void updateMember(MemberDto dto) throws Exception{
		session.update(namespace+"updateMember", dto);
	}
	
	public void deleteMember(List<String> userList) throws Exception{
		session.delete(namespace+"deleteMember", userList);
	}
	
	
}

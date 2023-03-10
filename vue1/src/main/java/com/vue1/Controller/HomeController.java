package com.vue1.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
	
	@Autowired
	MemberService s;
	
	@GetMapping(value="/members")
	public Map<String, Object> selectMember(MemberSearchDto dto) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List<MemberDto> list = s.searchMember(dto);
		List<MemberDto> genderList = s.selectGenderMember(dto.getGender());
		
		map.put("list", list);
		map.put("genderList", genderList);
		return map;
	}
	
	@GetMapping(value="/members/gender")
	public Map<String, Object> selectGenderMember(MemberSearchDto dto) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		List<MemberDto> genderList = s.selectGenderMember(dto.getGender());
		
		map.put("genderList", genderList);
		return map;
	}
	
	@GetMapping(value="/updateMember")	//update 정보 상세 페이지
	public MemberNumDto updateView(String id) throws Exception{
		MemberNumDto dto = s.searchUpdateMember(id);
		return dto;
	}
	
	@PostMapping(value = "/members")
	public int insertMember(MemberDto dto) throws Exception{
		return s.insertMember(dto);
	}
	
	@PatchMapping(value = "/members")
	public void updateMember(MemberDto dto) throws Exception{
		s.updateMember(dto);
	}
	
	@DeleteMapping(value = "/members")
	public int deleteMember(String id) throws Exception{
		return s.deleteMember(id);
	}
	
}

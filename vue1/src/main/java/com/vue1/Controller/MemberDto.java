package com.vue1.Controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MemberDto {
	
	private String id;
	private String name;
	private String gender;
	private String country;
	private String city;
	private String join_date;
	
}

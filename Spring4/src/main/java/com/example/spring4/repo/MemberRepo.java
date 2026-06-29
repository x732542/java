package com.example.spring4.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring4.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Long>{
	/*
	 * 動詞 + (介係詞)(By) + 屬性名稱
	 * findByAccount(String account) => Optional<Member> / Member
	 * findByTel(String tel) => List<Member>
	 * 
	 * countByBirthday(Stirng birthday) => long
	 * deleteByAccount(String account)
	 * 
	 * And/Or
	 * findByAgeAndGender(age,gender)
	 * findByAgeOrGender(age,gender)
	 * 
	 * Between / LessThan / GreateThanEqual
	 * findByBirthdayBetween(min, max)
	 * 
	 * IsNull / isNotNull
	 * 
	 * OrderBy + 屬性 + Asc/Desc (And ...)
	 * findByLastNameOrderByFirstNameAscAndTitleDesc(lastName)
	 * 
	 */
	
	
	
}
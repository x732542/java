package com.example.spring11.repo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase;
import org.springframework.boot.jdbc.test.autoconfigure.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.jpa.test.autoconfigure.TestEntityManager;

import com.example.spring11.entity.Member;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class MemberRepoTest {

	@Autowired
	private MemberRepo memberRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private Member testMember;
	
	@BeforeEach
	void setUp() {
		testMember = new Member();
		
		testMember.setAccount("bradkkkkk");
		testMember.setPasswd("123456");
		testMember.setName("Brad");
		
		entityManager.persist(testMember);
		entityManager.flush();
	}
	
	@Test
	void testfindByAccount_found() {
		Member member = memberRepo.findByAccount("bradkkkkk");
		
		assertThat(member).isNotNull();
		assertThat(member.getAccount()).isEqualTo("bradkkkkk");
		assertThat(member.getPasswd()).isEqualTo("123456");
		assertThat(member.getName()).isEqualTo("Brad");
		
	}
	
	@Test
	void testfindByAccount_notfound() {
		Member member = memberRepo.findByAccount("brad111");
		assertThat(member).isNull();
	}
	
	@Test
	void testExistsByAccount_true() {
		boolean isExist = memberRepo.existsByAccount("bradkkkkk");
		
		assertThat(isExist).isTrue();
	}
	
	@Test
	void testExistsByAccount_false() {
		boolean isExist = memberRepo.existsByAccount("bradxxx");
		
		assertThat(isExist).isFalse();
	}
	
	
	
}
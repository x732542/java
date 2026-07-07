package com.example.spring9.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring9.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Integer>{
	Optional<Member> findByAccount(String account);
}
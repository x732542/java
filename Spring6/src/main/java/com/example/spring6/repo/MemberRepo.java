package com.example.spring6.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring6.entity.Member;

public interface MemberRepo extends JpaRepository<Member, Integer>{
	Optional<Member> findByAccount(String account);
}
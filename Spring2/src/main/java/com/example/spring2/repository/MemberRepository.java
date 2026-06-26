package com.example.spring2.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.spring2.entity.Member;

@Repository
public interface MemberRepository extends  JpaRepository<Member, Long>{
	boolean existsByAccount(String account);
	Optional<Member> findByAccount(String account);
	
	
}
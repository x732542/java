package com.example.spring5.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.spring5.entity.Member;

@Repository
public interface MemberRepo extends JpaRepository<Member, Long>{
	Member findByAccount(String account);
}
package com.example.spring4.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring4.entity.Info;

public interface InfoRepo extends JpaRepository<Info, Long>{

}
package com.example.spring5.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.spring5.entity.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, Long>{

}
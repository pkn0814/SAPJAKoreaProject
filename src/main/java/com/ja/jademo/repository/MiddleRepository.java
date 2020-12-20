package com.ja.jademo.repository;

import com.ja.jademo.model.Element;
import com.ja.jademo.model.Middle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface MiddleRepository extends JpaRepository<Middle, Long> {
    List<Middle> findByid(Long id);

    //Page<Middle> findByYearContainingOrRegionContainingOrOrzContainingOrWorkContaining(String year, String region, String orz, String work);

}
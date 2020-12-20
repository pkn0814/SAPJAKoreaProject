package com.ja.jademo.repository;

import com.ja.jademo.model.High;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface HighRepository extends JpaRepository<High, Long> {
    List<High> findByid(Long id);

    //Page<High> findByYearContainingOrRegionContainingOrOrzContainingOrWorkContaining(String year, String region, String orz, String work, Pageable pageable);

}
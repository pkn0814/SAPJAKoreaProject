package com.ja.jademo.repository;

import com.ja.jademo.model.Univ;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UnivRepository extends JpaRepository<Univ, Long> {
    List<Univ> findByid(Long id);

    //Page<Univ> findByYearContainingOrRegionContainingOrOrzContainingOrWorkContaining(String year, String region, String orz, String work, Pageable pageable);

}
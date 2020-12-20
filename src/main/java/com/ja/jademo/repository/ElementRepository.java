package com.ja.jademo.repository;

import com.ja.jademo.model.Element;
import com.ja.jademo.model.Vehicle;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ElementRepository extends JpaRepository<Element, Long> {
    List<Element> findByid(Long id);
    //Page<Element> findByYearContainingOrRegionContainingOrOrzContainingOrWorkContaining(String year, String region, String orz, String work, Pageable pageable);
    @Query("SELECT SUM(m.class_num) FROM Element m")
    Float selectTotals();
}
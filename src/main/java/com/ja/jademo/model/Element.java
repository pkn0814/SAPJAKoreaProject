package com.ja.jademo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="info_elem")
public class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String region;
    private String orz;
    private String work;
    private int student;
    private int edu_hour;
    private int volunteer;
    private int semester;
    private String inout2;
    private String year;

    @Column(name = "class_num")
    private Float class_num;


}

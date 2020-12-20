package com.ja.jademo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="info_univ")
public class Univ {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String region;
    private String orz;
    private String work;
    private int class_num;
    private int student;
    private int edu_hour;
    private int volunteer;
    private int semester;
    private String inout2;
    private String year;
}

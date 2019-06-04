package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Album implements Serializable {
    private String id;

    private String title;

    private String score;

    private String author;

    private String broadcast;

    private Integer count;

    private String brief;

    private Date createdate;

    private String coverpic;

    private static final long serialVersionUID = 1L;


}
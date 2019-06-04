package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {
    private String id;

    private String title;

    private String author;

    private Date createdate;

    private String content;

    private static final long serialVersionUID = 1L;

}
package com.baizhi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Chapter implements Serializable {
    private String id;

    private String title;

    private String albumId;

    private String size;

    private String duration;

    private String path;

    private static final long serialVersionUID = 1L;

}
package com.baizhi.entity;


import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelEntity;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ExcelTarget(value="学生信息表")
public class User {
    @Excel(name="编号")
    private String id;
    @Excel(name="名字")
    private String name;
    @Excel(name="法号")
    private String dharma;
    @Excel(name="电话")
    private String phoneNum;
    @Excel(name="密码")
    private String password;
    @ExcelEntity
    private String salt;
    @Excel(name="头像",type=2,width=40,height=20 )
    private String headPic;
    @ExcelEntity
    private String sex;
    @ExcelEntity
    private String province;
    @ExcelEntity
    private String city;
    @ExcelEntity
    private String sign;
    @ExcelEntity
    private String status;
    @Excel(name="时间",format = "yyyy-MM-dd ")
    private Date createDate;
}

package com.sundz.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
public class Stock {
    private Integer id;

    private Integer count;

    private Integer goodsId;

    private String remark;

}
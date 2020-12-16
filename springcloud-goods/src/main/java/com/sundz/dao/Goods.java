package com.sundz.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

@Data
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
public class Goods implements Serializable {

    private static final long serialVersionUID = 441500655597974507L;
    /**
     * @field
     */
    private Integer id;

    /**
     * @field 商品名称
     */
    private String name;

    /**
     * @field 商品价格
     */
    private Double price;

    /**
     * @field 商品备注
     */
    private String remark;


}
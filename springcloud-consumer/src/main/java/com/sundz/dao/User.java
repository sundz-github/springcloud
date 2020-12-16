package com.sundz.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

import java.io.Serializable;

/**
 * <p> 用户消费者 </p>
 *
 * @author Sundz
 * @date 2020/12/16 19:35
 */
@Data
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = 1458543334310262642L;

    private int id;
    /**
     * @field 用户姓名
     */
    private String name;

    /**
     * @field 商品id
     */
    private int goodsId;

    /**
     * @field 商品描述
     */
    private String remark;

}

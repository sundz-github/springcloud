package com.sundz.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sundz.dao.GoodsMapper;
import com.sundz.entity.Goods;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

/**
 * <p> 消费服务层 </p>
 *
 * @author Sundz
 * @date 2020/12/16 19:58
 */
@Service
@Log4j2
public class GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    /**
     * @field 根据key删除商品
     */
    public int deleteByPrimaryKey(Integer id) {
        return goodsMapper.deleteByPrimaryKey(id);
    }

    /**
     * @field 插入商品
     */
    public int insert(Goods record) {
        return goodsMapper.insert(record);
    }

    /**
     * @field 获取所有的商品  commandProperties ==> 设置多久请求没响应则熔断
     */
    @HystrixCommand(fallbackMethod = "selectAllFallBack", commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "3000")})
    public List<Goods> selectAll() {
        //int a = 1 / 0;
        return goodsMapper.selectAll();

    }


    /**
     * 服务熔断
     *
     * @param
     * @return {@link List<Goods>}
     */
    public List<Goods> selectAllFallBack() {
        log.error("selectAllFallBack:发生了熔断——服务端（GoodsService）");
        return Collections.EMPTY_LIST;

    }


    /**
     * @field 根据key更新商品属性
     */
    public int updateByPrimaryKey(Goods record) {
        return goodsMapper.updateByPrimaryKey(record);
    }

    /**
     * @field 根据key查询商品
     */
    public Goods selectByPrimaryKey(Integer id) {
        return goodsMapper.selectByPrimaryKey(id);
    }
}

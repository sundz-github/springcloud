package com.sundz.service;

import com.sundz.dao.Goods;
import com.sundz.dao.mapper.GoodsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 消费服务层 </p>
 *
 * @author Sundz
 * @date 2020/12/16 19:58
 */
@Service
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
     * @field 获取所有的商品
     */
    public List<Goods> selectAll() {
        return goodsMapper.selectAll();

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

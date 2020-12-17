package com.sundz.service;

import com.sundz.dao.Stock;
import com.sundz.dao.mapper.StockMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 库存服务层 </p>
 *
 * @author Sundz
 * @date 2020/12/16 19:58
 */
@Service
public class StockService {

    @Autowired
    private StockMapper stockMapper;

    /**
     * @field 根据key删除库存
     */
    public int deleteByPrimaryKey(Integer id) {
        return stockMapper.deleteByPrimaryKey(id);
    }

    /**
     * @field 插入库存
     */
    public int insert(Stock record) {
        return stockMapper.insert(record);
    }

    /**
     * @field 获取所有的库存
     */
    public List<Stock> selectAll() {
        return stockMapper.selectAll();

    }

    /**
     * @field 根据key更新库存属性
     */
    public int updateByPrimaryKey(Stock record) {
        return stockMapper.updateByPrimaryKey(record);
    }

    /**
     * @field 根据key查询库存
     */
    public Stock selectByPrimaryKey(Integer id) {
        return stockMapper.selectByPrimaryKey(id);
    }
}

package com.sundz.dao;


import com.sundz.dao.Stock;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface StockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stock record);

    int insertSelective(Stock record);

    Stock selectByPrimaryKey(Integer id);

    List<Stock> selectAll();

    int updateByPrimaryKeySelective(Stock record);

    int updateByPrimaryKey(Stock record);
}
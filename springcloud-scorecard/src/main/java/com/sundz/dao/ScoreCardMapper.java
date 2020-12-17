package com.sundz.dao;


import com.sundz.entity.ScoreCard;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ScoreCardMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(ScoreCard record);

    int insertSelective(ScoreCard record);

    ScoreCard selectByPrimaryKey(Integer id);

    List<ScoreCard> selectAll();

    int updateByPrimaryKeySelective(ScoreCard record);

    int updateByPrimaryKey(ScoreCard record);
}
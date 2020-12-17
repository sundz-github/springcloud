package com.sundz.dao.mapper;


import com.sundz.dao.ScoreCard;
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
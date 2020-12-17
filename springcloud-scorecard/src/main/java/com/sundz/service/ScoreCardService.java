package com.sundz.service;

import com.sundz.dao.ScoreCard;
import com.sundz.dao.mapper.ScoreCardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p> 积分服务层 </p>
 *
 * @author Sundz
 * @date 2020/12/16 19:58
 */
@Service
public class ScoreCardService {

    @Autowired
    private ScoreCardMapper scoreCardMapper;

    /**
     * @field 根据key删除积分
     */
    public int deleteByPrimaryKey(Integer id) {
        return scoreCardMapper.deleteByPrimaryKey(id);
    }

    /**
     * @field 插入积分
     */
    public int insert(ScoreCard record) {
        return scoreCardMapper.insert(record);
    }

    /**
     * @field 获取所有的积分
     */
    public List<ScoreCard> selectAll() {
        return scoreCardMapper.selectAll();

    }

    /**
     * @field 根据key更新积分属性
     */
    public int updateByPrimaryKey(ScoreCard record) {
        return scoreCardMapper.updateByPrimaryKey(record);
    }

    /**
     * @field 根据key查询积分
     */
    public ScoreCard selectByPrimaryKey(Integer id) {
        return scoreCardMapper.selectByPrimaryKey(id);
    }
}

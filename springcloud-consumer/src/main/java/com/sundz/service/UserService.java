package com.sundz.service;


import com.sundz.dao.UserMapper;
import com.sundz.entity.User;
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
public class UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * @field 根据key删除消费者
     */
    public int deleteByPrimaryKey(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    /**
     * @field 插入消费者
     */
    public int insert(User record) {
        return userMapper.insert(record);
    }

    /**
     * @field 获取所有的消费者
     */
    public List<User> selectAll() {
        return userMapper.selectAll();

    }

    /**
     * @field 根据key更新消费者属性
     */
    public int updateByPrimaryKey(User record) {
        return userMapper.updateByPrimaryKey(record);
    }

    /**
     * @field 根据key查询消费者
     */
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }
}

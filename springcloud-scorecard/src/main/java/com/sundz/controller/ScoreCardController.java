package com.sundz.controller;

import com.sundz.dao.ScoreCard;
import com.sundz.service.ScoreCardService;
import com.sundz.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p> 积分Controller层 </p>
 *
 * @author Sundz
 * @date 2020/12/16 20:05
 */
@RestController
@RequestMapping(value = "/scorecard")
public class ScoreCardController {

    @Autowired
    private ScoreCardService scoreCardService;

    /**
     * @field 根据key删除积分
     */
    @DeleteMapping(value = "/{id}")
    public Response<String> deleteByPrimaryKey(@PathVariable("id") int id) {
        int delete = scoreCardService.deleteByPrimaryKey(id);
        return delete > 0 ? new Response.Builder<String>().code(HttpStatus.OK.value()).bodey("删除成功——consumer").build() :
                new Response.Builder<String>().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).bodey("删除失败——consumer").build();
    }

    /**
     * @field 插入积分
     */
    @PostMapping("/add")
    public Response<String> insert(@RequestBody ScoreCard record) {
        int insert = scoreCardService.insert(record);
        return insert > 0 ? new Response.Builder<String>().code(HttpStatus.OK.value()).bodey("插入成功——consumer").build() :
                new Response.Builder<String>().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).bodey("插入失败——consumer").build();
    }

    /**
     * @field 获取所有的积分
     */
    @GetMapping(value = "/list")
    public Response<List<ScoreCard>> selectAll() {
        List<ScoreCard> users = scoreCardService.selectAll();
        return new Response.Builder<List<ScoreCard>>().code(HttpStatus.OK.value()).message("数据返回成功!").bodey(users).build();

    }

    /**
     * @field 根据key更新积分属性
     */
    @PutMapping("/update")
    public Response<String> updateByPrimaryKey(ScoreCard record) {
        int update = scoreCardService.updateByPrimaryKey(record);
        return update > 0 ? new Response.Builder<String>().code(HttpStatus.OK.value()).bodey("更新成功——consumer").build() :
                new Response.Builder<String>().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).bodey("更新失败——consumer").build();
    }

    /**
     * @field 根据key获取积分
     */
    @GetMapping(value = "/{id}")
    public Response<ScoreCard> selectByKey(@PathVariable("id") int id) {
        ScoreCard user = scoreCardService.selectByPrimaryKey(id);
        return new Response.Builder<ScoreCard>().code(HttpStatus.OK.value()).message("数据获取成功!").bodey(user).build();
    }

}

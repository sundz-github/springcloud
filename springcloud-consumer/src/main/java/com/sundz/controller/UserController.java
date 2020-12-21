package com.sundz.controller;

import com.sundz.entity.Goods;
import com.sundz.entity.User;
import com.sundz.feign.GoodsFeign;
import com.sundz.service.UserService;
import com.sundz.utils.Constans;
import com.sundz.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;


/**
 * <p> 消费者Controller层 </p>
 *
 * @author Sundz
 * @date 2020/12/16 20:05
 */
@RestController
@RequestMapping(value = "/consumer")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private GoodsFeign goodsFeign;

    /**
     * @field 根据key删除消费者
     */
    @DeleteMapping(value = "/{id}")
    public Response<String> deleteByPrimaryKey(@PathVariable("id") int id) {
        int delete = userService.deleteByPrimaryKey(id);
        return delete > 0 ? new Response.Builder<String>().code(Constans.STATUS_CODE_SUCCESS).bodey("删除成功——consumer").build() :
                new Response.Builder<String>().code(Constans.STATUS_CODE_FAIL).bodey("删除失败——consumer").build();
    }

    /**
     * @field 插入消费者
     */
    @PostMapping("/add")
    public Response<String> insert(@RequestBody User record) {
        int insert = userService.insert(record);
        return insert > 0 ? new Response.Builder<String>().code(Constans.STATUS_CODE_SUCCESS).bodey("插入成功——consumer").build() :
                new Response.Builder<String>().code(Constans.STATUS_CODE_FAIL).bodey("插入失败——consumer").build();
    }

    /**
     * @field 获取所有的消费者
     */
    @GetMapping(value = "/list")
    public Response<List<User>> selectAll() {
        List<User> users = userService.selectAll();
        return new Response.Builder<List<User>>().code(Constans.STATUS_CODE_SUCCESS).message("数据返回成功!").bodey(users).build();

    }

    /**
     * @field 根据key更新消费者属性
     */
    @PutMapping("/update")
    public Response<String> updateByPrimaryKey(User record) {
        int update = userService.updateByPrimaryKey(record);
        return update > 0 ? new Response.Builder<String>().code(Constans.STATUS_CODE_SUCCESS).bodey("更新成功——consumer").build() :
                new Response.Builder<String>().code(Constans.STATUS_CODE_FAIL).bodey("更新失败——consumer").build();
    }

    /**
     * @field 根据key获取消费者
     */
    @GetMapping(value = "/{id}")
    public Response<User> selectByKey(@PathVariable("id") int id) {
        User user = userService.selectByPrimaryKey(id);
        return new Response.Builder<User>().code(Constans.STATUS_CODE_SUCCESS).message("数据获取成功!").bodey(user).build();
    }

    @GetMapping(value = "/goodsList")
    public Response<List<Goods>> selectGoodsList() {
        Response<List<Goods>> all = goodsFeign.selectAll();
        List<Goods> body = all.getBody();
        if (Objects.isNull(body)) {
            return new Response.Builder<List<Goods>>().code(Constans.STATUS_CODE_FAIL).message("获取商品时，服务发生了降级!").build();
        }
        return new Response.Builder<List<Goods>>().code(Constans.STATUS_CODE_SUCCESS).message("数据获取成功!").bodey(body).build();
    }

}

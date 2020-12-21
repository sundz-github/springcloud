package com.sundz.controller;


import com.sundz.entity.Goods;
import com.sundz.service.GoodsService;
import com.sundz.utils.Constans;
import com.sundz.utils.Response;
import lombok.extern.log4j.Log4j2;
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

/**
 * <p> 商品Controller层 </p>
 *
 * @author Sundz
 * @date 2020/12/16 20:05
 */
@Log4j2
@RestController
@RequestMapping(value = "/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    /**
     * @field 根据key删除商品
     */
    @DeleteMapping(value = "/{id}")
    public Response<String> deleteByPrimaryKey(@PathVariable("id") int id) {
        int delete = goodsService.deleteByPrimaryKey(id);
        return delete > 0 ? new Response.Builder<String>().code(Constans.STATUS_CODE_SUCCESS).bodey("删除成功——consumer").build() :
                new Response.Builder<String>().code(Constans.STATUS_CODE_FAIL).bodey("删除失败——consumer").build();
    }

    /**
     * @field 插入商品
     */
    @PostMapping("/add")
    public Response<String> insert(@RequestBody Goods record) {
        int insert = goodsService.insert(record);
        return insert > 0 ? new Response.Builder<String>().code(Constans.STATUS_CODE_SUCCESS).bodey("插入成功——consumer").build() :
                new Response.Builder<String>().code(Constans.STATUS_CODE_FAIL).bodey("插入失败——consumer").build();
    }

    /**
     * @field 获取所有的商品
     */
    @GetMapping(value = "/list")
    public Response<List<Goods>> selectAll() {
        log.info("springcloud-goods:7071服务被调用了!");
        List<Goods> users = goodsService.selectAll();
        return new Response.Builder<List<Goods>>().code(Constans.STATUS_CODE_SUCCESS).message("数据返回成功!").bodey(users).build();

    }

    /**
     * @field 根据key更新商品属性
     */
    @PutMapping("/update")
    public Response<String> updateByPrimaryKey(Goods record) {
        int update = goodsService.updateByPrimaryKey(record);
        return update > 0 ? new Response.Builder<String>().code(Constans.STATUS_CODE_SUCCESS).bodey("更新成功——consumer").build() :
                new Response.Builder<String>().code(Constans.STATUS_CODE_FAIL).bodey("更新失败——consumer").build();
    }

    /**
     * @field 根据key获取商品
     */
    @GetMapping(value = "/{id}")
    public Response<Goods> selectByKey(@PathVariable("id") int id) {
        Goods user = goodsService.selectByPrimaryKey(id);
        return new Response.Builder<Goods>().code(Constans.STATUS_CODE_SUCCESS).message("数据获取成功!").bodey(user).build();
    }

}

package com.sundz.controller;

import com.sundz.dao.Stock;
import com.sundz.service.StockService;
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
 * <p> 库存Controller层 </p>
 *
 * @author Sundz
 * @date 2020/12/16 20:05
 */
@RestController
@RequestMapping(value = "/stock")
public class StockController {

    @Autowired
    private StockService stockService;

    /**
     * @field 根据key删除库存
     */
    @DeleteMapping(value = "/{id}")
    public Response<String> deleteByPrimaryKey(@PathVariable("id") int id) {
        int delete = stockService.deleteByPrimaryKey(id);
        return delete > 0 ? new Response.Builder<String>().code(HttpStatus.OK.value()).bodey("删除成功——consumer").build() :
                new Response.Builder<String>().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).bodey("删除失败——consumer").build();
    }

    /**
     * @field 插入库存
     */
    @PostMapping("/add")
    public Response<String> insert(@RequestBody Stock record) {
        int insert = stockService.insert(record);
        return insert > 0 ? new Response.Builder<String>().code(HttpStatus.OK.value()).bodey("插入成功——consumer").build() :
                new Response.Builder<String>().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).bodey("插入失败——consumer").build();
    }

    /**
     * @field 获取所有的库存
     */
    @GetMapping(value = "/list")
    public Response<List<Stock>> selectAll() {
        List<Stock> users = stockService.selectAll();
        return new Response.Builder<List<Stock>>().code(HttpStatus.OK.value()).message("数据返回成功!").bodey(users).build();

    }

    /**
     * @field 根据key更新库存属性
     */
    @PutMapping("/update")
    public Response<String> updateByPrimaryKey(Stock record) {
        int update = stockService.updateByPrimaryKey(record);
        return update > 0 ? new Response.Builder<String>().code(HttpStatus.OK.value()).bodey("更新成功——consumer").build() :
                new Response.Builder<String>().code(HttpStatus.INTERNAL_SERVER_ERROR.value()).bodey("更新失败——consumer").build();
    }

    /**
     * @field 根据key获取库存
     */
    @GetMapping(value = "/{id}")
    public Response<Stock> selectByKey(@PathVariable("id") int id) {
        Stock user = stockService.selectByPrimaryKey(id);
        return new Response.Builder<Stock>().code(HttpStatus.OK.value()).message("数据获取成功!").bodey(user).build();
    }

}

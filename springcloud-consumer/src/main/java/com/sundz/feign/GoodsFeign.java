package com.sundz.feign;

import com.sundz.entity.Goods;
import com.sundz.fallback.GoodsFallBack;
import com.sundz.utils.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * <p> 商品服务调用 </p>
 *
 * @author Sundz
 * @date 2020/12/17 19:37
 */

@FeignClient(value = "SPRINGCLOUD-GOODS", fallback = GoodsFallBack.class, path = "/goods")
public interface GoodsFeign {

    @GetMapping(value = "/list")
    Response<List<Goods>> selectAll();


}

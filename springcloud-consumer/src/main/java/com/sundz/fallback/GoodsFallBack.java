package com.sundz.fallback;

import com.sundz.entity.Goods;
import com.sundz.feign.GoodsFeign;
import com.sundz.utils.Constans;
import com.sundz.utils.Response;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p> 商品服务降级使用 </p>
 *
 * @author Sundz
 * @date 2020/12/17 19:56
 */
@Component
@Log4j2
public class GoodsFallBack implements GoodsFeign {

    @Override
    public Response<List<Goods>> selectAll() {
        log.error("获取商品时，服务发生了降级!");
        return new Response.Builder<List<Goods>>().code(Constans.STATUS_CODE_FAIL).message("获取商品时，服务发生了降级!").build();
    }
}

package com.example.mall.member.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;

/**
 * TODO
 *
 * @Description
 * @Author qionghua
 * @Date 2025/1/5 13:01
 **/
@FeignClient(name = "mall-coupon", url = "http://localhost:7000")

public interface CouponFeignService {
    @RequestMapping("/coupon/coupon/member/list")
    public HashMap<String, String> MemberCoupons();
}

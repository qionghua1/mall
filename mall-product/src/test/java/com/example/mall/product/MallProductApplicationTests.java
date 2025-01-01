package com.example.mall.product;

import com.example.mall.product.domain.Brand;
import com.example.mall.product.service.IBrandService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MallProductApplicationTests {

    @Autowired
    IBrandService iBrandService;
    @Test
    public void contextLoads() {

        Brand brand = new Brand();
        brand.setBrandId(1L);
//        brand.setName("xiaomi");
//        brand.setDescript("雷军");
//        iBrandService.insertBrand(brand);
//        iBrandService.updateBrand(brand)差点;
        List<Brand> list = iBrandService.selectBrandList(brand);
        list.forEach((item) -> {
            System.out.println(item);
        });
    }

}

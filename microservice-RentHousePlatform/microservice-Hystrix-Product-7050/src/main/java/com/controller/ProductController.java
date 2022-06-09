package com.controller;

import com.Result.Result;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.po.House;
import com.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/product")
@Api(tags = {"ProductController"}, description = "Product控制类")
public class ProductController {
    @Autowired
    private ProductService productService;

    @ApiOperation("查询全部产品信息")
    @GetMapping("/getAll")
    public Result getAll() {
        return new Result(200, "操作成功", productService.getAll());
    }

    @ApiOperation("分页查询")
    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage, @PathVariable int pageSize, House house) {
        IPage<House> page = productService.getpage(currentPage, pageSize, house);
        if (currentPage > page.getPages()) {
            page = productService.getpage((int) page.getPages(), pageSize, house);
        }
        return new Result(200, "操作成功", page);
    }

    @ApiOperation("根据id获取产品信息")
    @ApiImplicitParam(value = "产品id", name = "id")
    @GetMapping("/getProduct/{id}")
    public Result getById(@PathVariable Integer id) {
        if (Objects.isNull(productService.getById(id))) {
            return new Result(400, "查询房源失败");
        }
        return new Result(200, "查询房源成功", productService.getById(id));
    }

    @ApiOperation("根据id删除用户信息")
    @ApiImplicitParam(value = "产品id", name = "id")
    @DeleteMapping("/deleteProduct/{id}")
    public Result deleteById(@PathVariable Integer id) {
        if (Objects.isNull(productService.delete(id))) {
            return new Result(400, "删除房源失败");
        }
        return new Result(200, "删除房源成功", productService.delete(id));
    }

    @ApiOperation("添加产品信息")
    @PostMapping("/saveProduct")
    public Result deleteById(@RequestBody House house) {
        if (Objects.isNull(house)) {
            return new Result(400, "添加房源失败");
        }
        return new Result(200, "添加房源成功", productService.save(house));
    }
    @ApiOperation("更新产品信息")
    @PutMapping("/updateProduct")
    public Result update(@RequestBody House house) {
        return new Result(200, "修改房源信息成功", productService.update(house));
    }

}

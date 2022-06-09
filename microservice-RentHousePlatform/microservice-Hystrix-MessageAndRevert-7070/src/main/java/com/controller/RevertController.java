package com.controller;

import com.po.revert;
import com.service.RevertService;
import com.messageandrevert.utils.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/revert")
@Api(tags = {"RevertController"}, description = "Revert控制类")
public class RevertController {
    @Autowired
    private RevertService rs;
    @Autowired
    private DateUtil dateUtil;

    @ApiOperation("根据id获取回复信息")
    @ApiImplicitParam(value = "回复id", name = "r_id")
    @GetMapping("/getRevert/{r_id}")
    public revert test1(@PathVariable Integer r_id) {
        return rs.getById(r_id);
    }

    @ApiOperation("获取全部回复信息")
    @GetMapping("/getAll")
    public List<revert> getall() {
        return rs.getAll();
    }

    @ApiOperation("根据id删除回复信息")
    @ApiImplicitParam(value = "回复id", name = "r_id")
    @DeleteMapping("/deleteRevert/{r_id}")
    public void delete(@PathVariable Integer r_id) {
        rs.delete(r_id);
    }

    @ApiOperation("添加回复信息")
    @PostMapping("/saveRevert")
    public void save(@RequestBody revert r) {
        r.setRUpdatetime(dateUtil.format(new Date()));
        rs.save(r);
    }

    @ApiOperation("更新回复信息")
    @PostMapping("/update")
    public void update(@RequestBody revert r) {
        r.setRUpdatetime(dateUtil.format(new Date()));
        rs.update(r);
    }
}

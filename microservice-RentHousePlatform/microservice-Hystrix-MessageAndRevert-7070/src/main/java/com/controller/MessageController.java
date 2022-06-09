package com.controller;


import com.po.messages;
import com.service.MessageService;
import com.messageandrevert.utils.DateUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/message")
@Api(tags = {"MessageController"}, description = "Message控制类")
public class MessageController {
    @Autowired
    private MessageService ms;
    @Autowired
    private DateUtil dateUtil;

    @ApiOperation("根据id获取留言信息")
    @ApiImplicitParam(value = "留言id", name = "id")
    @GetMapping("/getMessage/{m_id}")
    public messages select(@PathVariable Integer m_id) {
        return ms.getById(m_id);
    }

    @ApiOperation("获取全部留言")
    @GetMapping("/getAll")
    public List<messages> getall() {
        return ms.getAll();
    }

    @ApiOperation("添加留言")
    @PostMapping("/saveMessage")
    public void save(@RequestBody messages m) {
        m.setUpdatetime(dateUtil.format(new Date()));
        ms.save(m);
    }

    @ApiOperation("根据id删除留言信息")
    @ApiImplicitParam(value = "留言id", name = "id")
    @DeleteMapping("/delete/{m_id}")
    public void delete(@PathVariable Integer m_id) {
        ms.delete(m_id);
    }

    @ApiOperation("更新留言")
    @PostMapping("/update")
    public void update(@RequestBody messages m) {
        m.setUpdatetime(dateUtil.format(new Date()));
        ms.update(m);
    }
}

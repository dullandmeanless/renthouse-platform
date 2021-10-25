package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import po.*;
import services.UserService;

import java.util.List;

@Controller
public class ParkingController {
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
    //跳转到管理fare表的页面
    @RequestMapping("/fare")
    public String fare(){
        return "fare";
    }
    //查询所有车辆信息
    @RequestMapping("/selectallfare")
    public String selectallfare(Model model){ //查看停车信息
        List<fare> list=userService.selectallfare();
        model.addAttribute("InfoList",list);
        return "fare";
    }
    //查询所有车辆信息
    @RequestMapping("/selectCIALL")
    public String selectCIALL(Model model){ //查看停车信息
        List<carinfo> list=userService.selectCIAll();
        model.addAttribute("List",list);
        return "CarInfoList";
    }
    //查询所有车辆信息
    @RequestMapping("/selectAllhistory")
    public String selectAllhistory(Model model){ //查看停车信息
        List<history> list=userService.selectAllhistory();
        model.addAttribute("List",list);
        return "HistoryInfoList";
    }
    //查看所有空闲车位
    @RequestMapping("/park")
    public String park(Model model){
        List<Integer> list=userService.showFreeParking_id();
        model.addAttribute("List",list);
        return "park"; }
    //表parkinglot的controller语句
    //查询停车场信息
    @RequestMapping("/select")
    public String select(Model model){ //查看停车信息
        List<Parkinginfo> list=userService.selectPLAllstatus();
        model.addAttribute("InfoList",list);
        return "InfoList";
    }
    //跳转到操作页面
    @RequestMapping("/input")
    public String input(){
        return "input";
    }
    @RequestMapping("/add")
    public String add(){
        return "add";
    }
    @RequestMapping("/addPLinfo")
    //添加停车场信息，重定向到展示停车场信息的页面
    public String addPLinfo(Parkinginfo pl){
        userService.addPLinfo(pl);
    return "redirect:/select";
}
    @RequestMapping("/delete")
    public String delete(){
        return "delete";
    }
    //删除停车场信息，重定向到展示停车场信息的页面
    @RequestMapping("/deletePLinfo")
    public String deletePLinfo(int parking_id){
        userService.deletePLinfo(parking_id);
        return "redirect:/select";
    }
    @RequestMapping("/update")
    public String update(){
        return "update";
    }
    //更改停车场信息，重定向到展示停车场信息的页面
    @RequestMapping("/updatePLinfo")
    public String updatePLinfo(Parkinginfo pl){
        userService.updatePLinfo(pl);
        return "redirect:/select";
    }
    @RequestMapping("/statusToFree")
    public String statusToFree(Integer parking_id){
        userService.statusToFree(parking_id);
        return "redirect:/select";
    }
    @RequestMapping("/statusToBusy")
    public String statusToBusy(Integer parking_id){
        userService.statusToBusy(parking_id);
        return "redirect:/select";
    }
    //表carinfo的controller语句
    @RequestMapping("/selectCI")
    public String selectCI(Model model){ //查看车辆信息
        List<carinfo> list=userService.selectCIAll();
        model.addAttribute("CarInfoList",list);
        return "CarInfoList";
    }
    @RequestMapping("/addCI")
    public String addCI(carinfo ci){
        userService.addCI(ci);
        userService.statusToBusy(ci.getParking_id());
        userService.addfareinfo(ci.getParking_id());
        userService.updateStartTime(ci.getParking_id());
        return "redirect:/selectCI";
    }
    @RequestMapping("/deleteCI")
    public String deleteCI(int user_id){
        userService.deleteCI(user_id);
        return "redirect:/selectCI";
    }
    @RequestMapping("/updateCI")
    public String updateCI(carinfo ci){
        userService.updateCI(ci);
        return "redirect:/selectCI";
    }

}

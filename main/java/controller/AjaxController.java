package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import services.UserService;
import po.*;
import com.alibaba.fastjson.JSON;
import utils.JsonUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AjaxController {
   private  int parking_id=0;
   private String var="";
   private String car_number="";
    private String host_name ="";
    private String phone ="";
    @Autowired
    @Qualifier("userServiceImpl")
    private UserService userService;
//    @RequestMapping("/park1")
//    public boolean park1(Model model){
//        List<Integer> list=userService.showFreeParking_id();
//        model.addAttribute("List",list);
//        return list.isEmpty(); }

    @RequestMapping("/selectPLStatusById")
    public String selectPLStatusById(int parking_id){
        Parkinginfo pl= userService.selectPLStatusById(parking_id);
        return "车位"+parking_id+"的状态是："+pl.getParking_status();
    }
//    @RequestMapping("/selecthistoryBycarnumber")
//    public String selecthistoryBycarnumber(String car_number){
//        List<history> list=userService.selecthistoryBycarnumber(car_number);
//        return list.get(0).getStarttime()+"\n"+list.get(1).getStarttime();
//    }



//    @RequestMapping("/t2")
//    public String t2() throws JsonProcessingException {
//        List<Parkinginfo> userList = userService.selectPLAllstatus();
//        ObjectMapper mapper=new ObjectMapper();
//       String str=mapper.writeValueAsString(userList);
//        return str;
//    }
//    @RequestMapping("/t1")
//    public String t1(){
//        int parking_id = 55;
//        String parking_status = "zzw";
//        Parkinginfo pl=new Parkinginfo();
//        pl.setParking_id(parking_id);
//        pl.setParking_status(parking_status);
//        userService.addPLinfo(pl);
//        List<Parkinginfo> userList = userService.selectPLAllstatus();
//        Map<String,Object> map = new HashMap<String, Object>();
//        map.put("userList",userList);
//        return JSON.toJSONString(map);
//    }
//    @RequestMapping("/updatefareinfo")
//    public String updatefareinfo(fare fi){
//       userService.updatefareinfo(fi);
//       return String.valueOf(fi.getFare());
//    }
    @RequestMapping("/getfareById")
    public int getfareById(Integer parking_id){
        return userService.getfareById(parking_id);
    }
@RequestMapping("/pay")
public  double pay(int parking_id){
    userService.updateEndTime(parking_id);
    double count=userService.selectTimeDiff(parking_id)*5;
    userService.statusToFree(parking_id);
    userService.deleteCI(parking_id);
    userService.deletefareinfo(parking_id);
    return count;
}
   //后端往前端传数据 停车场信息
@RequestMapping(value="/sendPLinfo") //前端页面访问"http://172.23.63.47:8080/sendPLinfo"时触发方法
public void sendPLinfo(HttpServletResponse response,HttpServletRequest request) throws IOException {
    request.setCharacterEncoding("UTF-8"); response.setContentType("text/html;charset=utf-8");
    String datalist=userService.getParkinglotinfo();//后端查询停车位所有状态信息并包装成JSON字符串形式
    System.out.println(datalist);
    response.getWriter().print(datalist);//将要传的数据写到响应体里
}
@RequestMapping("/getCarnumber")
    public void getCarnumber(HttpServletResponse response,HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8"); response.setContentType("text/html;charset=utf-8");
        String car_number = (String)request.getParameter("carid");
       this.car_number=car_number;
       System.out.println(-2);
       System.out.println("车牌号："+car_number);
    }
@RequestMapping("/sendhistoryBycarnumber")
public void sendhistoryBycarnumber(HttpServletResponse response,HttpServletRequest request) throws IOException {
    request.setCharacterEncoding("UTF-8"); response.setContentType("text/html;charset=utf-8");
    String datalist=userService.sendhistoryBycarnumber(this.car_number);
    System.out.println(-3);
    System.out.println(datalist);
    response.getWriter().print(datalist);//将要传的数据写到响应体里
}
    //后端往前端传数据 车辆信息
@RequestMapping("/sendcarinfo") //前端页面访问"http://172.23.63.47:8080/sendPLinfo"时触发方法
public void sendcarinfo(HttpServletResponse response,HttpServletRequest request) throws IOException {
    request.setCharacterEncoding("UTF-8"); response.setContentType("text/html;charset=utf-8");
    String datalist=userService.getcarinfo();//后端查询停车位所有状态信息并包装成JSON字符串形式
    System.out.println(datalist);
    response.getWriter().print(datalist);//将要传的数据写到响应体里
}
    //后端往前端传数据 车辆信息
    @RequestMapping("/sendfareinfo") //前端页面访问"http://172.23.63.47:8080/sendPLinfo"时触发方法
    public void sendfareinfo(HttpServletResponse response,HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8"); response.setContentType("text/html;charset=utf-8");
        String datalist=userService.getfareinfo();//后端查询停车位所有状态信息并包装成JSON字符串形式
        System.out.println(datalist);
        response.getWriter().print(datalist);//将要传的数据写到响应体里
    }
    //后端往前端传数据 历史记录信息
    @RequestMapping("/sendhistoryinfo") //前端页面访问"http://172.23.63.47:8080/sendPLinfo"时触发方法
    public void sendhistoryinfo(HttpServletResponse response,HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8"); response.setContentType("text/html;charset=utf-8");
        String datalist=userService.gethistoryinfo();//后端查询停车位所有状态信息并包装成JSON字符串形式
        System.out.println(datalist);
        response.getWriter().print(datalist);//将要传的数据写到响应体里
    }
    @RequestMapping("/selectTimeDiff")
    public int selectTimeDiff(int parking_id){
      return userService.selectTimeDiff(parking_id);
    }
    @RequestMapping("/getStartTime")
    public String gerStartTime(int parking_id){
        return userService.getStartTime(parking_id);
    }
    @RequestMapping("/getEndTime")
    public String gerEndTime(int parking_id){
        return userService.getEndTime(parking_id);
    }

    @RequestMapping("/getParkingIdByUserId") //根据用户编号获取其停车位编号
    public int getParkingIdByUserId(int user_id){
      return  userService.getParkingIdByUserId(user_id);
    }
    //后端获取前端传回来的数据
    @RequestMapping(value="/getTimeSendMoney",method = RequestMethod.POST)//前端页面访问"http://172.23.63.47:8080/getTimeSendMoney"时触发
    public void  getTimeSendMoney(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("UTF-8");  response.setContentType("text/html;charset=utf-8");
        //获取前端数据
        String parking_id=request.getParameter("parking_id");
        String hour = (String)request.getParameter("hour");
        String min = (String) request.getParameter("min");
        String second = (String) request.getParameter("second");this.parking_id=Integer.parseInt(parking_id);
        System.out.println("从前端接收的停车位为parkingid："+parking_id);
//        System.out.println("从前端接收的停车位为this.num："+this.num);
        fare fi=new fare();fi.setParking_id(Integer.parseInt(parking_id));
       int money=userService.count(Integer.parseInt(min));
        System.out.println(money);fi.setFare(money);
        userService.addfareinfo(this.parking_id);//添加费用信息到数据库System.out.println(1);
        userService.updatefareinfo(fi);//将算好的钱加进数据库System.out.println(2);
        userService.updateStartTime(Integer.parseInt(parking_id));//往数据库添加入库时间System.out.println(3);
        System.out.println("车辆入库时间："+userService.getStartTime(Integer.parseInt(parking_id)));
        System.out.println("停车时长:"+hour+":"+min+":"+second);
    }
    @RequestMapping("/sendMoney")
    public void sendMoney(HttpServletResponse response,HttpServletRequest request) throws IOException{
        request.setCharacterEncoding("UTF-8"); response.setContentType("text/html;charset=utf-8");
        //获取刚入库用户的车位号
//        int parking_id=userService.getParkingIdByUserId(userService.selectCIAll().get(userService.selectCIAll().size()-1).getUser_id());
        int parking_id=this.parking_id;
       System.out.println("获取刚入库用户的车位号:"+parking_id);
        int money=userService.getfareById(parking_id); //根据车位号获取该车位的停车费用
        System.out.println(4);System.out.println("停车费用："+money);
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("money",String.valueOf(money));
        JSON.toJSONString(map); //将停车费用包装成json格式
        response.getWriter().print(map);//将停车费用写到响应体里
        //往数据库添加出库时间
        userService.updateEndTime(parking_id);System.out.println(5);
        System.out.println("车辆出库时间："+userService.getEndTime(parking_id));
       //将该用户信息、停车信息等历史记录添加到数据库
        history hi=new history();
        hi.setStarttime(userService.getStartTime(parking_id));
        hi.setEndtime(userService.getEndTime(parking_id));
        hi.setCar_number(this.car_number);
        hi.setHost_name(this.host_name);
        hi.setPhone(Integer.parseInt(this.phone));
    hi.setFare(userService.getfareById(parking_id));
        userService.addhistoryinfo(hi);System.out.println(6);
        //将该用户信息删除
        userService.deletefareinfo(parking_id);
        System.out.println("车辆已经出库");System.out.println(7);
        userService.deleteCI(parking_id);System.out.println(8);
        //将该车位状态转成空闲状态
        userService.statusToFree(parking_id);System.out.println(9);
    }
//    ,method = RequestMethod.POST
    //获取前端传过来的用户信息
@RequestMapping("/getUserInfo")
public void getUserInfo(HttpServletResponse response,HttpServletRequest request) throws IOException {
    request.setCharacterEncoding("UTF-8"); response.setContentType("text/html;charset=utf-8");
    String car_number = (String)request.getParameter("car_number");
    String host_name = (String) request.getParameter("host_name");
    String phone = (String) request.getParameter("phone");
    this.car_number=car_number;this.host_name=host_name;this.phone=phone;
    carinfo ci=new carinfo();
    ci.setCar_number(car_number);ci.setHost_name(host_name);ci.setPhone(Integer.parseInt(phone));
    ci.setParking_id(userService.showFreeParking_id().get(0));
//    System.out.println("分配的停车位为："+userService.showFreeParking_id().get(0));
    userService.addCI(ci); //将从前端获得用户信息添加到数据库
    System.out.println("成功获取车辆信息并添加车辆信息进数据库");

}
    //返回一个空闲状态的车位编号给前端
    @RequestMapping(value="/sendParkingId",method = RequestMethod.POST)
    public void sendParkingId(HttpServletResponse response,HttpServletRequest request) throws IOException {
        request.setCharacterEncoding("UTF-8"); response.setContentType("text/html;charset=utf-8");
        List<Integer> list= userService.showFreeParking_id();
        this.parking_id=list.get(0);
        if(!list.isEmpty()) {
            int parking_id = list.get(0);
            System.out.println("分配的停车位为：" + parking_id);//分配一个空闲的车位给前端
            userService.statusToBusy(parking_id);  //将该车位状态转成占用状态
            System.out.println(-1);
            response.getWriter().print(parking_id);//将要传的数据写到响应体里
        }
        else response.getWriter().print(false);
    }



}

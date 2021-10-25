package dao;

import po.*;

import java.util.Date;
import java.util.List;

public interface UserDao {
    //其他查询语句
    List<Integer> showFreeParking_id();//查询空闲车位 返回List
   double pay(Integer var1);   //缴费功能 参数是停车时间 返回需要缴费的金额
    //表Parkinglot的sql语句
    List<Parkinginfo> selectPLAllstatus();  //查询所有车位的状态 返回List
   Parkinginfo selectPLStatusById(Integer var1); //根据车位号查询该车位的状态
    int addPLinfo(Parkinginfo var1);             //添加停车位信息
    int updatePLinfo(Parkinginfo var1);        //更新停车位信息
    int deletePLinfo(Integer var1);            //删除停车位信息
    int statusToFree(Integer var1);            //将停车位的状态从 占用 变成 空闲
    int statusToBusy(Integer var1);            //将停车位的状态从 空闲 变成 占用

    //表carinfo的sql语句
    List<carinfo> selectCIAll();             //查询所有车辆信息 返回List
    carinfo selectCIById(Integer var1);      //根据车位号查询车辆信息
    int addCI(carinfo var1);               //添加车辆信息
    int updateCI(carinfo var1);            //更新车辆信息
    int deleteCI(Integer var1);             //删除车辆信息
    int getParkingIdByUserId(Integer var1);  //根据用户编号获取停车位编号
   String getcarnumberByParkingId(Integer var1);//根据车位号获取车牌号
   String gethostnameByParkingId(Integer var1);//根据车位号获取车主
    int getphoneByParkingId(Integer var1);//根据车位号获取联系方式
    //表fare的sql语句
    List<fare> selectallfare();    //查询所有停车费用信息 返回list
    int selectTimeDiff(Integer var1);      //根据车位号返回停车时长
    String getStartTime(Integer var1);        //获取该车位号 开始停车的时间
    String getEndTime(Integer var1);           //获取该车位号 结束停车的时间
   int updateStartTime(Integer var1);         //将该车位号 开始停车的时间存进数据库
    int updateEndTime(Integer var1);          //将该车位号 结束停车的时间存进数据库
    int addfareinfo(Integer var1);    //添加车位号位var的费用信息
    int deletefareinfo(Integer var1);//删除车位号位var的费用信息
    int updatefareinfo(fare fi);//更新车位号var的费用信息(主要是fare)
    int getfareById(Integer var1);//根据车位号返回该车位的停车费用
    //表history的语句
    List<history>selectAllhistory();  //查询所有历史记录 返回List
    int addhistoryinfo(history fi);   //增加历史记录
    int deletehistoryinfo(Integer var1);//删除历史记录
    int updatehistoryinfo(history fi);//更新历史记录
 List<history> selecthistoryBycarnumber(String car_number);
}

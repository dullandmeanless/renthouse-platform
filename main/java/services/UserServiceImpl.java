package services;

import com.alibaba.fastjson.JSON;
import dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import po.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl  implements UserService{
    @Autowired
    private UserDao userDao;

    //后端提取数据并包装成JSON字符串形式
    public String getParkinglotinfo(){
        List<Parkinginfo> list=userDao.selectPLAllstatus();
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("userList",list);
        return JSON.toJSONString(map);//将对象转成JSON字符串
    }
    public String getcarinfo(){
        List<carinfo> list=userDao.selectCIAll();
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("carinfoList",list);
        return JSON.toJSONString(map);//将对象转成JSON字符串
    }
    public String getfareinfo(){
        List<fare> list=userDao.selectallfare();
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("fareList",list);
        return JSON.toJSONString(map);//将对象转成JSON字符串
    }
    public String gethistoryinfo(){
        List<history> list=userDao.selectAllhistory();
        Map<String,Object> map= new HashMap<String,Object>();
        map.put("historyList",list);
        return JSON.toJSONString(map);//将对象转成JSON字符串
    }
    public int count(int minute){
//        if(minute<60)
//            return 0;
       if(minute>=1440)
           return 15;
       else return minute*2;
    }
    //其他查询语句
    public List<Integer>  showFreeParking_id(){return userDao.showFreeParking_id();}
    public  double pay(Integer var1){return userDao.pay(var1);}
    //表Parkinglot的sql语句
    @Override
    public List<Parkinginfo> selectPLAllstatus(){return userDao.selectPLAllstatus(); }
    @Override
    public Parkinginfo selectPLStatusById(Integer var1) {
        return userDao.selectPLStatusById(var1);
    }
    @Override
    public int addPLinfo(Parkinginfo var1) {
        return userDao.addPLinfo(var1);
    }
    @Override
    public int updatePLinfo(Parkinginfo var1) {
        return userDao.updatePLinfo(var1);
    }
    @Override
    public int deletePLinfo(Integer var1) {
        return userDao.deletePLinfo(var1);
    }
    @Override
    public int statusToFree(Integer var1){return userDao.statusToFree(var1);}
    @Override
    public int statusToBusy(Integer var1){return userDao.statusToBusy(var1);}
    //表carinfo的sql语句
    @Override
    public List<carinfo> selectCIAll() {
        return userDao.selectCIAll();
    }
    @Override
    public carinfo selectCIById(Integer var1) {
        return userDao.selectCIById(var1);
    }
    @Override
    public int addCI(carinfo var1) {
        return userDao.addCI(var1);
    }
    @Override
    public int updateCI(carinfo var1) {
        return userDao.updateCI(var1);
    }
    @Override
    public int deleteCI(Integer var1) {
        return userDao.deleteCI(var1);
    }
    public int getParkingIdByUserId(Integer var1){return userDao.getParkingIdByUserId(var1);}
    //表fare的sql语句
    public List<fare> selectallfare(){return userDao.selectallfare();}
    @Override
    public int selectTimeDiff(Integer var1){
        return userDao.selectTimeDiff(var1);
   }
    @Override
   public Date getStartTime(Integer var1){
        return userDao.getStartTime(var1);
    }
    @Override
    public Date getEndTime(Integer var1){
        return userDao.getEndTime(var1);
    }
    @Override
    public int updateStartTime(Integer var1){return userDao.updateStartTime(var1);}
    public int updateEndTime(Integer var1){return userDao.updateEndTime(var1);}
    public  int addfareinfo(Integer var1){return userDao.addfareinfo(var1);}
    public  int deletefareinfo(Integer var1){return userDao.deletefareinfo(var1);}
    public int  updatefareinfo(fare fi){return userDao.updatefareinfo(fi);}
    public int getfareById(Integer var1){return userDao.getfareById(var1);}
    public   String getcarnumberByParkingId(Integer var1){return userDao.getcarnumberByParkingId(var1);}
    public   String gethostnameByParkingId(Integer var1){return userDao.gethostnameByParkingId(var1);}
    public int getphoneByParkingId(Integer var1){return userDao.getphoneByParkingId(var1);}
    //表history的sql语句
    public List<history>selectAllhistory(){return userDao.selectAllhistory();}
   public int addhistoryinfo(history fi){return userDao.addhistoryinfo(fi);}
    public  int deletehistoryinfo(Integer var1){return userDao.deletehistoryinfo(var1);}
    public int updatehistoryinfo(history fi){return userDao.updatehistoryinfo(fi);}

}

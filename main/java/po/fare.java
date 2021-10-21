package po;
//数据库表fare的实体类
public class fare {
    private int parking_id;

    public int getParking_id() {
        return parking_id;
    }

    public void setParking_id(int parking_id) {
        this.parking_id = parking_id;
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }

    private String starttime;
    private String endtime;

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }

    private int fare;
    public fare(int parking_id,String starttime,String endtime){
        this.parking_id=parking_id;
        this.starttime=starttime;
        this.endtime=endtime;
    }
    public fare(){}

}

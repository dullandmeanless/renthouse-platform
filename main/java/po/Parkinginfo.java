package po;
//数据库表parkinglot的实体类
public class Parkinginfo {
    private Integer parking_id;
    private String parking_status;
    public Parkinginfo(int parking_id,String parking_status){
        this.parking_id=parking_id;
        this.parking_status=parking_status;
    }
    public Parkinginfo(){
    }
    public Integer getParking_id() {
        return parking_id;
    }

    public void setParking_id(Integer parking_id) {
        this.parking_id = parking_id;
    }

    public String getParking_status() {
        return parking_status;
    }

    public void setParking_status(String parking_status) {
        this.parking_status = parking_status;
    }

}

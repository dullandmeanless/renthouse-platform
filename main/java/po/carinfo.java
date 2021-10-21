package po;
//数据库表carinfo的实体类
public class carinfo {
    private String car_number;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    private Integer user_id;
    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getHost_name() {
        return host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getParking_id() {
        return parking_id;
    }

    public void setParking_id(int parking_id) {
        this.parking_id = parking_id;
    }

    private String host_name;
    private int phone;
    private int parking_id;
    public carinfo(String car_number,String host_name,int phone,int parking_id){
        this.car_number=car_number;
        this.host_name=host_name;
        this.phone=phone;
        this.parking_id=parking_id;

    }
    public carinfo(){}

}

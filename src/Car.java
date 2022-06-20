public class Car {
    private String Car_Name;//车辆的方向
    private boolean status;//判断是否为紧急车辆
    public Car(String car_Name)
    {
        this.Car_Name=car_Name;
    }
    public String getCar_Name() {
        return Car_Name;
    }

    public void setCar_Name(String car_Name) {
        Car_Name = car_Name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}

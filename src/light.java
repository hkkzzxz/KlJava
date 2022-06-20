public class light {
    private int x,y;//灯的坐标
    private String LightName;//灯的名字
    private boolean status;//灯的状态true为绿,false为红
    public light(int x,int y,boolean islight) {
        this.x=x;
        this.y=y;
        this.LightName=LightName;
        this.status=islight;
    }
    public void setlight(boolean sta) {        //对外接口更改灯的状态
        this.status=sta;
    }

    public boolean isStatus() {
        return status;
    }

    public String getLightName()
    {
        return this.LightName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}

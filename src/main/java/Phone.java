public class Phone {
    String mobile;
    String landLine;

    public Phone(String mobile, String landLine) {
        this.mobile = mobile;
        this.landLine = landLine;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLandLine() {
        return landLine;
    }

    public void setLandLine(String landLine) {
        this.landLine = landLine;
    }

    @Override
    public String toString(){
        return this.landLine + " " + this.mobile;
    }
}

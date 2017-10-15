package mf.pojo;

public class Designerorder {
    private Long yuid;

    private String dateTime;

    private Long designerid;

    private Long goodAspectid;

    private String timeQuantum;

    public Long getYuid() {
        return yuid;
    }

    public void setYuid(Long yuid) {
        this.yuid = yuid;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime == null ? null : dateTime.trim();
    }

    public Long getDesignerid() {
        return designerid;
    }

    public void setDesignerid(Long designerid) {
        this.designerid = designerid;
    }

    public Long getGoodAspectid() {
        return goodAspectid;
    }

    public void setGoodAspectid(Long goodAspectid) {
        this.goodAspectid = goodAspectid;
    }

    public String getTimeQuantum() {
        return timeQuantum;
    }

    public void setTimeQuantum(String timeQuantum) {
        this.timeQuantum = timeQuantum == null ? null : timeQuantum.trim();
    }
}
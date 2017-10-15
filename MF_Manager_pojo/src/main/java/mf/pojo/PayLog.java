package mf.pojo;

import java.util.Date;

public class PayLog {
    private Long logId;

    private Long payInOrderId;

    private String msg;

    private Date time;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public Long getPayInOrderId() {
        return payInOrderId;
    }

    public void setPayInOrderId(Long payInOrderId) {
        this.payInOrderId = payInOrderId;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg == null ? null : msg.trim();
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
package mf.pojo;

import java.util.Date;

public class UserKnow {
    private Integer userknowId;

    private String title;

    private Date creatTime;

    private Integer state;

    private String content;

    public Integer getUserknowId() {
        return userknowId;
    }

    public void setUserknowId(Integer userknowId) {
        this.userknowId = userknowId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Date getCreatTime() {
        return creatTime;
    }

    public void setCreatTime(Date creatTime) {
        this.creatTime = creatTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}
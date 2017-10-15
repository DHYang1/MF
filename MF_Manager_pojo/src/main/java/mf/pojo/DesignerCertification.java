package mf.pojo;

public class DesignerCertification {
    private Long certificationId;

    private Long desigerId;

    private String position;

    private String job;

    private Integer jobYear;

    private Integer good;

    private String designPath;

    private String ositiveCard;

    private String theCard;

    private Integer state;

    public Long getCertificationId() {
        return certificationId;
    }

    public void setCertificationId(Long certificationId) {
        this.certificationId = certificationId;
    }

    public Long getDesigerId() {
        return desigerId;
    }

    public void setDesigerId(Long desigerId) {
        this.desigerId = desigerId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    public Integer getJobYear() {
        return jobYear;
    }

    public void setJobYear(Integer jobYear) {
        this.jobYear = jobYear;
    }

    public Integer getGood() {
        return good;
    }

    public void setGood(Integer good) {
        this.good = good;
    }

    public String getDesignPath() {
        return designPath;
    }

    public void setDesignPath(String designPath) {
        this.designPath = designPath == null ? null : designPath.trim();
    }

    public String getOsitiveCard() {
        return ositiveCard;
    }

    public void setOsitiveCard(String ositiveCard) {
        this.ositiveCard = ositiveCard == null ? null : ositiveCard.trim();
    }

    public String getTheCard() {
        return theCard;
    }

    public void setTheCard(String theCard) {
        this.theCard = theCard == null ? null : theCard.trim();
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
}
package mf.pojo;

public class Designer {
    private Long designerId;

    private Long userId;

    private String headPath;

    private Double hotDyed;

    private Double makeups;

    private Double haircut;

    private Integer state;

    private String introduction;

    private String specialty;

    private String honor;

    private String autograph;

    private String position;

    private String job;

    private Integer jobYear;

    private Integer beGood;

    private Integer popularIndex;

    private String desigerName;

    public Long getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Long designerId) {
        this.designerId = designerId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath == null ? null : headPath.trim();
    }

    public Double getHotDyed() {
        return hotDyed;
    }

    public void setHotDyed(Double hotDyed) {
        this.hotDyed = hotDyed;
    }

    public Double getMakeups() {
        return makeups;
    }

    public void setMakeups(Double makeups) {
        this.makeups = makeups;
    }

    public Double getHaircut() {
        return haircut;
    }

    public void setHaircut(Double haircut) {
        this.haircut = haircut;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty == null ? null : specialty.trim();
    }

    public String getHonor() {
        return honor;
    }

    public void setHonor(String honor) {
        this.honor = honor == null ? null : honor.trim();
    }

    public String getAutograph() {
        return autograph;
    }

    public void setAutograph(String autograph) {
        this.autograph = autograph == null ? null : autograph.trim();
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

    public Integer getBeGood() {
        return beGood;
    }

    public void setBeGood(Integer beGood) {
        this.beGood = beGood;
    }

    public Integer getPopularIndex() {
        return popularIndex;
    }

    public void setPopularIndex(Integer popularIndex) {
        this.popularIndex = popularIndex;
    }

    public String getDesigerName() {
        return desigerName;
    }

    public void setDesigerName(String desigerName) {
        this.desigerName = desigerName == null ? null : desigerName.trim();
    }
}
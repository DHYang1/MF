package mf.pojo;

public class HotDesigner{

	  private Long designerId;
	  private String headPath;
	  private String desigerName;

	public Long getDesignerId() {
		return designerId;
	}
	public void setDesignerId(Long designerId) {
		this.designerId = designerId;
	}
	public String getHeadPath() {
		return headPath;
	}
	public void setHeadPath(String headPath) {
		this.headPath = headPath;
	}

    public String getDesigerName() {
        return desigerName;
    }

    public void setDesigerName(String desigerName) {
        this.desigerName = desigerName == null ? null : desigerName.trim();
    }
	  
}

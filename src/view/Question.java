package view;

import java.util.List;

public class Question {
	private Integer id;
	private Integer sort;
	private Integer enable;
	private String description;
	private Double score;
	private Integer required;
	private String createTime;
	private Integer creator;
	private String modifyTime;
	private Integer modifyBy;
	private List<ZwOption> zwOptions;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getSort() {
		return sort;
	}
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	public Integer getEnable() {
		return enable;
	}
	public void setEnable(Integer enable) {
		this.enable = enable;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getScore() {
		return score;
	}
	public void setScore(Double score) {
		this.score = score;
	}
	public Integer getRequired() {
		return required;
	}
	public void setRequired(Integer required) {
		this.required = required;
	}
	public String getCreateTime() {
		return createTime;
	}
	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}
	public Integer getCreator() {
		return creator;
	}
	public void setCreator(Integer creator) {
		this.creator = creator;
	}
	public String getModifyTime() {
		return modifyTime;
	}
	public void setModifyTime(String modifyTime) {
		this.modifyTime = modifyTime;
	}
	public Integer getModifyBy() {
		return modifyBy;
	}
	public void setModifyBy(Integer modifyBy) {
		this.modifyBy = modifyBy;
	}
	public List<ZwOption> getZwOptions() {
		return zwOptions;
	}
	public void setZwOptions(List<ZwOption> zwOptions) {
		this.zwOptions = zwOptions;
	}
	@Override
	public String toString() {
		return "Question [id=" + id + ", sort=" + sort + ", enable=" + enable
				+ ", description=" + description + ", score=" + score
				+ ", required=" + required + ", createTime=" + createTime
				+ ", creator=" + creator + ", modifyTime=" + modifyTime
				+ ", modifyBy=" + modifyBy + ", zwOptions=" + zwOptions
				+ ", getId()=" + getId() + ", getSort()=" + getSort()
				+ ", getEnable()=" + getEnable() + ", getDescription()="
				+ getDescription() + ", getScore()=" + getScore()
				+ ", getRequired()=" + getRequired() + ", getCreateTime()="
				+ getCreateTime() + ", getCreator()=" + getCreator()
				+ ", getModifyTime()=" + getModifyTime() + ", getModifyBy()="
				+ getModifyBy() + ", getZwOptions()=" + getZwOptions()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

}

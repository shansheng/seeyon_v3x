/**
 * 
 */
package com.seeyon.v3x.collaboration.his.domain;

import java.io.Serializable;

import com.seeyon.v3x.common.domain.BaseModel;
import com.seeyon.v3x.common.utils.BeanUtils;

/**
 * @author <a href="mailto:tanmf@seeyon.com">Tanmf</a>
 * 2012-1-7
 */
public class HisColOpinion extends BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4114030427245175319L;

	private Integer attitude = -1;

	private String content;

	private java.sql.Timestamp createDate;

	private Boolean isHidden = false;

	private Integer levelId = 0;

	private Integer opinionType;
	
	/**
	 * 该属性是ORM的字段
	 */
	private Long writeMemberId;
	
	private String proxyName;

	private Long summaryId;

	private Long affairId;
	//意见公开人
    private String  showToId;

	//归档Id
	private Long archiveId;

	// 是否处理后立即删除
	// 不存储在数据库中，只用于参数传递
	public boolean isDeleteImmediate = false;

	// 是否处理后跟踪
	// 不存储在ColOpinion表中，只用于参数传递
	public boolean affairIsTrack = true;
	
	//是否处理后归档
	// 不存储在ColOpinion表中，只用于参数传递
	public boolean isPipeonhole = true;
	
	private Boolean isAcconutAdmin = false ;

	/**
	 * 意见类型，有新的类型往后追加，切勿改变顺序 枚举项顺序将被记录到数据库
	 */
	public enum OpinionType {
		senderOpinion, // 发起人意见
		signOpinion, // 处理意见
		provisionalOpinoin, // 暂存待办意见
		backOpinion, // 回退意见
		draftOpinion, // 草稿意见
		stopOpinion, // 终止意见
		cancelOpinion, //处理人撤销流程
	}

	public HisColOpinion() {
	}
	
	/**
	 * 判断该意见是否是处理意见
	 * 
	 * @return
	 */
	public boolean isChuliOpinion(){
		return this.getOpinionType() == OpinionType.signOpinion.ordinal()
			|| this.getOpinionType() == OpinionType.provisionalOpinoin.ordinal()
			|| this.getOpinionType() == OpinionType.backOpinion.ordinal()
			|| this.getOpinionType() == OpinionType.stopOpinion.ordinal()
			||this.getOpinionType() == OpinionType.cancelOpinion.ordinal()
		;
	}

	public Integer getAttitude() {
		return this.attitude;
	}

	public void setAttitude(Integer attitude) {
		this.attitude = attitude;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public java.sql.Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(java.sql.Timestamp createDate) {
		this.createDate = createDate;
	}

	public Boolean getIsHidden() {
		return isHidden;
	}

	public void setIsHidden(Boolean hidden) {
		isHidden = hidden;
	}

	public Integer getOpinionType() {
		return this.opinionType;
	}

	public void setOpinionType(Integer opinionType) {
		this.opinionType = opinionType;
	}
	
	public void setOpinionType(OpinionType opinionType) {
		this.opinionType = opinionType.ordinal();
	}

	/**
	 * @return
	 */
	public Long getAffairId() {
		return affairId;
	}
	
	/**
	 * @return
	 */
	public void setAffairId(Long affairId) {
		this.affairId = affairId;
	}

	public Long getSummaryId() {
		return summaryId;
	}

	public void setSummaryId(Long summaryId) {
		this.summaryId = summaryId;
	}

	public Integer getLevelId() {
		return levelId;
	}

	public void setLevelId(Integer levelId) {
		this.levelId = levelId;
	}

	public Long getWriteMemberId() {
		return writeMemberId;
	}

	public void setWriteMemberId(Long writeMemberId) {
		this.writeMemberId = writeMemberId;
	}

	public Long getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Long archiveId) {
		this.archiveId = archiveId;
	}

	public String getProxyName() {
		return proxyName;
	}

	public void setProxyName(String proxyName) {
		this.proxyName = proxyName;
	}

	public Boolean getIsAcconutAdmin() {
		return isAcconutAdmin;
	}

	public void setIsAcconutAdmin(Boolean isAcconutAdmin) {
		this.isAcconutAdmin = isAcconutAdmin;
	}

	public String getShowToId() {
		return showToId;
	}

	public void setShowToId(String showToId) {
		this.showToId = showToId;
	}
	
	public void clone(com.seeyon.v3x.collaboration.domain.ColOpinion c) {
		BeanUtils.convert(this, c);
	}
	
	public com.seeyon.v3x.collaboration.domain.ColOpinion toColOpinion(){
		com.seeyon.v3x.collaboration.domain.ColOpinion o = new com.seeyon.v3x.collaboration.domain.ColOpinion();
		BeanUtils.convert(o, this);
		return o;
	}

}
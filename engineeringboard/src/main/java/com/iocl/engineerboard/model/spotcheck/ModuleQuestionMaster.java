package com.iocl.dhruva2api.model.spotcheck;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.iocl.dhruva2api.model.common.MstTypeDhruva;

/**
 * ModuleQuestionMaster
 */
@Entity
@Table(name = "SPOT_MST_QUESTIONS")
public class ModuleQuestionMaster implements Serializable {

	private static final long serialVersionUID = -4094309197337699877L;

	@EmbeddedId
	private ModuleQuestionMasterId id;

	@Column(name = "TEXT")
	private String text;

	@JsonIgnore
	@Column(name = "RES_COCO_ADHOC")
	private String resCOCOAdHoc;

	@Column(name = "RES_COCO_SERVICE")
	private String resCOCOService;

	@Column(name = "RES_ASITE")
	private String resASite;

	@Column(name = "RES_BSITE")
	private String resBSite;

	@Column(name = "INPUT_TYPE")
	private String inputType;

	@JsonIgnore
	@Column(name = "TYPE_SL_NO")
	private int typeSlno;

	@OneToMany
	@JoinColumn(name = "TYPE_SL_NO", referencedColumnName = "TYPE_SL_NO")
	private List<MstTypeDhruva> dropDownValues;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "PARENT_MODULE", nullable = false, insertable = false, updatable = false)
	private ModuleMaster master;

	public ModuleQuestionMaster() {

	}

	/**
	 * @return the id
	 */
	public ModuleQuestionMasterId getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(ModuleQuestionMasterId id) {
		this.id = id;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	/**
	 * @return the resCOCOAdHoc
	 */
	public String getResCOCOAdHoc() {
		return resCOCOAdHoc;
	}

	/**
	 * @param resCOCOAdHoc the resCOCOAdHoc to set
	 */
	public void setResCOCOAdHoc(String resCOCOAdHoc) {
		this.resCOCOAdHoc = resCOCOAdHoc;
	}

	/**
	 * @return the resCOCOService
	 */
	public String getResCOCOService() {
		return resCOCOService;
	}

	/**
	 * @param resCOCOService the resCOCOService to set
	 */
	public void setResCOCOService(String resCOCOService) {
		this.resCOCOService = resCOCOService;
	}

	/**
	 * @return the resASite
	 */
	public String getResASite() {
		return resASite;
	}

	/**
	 * @param resASite the resASite to set
	 */
	public void setResASite(String resASite) {
		this.resASite = resASite;
	}

	/**
	 * @return the resBSite
	 */
	public String getResBSite() {
		return resBSite;
	}

	/**
	 * @param resBSite the resBSite to set
	 */
	public void setResBSite(String resBSite) {
		this.resBSite = resBSite;
	}

	/**
	 * @return the inputType
	 */
	public String getInputType() {
		return inputType;
	}

	/**
	 * @param inputType the inputType to set
	 */
	public void setInputType(String inputType) {
		this.inputType = inputType;
	}

	/**
	 * @return the typeSlno
	 */
	public int getTypeSlno() {
		return typeSlno;
	}

	/**
	 * @param typeSlno the typeSlno to set
	 */
	public void setTypeSlno(int typeSlno) {
		this.typeSlno = typeSlno;
	}

	/**
	 * @return the master
	 */
	public ModuleMaster getMaster() {
		return master;
	}

	/**
	 * @param master the master to set
	 */
	public void setMaster(ModuleMaster master) {
		this.master = master;
	}

	/**
	 * @return the dropDownValues
	 */
	public List<MstTypeDhruva> getDropDownValues() {
		return dropDownValues;
	}

	/**
	 * @param dropDownValues the dropDownValues to set
	 */
	public void setDropDownValues(List<MstTypeDhruva> dropDownValues) {
		this.dropDownValues = dropDownValues;
	}

}
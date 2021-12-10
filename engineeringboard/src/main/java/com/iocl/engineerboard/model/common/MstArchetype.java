package com.iocl.dhruva2api.model.common;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MST_ARCHETYPE")
public class MstArchetype {

	@Id
	@Column(name="ARCHE_CODE")
	private int archetypeCode;

	public int getArchetypeCode() {
		return archetypeCode;
	}

	public void setArchetypeCode(int archetypeCode) {
		this.archetypeCode = archetypeCode;
	}
	
}

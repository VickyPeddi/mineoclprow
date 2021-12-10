package com.iocl.dhruva2api.model.leaderboard;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="DO_LEADERBOARD")
public class DOFITScore {
	
	    @Column(name = "SALESORG_NAME")
	    private String salesOrgName;
	 	
	    @Id
	    @Column(name = "SALES_OFF_NAME")
	    private String doMaster;

	    @Column(name = "FIT")
	    private Integer fit;

		public String getSalesOrgName() {
			return salesOrgName;
		}

		public void setSalesOrgName(String salesOrgName) {
			this.salesOrgName = salesOrgName;
		}

		public String getDoMaster() {
			return doMaster;
		}

		public void setDoMaster(String doMaster) {
			this.doMaster = doMaster;
		}

		public Integer getFit() {
			return fit;
		}

		public void setFit(Integer fit) {
			this.fit = fit;
		}

	   

}

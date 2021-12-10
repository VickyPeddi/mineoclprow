package com.iocl.dhruva2api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="DO_LEADERBOARD")
public class DODhruvaCompliantScore {
	
	    @Column(name = "SALESORG_NAME")
	    private String salesOrgName;
	 	
	    @Id
	    @Column(name = "SALES_OFF_NAME")
	    private String doMaster;

	    @Column(name = "DHRUVA_COMPLIANT")
	    private Integer dhruvaCompliant;

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

		public Integer getDhruvaCompliant() {
			return dhruvaCompliant;
		}

		public void setDhruvaCompliant(Integer dhruvaCompliant) {
			this.dhruvaCompliant = dhruvaCompliant;
		}

		
	   

}

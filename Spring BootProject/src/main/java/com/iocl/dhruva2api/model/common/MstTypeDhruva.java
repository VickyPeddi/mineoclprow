package com.iocl.dhruva2api.model.common;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * MstTypeDhruva
 */
@Entity
@Table(name = "MST_TYPE_DHRUVA")
public class MstTypeDhruva implements Serializable {

    private static final long serialVersionUID = -5703181509079219236L;

    @Id
    @Column(name = "sr_no")
    private int serialNo;

    @Column(name = "value")
    private String value;

    @Column(name = "TYPE_SL_NO")
    private int typeSlNo;

    public MstTypeDhruva() {

    }

    /**
     * @return the serialNo
     */
    public int getSerialNo() {
        return serialNo;
    }

    /**
     * @param serialNo the serialNo to set
     */
    public void setSerialNo(int serialNo) {
        this.serialNo = serialNo;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * @return the typeSlNo
     */
    public int getTypeSlNo() {
        return typeSlNo;
    }

    /**
     * @param typeSlNo the typeSlNo to set
     */
    public void setTypeSlNo(int typeSlNo) {
        this.typeSlNo = typeSlNo;
    }

}
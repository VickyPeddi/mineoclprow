package com.iocl.dhruva2api.model.spotcheck;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * SpotTranAnswerId
 */
@Embeddable
public class SpotTranAnswerId implements Serializable {

    private static final long serialVersionUID = 996143305499692650L;

    @Column(name = "INSP_NO")
    private long inspNo;

    @Column(name = "MODULE_NO")
    private int moduleNo;

    @Column(name = "QUESTION_NO")
    private String questionNo;

    public SpotTranAnswerId() {

    }

    public SpotTranAnswerId(long inspNo, int moduleNo, String questionNo) {
        this.inspNo = inspNo;
        this.moduleNo = moduleNo;
        this.questionNo = questionNo;
    }

    /**
     * @return the inspNo
     */
    public long getInspNo() {
        return inspNo;
    }

    /**
     * @param inspNo the inspNo to set
     */
    public void setInspNo(long inspNo) {
        this.inspNo = inspNo;
    }

    /**
     * @return the moduleNo
     */
    public int getModuleNo() {
        return moduleNo;
    }

    /**
     * @param moduleNo the moduleNo to set
     */
    public void setModuleNo(int moduleNo) {
        this.moduleNo = moduleNo;
    }

    /**
     * @return the questionNo
     */
    public String getQuestionNo() {
        return questionNo;
    }

    /**
     * @param questionNo the questionNo to set
     */
    public void setQuestionNo(String questionNo) {
        this.questionNo = questionNo;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (inspNo ^ (inspNo >>> 32));
        result = prime * result + moduleNo;
        result = prime * result + ((questionNo == null) ? 0 : questionNo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        SpotTranAnswerId other = (SpotTranAnswerId) obj;
        if (inspNo != other.inspNo)
            return false;
        if (moduleNo != other.moduleNo)
            return false;
        if (questionNo == null) {
            if (other.questionNo != null)
                return false;
        } else if (!questionNo.equals(other.questionNo))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "SpotTranAnswerId [inspNo=" + inspNo + ", moduleNo=" + moduleNo + ", questionNo=" + questionNo + "]";
    }
}
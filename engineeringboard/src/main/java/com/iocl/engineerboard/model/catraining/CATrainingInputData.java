package com.iocl.dhruva2api.model.catraining;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.iocl.dhruva2api.util.DateUtils;

/**
 * CATrainingInputData
 */
@Entity
@Table(name = "TRN_CA_TRAINING")
public class CATrainingInputData implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Basic(optional = false)
    @Column(name = "RO_CODE")
    @JsonProperty(value = "RO Code")
    private String roCode;

    @JsonProperty(value = "Dealer Contact Number")
    @Column(name = "DEALER_CONTACT")
    private String dealerContact;

    @JsonProperty(value = "Training Date")
    @Basic(optional = false)
    @Column(name = "TRAINING_DATE")
    @Temporal(TemporalType.DATE)
    // @DateTimeFormat(pattern = "DD-MM-YY")
    private Date trainingDate;

    @JsonProperty(value = "Agency")
    @Column(name = "AGENCY")
    private String agency;

    @JsonProperty(value = "1st or 2nd (Refresher) Intervention")
    @Column(name = "INTERVENTION")
    private String intervention;

    @JsonProperty(value = "Training Venue")
    @Column(name = "TRAINING_VENUE")
    private String trainingVenue;

    @JsonProperty(value = "Training Days")
    @Column(name = "TRAINING_DAYS")
    private String trainingDays;

    @JsonProperty(value = "Trainer Name")
    @Column(name = "TRAINER_NAME")
    private String trainerName;

    @JsonProperty(value = "Trainer Contact No")
    @Column(name = "TRAINER_CONTACT_NO")
    private String trainerContactNo;

    @JsonProperty(value = "Actual Participant")
    @Column(name = "ACTUAL_PARTICIPANT")
    private String actualParticipant;

    @JsonProperty(value = "Planned Participant")
    @Column(name = "PLANNED_PARTICIPANT")
    private String plannedParticipant;

    @JsonProperty(value = "SOP Booklet Language")
    @Column(name = "SOP_BOOKLET_LANGUAGE")
    private String sopBookletLanguage;

    @JsonProperty(value = "SOP Booklet Given (Enter Yes/No Only)")
    @Column(name = "SOP_BOOKLET_GIVEN")
    private String sopBookletGiven;

    @JsonProperty(value = "Rule Poster (Enter Yes/No Only)")
    @Column(name = "RULE_POSTER")
    private String rulePoster;

    @JsonProperty(value = "C.A. Badges (Enter Yes/No Only)")
    @Column(name = "CA_BADGES")
    private String caBadges;

    @JsonProperty(value = "Projector/LCD (Enter Yes/No Only)")
    @Column(name = "PROJECTOR_LCD")
    private String projectorLcd;

    @JsonProperty(value = "FO Present (Enter Yes/No Only)")
    @Column(name = "FO_PRESENT")
    private String foPresent;

    @JsonProperty(value = "Dealer Present (Enter Yes/No Only)")
    @Column(name = "DEALER_PRESENT")
    private String dealerPresent;

    @JsonProperty(value = "CA Trainer Present (Enter Yes/No Only)")
    @Column(name = "CA_TRAINER_PRESENT")
    private String caTrainerPresent;

    @JsonProperty(value = "Huddle Circle (Enter Yes/No Only)")
    @Column(name = "HUDDLE_CIRCLE")
    private String huddleCircle;

    @JsonProperty(value = "CA Attendance Sheet Collected (Enter Yes/No Only)")
    @Column(name = "ATTENDANCE_COLLECTED")
    private String attendanceCollected;

    @JsonProperty(value = "NO of CA Mobile no captured")
    @Column(name = "NO_OF_CA_MOB")
    private String noOfCaMob;

    @JsonProperty(value = "NO of CA Photos captured")
    @Column(name = "NO_OF_CA_PHOTOGRAPHS")
    private String noOfCaPhotographs;

    @JsonProperty(value = "Huddle Photo (Enter Yes/No Only)")
    @Column(name = "HUDDLE_PHOTO")
    private String huddlePhoto;

    @JsonProperty(value = "Info-Graphic (Enter Yes/No Only)")
    @Column(name = "INFO_GRAPHIC")
    private String infoGraphic;

    public CATrainingInputData() {
    }

    public String getRoCode() {
        return roCode;
    }

    public void setRoCode(String roCode) {
        this.roCode = roCode;
    }

    public String getDealerContact() {
        return dealerContact;
    }

    public void setDealerContact(String dealerContact) {
        this.dealerContact = dealerContact;
    }

    public Date getTrainingDate() {
        return trainingDate;
    }

    public void setTrainingDate(String trainingDate) {
    	trainingDate = trainingDate.replace("/", "-");//in case date format is uploaded wrong.
    	try {
        this.trainingDate = DateUtils.convertStringToDate(trainingDate, "dd-MM-yyyy");
    	}catch(Exception ex) {
    		System.out.println("");
    	}
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getIntervention() {
        return intervention;
    }

    public void setIntervention(String intervention) {
        this.intervention = intervention;
    }

    public String getTrainingVenue() {
        return trainingVenue;
    }

    public void setTrainingVenue(String trainingVenue) {
        this.trainingVenue = trainingVenue;
    }

    public String getTrainingDays() {
        return trainingDays;
    }

    public void setTrainingDays(String trainingDays) {
        this.trainingDays = trainingDays;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerContactNo() {
        return trainerContactNo;
    }

    public void setTrainerContactNo(String trainerContactNo) {
        this.trainerContactNo = trainerContactNo;
    }

    public String getActualParticipant() {
        return actualParticipant;
    }

    public void setActualParticipant(String actualParticipant) {
        this.actualParticipant = actualParticipant;
    }

    public String getPlannedParticipant() {
        return plannedParticipant;
    }

    public void setPlannedParticipant(String plannedParticipant) {
        this.plannedParticipant = plannedParticipant;
    }

    public String getSopBookletLanguage() {
        return sopBookletLanguage;
    }

    public void setSopBookletLanguage(String sopBookletLanguage) {
        this.sopBookletLanguage = sopBookletLanguage;
    }

    public String getSopBookletGiven() {
        return sopBookletGiven;
    }

    public void setSopBookletGiven(String sopBookletGiven) {
        this.sopBookletGiven = sopBookletGiven;
    }

    public String getRulePoster() {
        return rulePoster;
    }

    public void setRulePoster(String rulePoster) {
        this.rulePoster = rulePoster;
    }

    public String getCaBadges() {
        return caBadges;
    }

    public void setCaBadges(String caBadges) {
        this.caBadges = caBadges;
    }

    public String getProjectorLcd() {
        return projectorLcd;
    }

    public void setProjectorLcd(String projectorLcd) {
        this.projectorLcd = projectorLcd;
    }

    public String getFoPresent() {
        return foPresent;
    }

    public void setFoPresent(String foPresent) {
        this.foPresent = foPresent;
    }

    public String getDealerPresent() {
        return dealerPresent;
    }

    public void setDealerPresent(String dealerPresent) {
        this.dealerPresent = dealerPresent;
    }

    public String getCaTrainerPresent() {
        return caTrainerPresent;
    }

    public void setCaTrainerPresent(String caTrainerPresent) {
        this.caTrainerPresent = caTrainerPresent;
    }

    public String getHuddleCircle() {
        return huddleCircle;
    }

    public void setHuddleCircle(String huddleCircle) {
        this.huddleCircle = huddleCircle;
    }

    public String getAttendanceCollected() {
        return attendanceCollected;
    }

    public void setAttendanceCollected(String attendanceCollected) {
        this.attendanceCollected = attendanceCollected;
    }

    public String getNoOfCaMob() {
        return noOfCaMob;
    }

    public void setNoOfCaMob(String noOfCaMob) {
        this.noOfCaMob = noOfCaMob;
    }

    public String getNoOfCaPhotographs() {
        return noOfCaPhotographs;
    }

    public void setNoOfCaPhotographs(String noOfCaPhotographs) {
        this.noOfCaPhotographs = noOfCaPhotographs;
    }

    public String getHuddlePhoto() {
        return huddlePhoto;
    }

    public void setHuddlePhoto(String huddlePhoto) {
        this.huddlePhoto = huddlePhoto;
    }

    public String getInfoGraphic() {
        return infoGraphic;
    }

    public void setInfoGraphic(String infoGraphic) {
        this.infoGraphic = infoGraphic;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((actualParticipant == null) ? 0 : actualParticipant.hashCode());
        result = prime * result + ((agency == null) ? 0 : agency.hashCode());
        result = prime * result + ((attendanceCollected == null) ? 0 : attendanceCollected.hashCode());
        result = prime * result + ((caBadges == null) ? 0 : caBadges.hashCode());
        result = prime * result + ((caTrainerPresent == null) ? 0 : caTrainerPresent.hashCode());
        result = prime * result + ((dealerContact == null) ? 0 : dealerContact.hashCode());
        result = prime * result + ((dealerPresent == null) ? 0 : dealerPresent.hashCode());
        result = prime * result + ((foPresent == null) ? 0 : foPresent.hashCode());
        result = prime * result + ((huddleCircle == null) ? 0 : huddleCircle.hashCode());
        result = prime * result + ((huddlePhoto == null) ? 0 : huddlePhoto.hashCode());
        result = prime * result + ((infoGraphic == null) ? 0 : infoGraphic.hashCode());
        result = prime * result + ((intervention == null) ? 0 : intervention.hashCode());
        result = prime * result + ((noOfCaMob == null) ? 0 : noOfCaMob.hashCode());
        result = prime * result + ((noOfCaPhotographs == null) ? 0 : noOfCaPhotographs.hashCode());
        result = prime * result + ((plannedParticipant == null) ? 0 : plannedParticipant.hashCode());
        result = prime * result + ((projectorLcd == null) ? 0 : projectorLcd.hashCode());
        result = prime * result + ((roCode == null) ? 0 : roCode.hashCode());
        result = prime * result + ((rulePoster == null) ? 0 : rulePoster.hashCode());
        result = prime * result + ((sopBookletGiven == null) ? 0 : sopBookletGiven.hashCode());
        result = prime * result + ((sopBookletLanguage == null) ? 0 : sopBookletLanguage.hashCode());
        result = prime * result + ((trainerContactNo == null) ? 0 : trainerContactNo.hashCode());
        result = prime * result + ((trainerName == null) ? 0 : trainerName.hashCode());
        result = prime * result + ((trainingDate == null) ? 0 : trainingDate.hashCode());
        result = prime * result + ((trainingDays == null) ? 0 : trainingDays.hashCode());
        result = prime * result + ((trainingVenue == null) ? 0 : trainingVenue.hashCode());
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
        CATrainingInputData other = (CATrainingInputData) obj;
        if (actualParticipant == null) {
            if (other.actualParticipant != null)
                return false;
        } else if (!actualParticipant.equals(other.actualParticipant))
            return false;
        if (agency == null) {
            if (other.agency != null)
                return false;
        } else if (!agency.equals(other.agency))
            return false;
        if (attendanceCollected == null) {
            if (other.attendanceCollected != null)
                return false;
        } else if (!attendanceCollected.equals(other.attendanceCollected))
            return false;
        if (caBadges == null) {
            if (other.caBadges != null)
                return false;
        } else if (!caBadges.equals(other.caBadges))
            return false;
        if (caTrainerPresent == null) {
            if (other.caTrainerPresent != null)
                return false;
        } else if (!caTrainerPresent.equals(other.caTrainerPresent))
            return false;
        if (dealerContact == null) {
            if (other.dealerContact != null)
                return false;
        } else if (!dealerContact.equals(other.dealerContact))
            return false;
        if (dealerPresent == null) {
            if (other.dealerPresent != null)
                return false;
        } else if (!dealerPresent.equals(other.dealerPresent))
            return false;
        if (foPresent == null) {
            if (other.foPresent != null)
                return false;
        } else if (!foPresent.equals(other.foPresent))
            return false;
        if (huddleCircle == null) {
            if (other.huddleCircle != null)
                return false;
        } else if (!huddleCircle.equals(other.huddleCircle))
            return false;
        if (huddlePhoto == null) {
            if (other.huddlePhoto != null)
                return false;
        } else if (!huddlePhoto.equals(other.huddlePhoto))
            return false;
        if (infoGraphic == null) {
            if (other.infoGraphic != null)
                return false;
        } else if (!infoGraphic.equals(other.infoGraphic))
            return false;
        if (intervention == null) {
            if (other.intervention != null)
                return false;
        } else if (!intervention.equals(other.intervention))
            return false;
        if (noOfCaMob == null) {
            if (other.noOfCaMob != null)
                return false;
        } else if (!noOfCaMob.equals(other.noOfCaMob))
            return false;
        if (noOfCaPhotographs == null) {
            if (other.noOfCaPhotographs != null)
                return false;
        } else if (!noOfCaPhotographs.equals(other.noOfCaPhotographs))
            return false;
        if (plannedParticipant == null) {
            if (other.plannedParticipant != null)
                return false;
        } else if (!plannedParticipant.equals(other.plannedParticipant))
            return false;
        if (projectorLcd == null) {
            if (other.projectorLcd != null)
                return false;
        } else if (!projectorLcd.equals(other.projectorLcd))
            return false;
        if (roCode == null) {
            if (other.roCode != null)
                return false;
        } else if (!roCode.equals(other.roCode))
            return false;
        if (rulePoster == null) {
            if (other.rulePoster != null)
                return false;
        } else if (!rulePoster.equals(other.rulePoster))
            return false;
        if (sopBookletGiven == null) {
            if (other.sopBookletGiven != null)
                return false;
        } else if (!sopBookletGiven.equals(other.sopBookletGiven))
            return false;
        if (sopBookletLanguage == null) {
            if (other.sopBookletLanguage != null)
                return false;
        } else if (!sopBookletLanguage.equals(other.sopBookletLanguage))
            return false;
        if (trainerContactNo == null) {
            if (other.trainerContactNo != null)
                return false;
        } else if (!trainerContactNo.equals(other.trainerContactNo))
            return false;
        if (trainerName == null) {
            if (other.trainerName != null)
                return false;
        } else if (!trainerName.equals(other.trainerName))
            return false;
        if (trainingDate == null) {
            if (other.trainingDate != null)
                return false;
        } else if (!trainingDate.equals(other.trainingDate))
            return false;
        if (trainingDays == null) {
            if (other.trainingDays != null)
                return false;
        } else if (!trainingDays.equals(other.trainingDays))
            return false;
        if (trainingVenue == null) {
            if (other.trainingVenue != null)
                return false;
        } else if (!trainingVenue.equals(other.trainingVenue))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "CATrainingInputData [actualParticipant=" + actualParticipant + ", agency=" + agency
                + ", attendanceCollected=" + attendanceCollected + ", caBadges=" + caBadges + ", caTrainerPresent="
                + caTrainerPresent + ", dealerContact=" + dealerContact + ", dealerPresent=" + dealerPresent
                + ", foPresent=" + foPresent + ", huddleCircle=" + huddleCircle + ", huddlePhoto=" + huddlePhoto
                + ", infoGraphic=" + infoGraphic + ", intervention=" + intervention + ", noOfCaMob=" + noOfCaMob
                + ", noOfCaPhotographs=" + noOfCaPhotographs + ", plannedParticipant=" + plannedParticipant
                + ", projectorLcd=" + projectorLcd + ", roCode=" + roCode + ", rulePoster=" + rulePoster
                + ", sopBookletGiven=" + sopBookletGiven + ", sopBookletLanguage=" + sopBookletLanguage
                + ", trainerContactNo=" + trainerContactNo + ", trainerName=" + trainerName + ", trainingDate="
                + trainingDate + ", trainingDays=" + trainingDays + ", trainingVenue=" + trainingVenue + "]";
    }
}

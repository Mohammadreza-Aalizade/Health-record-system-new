package ir.pt.HRS.dto;

import ir.pt.HRS.entity.Drug;
import ir.pt.HRS.entity.Prescription;
import ir.pt.HRS.entity.VisitPrescription;

public class PrescriptionDTO {

    private long presId;
    private VisitPrescription visitPrescription;
    private Drug drug;
    private String usage_note;

    public PrescriptionDTO(Prescription prescription) {
        this.presId = prescription.getPresId();
        this.visitPrescription = prescription.getVisitPrescription();
        this.drug = prescription.getDrug();
        this.usage_note = prescription.getUsage_note();
    }

    public PrescriptionDTO() {
    }

    public long getPresId() {
        return presId;
    }

    public void setPresId(long presId) {
        this.presId = presId;
    }

    public VisitPrescription getVisitPrescription() {
        return visitPrescription;
    }

    public void setVisitPrescription(VisitPrescription visitPrescription) {
        this.visitPrescription = visitPrescription;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public String getUsage_note() {
        return usage_note;
    }

    public void setUsage_note(String usage_note) {
        this.usage_note = usage_note;
    }
}

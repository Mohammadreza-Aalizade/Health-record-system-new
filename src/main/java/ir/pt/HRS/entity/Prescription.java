package ir.pt.HRS.entity;

import javax.persistence.*;

@Entity
@Table(name = "prescription")
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "presID")
    private long presId;

    @ManyToOne
    @JoinColumn(name = "vid")
    private VisitPrescription visitPrescription;

    @ManyToOne
    @JoinColumn(name = "DRUG_ID")
    private Drug drug;

    @Column(name = "usage_note")
    private String usage_note;

    public Prescription(long presId, VisitPrescription visitPrescription, Drug drug, String usage_note) {
        this.presId = presId;
        this.visitPrescription = visitPrescription;
        this.drug = drug;
        this.usage_note = usage_note;
    }

    public Prescription() {
    }

    public long getPresId() {
        return presId;
    }

    public void setPresId(long presID) {
        this.presId = presID;
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

package ir.pt.HRS.dto;

import ir.pt.HRS.entity.Pharmacy;
import ir.pt.HRS.entity.Reception;
import ir.pt.HRS.entity.VisitPrescription;

import javax.persistence.Column;
import java.util.Date;

public class ReceptionDTO {

    private long recId;
    private VisitPrescription visitPrescription;
    private Pharmacy pharmacy;
    private double totalPrice;

    private Date dateTime;
    public ReceptionDTO() {

    }

    public ReceptionDTO(Reception reception) {
        this.recId = reception.getRecId();
        this.visitPrescription = reception.getVisitPrescription();
        this.pharmacy = reception.getPharmacy();
        this.totalPrice = reception.getTotalPrice();
        this.dateTime = reception.getDateTime();
    }

    public long getRecId() {
        return recId;
    }

    public void setRecId(long recId) {
        this.recId = recId;
    }

    public VisitPrescription getVisitPrescription() {
        return visitPrescription;
    }

    public void setVisitPrescription(VisitPrescription visitPrescription) {
        this.visitPrescription = visitPrescription;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

}

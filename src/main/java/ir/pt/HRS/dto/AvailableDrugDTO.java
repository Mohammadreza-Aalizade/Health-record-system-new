package ir.pt.HRS.dto;

import ir.pt.HRS.entity.AvailableDrug;
import ir.pt.HRS.entity.Drug;
import ir.pt.HRS.entity.Pharmacy;

public class AvailableDrugDTO {
    private long ADrugID;
    private Drug drug;
    private Pharmacy pharmacy;
    private long stock;

    public long getADrugID() {
        return ADrugID;
    }

    public void setADrugID(long ADrugID) {
        this.ADrugID = ADrugID;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public long getStock() {
        return stock;
    }

    public void setStock(long stock) {
        this.stock = stock;
    }

    public AvailableDrugDTO() {
    }

    public AvailableDrugDTO(AvailableDrug availableDrug) {
        this.ADrugID = availableDrug.getADrugID();
        this.drug = availableDrug.getDrug();
        this.pharmacy = availableDrug.getPharmacy();
        this.stock = availableDrug.getStock();
    }
}

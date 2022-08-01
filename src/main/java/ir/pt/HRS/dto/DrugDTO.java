package ir.pt.HRS.dto;

import ir.pt.HRS.entity.Drug;

import java.util.Date;


public class DrugDTO {

    private long drugId;
    private String Name;
    private Date manufacturingDate;
    private Date expDate;
    private String manufactorName;
    private String description;

    public DrugDTO(Drug drug) {
        this.drugId = drug.getDrugId();
        Name = drug.getName();
        this.manufacturingDate = drug.getManufacturingDate();
        this.expDate = drug.getExpDate();
        this.manufactorName = drug.getManufactorName();
        this.description = drug.getDescription();
    }

    public DrugDTO() {
    }

    public long getDrugId() {
        return drugId;
    }

    public void setDrugId(long drugId) {
        this.drugId = drugId;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Date getManufacturingDate() {
        return manufacturingDate;
    }

    public void setManufacturingDate(Date manufacturingDate) {
        this.manufacturingDate = manufacturingDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public String getManufactorName() {
        return manufactorName;
    }

    public void setManufactorName(String manufactorName) {
        this.manufactorName = manufactorName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

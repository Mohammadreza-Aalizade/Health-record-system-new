package ir.pt.HRS.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "DRUG")
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DRUG_ID")
    private long drugId;

    @Column(name = "DRUG_NAME")
    private String Name;

    @Column(name = "DRUG_MANU_DATE")
    private Date manufacturingDate;

    @Column(name = "DRUG_EXP_DATE")
    private Date expDate;

    @Column(name = "DRUG_ADDRESS")
    private String manufactorName;

    @Column(name = "DESCRIPTION_ADDRESS")
    private String description;

    public Drug(long drugId, String name, Date manufacturingDate, Date expDate, String manufactorName, String description) {
        this.drugId = drugId;
        Name = name;
        this.manufacturingDate = manufacturingDate;
        this.expDate = expDate;
        this.manufactorName = manufactorName;
        this.description = description;
    }

    public Drug() {
    }

    public long getDrugId() {
        return drugId;
    }

    public void setDrugId(long doctorId) {
        this.drugId = doctorId;
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

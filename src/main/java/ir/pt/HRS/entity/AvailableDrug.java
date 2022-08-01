package ir.pt.HRS.entity;

import javax.persistence.*;

@Entity
@Table(name = "AVAILABLE_DRUG")
public class AvailableDrug {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AVL_DRUG_ID")
    private long ADrugID;

    @ManyToOne
    @JoinColumn(name = "DRUG_ID")
    private Drug drug;

    @ManyToOne
    @JoinColumn(name = "PHAR_ID")
    private Pharmacy pharmacy;

    @Column(name = "AVL_DRUG_STOCK")
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

    public AvailableDrug() {
    }

    public AvailableDrug(long ADrugID, Drug drug, Pharmacy pharmacy, long stock) {
        this.ADrugID = ADrugID;
        this.drug = drug;
        this.pharmacy = pharmacy;
        this.stock = stock;
    }
}

package ir.pt.HRS.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "RECEPTION")
public class Reception {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REC_ID")
    private long recId;

    @OneToOne
    @JoinColumn(name = "vid")
    private VisitPrescription visitPrescription;

    @ManyToOne
    @JoinColumn(name = "PHAR_ID")
    private Pharmacy pharmacy;

    @Column(name = "REC_PRICE")
    private double totalPrice;

    @Column(name = "REC_DATE")
    private Date dateTime;

    public Reception() {

    }

    public Reception(long recId, VisitPrescription visitPrescription, Pharmacy pharmacy, double totalPrice, Date dateTime) {
        this.recId = recId;
        this.visitPrescription = visitPrescription;
        this.pharmacy = pharmacy;
        this.totalPrice = totalPrice;
        this.dateTime = dateTime;
    }

    public long getRecId() {
        return recId;
    }

    public void setRecId(long recID) {
        this.recId = recID;
    }

    public VisitPrescription getVisitPrescription() {
        return visitPrescription;
    }

    public void setVisitPrescription(VisitPrescription visitPrescription) {
        this.visitPrescription = visitPrescription;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getDateTime() {
        return dateTime;
    }

    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

}

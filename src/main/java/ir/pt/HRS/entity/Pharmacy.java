package ir.pt.HRS.entity;

import javax.persistence.*;

@Entity
@Table(name = "PHARMACY")
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PHAR_ID")
    private long pharId;

    @Column(name = "PHAR_NAME")
    private String name;

    @Column(name = "PHAR_ADDRESS")
    private String address;

    @Column(name = "PHAR_TELL")
    private long telephone;

    public Pharmacy() {
    }

    public long getPharId() {
        return pharId;
    }

    public void setPharId(long pharID) {
        this.pharId = pharID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTelephone() {
        return telephone;
    }

    public void setTelephone(long telephone) {
        this.telephone = telephone;
    }

    public Pharmacy(long pharId, String name, String address, long telephone) {
        this.pharId = pharId;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }
}

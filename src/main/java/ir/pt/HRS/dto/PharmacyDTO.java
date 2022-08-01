package ir.pt.HRS.dto;

import ir.pt.HRS.entity.Pharmacy;

public class PharmacyDTO {
    private long pharId;
    private String name;
    private String address;
    private long telephone;

    public PharmacyDTO(Pharmacy pharmacy) {
        this.pharId = pharmacy.getPharId();
        this.name = pharmacy.getName();
        this.address = address;
        this.telephone = telephone;
    }

    public PharmacyDTO() {
    }

    public long getPharId() {
        return pharId;
    }

    public void setPharId(long pharId) {
        this.pharId = pharId;
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

}



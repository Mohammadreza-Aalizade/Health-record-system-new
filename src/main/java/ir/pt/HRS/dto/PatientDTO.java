package ir.pt.HRS.dto;


import ir.pt.HRS.entity.Patient;

public class PatientDTO {

    private long pid;
    private String pName;
    private String pDob;
    private String pAdd;
    private long pMobileNo;
    private String Email;

    public PatientDTO(Patient patient) {
        this.pName = patient.getpName();
        this.pid = patient.getPid();
        this.pAdd = patient.getpAdd();
        this.pDob = patient.getpDob();
        this.pMobileNo = patient.getpMobileNo();
        this.Email = patient.getEmail();
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public PatientDTO() {

    }

    public PatientDTO(long pid, String pName, String pDob, String pAdd, long pMobileNo, String email) {
        this.pid = pid;
        this.pName = pName;
        this.pDob = pDob;
        this.pAdd = pAdd;
        this.pMobileNo = pMobileNo;
        Email = email;
    }

    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getpDob() {
        return pDob;
    }

    public void setpDob(String pDob) {
        this.pDob = pDob;
    }

    public String getpAdd() {
        return pAdd;
    }

    public void setpAdd(String pAdd) {
        this.pAdd = pAdd;
    }

    public long getpMobileNo() {
        return pMobileNo;
    }

    public void setpMobileNo(long pMobileNo) {
        this.pMobileNo = pMobileNo;
    }

}

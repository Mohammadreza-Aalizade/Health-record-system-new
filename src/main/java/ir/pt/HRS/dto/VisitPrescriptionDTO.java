package ir.pt.HRS.dto;


import ir.pt.HRS.entity.Doctor;
import ir.pt.HRS.entity.Patient;
import ir.pt.HRS.entity.VisitPrescription;

import java.util.Date;

public class VisitPrescriptionDTO {
    public long getvId() {
        return vId;
    }

    public void setvId(long vId) {
        this.vId = vId;
    }

    public String getvName() {
        return vName;
    }

    public void setvName(String vName) {
        this.vName = vName;
    }

    public Date getvDate() {
        return vDate;
    }

    public void setvDate(Date vDate) {
        this.vDate = vDate;
    }

    public String getvDoctorAdvices() {
        return vDoctorAdvices;
    }

    public void setvDoctorAdvices(String vDoctorAdvices) {
        this.vDoctorAdvices = vDoctorAdvices;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    private long vId;
    private String vName;
    private Date vDate;
    private String vDoctorAdvices;

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    private Doctor doctor;
    private Patient patient;

    public VisitPrescriptionDTO() {
        // TODO Auto-generated constructor stub
    }

    public VisitPrescriptionDTO(VisitPrescription visitPrescription) {
        super();
        this.vId = visitPrescription.getVId();
        this.patient = visitPrescription.getPatient();
        this.doctor = visitPrescription.getDoctor();
        this.vDoctorAdvices = visitPrescription.getvDoctorAdvices();
        this.vName = visitPrescription.getvName();
        this.vDate = visitPrescription.getvDate();
    }
}

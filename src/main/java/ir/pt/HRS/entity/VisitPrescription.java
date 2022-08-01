package ir.pt.HRS.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "VisitPrescription")
public class VisitPrescription {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vid")
	private long vId;

	@Column(name = "vName")
	private String vName;

	@Temporal(TemporalType.DATE)
	@Column(name = "vDate")
	private Date vDate;

	@Column(name = "vDoctorAdvices")
	private String vDoctorAdvices;

	@ManyToOne
	@JoinColumn(name = "DOC_ID")
	private Doctor doctor;

	@ManyToOne
	@JoinColumn(name = "PAT_ID")
	private Patient patient;

	public VisitPrescription() {
	}

	public VisitPrescription(long vId, String vName, Date vDate, String vDoctorAdvices, Doctor doctor, Patient patient) {
		this.vId = vId;
		this.vName = vName;
		this.vDate = vDate;
		this.vDoctorAdvices = vDoctorAdvices;
		this.doctor = doctor;
		this.patient = patient;
	}


	@Override
	public String toString() {
		return "Test [tid=" + vId + ", tName=" + vName + ", tDate=" + vDate + ", doctor=" + doctor + "]";
	}


	public long getVId() {
		return vId;
	}

	public void setVId(long vid) {
		this.vId = vid;
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

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}
}

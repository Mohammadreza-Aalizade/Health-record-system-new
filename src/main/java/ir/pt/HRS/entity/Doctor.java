package ir.pt.HRS.entity;

import javax.persistence.*;

@Entity
@Table(name = "DOCTOR")
public class Doctor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "DOC_ID")
	private long doctorId;

	@Column(name = "DOC_NAME")
	private String doctorName;

	@Column(name = "DOC_ADDRESS")
	private String doctorAddress;

	@Column(name = "PHONE_NO")
	private long doctorPhoneNO;



	@OneToOne
	@JoinColumn(name = "SPEC_ID")
	private Specialization specialization;

	public long getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(long doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorAddress() {
		return doctorAddress;
	}

	public void setDoctorAddress(String doctorAddress) {
		this.doctorAddress = doctorAddress;
	}

	public long getDoctorPhoneNO() {
		return doctorPhoneNO;
	}

	public void setDoctorPhoneNO(long doctorPhoneNO) {
		this.doctorPhoneNO = doctorPhoneNO;
	}

	public Specialization getSepcialization() {
		return specialization;
	}

	public void setSpecialization(Specialization specialization) {
		this.specialization = specialization;
	}

	
}

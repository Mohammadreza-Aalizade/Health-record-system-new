package ir.pt.HRS.entity;


import javax.persistence.*;

@Entity
@Table(name="SPECIALIZATION")
public class Specialization {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "SPEC_ID")
	private long specId;
	
	@Column(name="SPECIALITY")
	private String speciality;

	public Specialization() {
	}

	public Specialization(long specId, String speciality) {
		this.specId = specId;
		this.speciality = speciality;
	}

	public long getSpecId() {
		return specId;
	}

	public void setSpecId(long specId) {
		this.specId = specId;
	}

	public String getSpeciality() {
		return this.speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
}


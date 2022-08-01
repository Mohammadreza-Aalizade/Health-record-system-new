package ir.pt.HRS.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "PATIENT")
public class Patient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pid")
	private long pid;

	@Column(name = "pname")
	private String pName;

	@Column(name = "pdob")
	private String pDob;

	@Column(name = "paddress")
	private String pAdd;

	@Column(name = "pmobile")
	private long pMobileNo;

	@Email
	@Column(name = "pemail")
	private String Email;

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public Patient() {
	}

	public Patient(long pid, String pName, String pDob, String pAdd, long pMobileNo, String email) {
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

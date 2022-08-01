package ir.pt.HRS.service;

import ir.pt.HRS.dto.DoctorDTO;

import java.util.List;
import java.util.Map;

public interface DoctorService {
	
	public DoctorDTO save(DoctorDTO doctorDTO);
    public DoctorDTO update(DoctorDTO doctorDTO, long docId) throws Exception;
	public DoctorDTO getById(long doctorId) throws Exception;
	public List<DoctorDTO> getAll();
	public Map<String, Boolean> delete(long doctorId) throws Exception;
	public boolean existsByNumber(DoctorDTO doctorDTO);

}

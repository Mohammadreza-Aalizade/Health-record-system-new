package ir.pt.HRS.service;

import ir.pt.HRS.dto.PatientDTO;

import java.util.List;
import java.util.Map;

public interface PatientService {

	public PatientDTO save(PatientDTO patientDTO);
    public PatientDTO update(PatientDTO patientDTO,  long pid) throws Exception;
	public PatientDTO getById(long pid) throws Exception;
	public List<PatientDTO> getAll();
	public Map<String, Boolean> delete(long pid) throws Exception;
	public boolean existsByNumber(PatientDTO patientDTO);
}

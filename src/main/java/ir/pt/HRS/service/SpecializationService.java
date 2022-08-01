package ir.pt.HRS.service;

import ir.pt.HRS.dto.SpecializationDTO;

import java.util.List;
import java.util.Map;

public interface SpecializationService {
	
	public SpecializationDTO save(SpecializationDTO specializationDTO);
    public SpecializationDTO update(SpecializationDTO specializationDTO, long specId) throws Exception;
	public SpecializationDTO getById(long specId) throws Exception;
	public List<SpecializationDTO> getAll();
	public Map<String, Boolean> delete(long specId) throws Exception;

}

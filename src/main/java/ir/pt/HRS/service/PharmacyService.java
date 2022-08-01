package ir.pt.HRS.service;

import ir.pt.HRS.dto.PharmacyDTO;

import java.util.List;
import java.util.Map;

public interface PharmacyService {
	
	public PharmacyDTO save(PharmacyDTO pharmacyDTO);
    public PharmacyDTO update(PharmacyDTO pharmacyDTO, long pharId) throws Exception;
	public PharmacyDTO getById(long pharId) throws Exception;
	public List<PharmacyDTO> getAll();
	public Map<String, Boolean> delete(long pharId) throws Exception;

}

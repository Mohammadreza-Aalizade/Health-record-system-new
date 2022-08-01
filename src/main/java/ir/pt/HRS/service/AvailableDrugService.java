package ir.pt.HRS.service;

import ir.pt.HRS.dto.AvailableDrugDTO;

import java.util.List;
import java.util.Map;

public interface AvailableDrugService {
	
	public AvailableDrugDTO save(AvailableDrugDTO availableDrugDTO);
    public AvailableDrugDTO update(AvailableDrugDTO availableDrugDTO, long ADrugID) throws Exception;
	public AvailableDrugDTO getById(long ADrugID) throws Exception;
	public List<AvailableDrugDTO> getAll();
	public Map<String, Boolean> delete(long ADrugID) throws Exception;

}

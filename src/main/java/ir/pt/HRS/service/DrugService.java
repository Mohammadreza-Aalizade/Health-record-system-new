package ir.pt.HRS.service;

import ir.pt.HRS.dto.DrugDTO;

import java.util.List;
import java.util.Map;

public interface DrugService {
	
	public DrugDTO save(DrugDTO drugDTO);
    public DrugDTO update(DrugDTO drugDTO, long drugId) throws Exception;
	public DrugDTO getById(long drugId) throws Exception;
	public List<DrugDTO> getAll();
	public Map<String, Boolean> delete(long drugId) throws Exception;

}

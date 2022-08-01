package ir.pt.HRS.service;

import ir.pt.HRS.dto.ReceptionDTO;

import java.util.List;
import java.util.Map;

public interface ReceptionService {

	public ReceptionDTO save(ReceptionDTO receptionDTO);
    public ReceptionDTO update(ReceptionDTO receptionDTO, long recId) throws Exception;
	public ReceptionDTO getById(long recId) throws Exception;
	public List<ReceptionDTO> getAll();
	public Map<String, Boolean> delete(long recId) throws Exception;

}

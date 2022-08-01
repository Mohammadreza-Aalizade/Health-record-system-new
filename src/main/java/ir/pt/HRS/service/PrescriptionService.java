package ir.pt.HRS.service;

import ir.pt.HRS.dto.PrescriptionDTO;

import java.util.List;
import java.util.Map;

public interface PrescriptionService {

	public PrescriptionDTO save(PrescriptionDTO prescriptionDTO);
    public PrescriptionDTO update(PrescriptionDTO prescriptionDTO, long presId) throws Exception;
	public PrescriptionDTO getById(long presId) throws Exception;
	public List<PrescriptionDTO> getAll();
	public Map<String, Boolean> delete(long presId) throws Exception;

}

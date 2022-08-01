package ir.pt.HRS.service;

import ir.pt.HRS.dao_Repository.PrescriptionRepository;
import ir.pt.HRS.entity.Prescription;
import ir.pt.HRS.dto.PrescriptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PrescriptionServiceImpl implements PrescriptionService{

	@Autowired
	private PrescriptionRepository pRepo;
	
	private Prescription convertDTOtoModel(PrescriptionDTO prescriptionDTO) {

		Prescription prescription = new Prescription();

		prescription.setPresId(prescriptionDTO.getPresId());
		prescription.setVisitPrescription(prescriptionDTO.getVisitPrescription());
		prescription.setDrug(prescriptionDTO.getDrug());
		prescription.setUsage_note(prescriptionDTO.getUsage_note());

		return prescription;
	}
	
	/*
	 * Convert Model To DTO
	 */
	private PrescriptionDTO convertModelToDTO(Prescription prescription) {
		return new PrescriptionDTO(prescription);
	}

	@Override
	public PrescriptionDTO save(PrescriptionDTO prescriptionDTO) {
		Prescription prescription = convertDTOtoModel(prescriptionDTO);
		pRepo.save(prescription);
		return convertModelToDTO(prescription);
	}

	@Override
	public PrescriptionDTO update(PrescriptionDTO prescriptionDTO, long presId) throws Exception{
		PrescriptionDTO cpyPrescription = getById(presId);

		cpyPrescription.setVisitPrescription(prescriptionDTO.getVisitPrescription());
		cpyPrescription.setDrug(prescriptionDTO.getDrug());
		cpyPrescription.setUsage_note(prescriptionDTO.getUsage_note());

		Prescription prescription = convertDTOtoModel(cpyPrescription);
		pRepo.save(prescription);
		return convertModelToDTO(prescription);
	}

	@Override
	public PrescriptionDTO getById(long presId) throws Exception{
		Prescription prescription = pRepo.findById(presId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION ::::" + presId));
		return convertModelToDTO(prescription);
	}

	@Override
	public List<PrescriptionDTO> getAll() {
		List<Prescription> prescriptionList = pRepo.findAll();
		List<PrescriptionDTO> prescriptionDTOList = new ArrayList<>();
		
		for(Prescription prescription : prescriptionList) {
			prescriptionDTOList.add(convertModelToDTO(prescription));
		}
		return prescriptionDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long presId) throws Exception {
		Prescription prescription = convertDTOtoModel(getById(presId));
		
		pRepo.delete(prescription);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Delete", Boolean.TRUE);
		
		return response;
	}


}

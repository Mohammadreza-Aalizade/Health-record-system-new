package ir.pt.HRS.service;

import ir.pt.HRS.dao_Repository.PharmacyRepository;
import ir.pt.HRS.entity.Pharmacy;
import ir.pt.HRS.dto.PharmacyDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PharmacyServiceImpl implements PharmacyService{

	@Autowired
	private PharmacyRepository pRepo;
	
	private Pharmacy convertDTOtoModel(PharmacyDTO pharmacyDTO) {

		Pharmacy pharmacy = new Pharmacy();

		pharmacy.setPharId(pharmacyDTO.getPharId());
		pharmacy.setAddress(pharmacyDTO.getAddress());
		pharmacy.setName(pharmacyDTO.getName());
		pharmacy.setTelephone(pharmacyDTO.getTelephone());

		return pharmacy;
	}
	
	/*
	 * Convert Model To DTO
	 */
	private PharmacyDTO convertModelToDTO(Pharmacy pharmacy) {
		return new PharmacyDTO(pharmacy);
	}

	@Override
	public PharmacyDTO save(PharmacyDTO pharmacyDTO) {
		Pharmacy pharmacy = convertDTOtoModel(pharmacyDTO);
		pRepo.save(pharmacy);
		return convertModelToDTO(pharmacy);
	}

	@Override
	public PharmacyDTO update(PharmacyDTO pharmacyDTO, long pharId) throws Exception {
		PharmacyDTO cpyPharmacyDTO = getById(pharId);

		cpyPharmacyDTO.setAddress(pharmacyDTO.getAddress());
		cpyPharmacyDTO.setName(pharmacyDTO.getName());
		cpyPharmacyDTO.setTelephone(pharmacyDTO.getTelephone());

		Pharmacy pharmacy = convertDTOtoModel(cpyPharmacyDTO);
		pRepo.save(pharmacy);
		return convertModelToDTO(pharmacy);
	}

	@Override
	public PharmacyDTO getById(long pharId) throws Exception {
		Pharmacy doctor = pRepo.findById(pharId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION ::::" + pharId));
		return convertModelToDTO(doctor);
	}

	@Override
	public List<PharmacyDTO> getAll() {
		List<Pharmacy> docList = pRepo.findAll();
		List<PharmacyDTO> docDTOList = new ArrayList<>();
		
		for(Pharmacy pharmacy : docList) {
			docDTOList.add(convertModelToDTO(pharmacy));
		}
		return docDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long pharId) throws Exception {
		Pharmacy pharmacy = convertDTOtoModel(getById(pharId));
		
		pRepo.delete(pharmacy);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Delete", Boolean.TRUE);
		
		return response;
	}


}

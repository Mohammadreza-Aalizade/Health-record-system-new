package ir.pt.HRS.service;

import ir.pt.HRS.dao_Repository.AvailableDrugRepository;
import ir.pt.HRS.entity.AvailableDrug;
import ir.pt.HRS.dto.AvailableDrugDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AvailableDrugServiceImpl implements AvailableDrugService{

	@Autowired
	private AvailableDrugRepository aRepo;
	
	private AvailableDrug convertDTOtoModel(AvailableDrugDTO availableDrugDTO) {

		AvailableDrug availableDrug = new AvailableDrug();

		availableDrug.setADrugID(availableDrugDTO.getADrugID());
		availableDrug.setDrug(availableDrugDTO.getDrug());
		availableDrug.setPharmacy(availableDrugDTO.getPharmacy());
		availableDrug.setStock(availableDrugDTO.getStock());

		return availableDrug;
	}
	
	/*
	 * Convert Model To DTO
	 */
	private AvailableDrugDTO convertModelToDTO(AvailableDrug availableDrug) {
		return new AvailableDrugDTO(availableDrug);
	}

	@Override
	public AvailableDrugDTO save(AvailableDrugDTO availableDrugDTO) {
		AvailableDrug availableDrug = convertDTOtoModel(availableDrugDTO);
		aRepo.save(availableDrug);
		return convertModelToDTO(availableDrug);
	}

	@Override
	public AvailableDrugDTO update(AvailableDrugDTO availableDrugDTO, long ADrugID) throws Exception {
		AvailableDrugDTO cpyAvailableDrug = getById(ADrugID);

		cpyAvailableDrug.setDrug(availableDrugDTO.getDrug());
		cpyAvailableDrug.setPharmacy(availableDrugDTO.getPharmacy());
		cpyAvailableDrug.setStock(availableDrugDTO.getStock());

		AvailableDrug availableDrug = convertDTOtoModel(cpyAvailableDrug);
		aRepo.save(availableDrug);
		return convertModelToDTO(availableDrug);
	}

	@Override
	public  AvailableDrugDTO getById(long ADrugID) throws Exception {
		AvailableDrug availableDrug = aRepo.findById(ADrugID)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION ::::" + ADrugID));
		return convertModelToDTO(availableDrug);
	}

	@Override
	public List<AvailableDrugDTO> getAll() {
		List<AvailableDrug> availableDrugList = aRepo.findAll();
		List<AvailableDrugDTO> availableDrugDTOList = new ArrayList<>();
		
		for(AvailableDrug availableDrug : availableDrugList) {
			availableDrugDTOList.add(convertModelToDTO(availableDrug));
		}
		return availableDrugDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long ADrugID) throws Exception {
		AvailableDrug availableDrug = convertDTOtoModel(getById(ADrugID));
		
		aRepo.delete(availableDrug);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Delete", Boolean.TRUE);
		
		return response;
	}

}

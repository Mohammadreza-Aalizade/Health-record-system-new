package ir.pt.HRS.service;

import ir.pt.HRS.dao_Repository.DrugRepository;
import ir.pt.HRS.entity.Drug;
import ir.pt.HRS.dto.DrugDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DrugServiceImpl implements DrugService{

	@Autowired
	private DrugRepository dRepo;

	private Drug convertDTOtoModel( DrugDTO drugDTO) {

		Drug drug = new  Drug();
		
		drug.setDrugId(drugDTO.getDrugId());
		drug.setDescription(drugDTO.getDescription());
		drug.setExpDate(drugDTO.getExpDate());
		drug.setName(drugDTO.getName());
		drug.setManufactorName(drugDTO.getManufactorName());
		drug.setManufacturingDate(drugDTO.getManufacturingDate());
		drug.setManufacturingDate(drugDTO.getManufacturingDate());

		return drug;
	}
	
	/*
	 * Convert Model To DTO
	 */
	private DrugDTO convertModelToDTO(Drug drug) {
		return new DrugDTO(drug);
	}

	@Override
	public DrugDTO save(DrugDTO drugDTO) {
		Drug drug = convertDTOtoModel(drugDTO);
		dRepo.save(drug);
		return convertModelToDTO(drug);
	}

	@Override
	public DrugDTO update(DrugDTO drugDTO, long drugId) throws Exception {
		DrugDTO cpyDrug = getById(drugId);
		
		cpyDrug.setDescription(drugDTO.getDescription());
		cpyDrug.setManufacturingDate(drugDTO.getManufacturingDate());
		cpyDrug.setExpDate(drugDTO.getExpDate());
		cpyDrug.setManufactorName(drugDTO.getManufactorName());
		cpyDrug.setName(drugDTO.getName());
		cpyDrug.setManufactorName(drugDTO.getManufactorName());

		Drug drug = convertDTOtoModel(cpyDrug);
		dRepo.save(drug);
		return convertModelToDTO(drug);
	}

	@Override
	public DrugDTO getById(long drugId) throws Exception {
		Drug drug = dRepo.findById(drugId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION ::::" + drugId));
		return convertModelToDTO(drug);
	}

	@Override
	public List<DrugDTO> getAll() {
		List<Drug> drugList = dRepo.findAll();
		List<DrugDTO> drugDTOList = new ArrayList<>();
		
		for(Drug drug : drugList) {
			drugDTOList.add(convertModelToDTO(drug));
		}
		return drugDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long drugId) throws Exception {
		Drug drug = convertDTOtoModel(getById(drugId));
		
		dRepo.delete(drug);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Delete", Boolean.TRUE);
		
		return response;
	}

}

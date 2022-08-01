package ir.pt.HRS.service;

import ir.pt.HRS.dao_Repository.SpecializationRepository;
import ir.pt.HRS.entity.Specialization;
import ir.pt.HRS.dto.SpecializationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SpecializationServiceImpl implements SpecializationService{

	@Autowired
	private SpecializationRepository sRepo;
	
	private Specialization convertDTOtoModel(SpecializationDTO doctorDTO) {

		Specialization specialization = new Specialization();
		
		specialization.setSpecId(doctorDTO.getSpecId());
		specialization.setSpeciality(doctorDTO.getSpeciality());
		
		return specialization;
	}
	
	/*
	 * Convert Model To DTO
	 */
	private SpecializationDTO convertModelToDTO(Specialization specialization) {
		return new SpecializationDTO(specialization);
	}

	@Override
	public SpecializationDTO save(SpecializationDTO specializationDTO) {
		Specialization specialization = convertDTOtoModel(specializationDTO);
		sRepo.save(specialization);
		return convertModelToDTO(specialization);
	}

	@Override
	public SpecializationDTO update(SpecializationDTO specializationDTO, long specId) throws Exception {
		SpecializationDTO cpySpecialization = getById(specId);
		
		cpySpecialization.setSpeciality(specializationDTO.getSpeciality());

		Specialization specialization = convertDTOtoModel(cpySpecialization);
		sRepo.save(specialization);
		return convertModelToDTO(specialization);
	}

	@Override
	public SpecializationDTO getById(long specId) throws Exception{
		Specialization specialization = sRepo.findById(specId)
				.orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION ::::" + specId));
		return convertModelToDTO(specialization);
	}

	@Override
	public List<SpecializationDTO> getAll(){
		List<Specialization> specializationList = sRepo.findAll();
		List<SpecializationDTO> specializationDTOList = new ArrayList<>();
		
		for(Specialization specialization : specializationList) {
			specializationDTOList.add(convertModelToDTO(specialization));
		}
		return specializationDTOList;
	}

	@Override
	public Map<String, Boolean> delete(long specId) throws Exception {
		Specialization specialization = convertDTOtoModel(getById(specId));
		
		sRepo.delete(specialization);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Delete", Boolean.TRUE);
		
		return response;
	}


}

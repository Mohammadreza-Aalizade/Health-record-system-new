package ir.pt.HRS.controller;

import ir.pt.HRS.dto.SpecializationDTO;
import ir.pt.HRS.service.SpecializationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class SpecializationController {

    @Autowired
    private SpecializationServiceImpl specializationService;

    @PostMapping(value = "/specialization")
    public ResponseEntity<SpecializationDTO> addSpecialization(@RequestBody SpecializationDTO specializationDTO) {

        SpecializationDTO specializationDTO1 = specializationService.save(specializationDTO);
        return ResponseEntity.ok().body(specializationDTO1);
    }

    @PutMapping(value = "/specialization/{id}")
    public ResponseEntity<SpecializationDTO> updateSpecialization(@RequestBody SpecializationDTO specializationDTO, @PathVariable("id") long id)
            throws Exception {

        SpecializationDTO specializationDTO1 = specializationService.update(specializationDTO, id);
        return ResponseEntity.ok().body(specializationDTO1);
    }

    @DeleteMapping(value = "/specialization/{id}")
    public Map<String, Boolean> deleteSpecialization(@PathVariable long id) throws Exception {
        return specializationService.delete(id);
    }

    @GetMapping(value = "/specialization/{id}")
    public ResponseEntity<SpecializationDTO> findById(@PathVariable long id) throws Exception {

        SpecializationDTO specializationDTO = specializationService.getById(id);
        return ResponseEntity.ok().body(specializationDTO);
    }

    @GetMapping(value = "/specialization")
    public ResponseEntity<List<SpecializationDTO>> listAll() {
        List<SpecializationDTO> specializationDTOList = specializationService.getAll();
        return ResponseEntity.ok().body(specializationDTOList);
    }
}

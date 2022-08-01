package ir.pt.HRS.controller;

import ir.pt.HRS.dto.PharmacyDTO;
import ir.pt.HRS.service.PharmacyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class PharmacyController {

    @Autowired
    private PharmacyServiceImpl pharmacyService;

    @PostMapping(value = "/pharmacy")
    public ResponseEntity<PharmacyDTO> addPharmacy(@RequestBody PharmacyDTO pharmacyDTO) {

        PharmacyDTO pharmacyDTO1 = pharmacyService.save(pharmacyDTO);
        return ResponseEntity.ok().body(pharmacyDTO1);
    }

    @PutMapping(value = "/pharmacy/{id}")
    public ResponseEntity<PharmacyDTO> updatePharmacy(@RequestBody PharmacyDTO pharmacyDTO, @PathVariable("id") long id)
            throws Exception {

        PharmacyDTO pharmacyDTO1 = pharmacyService.update(pharmacyDTO, id);
        return ResponseEntity.ok().body(pharmacyDTO1);
    }

    @DeleteMapping(value = "/pharmacy/{id}")
    public Map<String, Boolean> deletePharmacy(@PathVariable long id) throws Exception {
        return pharmacyService.delete(id);
    }

    @GetMapping(value = "/pharmacy/{id}")
    public ResponseEntity<PharmacyDTO> findById(@PathVariable long id) throws Exception {

        PharmacyDTO pharmacyDTO = pharmacyService.getById(id);
        return ResponseEntity.ok().body(pharmacyDTO);
    }

    @GetMapping(value = "/pharmacy")
    public ResponseEntity<List<PharmacyDTO>> listAll() {
        List<PharmacyDTO> pharmacyDTOList = pharmacyService.getAll();
        return ResponseEntity.ok().body(pharmacyDTOList);
    }

}

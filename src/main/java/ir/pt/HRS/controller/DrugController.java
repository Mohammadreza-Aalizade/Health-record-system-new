package ir.pt.HRS.controller;

import ir.pt.HRS.dto.DrugDTO;
import ir.pt.HRS.service.DrugServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class DrugController {

    @Autowired
    private DrugServiceImpl drugService;

    @PostMapping(value = "/drug")
    public ResponseEntity<DrugDTO> addDrug(@RequestBody DrugDTO drugDTO) {

        DrugDTO drugDTO1 = drugService.save(drugDTO);
        return ResponseEntity.ok().body(drugDTO1);
    }

    @PutMapping(value = "/drug/{id}")
    public ResponseEntity<DrugDTO> updateDrug(@RequestBody DrugDTO drugDTO, @PathVariable("id") long id)
            throws Exception {

        DrugDTO drugDTO1 = drugService.update(drugDTO, id);
        return ResponseEntity.ok().body(drugDTO1);
    }

    @DeleteMapping(value = "/drug/{id}")
    public Map<String, Boolean> deleteDrug(@PathVariable long id) throws Exception {
        return drugService.delete(id);
    }

    @GetMapping(value = "/drug/{id}")
    public ResponseEntity<DrugDTO> findById(@PathVariable long id) throws Exception {

        DrugDTO drugDTO = drugService.getById(id);
        return ResponseEntity.ok().body(drugDTO);
    }

    @GetMapping(value = "/drug")
    public ResponseEntity<List<DrugDTO>> listAll() {
        List<DrugDTO> drugDTOList = drugService.getAll();
        return ResponseEntity.ok().body(drugDTOList);
    }

}

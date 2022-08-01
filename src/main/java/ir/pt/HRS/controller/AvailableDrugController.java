package ir.pt.HRS.controller;

import ir.pt.HRS.dto.AvailableDrugDTO;
import ir.pt.HRS.service.AvailableDrugServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class AvailableDrugController {

    @Autowired
    private AvailableDrugServiceImpl availableDrugService;

    @PostMapping(value = "/aDrug")
    public ResponseEntity<AvailableDrugDTO> addAvailableDrug(@RequestBody AvailableDrugDTO availableDrugDTO) {

        AvailableDrugDTO availableDrugDTO1 = availableDrugService.save(availableDrugDTO);
        return ResponseEntity.ok().body(availableDrugDTO1);
    }

    @PutMapping(value = "/aDrug/{id}")
    public ResponseEntity<AvailableDrugDTO> updateAvailableDrug(@RequestBody AvailableDrugDTO availableDrugDTO, @PathVariable("id") long id)
            throws Exception {

        AvailableDrugDTO availableDrugDTO1 = availableDrugService.update(availableDrugDTO, id);
        return ResponseEntity.ok().body(availableDrugDTO1);
    }

    @DeleteMapping(value = "/aDrug/{id}")
    public Map<String, Boolean> deleteAvailableDrug(@PathVariable long id) throws Exception {
        return availableDrugService.delete(id);
    }

    @GetMapping(value = "/aDrug/{id}")
    public ResponseEntity<AvailableDrugDTO> findById(@PathVariable long id) throws Exception {

        AvailableDrugDTO availableDrugDTO = availableDrugService.getById(id);
        return ResponseEntity.ok().body(availableDrugDTO);
    }

    @GetMapping(value = "/aDrug")
    public ResponseEntity<List<AvailableDrugDTO>> listAll() {
        List<AvailableDrugDTO> availableDrugDTOList = availableDrugService.getAll();
        return ResponseEntity.ok().body(availableDrugDTOList);
    }

}

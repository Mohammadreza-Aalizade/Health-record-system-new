package ir.pt.HRS.controller;


import ir.pt.HRS.dto.PrescriptionDTO;
import ir.pt.HRS.service.PrescriptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class PrescriptionController {

    @Autowired
    private PrescriptionServiceImpl prescriptionService;

    @PostMapping(value = "/prescription")
    public ResponseEntity<PrescriptionDTO> addPrescription(@RequestBody PrescriptionDTO prescriptionDTO) {

        PrescriptionDTO prescriptionDTO1 = prescriptionService.save(prescriptionDTO);
        return ResponseEntity.ok().body(prescriptionDTO1);
    }

    @PutMapping(value = "/prescription/{id}")
    public ResponseEntity<PrescriptionDTO> updatePrescription(@RequestBody PrescriptionDTO prescriptionDTO, @PathVariable("id") long id)
            throws Exception {

        PrescriptionDTO prescriptionDTO1 = prescriptionService.update(prescriptionDTO, id);
        return ResponseEntity.ok().body(prescriptionDTO1);
    }

    @DeleteMapping(value = "/prescription/{id}")
    public Map<String, Boolean> deletePrescription(@PathVariable long id) throws Exception {
        return prescriptionService.delete(id);
    }

    @GetMapping(value = "/prescription/{id}")
    public ResponseEntity<PrescriptionDTO> findById(@PathVariable long id) throws Exception {

        PrescriptionDTO prescriptionDTO = prescriptionService.getById(id);
        return ResponseEntity.ok().body(prescriptionDTO);
    }

    @GetMapping(value = "/prescription")
    public ResponseEntity<List<PrescriptionDTO>> listAll() {
        List<PrescriptionDTO> prescriptionDTOList = prescriptionService.getAll();
        return ResponseEntity.ok().body(prescriptionDTOList);
    }


}

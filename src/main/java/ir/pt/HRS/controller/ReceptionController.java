package ir.pt.HRS.controller;

import ir.pt.HRS.dto.ReceptionDTO;
import ir.pt.HRS.service.ReceptionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class ReceptionController {

    @Autowired
    private ReceptionServiceImpl receptionService;

    @PostMapping(value = "/reception")
    public ResponseEntity<ReceptionDTO> addReception(@RequestBody ReceptionDTO receptionDTO) {

        ReceptionDTO receptionDTO1 = receptionService.save(receptionDTO);
        return ResponseEntity.ok().body(receptionDTO1);
    }

    @PutMapping(value = "/reception/{id}")
    public ResponseEntity<ReceptionDTO> updateReception(@RequestBody ReceptionDTO receptionDTO, @PathVariable("id") long id)
            throws Exception {

        ReceptionDTO receptionDTO1 = receptionService.update(receptionDTO, id);
        return ResponseEntity.ok().body(receptionDTO1);
    }

    @DeleteMapping(value = "/reception/{id}")
    public Map<String, Boolean> deleteReception(@PathVariable long id) throws Exception {
        return receptionService.delete(id);
    }

    @GetMapping(value = "/reception/{id}")
    public ResponseEntity<ReceptionDTO> findById(@PathVariable long id) throws Exception {

        ReceptionDTO receptionDTO = receptionService.getById(id);
        return ResponseEntity.ok().body(receptionDTO);
    }

    @GetMapping(value = "/reception")
    public ResponseEntity<List<ReceptionDTO>> listAll() {
        List<ReceptionDTO> receptionDTOList = receptionService.getAll();
        return ResponseEntity.ok().body(receptionDTOList);
    }


}

package ir.pt.HRS.service;

import ir.pt.HRS.dao_Repository.PatientRepository;
import ir.pt.HRS.dao_Repository.ReceptionRepository;
import ir.pt.HRS.dao_Repository.VisitPrescriptionRepository;
import ir.pt.HRS.dto.EmailDetails;
import ir.pt.HRS.entity.Patient;
import ir.pt.HRS.entity.Reception;
import ir.pt.HRS.dto.ReceptionDTO;
import ir.pt.HRS.entity.VisitPrescription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Service
@Transactional
public class ReceptionServiceImpl implements ReceptionService {

    @Autowired
    private ReceptionRepository rRepo;
    @Autowired
    private PatientRepository pRepo;

    private Reception convertDTOtoModel(ReceptionDTO receptionDTO) {

        Reception reception = new Reception();

        reception.setPharmacy(receptionDTO.getPharmacy());
        reception.setVisitPrescription(receptionDTO.getVisitPrescription());
        reception.setRecId(receptionDTO.getRecId());

        return reception;
    }

    /*
     * Convert Model To DTO
     */
    private ReceptionDTO convertModelToDTO(Reception reception) {
        return new ReceptionDTO(reception);
    }

    @Autowired
    private EmailService emailService;

    @Override
    public ReceptionDTO save(ReceptionDTO receptionDTO) {
        Reception reception = convertDTOtoModel(receptionDTO);
        VisitPrescription visitPrescription = reception.getVisitPrescription();
        Patient patient = visitPrescription.getPatient();

        String MsgBody = String.format("Patient name: %s\nPhone: %d\nDoctor: %s\nVisit time: %t\nReception time: %t\nTotal price: %a\n",
                patient.getpName(),
                patient.getpMobileNo(),
                visitPrescription.getDoctor().getDoctorName(),
                visitPrescription.getvDate(),
                reception.getDateTime(),
                reception.getTotalPrice());

        EmailDetails details = new EmailDetails();
        details.setMsgBody(MsgBody);
        details.setRecipient(patient.getEmail());
        details.setSubject("Reception receipt");
        emailService.sendSimpleMail(details);

        rRepo.save(reception);
        return convertModelToDTO(reception);
    }

    @Override
    public ReceptionDTO update(ReceptionDTO receptionDTO, long recId) throws Exception {
        ReceptionDTO cpyReception = getById(recId);

        cpyReception.setVisitPrescription(receptionDTO.getVisitPrescription());
        cpyReception.setPharmacy(receptionDTO.getPharmacy());

        Reception reception = convertDTOtoModel(cpyReception);
        rRepo.save(reception);
        return convertModelToDTO(reception);
    }

    @Override
    public ReceptionDTO getById(long recId) throws Exception {
        Reception reception = rRepo.findById(recId)
                .orElseThrow(() -> new Exception("ID NOT FOUND EXCEPTION ::::" + recId));
        return convertModelToDTO(reception);
    }

    @Override
    public List<ReceptionDTO> getAll() {
        List<Reception> receptionList = rRepo.findAll();
        List<ReceptionDTO> receptionDTOList = new ArrayList<>();

        for (Reception reception : receptionList) {
            receptionDTOList.add(convertModelToDTO(reception));
        }
        return receptionDTOList;
    }

    @Override
    public Map<String, Boolean> delete(long recId) throws Exception {
        Reception reception = convertDTOtoModel(getById(recId));

        rRepo.delete(reception);
        Map<String, Boolean> response = new HashMap<>();
        response.put("Delete", Boolean.TRUE);

        return response;
    }


}

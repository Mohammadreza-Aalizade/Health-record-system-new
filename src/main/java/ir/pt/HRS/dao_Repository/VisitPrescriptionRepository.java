package ir.pt.HRS.dao_Repository;

import ir.pt.HRS.entity.VisitPrescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitPrescriptionRepository extends JpaRepository<VisitPrescription,Long> {
    @Override
    VisitPrescription getById(Long aLong);
}

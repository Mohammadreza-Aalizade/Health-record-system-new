package ir.pt.HRS.dao_Repository;

import ir.pt.HRS.entity.Prescription;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrescriptionRepository extends JpaRepository<Prescription,Long> {
}

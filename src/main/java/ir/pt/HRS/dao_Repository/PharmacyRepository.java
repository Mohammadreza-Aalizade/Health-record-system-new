package ir.pt.HRS.dao_Repository;

import ir.pt.HRS.entity.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyRepository extends JpaRepository<Pharmacy,Long> {
}

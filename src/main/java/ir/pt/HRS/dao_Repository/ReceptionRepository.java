package ir.pt.HRS.dao_Repository;

import ir.pt.HRS.entity.Reception;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptionRepository extends JpaRepository<Reception,Long> {
}

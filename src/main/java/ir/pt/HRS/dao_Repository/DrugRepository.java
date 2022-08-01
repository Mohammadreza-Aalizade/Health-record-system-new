package ir.pt.HRS.dao_Repository;

import ir.pt.HRS.entity.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug,Long> {
}

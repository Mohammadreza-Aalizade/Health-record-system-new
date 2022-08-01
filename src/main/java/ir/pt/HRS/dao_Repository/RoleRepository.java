package ir.pt.HRS.dao_Repository;

import ir.pt.HRS.Enums.ERole;
import ir.pt.HRS.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);

}

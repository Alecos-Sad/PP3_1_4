package pp3_1_4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pp3_1_4.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
}

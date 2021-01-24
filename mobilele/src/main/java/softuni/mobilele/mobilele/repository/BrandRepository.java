package softuni.mobilele.mobilele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.mobilele.mobilele.models.entities.BrandEntity;

@Repository
public interface BrandRepository extends JpaRepository<BrandEntity,Long> {
}

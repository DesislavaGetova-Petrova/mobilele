package softuni.mobilele.mobilele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.mobilele.mobilele.models.entities.ModelEntity;

@Repository
public interface ModelRepository extends JpaRepository<ModelEntity,Long> {

}

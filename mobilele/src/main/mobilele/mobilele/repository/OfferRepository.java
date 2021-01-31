package softuni.mobilele.mobilele.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import softuni.mobilele.mobilele.model.entities.OfferEntity;

@Repository
public interface OfferRepository extends JpaRepository<OfferEntity, Long> {

}

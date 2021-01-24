package softuni.mobilele.mobilele;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import softuni.mobilele.mobilele.models.entities.BrandEntity;
import softuni.mobilele.mobilele.repository.BrandRepository;
import softuni.mobilele.mobilele.repository.ModelRepository;

import java.time.Instant;

@Component
public class DBInit implements CommandLineRunner {
    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    public  DBInit(ModelRepository modelRepository1, BrandRepository brandRepository){
        this.modelRepository = modelRepository1;
        this.brandRepository = brandRepository;
    }
    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand=new BrandEntity();
        fordBrand.setName("Ford");
        fordBrand.setCreated(Instant.now());
        fordBrand.setUpdated(Instant.now());
        brandRepository.save(fordBrand);

    }
}

package softuni.mobilele.mobilele;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import softuni.mobilele.mobilele.model.entities.*;
import softuni.mobilele.mobilele.model.entities.enums.EngineEnum;
import softuni.mobilele.mobilele.model.entities.enums.ModelCategoryEnum;
import softuni.mobilele.mobilele.model.entities.enums.TransmissionEnum;
import softuni.mobilele.mobilele.repository.BrandRepository;
import softuni.mobilele.mobilele.repository.ModelRepository;
import softuni.mobilele.mobilele.repository.OfferRepository;
import softuni.mobilele.mobilele.repository.UserRepository;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.List;

@Component
public class DBInit implements CommandLineRunner {

    private final ModelRepository modelRepository;
    private final BrandRepository brandRepository;
    private final OfferRepository offerRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DBInit(ModelRepository modelRepository,
                  BrandRepository brandRepository,
                  OfferRepository offerRepository,
                  UserRepository userRepository,
                  PasswordEncoder passwordEncoder) {
        this.modelRepository = modelRepository;
        this.brandRepository = brandRepository;
        this.offerRepository = offerRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        BrandEntity fordBrand = new BrandEntity();
        fordBrand.setName("Ford");
        setCurrentTimestamps(fordBrand);

        BrandEntity hondaBrand = new BrandEntity();
        hondaBrand.setName("Honda");
        setCurrentTimestamps(hondaBrand);

        brandRepository.saveAll(List.of(fordBrand, hondaBrand));

        ModelEntity fiestaModel = initFiesta(fordBrand);
        initEscort(fordBrand);
        initNC750S(hondaBrand);
        createFiestaOffer(fiestaModel);

        initAdmin();
    }

    private void initAdmin() {
        UserEntity admin = new UserEntity();
        admin.setFirstName("Петър");
        admin.setLastName("Димитров");
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("topsecret"));
        setCurrentTimestamps(admin);

        userRepository.save(admin);
    }

    private void createFiestaOffer(ModelEntity modelEntity) {
        OfferEntity fiestaOffer = new OfferEntity();

        fiestaOffer.
                setEngine(EngineEnum.GASOLINE).
                setImageUrl("https://media.autoexpress.co.uk/image/private/s--7btEt2wi--/v1562244788/autoexpress/2017/07/dsc_1328-1.jpg").
                setMileage(40000).
                setPrice(BigDecimal.valueOf(10000)).
                setYear(2019).
                setDescription("Karana e ot nemska baba. Zimata v garaj.").
                setTransmission(TransmissionEnum.MANUAL).
                setModel(modelEntity);

        setCurrentTimestamps(fiestaOffer);

        offerRepository.save(fiestaOffer);
    }

    private ModelEntity initNC750S(BrandEntity hondaBrand){
        ModelEntity nc750s = new ModelEntity();

        nc750s.
                setName("NC750S").
                setCategory(ModelCategoryEnum.MOTORCYCLE).
                setImageUrl("https://www.mitchellsmc.co.uk/wp-content/uploads/2020/07/IMG_0686.jpg").
                setStartYear(2014).
                setBrand(hondaBrand);

        setCurrentTimestamps(nc750s);

        return modelRepository.save(nc750s);
    }

    private ModelEntity initEscort(BrandEntity fordBrand) {
        ModelEntity escort = new ModelEntity();

        escort.
                setName("Escort").
                setCategory(ModelCategoryEnum.CAR).
                setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/Ford_Escort_MkI_1100_1972.JPG/1920px-Ford_Escort_MkI_1100_1972.JPG").
                setStartYear(1968).
                setEndYear(2002).
                setBrand(fordBrand);

        setCurrentTimestamps(escort);

        return modelRepository.save(escort);
    }

    private ModelEntity initFiesta(BrandEntity fordBrand) {
        ModelEntity fiesta = new ModelEntity();

        fiesta.
                setName("Fiesta").
                setCategory(ModelCategoryEnum.CAR).
                setImageUrl("https://upload.wikimedia.org/wikipedia/commons/thumb/7/7d/2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg/420px-2017_Ford_Fiesta_Zetec_Turbo_1.0_Front.jpg").
                setStartYear(1976).
                setBrand(fordBrand);

        setCurrentTimestamps(fiesta);

        return modelRepository.save(fiesta);
    }

    private static void setCurrentTimestamps(BaseEntity baseEntity) {
        baseEntity.setCreated(Instant.now());
        baseEntity.setUpdated(Instant.now());
    }
}

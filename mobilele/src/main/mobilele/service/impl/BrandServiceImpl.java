package softuni.mobilele.mobilele.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.mobilele.mobilele.model.entities.BrandEntity;
import softuni.mobilele.mobilele.model.entities.ModelEntity;
import softuni.mobilele.mobilele.model.view.BrandViewModel;
import softuni.mobilele.mobilele.model.view.ModelViewModel;
import softuni.mobilele.mobilele.repository.ModelRepository;
import softuni.mobilele.mobilele.service.BrandService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BrandServiceImpl implements BrandService {

    private final ModelRepository modelRepository;
    private final ModelMapper modelMapper;

    public BrandServiceImpl(ModelRepository modelRepository,
                            ModelMapper modelMapper) {
        this.modelRepository = modelRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<BrandViewModel> getAllBrands() {

        List<BrandViewModel> result = new ArrayList<>();// <- final result here

        List<ModelEntity> allModels =
                modelRepository.findAll();

        allModels.forEach(me -> {
            // example: fiesta -> ford
            BrandEntity brandEntity = me.getBrand();

            Optional<BrandViewModel> brandViewModelOpt = findByName(result,
                    brandEntity.getName());
            if (!brandViewModelOpt.isPresent()) {
                // not yet in the result, we will create a new model
                BrandViewModel newBrandViewModel = new BrandViewModel();
                modelMapper.map(brandEntity, newBrandViewModel);
                result.add(newBrandViewModel);
                brandViewModelOpt = Optional.of(newBrandViewModel);
            }

            ModelViewModel newModelViewModel = new ModelViewModel();
            modelMapper.map(me, newModelViewModel);
            brandViewModelOpt.get().addModel(newModelViewModel);
        });

        return result;
    }

    private static Optional<BrandViewModel>
    findByName(List<BrandViewModel> allModels, String name) {
        return allModels.
                stream().
                filter(m-> m.getName().equals(name)).
                findAny();
    }
}

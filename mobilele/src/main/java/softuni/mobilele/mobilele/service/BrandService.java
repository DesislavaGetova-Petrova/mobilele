package softuni.mobilele.mobilele.service;

import org.springframework.stereotype.Service;
import softuni.mobilele.mobilele.models.view.BrandViewModel;

import java.util.List;


public interface BrandService {
   List<BrandViewModel> getAllBrands();
}

package softuni.mobilele.mobilele.model.view;

import java.util.List;

public class BrandViewModel {
    private String name;

    private List<ModelViewModel> models;

    public String getName() {
        return name;
    }

    public BrandViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<ModelViewModel> getModels() {
        return models;
    }
    public BrandViewModel setModels(List<ModelViewModel> models) {
        this.models = models;
        return this;
    }
    public BrandViewModel addModel(ModelViewModel modelViewModel) {
        this.models.add(modelViewModel);
        return this;
    }


    @Override
    public String toString() {
        return "BrandViewModel{" +
                "name='" + name + '\'' +
                ", models=" + models +
                '}';
    }
}

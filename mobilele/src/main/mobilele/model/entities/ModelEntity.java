package softuni.mobilele.mobilele.model.entities;

import softuni.mobilele.mobilele.model.entities.enums.ModelCategoryEnum;

import javax.persistence.*;

@Entity
@Table(name="models")
public class ModelEntity extends BaseEntity{
    @Column(unique = true, nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    private ModelCategoryEnum category;

    @Column(length = 512)
    private String imageUrl;

    @Column
    private int startYear;

    @Column
    private Integer endYear;

    @ManyToOne
    private BrandEntity brand;

    public String getName() {
        return name;
    }



    public ModelCategoryEnum getCategory() {
        return category;
    }



    public String getImageUrl() {
        return imageUrl;
    }



    public int getStartYear() {
        return startYear;
    }



    public Integer getEndYear() {
        return endYear;
    }



    public BrandEntity getBrand() {
        return brand;
    }

    public ModelEntity setName(String name) {
        this.name = name;
        return this;
    }

    public ModelEntity setCategory(ModelCategoryEnum category) {
        this.category = category;
        return this;
    }

    public ModelEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public ModelEntity setStartYear(int startYear) {
        this.startYear = startYear;
        return this;
    }

    public ModelEntity setEndYear(Integer endYear) {
        this.endYear = endYear;
        return this;
    }

    public ModelEntity setBrand(BrandEntity brand) {
        this.brand = brand;
        return this;
    }

    @Override
    public String toString() {
        return "ModelEntity{" +
                "name='" + name + '\'' +
                ", category=" + category +
                ", imageUrl='" + imageUrl + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", brand=" + brand +
                ", id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}

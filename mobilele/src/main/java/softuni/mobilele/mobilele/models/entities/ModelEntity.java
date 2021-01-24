package softuni.mobilele.mobilele.models.entities;

import softuni.mobilele.mobilele.models.entities.enums.ModelCategoryEnum;

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
    private int endYear;

    @ManyToOne
    private BrandEntity brand;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelCategoryEnum getCategory() {
        return category;
    }

    public void setCategory(ModelCategoryEnum category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public BrandEntity getBrand() {
        return brand;
    }

    public void setBrand(BrandEntity brand) {
        this.brand = brand;
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

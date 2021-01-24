package softuni.mobilele.mobilele.models.entities;

import softuni.mobilele.mobilele.models.entities.enums.EngineEnum;
import softuni.mobilele.mobilele.models.entities.enums.TransmissionEnum;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name ="offers")
public class OfferEntity extends BaseEntity {
    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    private EngineEnum engine;
    @Column
    private String imageUrl;
    @Column
    private int mileage;
    @Column
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    private TransmissionEnum transmission;
    @Column
    private int year;

    @ManyToOne
    private ModelEntity model;

    @ManyToOne
    private UserEntity user;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public EngineEnum getEngine() {
        return engine;
    }

    public void setEngine(EngineEnum engine) {
        this.engine = engine;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public TransmissionEnum getTransmission() {
        return transmission;
    }

    public void setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ModelEntity getModel() {
        return model;
    }

    public void setModel(ModelEntity model) {
        this.model = model;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "description='" + description + '\'' +
                ", engine=" + engine +
                ", imageUrl='" + imageUrl + '\'' +
                ", mileage=" + mileage +
                ", price=" + price +
                ", transmission=" + transmission +
                ", year=" + year +
                ", model=" + model +
                ", user=" + user +
                ", id=" + id +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}

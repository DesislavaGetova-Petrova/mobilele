package softuni.mobilele.mobilele.model.entities;

import softuni.mobilele.mobilele.model.entities.enums.EngineEnum;
import softuni.mobilele.mobilele.model.entities.enums.TransmissionEnum;

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



    public EngineEnum getEngine() {
        return engine;
    }


    public String getImageUrl() {
        return imageUrl;
    }



    public int getMileage() {
        return mileage;
    }



    public BigDecimal getPrice() {
        return price;
    }



    public TransmissionEnum getTransmission() {
        return transmission;
    }



    public int getYear() {
        return year;
    }



    public ModelEntity getModel() {
        return model;
    }



    public UserEntity getUser() {
        return user;
    }

    public OfferEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    public OfferEntity setEngine(EngineEnum engine) {
        this.engine = engine;
        return this;
    }

    public OfferEntity setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
        return this;
    }

    public OfferEntity setMileage(int mileage) {
        this.mileage = mileage;
        return this;
    }

    public OfferEntity setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }

    public OfferEntity setTransmission(TransmissionEnum transmission) {
        this.transmission = transmission;
        return this;
    }

    public OfferEntity setYear(int year) {
        this.year = year;
        return this;
    }

    public OfferEntity setModel(ModelEntity model) {
        this.model = model;
        return this;
    }

    public OfferEntity setUser(UserEntity user) {
        this.user = user;
        return this;
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

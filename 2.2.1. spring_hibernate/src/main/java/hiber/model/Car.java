package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long series;

    @Column(name = "model")
    private String model;


    @OneToOne(mappedBy = "car")
    private User user;

    public Car() {}

    public Car(String model) {
        this.model = model;

    }
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }



    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + series +
                ", model='" + model + '\'' +
                ", series=" + series +
                '}';
    }
}

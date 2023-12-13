package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Table(name = "models")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Model {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")//brand_id ile brand arasinda fiziksel iliski kurulacak db tarafinda.
    private Brand brand;

    //kisaca bir modelin birden fazl aracini tutabiliriz yani 1 bmw e3 modelinden 15 tane olabilir.
    @OneToMany(mappedBy = "model")
    private List<Car> cars;
}
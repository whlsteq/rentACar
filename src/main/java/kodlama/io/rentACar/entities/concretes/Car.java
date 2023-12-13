package kodlama.io.rentACar.entities.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "cars")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "plate",unique = true)
    private String plate;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "state")
    private int state;// 1-Available 2- Rented 3-Maintenance

//    modelin icinde brand bilgisi oldugundan (brand_id brand verileri yerine geldiginden) buraya model i eklemek yeterli yaninda modelin markasinida getirmis oluyor.
    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;
}

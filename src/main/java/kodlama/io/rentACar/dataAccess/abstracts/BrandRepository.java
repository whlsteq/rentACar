package kodlama.io.rentACar.dataAccess.abstracts;


import kodlama.io.rentACar.entities.concretes.Brand;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
//BrandDao
public interface BrandRepository extends JpaRepository<Brand,Integer> {
    boolean existsByName(String name);//spring jpa keywords (burda jpanin keyywordlerinden dolayi otomatik kendisi arama yapiyor )

}

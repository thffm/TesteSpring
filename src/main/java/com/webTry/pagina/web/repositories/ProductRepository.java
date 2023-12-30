package com.webTry.pagina.web.repositories;

import com.webTry.pagina.web.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {

}

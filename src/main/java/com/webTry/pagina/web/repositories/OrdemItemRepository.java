package com.webTry.pagina.web.repositories;

import com.webTry.pagina.web.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdemItemRepository extends JpaRepository<OrderItem,Long> {
}

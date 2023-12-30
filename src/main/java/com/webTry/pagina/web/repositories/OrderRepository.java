package com.webTry.pagina.web.repositories;

import com.webTry.pagina.web.entities.Order;
import com.webTry.pagina.web.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
}

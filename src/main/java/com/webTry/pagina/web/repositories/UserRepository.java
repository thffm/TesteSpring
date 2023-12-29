package com.webTry.pagina.web.repositories;

import com.webTry.pagina.web.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User,Long> {
}

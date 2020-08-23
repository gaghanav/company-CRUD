package com.enigmacamp.valentino.DAO;

import com.enigmacamp.valentino.entitys.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionDAO extends JpaRepository<Position, Integer> {
}

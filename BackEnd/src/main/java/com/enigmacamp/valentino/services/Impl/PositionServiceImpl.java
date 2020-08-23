package com.enigmacamp.valentino.services.Impl;

import com.enigmacamp.valentino.DAO.PositionDAO;
import com.enigmacamp.valentino.entitys.Position;
import com.enigmacamp.valentino.services.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    @Autowired
    PositionDAO positionDAO;

    @Override
    public List<Position> getList() {
        return positionDAO.findAll();
    }
}

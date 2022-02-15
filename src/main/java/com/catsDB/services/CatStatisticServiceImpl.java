package com.catsDB.services;

import com.catsDB.models.Cat;
import com.catsDB.repository.CatsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatStatisticServiceImpl implements CatStatisticService{
    @Autowired
    protected CatsRepository catsRepository;

    @Override
    public List<Cat> getAll() {
        return catsRepository.findAll();
    }
}

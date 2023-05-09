package com.plantshop.service_impl;

import com.plantshop.entity.Plant;
import com.plantshop.repository.PlantRepo;
import com.plantshop.repository_impl.PlantRepoImpl;
import com.plantshop.service.PlantService;
import java.util.ArrayList;

public class PlantServiceImp implements PlantService {

    PlantRepo plantRepo = new PlantRepoImpl();

    @Override
    public ArrayList<Plant> findAll() {
        return plantRepo.findAll();
    }

    @Override
    public ArrayList<Plant> findPlantByKeywordName(String keyword) {
        return plantRepo.findByKeywordName(keyword);
    }

    @Override
    public ArrayList<Plant> findByNameAndCategoryWithOffsetAndLimitWithOrderBy(String key, String category, Integer offset, Integer limit, String orderBy) {
        return plantRepo.findByNameAndCategoryWithOffsetAndLimitWithOrderBy(key, category, offset, limit, orderBy);
    }

    @Override
    public Plant findById(Integer id) {
        return plantRepo.findById(String.valueOf(id));
    }

    @Override
    public ArrayList<Plant> findTopFourNewPlant() {
        return plantRepo.findTopNewPlant(4);
    }

    @Override
    public ArrayList<Plant> findByNameAndCategory(String key, String category) {
        return plantRepo.findByNameAndCategory(key, category);
    }

    @Override
    public Integer save(String name, String category, String price, String description, String uuidFileName) {
        return plantRepo.save(name, category, price, description, uuidFileName);
    }

    @Override
    public void update(String name, String category, String price, String description, String uuidFileName, Integer PID) {
        plantRepo.update(name, category, price, description, uuidFileName, PID);
    }

}

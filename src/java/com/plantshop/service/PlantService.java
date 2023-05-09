package com.plantshop.service;

import com.plantshop.entity.Plant;
import java.util.ArrayList;

public interface PlantService {

    public ArrayList<Plant> findAll();

    public ArrayList<Plant> findPlantByKeywordName(String keyword);

    public ArrayList<Plant> findByNameAndCategoryWithOffsetAndLimitWithOrderBy(String key, String category, Integer offset, Integer limit, String orderBy);

    public Plant findById(Integer id);

    public ArrayList<Plant> findTopFourNewPlant();

    public ArrayList<Plant> findByNameAndCategory(String key, String category);

    public Integer save(String name, String category, String price, String description, String uuidFileName);

    public void update(String name, String category, String price, String description, String uuidFileName, Integer PID);
}

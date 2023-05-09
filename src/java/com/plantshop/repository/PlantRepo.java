package com.plantshop.repository;

import com.plantshop.entity.Plant;
import java.util.ArrayList;

public interface PlantRepo {

    public ArrayList<Plant> findAll();

    public ArrayList<Plant> findByKeywordName(String keyword);

    public ArrayList<Plant> findByNameAndCategoryWithOffsetAndLimitWithOrderBy(String key, String category, Integer offset, Integer limit, String orderBy);

    public Plant findById(String id);

    public ArrayList<Plant> findTopNewPlant(Integer i);

    public ArrayList<Plant> findByNameAndCategory(String key, String category);

    public Integer save(String name, String category, String price, String description, String uuidFileName);

    public void update(String name, String category, String price, String description, String uuidFileName, Integer PID);
}

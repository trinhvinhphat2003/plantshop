package com.plantshop.repository_impl;

import com.plantshop.entity.Plant;
import com.plantshop.repository.PlantRepo;
import java.util.ArrayList;
import mapperEntity.PlantMapper;

public class PlantRepoImpl extends GenericRepoImpl<Plant> implements PlantRepo {

    @Override
    public ArrayList<Plant> findAll() {
        StringBuilder query = new StringBuilder("select * from Plants");
        return query(query.toString(), new PlantMapper());
    }

    @Override
    public ArrayList<Plant> findByKeywordName(String keyword) {
        StringBuilder query = new StringBuilder("select * from Plants where PName like '%" + keyword + "%'");
        return query(query.toString(), new PlantMapper());
    }

    @Override
    public ArrayList<Plant> findByNameAndCategoryWithOffsetAndLimitWithOrderBy(String key, String category, Integer offset, Integer limit, String orderBy) {
        StringBuilder query = new StringBuilder("select * from plants as p inner join categories as c on p.CatelD = c.CatelD\n"
                + "where p.Pname like '%" + key + "%' and c.CateName like '%" + category + "%'\n"
                + "order by PID desc\n"
                + "offset " + offset + " rows\n"
                + "fetch next " + limit + " rows only;");
        return query(query.toString(), new PlantMapper());
    }

    @Override
    public Plant findById(String id) {
        StringBuilder query = new StringBuilder("select * from Plants where PID = " + id);
        ArrayList<Plant> plants = query(query.toString(), new PlantMapper());
        return plants.size() == 0 ? null : plants.get(0);
    }

    @Override
    public ArrayList<Plant> findTopNewPlant(Integer i) {
        StringBuilder query = new StringBuilder("select top " + i + " * from plants\n"
                + "order by PID desc");
        return query(query.toString(), new PlantMapper());
    }

    @Override
    public ArrayList<Plant> findByNameAndCategory(String key, String category) {
        StringBuilder query = new StringBuilder("select * from plants as p inner join categories as c on p.CatelD = c.CatelD\n"
                + "where p.Pname like '%" + key + "%' and c.CateName like '%" + category + "%'");
        return query(query.toString(), new PlantMapper());
    }

    @Override
    public Integer save(String name, String category, String price, String description, String uuidFileName) {
        StringBuilder query = new StringBuilder("insert into plants(pname, cateld, price, description, imgpath, status) values(?, ?, ?, ?, ?, 1)");
        return insert(query.toString(), name, Integer.parseInt(category), Integer.parseInt(price), description, uuidFileName);
    }

    @Override
    public void update(String name, String category, String price, String description, String uuidFileName, Integer PID) {
        StringBuilder query = new StringBuilder("update plants set pname = ?, cateld = ?, price = ?, description = ?, imgpath = ?, status = 1 where [PID] = ?");
        update(query.toString(), name, Integer.parseInt(category), Integer.parseInt(price), description, uuidFileName, PID);
    }

}

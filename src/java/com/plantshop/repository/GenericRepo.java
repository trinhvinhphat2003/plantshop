/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.plantshop.repository;

import java.util.List;
import mapperEntity.RowMapper;

public interface GenericRepo<T> {

    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters);

    void update(String sql, Object... parameters);

    Integer insert(String sql, Object... parameters);

    int count(String sql, Object... parameters);

    boolean delete(String sql, Object... parameters);
}

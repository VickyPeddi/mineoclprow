package com.iocl.dhruva2api.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * GenericDAO
 */
@Component
public class GenericDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ArrayList<String> getTableHeaders(String query) {
        ArrayList<String> headerDatas = new ArrayList<>();
        jdbcTemplate.query(query, (ResultSet rs) -> {
            ResultSetMetaData meta = rs.getMetaData();
            System.out.println(meta.getColumnCount());
            // for (int i = 0; i < meta.getColumnCount(); i++) {
            headerDatas.add(meta.getColumnTypeName(0));
            // }
            return headerDatas;
        });
        return headerDatas;
    }
}
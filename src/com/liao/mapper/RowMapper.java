package com.liao.mapper;

import java.sql.ResultSet;
@SuppressWarnings("all")
public interface RowMapper {
    public Object objectMapper(ResultSet rs);
}

package com.multi.spring2.city.dao;

import com.multi.spring2.city.domain.CityVO;
import com.multi.spring2.city.mapper.CityMapper;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class CityDAO {
    private final SqlSessionTemplate sqlSessionTemplate;

    public CityDAO(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    public int insert(CityVO cityVO) {
        return sqlSessionTemplate.getMapper(CityMapper.class).insert(cityVO);
    }

    public List<CityVO> all() {
        return sqlSessionTemplate.getMapper(CityMapper.class).all();
    }

    /****
     *
     *
     *
     *
     * 구현 부분
     *
     *
     *
     *
     *
     *
     ****/
}


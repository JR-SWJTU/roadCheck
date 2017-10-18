package com.swjtu.roadCheck.mapper;

import com.swjtu.roadCheck.entity.QitaPeopelData;
import com.swjtu.roadCheck.entity.QitaPeopelDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QitaPeopelDataMapper {
    int countByExample(QitaPeopelDataExample example);

    int deleteByExample(QitaPeopelDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(QitaPeopelData record);

    int insertSelective(QitaPeopelData record);

    List<QitaPeopelData> selectByExample(QitaPeopelDataExample example);

    QitaPeopelData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") QitaPeopelData record, @Param("example") QitaPeopelDataExample example);

    int updateByExample(@Param("record") QitaPeopelData record, @Param("example") QitaPeopelDataExample example);

    int updateByPrimaryKeySelective(QitaPeopelData record);

    int updateByPrimaryKey(QitaPeopelData record);
}
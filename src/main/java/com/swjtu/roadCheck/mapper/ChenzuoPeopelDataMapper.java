package com.swjtu.roadCheck.mapper;

import com.swjtu.roadCheck.entity.ChenzuoPeopelData;
import com.swjtu.roadCheck.entity.ChenzuoPeopelDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ChenzuoPeopelDataMapper {
    int countByExample(ChenzuoPeopelDataExample example);

    int deleteByExample(ChenzuoPeopelDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ChenzuoPeopelData record);

    int insertSelective(ChenzuoPeopelData record);

    List<ChenzuoPeopelData> selectByExampleWithBLOBs(ChenzuoPeopelDataExample example);

    List<ChenzuoPeopelData> selectByExample(ChenzuoPeopelDataExample example);

    ChenzuoPeopelData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ChenzuoPeopelData record, @Param("example") ChenzuoPeopelDataExample example);

    int updateByExampleWithBLOBs(@Param("record") ChenzuoPeopelData record, @Param("example") ChenzuoPeopelDataExample example);

    int updateByExample(@Param("record") ChenzuoPeopelData record, @Param("example") ChenzuoPeopelDataExample example);

    int updateByPrimaryKeySelective(ChenzuoPeopelData record);

    int updateByPrimaryKeyWithBLOBs(ChenzuoPeopelData record);

    int updateByPrimaryKey(ChenzuoPeopelData record);
}
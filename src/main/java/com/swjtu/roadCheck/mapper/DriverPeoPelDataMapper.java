package com.swjtu.roadCheck.mapper;

import com.swjtu.roadCheck.entity.DriverPeoPelData;
import com.swjtu.roadCheck.entity.DriverPeoPelDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DriverPeoPelDataMapper {
    int countByExample(DriverPeoPelDataExample example);

    int deleteByExample(DriverPeoPelDataExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DriverPeoPelData record);

    int insertSelective(DriverPeoPelData record);

    List<DriverPeoPelData> selectByExample(DriverPeoPelDataExample example);

    DriverPeoPelData selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DriverPeoPelData record, @Param("example") DriverPeoPelDataExample example);

    int updateByExample(@Param("record") DriverPeoPelData record, @Param("example") DriverPeoPelDataExample example);

    int updateByPrimaryKeySelective(DriverPeoPelData record);

    int updateByPrimaryKey(DriverPeoPelData record);
}
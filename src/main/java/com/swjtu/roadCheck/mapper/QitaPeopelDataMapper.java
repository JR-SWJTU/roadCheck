package com.swjtu.roadCheck.mapper;

import com.swjtu.roadCheck.entity.QitaPeopelData;
import com.swjtu.roadCheck.entity.QitaPeopelDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface QitaPeopelDataMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qita_peopel_data
     *
     * @mbggenerated
     */
    int countByExample(QitaPeopelDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qita_peopel_data
     *
     * @mbggenerated
     */
    int deleteByExample(QitaPeopelDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qita_peopel_data
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qita_peopel_data
     *
     * @mbggenerated
     */
    int insert(QitaPeopelData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qita_peopel_data
     *
     * @mbggenerated
     */
    int insertSelective(QitaPeopelData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qita_peopel_data
     *
     * @mbggenerated
     */
    List<QitaPeopelData> selectByExample(QitaPeopelDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qita_peopel_data
     *
     * @mbggenerated
     */
    QitaPeopelData selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qita_peopel_data
     *
     * @mbggenerated
     */
    int updateByExampleSelective(@Param("record") QitaPeopelData record, @Param("example") QitaPeopelDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qita_peopel_data
     *
     * @mbggenerated
     */
    int updateByExample(@Param("record") QitaPeopelData record, @Param("example") QitaPeopelDataExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qita_peopel_data
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(QitaPeopelData record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table qita_peopel_data
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(QitaPeopelData record);
}
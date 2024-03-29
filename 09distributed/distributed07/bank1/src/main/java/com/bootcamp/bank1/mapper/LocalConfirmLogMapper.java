package com.bootcamp.bank1.mapper;

import com.bootcamp.bank1.entity.LocalConfirmLog;
import com.bootcamp.bank1.entity.LocalConfirmLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocalConfirmLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_confirm_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    long countByExample(LocalConfirmLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_confirm_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    int deleteByExample(LocalConfirmLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_confirm_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    int insert(LocalConfirmLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_confirm_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    int insertSelective(LocalConfirmLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_confirm_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    List<LocalConfirmLog> selectByExample(LocalConfirmLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_confirm_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    int updateByExampleSelective(@Param("record") LocalConfirmLog record, @Param("example") LocalConfirmLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_confirm_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    int updateByExample(@Param("record") LocalConfirmLog record, @Param("example") LocalConfirmLogExample example);

    int isExistConfirm(@Param("txNo") String txNo);
}
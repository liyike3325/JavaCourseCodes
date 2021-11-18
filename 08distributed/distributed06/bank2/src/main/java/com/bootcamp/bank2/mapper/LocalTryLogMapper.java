package com.bootcamp.bank2.mapper;

import com.bootcamp.bank2.entity.LocalTryLog;
import com.bootcamp.bank2.entity.LocalTryLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LocalTryLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Mon Nov 08 17:21:28 CST 2021
     */
    long countByExample(LocalTryLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Mon Nov 08 17:21:28 CST 2021
     */
    int deleteByExample(LocalTryLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Mon Nov 08 17:21:28 CST 2021
     */
    int insert(LocalTryLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Mon Nov 08 17:21:28 CST 2021
     */
    int insertSelective(LocalTryLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Mon Nov 08 17:21:28 CST 2021
     */
    List<LocalTryLog> selectByExample(LocalTryLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Mon Nov 08 17:21:28 CST 2021
     */
    int updateByExampleSelective(@Param("record") LocalTryLog record, @Param("example") LocalTryLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Mon Nov 08 17:21:28 CST 2021
     */
    int updateByExample(@Param("record") LocalTryLog record, @Param("example") LocalTryLogExample example);

    int isExistTry(@Param("txNo") String txNo);
}
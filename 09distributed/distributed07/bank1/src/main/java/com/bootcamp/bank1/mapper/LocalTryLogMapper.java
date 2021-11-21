package com.bootcamp.bank1.mapper;

import com.bootcamp.bank1.entity.LocalTryLog;
import com.bootcamp.bank1.entity.LocalTryLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LocalTryLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    long countByExample(LocalTryLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    int deleteByExample(LocalTryLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    int insert(LocalTryLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    int insertSelective(LocalTryLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    List<LocalTryLog> selectByExample(LocalTryLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    int updateByExampleSelective(@Param("record") LocalTryLog record, @Param("example") LocalTryLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table local_try_log
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    int updateByExample(@Param("record") LocalTryLog record, @Param("example") LocalTryLogExample example);

    int isExistTry(@Param("txNo") String txNo);
}
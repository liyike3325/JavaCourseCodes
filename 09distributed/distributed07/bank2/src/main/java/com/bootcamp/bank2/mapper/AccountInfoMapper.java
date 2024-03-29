package com.bootcamp.bank2.mapper;

import com.bootcamp.bank2.entity.AccountInfo;
import com.bootcamp.bank2.entity.AccountInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AccountInfoMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_info
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    long countByExample(AccountInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_info
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    int deleteByExample(AccountInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_info
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    int insert(AccountInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_info
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    int insertSelective(AccountInfo record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_info
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    List<AccountInfo> selectByExample(AccountInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_info
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    int updateByExampleSelective(@Param("record") AccountInfo record, @Param("example") AccountInfoExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table account_info
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    int updateByExample(@Param("record") AccountInfo record, @Param("example") AccountInfoExample example);
}
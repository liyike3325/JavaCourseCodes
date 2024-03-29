package com.bootcamp.bank2.mapper;

import com.bootcamp.bank2.entity.Balance;
import com.bootcamp.bank2.entity.BalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BalanceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    long countByExample(BalanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    int deleteByExample(BalanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    int insert(Balance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    int insertSelective(Balance record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    List<Balance> selectByExample(BalanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    int updateByExampleSelective(@Param("record") Balance record, @Param("example") BalanceExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 20:47:59 CST 2021
     */
    int updateByExample(@Param("record") Balance record, @Param("example") BalanceExample example);

    int subtractDollar(@Param("accountNo") String accountNo, @Param("dollar") Double dollar);

    int addDollar(@Param("accountNo") String accountNo, @Param("dollar") Double dollar);

    int subtractFrozenDollar(@Param("accountNo") String accountNo, @Param("frozenDollar") Double frozenDollar);

    int addFrozenDollar(@Param("accountNo") String accountNo, @Param("frozenDollar") Double frozenDollar);

    int subtractRmb(@Param("accountNo") String accountNo, @Param("rmb") Double rmb);

    int addRmb(@Param("accountNo") String accountNo, @Param("rmb") Double rmb);

    int subtractFrozenRmb(@Param("accountNo") String accountNo, @Param("frozenRmb") Double frozenRmb);

    int addFrozenRmb(@Param("accountNo") String accountNo, @Param("frozenRmb") Double frozenRmb);

    Balance getBalanceByAccountNo(@Param("accountNo") String accountNo);
}
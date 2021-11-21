package com.bootcamp.bank1.entity;

import java.io.Serializable;

public class AccountInfo implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_info.id
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_info.account_name
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    private String accountName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_info.account_no
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    private String accountNo;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_info.account_password
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    private String accountPassword;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column account_info.account_balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    private Double accountBalance;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table account_info
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_info.id
     *
     * @return the value of account_info.id
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_info.id
     *
     * @param id the value for account_info.id
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_info.account_name
     *
     * @return the value of account_info.account_name
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public String getAccountName() {
        return accountName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_info.account_name
     *
     * @param accountName the value for account_info.account_name
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_info.account_no
     *
     * @return the value of account_info.account_no
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public String getAccountNo() {
        return accountNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_info.account_no
     *
     * @param accountNo the value for account_info.account_no
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_info.account_password
     *
     * @return the value of account_info.account_password
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public String getAccountPassword() {
        return accountPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_info.account_password
     *
     * @param accountPassword the value for account_info.account_password
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column account_info.account_balance
     *
     * @return the value of account_info.account_balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public Double getAccountBalance() {
        return accountBalance;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column account_info.account_balance
     *
     * @param accountBalance the value for account_info.account_balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
    }
}
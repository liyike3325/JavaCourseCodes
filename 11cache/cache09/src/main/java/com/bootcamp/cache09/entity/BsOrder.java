package com.bootcamp.cache09.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class BsOrder implements Serializable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.id
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.uid
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private Integer uid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.tid
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private String tid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.oid
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private String oid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.item_id
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private Integer itemId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.quantity
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private Integer quantity;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.price
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private BigDecimal price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.total_fee
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private BigDecimal totalFee;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.payment
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private BigDecimal payment;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.item_name
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private String itemName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.status
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.create_time
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private Date createTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.update_time
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private Date updateTime;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column bs_order.delete_time
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private Date deleteTime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table bs_order
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    private static final long serialVersionUID = 1L;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.id
     *
     * @return the value of bs_order.id
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.id
     *
     * @param id the value for bs_order.id
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.uid
     *
     * @return the value of bs_order.uid
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.uid
     *
     * @param uid the value for bs_order.uid
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.tid
     *
     * @return the value of bs_order.tid
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public String getTid() {
        return tid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.tid
     *
     * @param tid the value for bs_order.tid
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setTid(String tid) {
        this.tid = tid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.oid
     *
     * @return the value of bs_order.oid
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public String getOid() {
        return oid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.oid
     *
     * @param oid the value for bs_order.oid
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setOid(String oid) {
        this.oid = oid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.item_id
     *
     * @return the value of bs_order.item_id
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.item_id
     *
     * @param itemId the value for bs_order.item_id
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.quantity
     *
     * @return the value of bs_order.quantity
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.quantity
     *
     * @param quantity the value for bs_order.quantity
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.price
     *
     * @return the value of bs_order.price
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.price
     *
     * @param price the value for bs_order.price
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.total_fee
     *
     * @return the value of bs_order.total_fee
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public BigDecimal getTotalFee() {
        return totalFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.total_fee
     *
     * @param totalFee the value for bs_order.total_fee
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setTotalFee(BigDecimal totalFee) {
        this.totalFee = totalFee;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.payment
     *
     * @return the value of bs_order.payment
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public BigDecimal getPayment() {
        return payment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.payment
     *
     * @param payment the value for bs_order.payment
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setPayment(BigDecimal payment) {
        this.payment = payment;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.item_name
     *
     * @return the value of bs_order.item_name
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.item_name
     *
     * @param itemName the value for bs_order.item_name
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.status
     *
     * @return the value of bs_order.status
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.status
     *
     * @param status the value for bs_order.status
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.create_time
     *
     * @return the value of bs_order.create_time
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.create_time
     *
     * @param createTime the value for bs_order.create_time
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.update_time
     *
     * @return the value of bs_order.update_time
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.update_time
     *
     * @param updateTime the value for bs_order.update_time
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column bs_order.delete_time
     *
     * @return the value of bs_order.delete_time
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public Date getDeleteTime() {
        return deleteTime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column bs_order.delete_time
     *
     * @param deleteTime the value for bs_order.delete_time
     *
     * @mbg.generated Fri Dec 03 16:09:32 CST 2021
     */
    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
    }
}
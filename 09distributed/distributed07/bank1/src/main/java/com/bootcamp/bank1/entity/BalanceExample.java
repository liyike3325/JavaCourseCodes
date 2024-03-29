package com.bootcamp.bank1.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class BalanceExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public BalanceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNull() {
            addCriterion("account_no is null");
            return (Criteria) this;
        }

        public Criteria andAccountNoIsNotNull() {
            addCriterion("account_no is not null");
            return (Criteria) this;
        }

        public Criteria andAccountNoEqualTo(String value) {
            addCriterion("account_no =", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotEqualTo(String value) {
            addCriterion("account_no <>", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThan(String value) {
            addCriterion("account_no >", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoGreaterThanOrEqualTo(String value) {
            addCriterion("account_no >=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThan(String value) {
            addCriterion("account_no <", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLessThanOrEqualTo(String value) {
            addCriterion("account_no <=", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoLike(String value) {
            addCriterion("account_no like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotLike(String value) {
            addCriterion("account_no not like", value, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoIn(List<String> values) {
            addCriterion("account_no in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotIn(List<String> values) {
            addCriterion("account_no not in", values, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoBetween(String value1, String value2) {
            addCriterion("account_no between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andAccountNoNotBetween(String value1, String value2) {
            addCriterion("account_no not between", value1, value2, "accountNo");
            return (Criteria) this;
        }

        public Criteria andRmbIsNull() {
            addCriterion("rmb is null");
            return (Criteria) this;
        }

        public Criteria andRmbIsNotNull() {
            addCriterion("rmb is not null");
            return (Criteria) this;
        }

        public Criteria andRmbEqualTo(BigDecimal value) {
            addCriterion("rmb =", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbNotEqualTo(BigDecimal value) {
            addCriterion("rmb <>", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbGreaterThan(BigDecimal value) {
            addCriterion("rmb >", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rmb >=", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbLessThan(BigDecimal value) {
            addCriterion("rmb <", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rmb <=", value, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbIn(List<BigDecimal> values) {
            addCriterion("rmb in", values, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbNotIn(List<BigDecimal> values) {
            addCriterion("rmb not in", values, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rmb between", value1, value2, "rmb");
            return (Criteria) this;
        }

        public Criteria andRmbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rmb not between", value1, value2, "rmb");
            return (Criteria) this;
        }

        public Criteria andFrozenRmbIsNull() {
            addCriterion("frozen_rmb is null");
            return (Criteria) this;
        }

        public Criteria andFrozenRmbIsNotNull() {
            addCriterion("frozen_rmb is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenRmbEqualTo(BigDecimal value) {
            addCriterion("frozen_rmb =", value, "frozenRmb");
            return (Criteria) this;
        }

        public Criteria andFrozenRmbNotEqualTo(BigDecimal value) {
            addCriterion("frozen_rmb <>", value, "frozenRmb");
            return (Criteria) this;
        }

        public Criteria andFrozenRmbGreaterThan(BigDecimal value) {
            addCriterion("frozen_rmb >", value, "frozenRmb");
            return (Criteria) this;
        }

        public Criteria andFrozenRmbGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("frozen_rmb >=", value, "frozenRmb");
            return (Criteria) this;
        }

        public Criteria andFrozenRmbLessThan(BigDecimal value) {
            addCriterion("frozen_rmb <", value, "frozenRmb");
            return (Criteria) this;
        }

        public Criteria andFrozenRmbLessThanOrEqualTo(BigDecimal value) {
            addCriterion("frozen_rmb <=", value, "frozenRmb");
            return (Criteria) this;
        }

        public Criteria andFrozenRmbIn(List<BigDecimal> values) {
            addCriterion("frozen_rmb in", values, "frozenRmb");
            return (Criteria) this;
        }

        public Criteria andFrozenRmbNotIn(List<BigDecimal> values) {
            addCriterion("frozen_rmb not in", values, "frozenRmb");
            return (Criteria) this;
        }

        public Criteria andFrozenRmbBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("frozen_rmb between", value1, value2, "frozenRmb");
            return (Criteria) this;
        }

        public Criteria andFrozenRmbNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("frozen_rmb not between", value1, value2, "frozenRmb");
            return (Criteria) this;
        }

        public Criteria andDollarIsNull() {
            addCriterion("dollar is null");
            return (Criteria) this;
        }

        public Criteria andDollarIsNotNull() {
            addCriterion("dollar is not null");
            return (Criteria) this;
        }

        public Criteria andDollarEqualTo(BigDecimal value) {
            addCriterion("dollar =", value, "dollar");
            return (Criteria) this;
        }

        public Criteria andDollarNotEqualTo(BigDecimal value) {
            addCriterion("dollar <>", value, "dollar");
            return (Criteria) this;
        }

        public Criteria andDollarGreaterThan(BigDecimal value) {
            addCriterion("dollar >", value, "dollar");
            return (Criteria) this;
        }

        public Criteria andDollarGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("dollar >=", value, "dollar");
            return (Criteria) this;
        }

        public Criteria andDollarLessThan(BigDecimal value) {
            addCriterion("dollar <", value, "dollar");
            return (Criteria) this;
        }

        public Criteria andDollarLessThanOrEqualTo(BigDecimal value) {
            addCriterion("dollar <=", value, "dollar");
            return (Criteria) this;
        }

        public Criteria andDollarIn(List<BigDecimal> values) {
            addCriterion("dollar in", values, "dollar");
            return (Criteria) this;
        }

        public Criteria andDollarNotIn(List<BigDecimal> values) {
            addCriterion("dollar not in", values, "dollar");
            return (Criteria) this;
        }

        public Criteria andDollarBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dollar between", value1, value2, "dollar");
            return (Criteria) this;
        }

        public Criteria andDollarNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("dollar not between", value1, value2, "dollar");
            return (Criteria) this;
        }

        public Criteria andFrozenDollarIsNull() {
            addCriterion("frozen_dollar is null");
            return (Criteria) this;
        }

        public Criteria andFrozenDollarIsNotNull() {
            addCriterion("frozen_dollar is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenDollarEqualTo(BigDecimal value) {
            addCriterion("frozen_dollar =", value, "frozenDollar");
            return (Criteria) this;
        }

        public Criteria andFrozenDollarNotEqualTo(BigDecimal value) {
            addCriterion("frozen_dollar <>", value, "frozenDollar");
            return (Criteria) this;
        }

        public Criteria andFrozenDollarGreaterThan(BigDecimal value) {
            addCriterion("frozen_dollar >", value, "frozenDollar");
            return (Criteria) this;
        }

        public Criteria andFrozenDollarGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("frozen_dollar >=", value, "frozenDollar");
            return (Criteria) this;
        }

        public Criteria andFrozenDollarLessThan(BigDecimal value) {
            addCriterion("frozen_dollar <", value, "frozenDollar");
            return (Criteria) this;
        }

        public Criteria andFrozenDollarLessThanOrEqualTo(BigDecimal value) {
            addCriterion("frozen_dollar <=", value, "frozenDollar");
            return (Criteria) this;
        }

        public Criteria andFrozenDollarIn(List<BigDecimal> values) {
            addCriterion("frozen_dollar in", values, "frozenDollar");
            return (Criteria) this;
        }

        public Criteria andFrozenDollarNotIn(List<BigDecimal> values) {
            addCriterion("frozen_dollar not in", values, "frozenDollar");
            return (Criteria) this;
        }

        public Criteria andFrozenDollarBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("frozen_dollar between", value1, value2, "frozenDollar");
            return (Criteria) this;
        }

        public Criteria andFrozenDollarNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("frozen_dollar not between", value1, value2, "frozenDollar");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table balance
     *
     * @mbg.generated do_not_delete_during_merge Sun Nov 21 10:25:03 CST 2021
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table balance
     *
     * @mbg.generated Sun Nov 21 10:25:03 CST 2021
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
package mf.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PayInOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PayInOrderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

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

        public Criteria andPayInOrderIdIsNull() {
            addCriterion("pay_in_order_id is null");
            return (Criteria) this;
        }

        public Criteria andPayInOrderIdIsNotNull() {
            addCriterion("pay_in_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayInOrderIdEqualTo(Long value) {
            addCriterion("pay_in_order_id =", value, "payInOrderId");
            return (Criteria) this;
        }

        public Criteria andPayInOrderIdNotEqualTo(Long value) {
            addCriterion("pay_in_order_id <>", value, "payInOrderId");
            return (Criteria) this;
        }

        public Criteria andPayInOrderIdGreaterThan(Long value) {
            addCriterion("pay_in_order_id >", value, "payInOrderId");
            return (Criteria) this;
        }

        public Criteria andPayInOrderIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_in_order_id >=", value, "payInOrderId");
            return (Criteria) this;
        }

        public Criteria andPayInOrderIdLessThan(Long value) {
            addCriterion("pay_in_order_id <", value, "payInOrderId");
            return (Criteria) this;
        }

        public Criteria andPayInOrderIdLessThanOrEqualTo(Long value) {
            addCriterion("pay_in_order_id <=", value, "payInOrderId");
            return (Criteria) this;
        }

        public Criteria andPayInOrderIdIn(List<Long> values) {
            addCriterion("pay_in_order_id in", values, "payInOrderId");
            return (Criteria) this;
        }

        public Criteria andPayInOrderIdNotIn(List<Long> values) {
            addCriterion("pay_in_order_id not in", values, "payInOrderId");
            return (Criteria) this;
        }

        public Criteria andPayInOrderIdBetween(Long value1, Long value2) {
            addCriterion("pay_in_order_id between", value1, value2, "payInOrderId");
            return (Criteria) this;
        }

        public Criteria andPayInOrderIdNotBetween(Long value1, Long value2) {
            addCriterion("pay_in_order_id not between", value1, value2, "payInOrderId");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Long value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Long value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Long value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Long value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Long value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Long value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Long> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Long> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Long value1, Long value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Long value1, Long value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andPayVendorIdIsNull() {
            addCriterion("pay_vendor_id is null");
            return (Criteria) this;
        }

        public Criteria andPayVendorIdIsNotNull() {
            addCriterion("pay_vendor_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayVendorIdEqualTo(Long value) {
            addCriterion("pay_vendor_id =", value, "payVendorId");
            return (Criteria) this;
        }

        public Criteria andPayVendorIdNotEqualTo(Long value) {
            addCriterion("pay_vendor_id <>", value, "payVendorId");
            return (Criteria) this;
        }

        public Criteria andPayVendorIdGreaterThan(Long value) {
            addCriterion("pay_vendor_id >", value, "payVendorId");
            return (Criteria) this;
        }

        public Criteria andPayVendorIdGreaterThanOrEqualTo(Long value) {
            addCriterion("pay_vendor_id >=", value, "payVendorId");
            return (Criteria) this;
        }

        public Criteria andPayVendorIdLessThan(Long value) {
            addCriterion("pay_vendor_id <", value, "payVendorId");
            return (Criteria) this;
        }

        public Criteria andPayVendorIdLessThanOrEqualTo(Long value) {
            addCriterion("pay_vendor_id <=", value, "payVendorId");
            return (Criteria) this;
        }

        public Criteria andPayVendorIdIn(List<Long> values) {
            addCriterion("pay_vendor_id in", values, "payVendorId");
            return (Criteria) this;
        }

        public Criteria andPayVendorIdNotIn(List<Long> values) {
            addCriterion("pay_vendor_id not in", values, "payVendorId");
            return (Criteria) this;
        }

        public Criteria andPayVendorIdBetween(Long value1, Long value2) {
            addCriterion("pay_vendor_id between", value1, value2, "payVendorId");
            return (Criteria) this;
        }

        public Criteria andPayVendorIdNotBetween(Long value1, Long value2) {
            addCriterion("pay_vendor_id not between", value1, value2, "payVendorId");
            return (Criteria) this;
        }

        public Criteria andAmountIsNull() {
            addCriterion("amount is null");
            return (Criteria) this;
        }

        public Criteria andAmountIsNotNull() {
            addCriterion("amount is not null");
            return (Criteria) this;
        }

        public Criteria andAmountEqualTo(Double value) {
            addCriterion("amount =", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotEqualTo(Double value) {
            addCriterion("amount <>", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThan(Double value) {
            addCriterion("amount >", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountGreaterThanOrEqualTo(Double value) {
            addCriterion("amount >=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThan(Double value) {
            addCriterion("amount <", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountLessThanOrEqualTo(Double value) {
            addCriterion("amount <=", value, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountIn(List<Double> values) {
            addCriterion("amount in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotIn(List<Double> values) {
            addCriterion("amount not in", values, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountBetween(Double value1, Double value2) {
            addCriterion("amount between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andAmountNotBetween(Double value1, Double value2) {
            addCriterion("amount not between", value1, value2, "amount");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNull() {
            addCriterion("ctime is null");
            return (Criteria) this;
        }

        public Criteria andCtimeIsNotNull() {
            addCriterion("ctime is not null");
            return (Criteria) this;
        }

        public Criteria andCtimeEqualTo(Date value) {
            addCriterion("ctime =", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotEqualTo(Date value) {
            addCriterion("ctime <>", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThan(Date value) {
            addCriterion("ctime >", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("ctime >=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThan(Date value) {
            addCriterion("ctime <", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeLessThanOrEqualTo(Date value) {
            addCriterion("ctime <=", value, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeIn(List<Date> values) {
            addCriterion("ctime in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotIn(List<Date> values) {
            addCriterion("ctime not in", values, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeBetween(Date value1, Date value2) {
            addCriterion("ctime between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andCtimeNotBetween(Date value1, Date value2) {
            addCriterion("ctime not between", value1, value2, "ctime");
            return (Criteria) this;
        }

        public Criteria andRmakeIsNull() {
            addCriterion("rmake is null");
            return (Criteria) this;
        }

        public Criteria andRmakeIsNotNull() {
            addCriterion("rmake is not null");
            return (Criteria) this;
        }

        public Criteria andRmakeEqualTo(String value) {
            addCriterion("rmake =", value, "rmake");
            return (Criteria) this;
        }

        public Criteria andRmakeNotEqualTo(String value) {
            addCriterion("rmake <>", value, "rmake");
            return (Criteria) this;
        }

        public Criteria andRmakeGreaterThan(String value) {
            addCriterion("rmake >", value, "rmake");
            return (Criteria) this;
        }

        public Criteria andRmakeGreaterThanOrEqualTo(String value) {
            addCriterion("rmake >=", value, "rmake");
            return (Criteria) this;
        }

        public Criteria andRmakeLessThan(String value) {
            addCriterion("rmake <", value, "rmake");
            return (Criteria) this;
        }

        public Criteria andRmakeLessThanOrEqualTo(String value) {
            addCriterion("rmake <=", value, "rmake");
            return (Criteria) this;
        }

        public Criteria andRmakeLike(String value) {
            addCriterion("rmake like", value, "rmake");
            return (Criteria) this;
        }

        public Criteria andRmakeNotLike(String value) {
            addCriterion("rmake not like", value, "rmake");
            return (Criteria) this;
        }

        public Criteria andRmakeIn(List<String> values) {
            addCriterion("rmake in", values, "rmake");
            return (Criteria) this;
        }

        public Criteria andRmakeNotIn(List<String> values) {
            addCriterion("rmake not in", values, "rmake");
            return (Criteria) this;
        }

        public Criteria andRmakeBetween(String value1, String value2) {
            addCriterion("rmake between", value1, value2, "rmake");
            return (Criteria) this;
        }

        public Criteria andRmakeNotBetween(String value1, String value2) {
            addCriterion("rmake not between", value1, value2, "rmake");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

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
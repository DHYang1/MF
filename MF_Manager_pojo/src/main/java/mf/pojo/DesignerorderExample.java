package mf.pojo;

import java.util.ArrayList;
import java.util.List;

public class DesignerorderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DesignerorderExample() {
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

        public Criteria andYuidIsNull() {
            addCriterion("yuId is null");
            return (Criteria) this;
        }

        public Criteria andYuidIsNotNull() {
            addCriterion("yuId is not null");
            return (Criteria) this;
        }

        public Criteria andYuidEqualTo(Long value) {
            addCriterion("yuId =", value, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidNotEqualTo(Long value) {
            addCriterion("yuId <>", value, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidGreaterThan(Long value) {
            addCriterion("yuId >", value, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidGreaterThanOrEqualTo(Long value) {
            addCriterion("yuId >=", value, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidLessThan(Long value) {
            addCriterion("yuId <", value, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidLessThanOrEqualTo(Long value) {
            addCriterion("yuId <=", value, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidIn(List<Long> values) {
            addCriterion("yuId in", values, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidNotIn(List<Long> values) {
            addCriterion("yuId not in", values, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidBetween(Long value1, Long value2) {
            addCriterion("yuId between", value1, value2, "yuid");
            return (Criteria) this;
        }

        public Criteria andYuidNotBetween(Long value1, Long value2) {
            addCriterion("yuId not between", value1, value2, "yuid");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNull() {
            addCriterion("date_time is null");
            return (Criteria) this;
        }

        public Criteria andDateTimeIsNotNull() {
            addCriterion("date_time is not null");
            return (Criteria) this;
        }

        public Criteria andDateTimeEqualTo(String value) {
            addCriterion("date_time =", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotEqualTo(String value) {
            addCriterion("date_time <>", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThan(String value) {
            addCriterion("date_time >", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeGreaterThanOrEqualTo(String value) {
            addCriterion("date_time >=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThan(String value) {
            addCriterion("date_time <", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLessThanOrEqualTo(String value) {
            addCriterion("date_time <=", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeLike(String value) {
            addCriterion("date_time like", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotLike(String value) {
            addCriterion("date_time not like", value, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeIn(List<String> values) {
            addCriterion("date_time in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotIn(List<String> values) {
            addCriterion("date_time not in", values, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeBetween(String value1, String value2) {
            addCriterion("date_time between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDateTimeNotBetween(String value1, String value2) {
            addCriterion("date_time not between", value1, value2, "dateTime");
            return (Criteria) this;
        }

        public Criteria andDesigneridIsNull() {
            addCriterion("designerId is null");
            return (Criteria) this;
        }

        public Criteria andDesigneridIsNotNull() {
            addCriterion("designerId is not null");
            return (Criteria) this;
        }

        public Criteria andDesigneridEqualTo(Long value) {
            addCriterion("designerId =", value, "designerid");
            return (Criteria) this;
        }

        public Criteria andDesigneridNotEqualTo(Long value) {
            addCriterion("designerId <>", value, "designerid");
            return (Criteria) this;
        }

        public Criteria andDesigneridGreaterThan(Long value) {
            addCriterion("designerId >", value, "designerid");
            return (Criteria) this;
        }

        public Criteria andDesigneridGreaterThanOrEqualTo(Long value) {
            addCriterion("designerId >=", value, "designerid");
            return (Criteria) this;
        }

        public Criteria andDesigneridLessThan(Long value) {
            addCriterion("designerId <", value, "designerid");
            return (Criteria) this;
        }

        public Criteria andDesigneridLessThanOrEqualTo(Long value) {
            addCriterion("designerId <=", value, "designerid");
            return (Criteria) this;
        }

        public Criteria andDesigneridIn(List<Long> values) {
            addCriterion("designerId in", values, "designerid");
            return (Criteria) this;
        }

        public Criteria andDesigneridNotIn(List<Long> values) {
            addCriterion("designerId not in", values, "designerid");
            return (Criteria) this;
        }

        public Criteria andDesigneridBetween(Long value1, Long value2) {
            addCriterion("designerId between", value1, value2, "designerid");
            return (Criteria) this;
        }

        public Criteria andDesigneridNotBetween(Long value1, Long value2) {
            addCriterion("designerId not between", value1, value2, "designerid");
            return (Criteria) this;
        }

        public Criteria andGoodAspectidIsNull() {
            addCriterion("good_aspectId is null");
            return (Criteria) this;
        }

        public Criteria andGoodAspectidIsNotNull() {
            addCriterion("good_aspectId is not null");
            return (Criteria) this;
        }

        public Criteria andGoodAspectidEqualTo(Long value) {
            addCriterion("good_aspectId =", value, "goodAspectid");
            return (Criteria) this;
        }

        public Criteria andGoodAspectidNotEqualTo(Long value) {
            addCriterion("good_aspectId <>", value, "goodAspectid");
            return (Criteria) this;
        }

        public Criteria andGoodAspectidGreaterThan(Long value) {
            addCriterion("good_aspectId >", value, "goodAspectid");
            return (Criteria) this;
        }

        public Criteria andGoodAspectidGreaterThanOrEqualTo(Long value) {
            addCriterion("good_aspectId >=", value, "goodAspectid");
            return (Criteria) this;
        }

        public Criteria andGoodAspectidLessThan(Long value) {
            addCriterion("good_aspectId <", value, "goodAspectid");
            return (Criteria) this;
        }

        public Criteria andGoodAspectidLessThanOrEqualTo(Long value) {
            addCriterion("good_aspectId <=", value, "goodAspectid");
            return (Criteria) this;
        }

        public Criteria andGoodAspectidIn(List<Long> values) {
            addCriterion("good_aspectId in", values, "goodAspectid");
            return (Criteria) this;
        }

        public Criteria andGoodAspectidNotIn(List<Long> values) {
            addCriterion("good_aspectId not in", values, "goodAspectid");
            return (Criteria) this;
        }

        public Criteria andGoodAspectidBetween(Long value1, Long value2) {
            addCriterion("good_aspectId between", value1, value2, "goodAspectid");
            return (Criteria) this;
        }

        public Criteria andGoodAspectidNotBetween(Long value1, Long value2) {
            addCriterion("good_aspectId not between", value1, value2, "goodAspectid");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumIsNull() {
            addCriterion("time_quantum is null");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumIsNotNull() {
            addCriterion("time_quantum is not null");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumEqualTo(String value) {
            addCriterion("time_quantum =", value, "timeQuantum");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumNotEqualTo(String value) {
            addCriterion("time_quantum <>", value, "timeQuantum");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumGreaterThan(String value) {
            addCriterion("time_quantum >", value, "timeQuantum");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumGreaterThanOrEqualTo(String value) {
            addCriterion("time_quantum >=", value, "timeQuantum");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumLessThan(String value) {
            addCriterion("time_quantum <", value, "timeQuantum");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumLessThanOrEqualTo(String value) {
            addCriterion("time_quantum <=", value, "timeQuantum");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumLike(String value) {
            addCriterion("time_quantum like", value, "timeQuantum");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumNotLike(String value) {
            addCriterion("time_quantum not like", value, "timeQuantum");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumIn(List<String> values) {
            addCriterion("time_quantum in", values, "timeQuantum");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumNotIn(List<String> values) {
            addCriterion("time_quantum not in", values, "timeQuantum");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumBetween(String value1, String value2) {
            addCriterion("time_quantum between", value1, value2, "timeQuantum");
            return (Criteria) this;
        }

        public Criteria andTimeQuantumNotBetween(String value1, String value2) {
            addCriterion("time_quantum not between", value1, value2, "timeQuantum");
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
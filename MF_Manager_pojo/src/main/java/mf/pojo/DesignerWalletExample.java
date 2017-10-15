package mf.pojo;

import java.util.ArrayList;
import java.util.List;

public class DesignerWalletExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DesignerWalletExample() {
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

        public Criteria andDesignerIdIsNull() {
            addCriterion("designer_id is null");
            return (Criteria) this;
        }

        public Criteria andDesignerIdIsNotNull() {
            addCriterion("designer_id is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerIdEqualTo(Long value) {
            addCriterion("designer_id =", value, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdNotEqualTo(Long value) {
            addCriterion("designer_id <>", value, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdGreaterThan(Long value) {
            addCriterion("designer_id >", value, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("designer_id >=", value, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdLessThan(Long value) {
            addCriterion("designer_id <", value, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdLessThanOrEqualTo(Long value) {
            addCriterion("designer_id <=", value, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdIn(List<Long> values) {
            addCriterion("designer_id in", values, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdNotIn(List<Long> values) {
            addCriterion("designer_id not in", values, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdBetween(Long value1, Long value2) {
            addCriterion("designer_id between", value1, value2, "designerId");
            return (Criteria) this;
        }

        public Criteria andDesignerIdNotBetween(Long value1, Long value2) {
            addCriterion("designer_id not between", value1, value2, "designerId");
            return (Criteria) this;
        }

        public Criteria andIncomeCountIsNull() {
            addCriterion("income_count is null");
            return (Criteria) this;
        }

        public Criteria andIncomeCountIsNotNull() {
            addCriterion("income_count is not null");
            return (Criteria) this;
        }

        public Criteria andIncomeCountEqualTo(Double value) {
            addCriterion("income_count =", value, "incomeCount");
            return (Criteria) this;
        }

        public Criteria andIncomeCountNotEqualTo(Double value) {
            addCriterion("income_count <>", value, "incomeCount");
            return (Criteria) this;
        }

        public Criteria andIncomeCountGreaterThan(Double value) {
            addCriterion("income_count >", value, "incomeCount");
            return (Criteria) this;
        }

        public Criteria andIncomeCountGreaterThanOrEqualTo(Double value) {
            addCriterion("income_count >=", value, "incomeCount");
            return (Criteria) this;
        }

        public Criteria andIncomeCountLessThan(Double value) {
            addCriterion("income_count <", value, "incomeCount");
            return (Criteria) this;
        }

        public Criteria andIncomeCountLessThanOrEqualTo(Double value) {
            addCriterion("income_count <=", value, "incomeCount");
            return (Criteria) this;
        }

        public Criteria andIncomeCountIn(List<Double> values) {
            addCriterion("income_count in", values, "incomeCount");
            return (Criteria) this;
        }

        public Criteria andIncomeCountNotIn(List<Double> values) {
            addCriterion("income_count not in", values, "incomeCount");
            return (Criteria) this;
        }

        public Criteria andIncomeCountBetween(Double value1, Double value2) {
            addCriterion("income_count between", value1, value2, "incomeCount");
            return (Criteria) this;
        }

        public Criteria andIncomeCountNotBetween(Double value1, Double value2) {
            addCriterion("income_count not between", value1, value2, "incomeCount");
            return (Criteria) this;
        }

        public Criteria andExpenditureCountIsNull() {
            addCriterion("expenditure_count is null");
            return (Criteria) this;
        }

        public Criteria andExpenditureCountIsNotNull() {
            addCriterion("expenditure_count is not null");
            return (Criteria) this;
        }

        public Criteria andExpenditureCountEqualTo(Double value) {
            addCriterion("expenditure_count =", value, "expenditureCount");
            return (Criteria) this;
        }

        public Criteria andExpenditureCountNotEqualTo(Double value) {
            addCriterion("expenditure_count <>", value, "expenditureCount");
            return (Criteria) this;
        }

        public Criteria andExpenditureCountGreaterThan(Double value) {
            addCriterion("expenditure_count >", value, "expenditureCount");
            return (Criteria) this;
        }

        public Criteria andExpenditureCountGreaterThanOrEqualTo(Double value) {
            addCriterion("expenditure_count >=", value, "expenditureCount");
            return (Criteria) this;
        }

        public Criteria andExpenditureCountLessThan(Double value) {
            addCriterion("expenditure_count <", value, "expenditureCount");
            return (Criteria) this;
        }

        public Criteria andExpenditureCountLessThanOrEqualTo(Double value) {
            addCriterion("expenditure_count <=", value, "expenditureCount");
            return (Criteria) this;
        }

        public Criteria andExpenditureCountIn(List<Double> values) {
            addCriterion("expenditure_count in", values, "expenditureCount");
            return (Criteria) this;
        }

        public Criteria andExpenditureCountNotIn(List<Double> values) {
            addCriterion("expenditure_count not in", values, "expenditureCount");
            return (Criteria) this;
        }

        public Criteria andExpenditureCountBetween(Double value1, Double value2) {
            addCriterion("expenditure_count between", value1, value2, "expenditureCount");
            return (Criteria) this;
        }

        public Criteria andExpenditureCountNotBetween(Double value1, Double value2) {
            addCriterion("expenditure_count not between", value1, value2, "expenditureCount");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNull() {
            addCriterion("balance is null");
            return (Criteria) this;
        }

        public Criteria andBalanceIsNotNull() {
            addCriterion("balance is not null");
            return (Criteria) this;
        }

        public Criteria andBalanceEqualTo(Double value) {
            addCriterion("balance =", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotEqualTo(Double value) {
            addCriterion("balance <>", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThan(Double value) {
            addCriterion("balance >", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceGreaterThanOrEqualTo(Double value) {
            addCriterion("balance >=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThan(Double value) {
            addCriterion("balance <", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceLessThanOrEqualTo(Double value) {
            addCriterion("balance <=", value, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceIn(List<Double> values) {
            addCriterion("balance in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotIn(List<Double> values) {
            addCriterion("balance not in", values, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceBetween(Double value1, Double value2) {
            addCriterion("balance between", value1, value2, "balance");
            return (Criteria) this;
        }

        public Criteria andBalanceNotBetween(Double value1, Double value2) {
            addCriterion("balance not between", value1, value2, "balance");
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
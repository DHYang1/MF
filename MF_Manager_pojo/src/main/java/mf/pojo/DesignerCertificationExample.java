package mf.pojo;

import java.util.ArrayList;
import java.util.List;

public class DesignerCertificationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DesignerCertificationExample() {
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

        public Criteria andCertificationIdIsNull() {
            addCriterion("certification_id is null");
            return (Criteria) this;
        }

        public Criteria andCertificationIdIsNotNull() {
            addCriterion("certification_id is not null");
            return (Criteria) this;
        }

        public Criteria andCertificationIdEqualTo(Long value) {
            addCriterion("certification_id =", value, "certificationId");
            return (Criteria) this;
        }

        public Criteria andCertificationIdNotEqualTo(Long value) {
            addCriterion("certification_id <>", value, "certificationId");
            return (Criteria) this;
        }

        public Criteria andCertificationIdGreaterThan(Long value) {
            addCriterion("certification_id >", value, "certificationId");
            return (Criteria) this;
        }

        public Criteria andCertificationIdGreaterThanOrEqualTo(Long value) {
            addCriterion("certification_id >=", value, "certificationId");
            return (Criteria) this;
        }

        public Criteria andCertificationIdLessThan(Long value) {
            addCriterion("certification_id <", value, "certificationId");
            return (Criteria) this;
        }

        public Criteria andCertificationIdLessThanOrEqualTo(Long value) {
            addCriterion("certification_id <=", value, "certificationId");
            return (Criteria) this;
        }

        public Criteria andCertificationIdIn(List<Long> values) {
            addCriterion("certification_id in", values, "certificationId");
            return (Criteria) this;
        }

        public Criteria andCertificationIdNotIn(List<Long> values) {
            addCriterion("certification_id not in", values, "certificationId");
            return (Criteria) this;
        }

        public Criteria andCertificationIdBetween(Long value1, Long value2) {
            addCriterion("certification_id between", value1, value2, "certificationId");
            return (Criteria) this;
        }

        public Criteria andCertificationIdNotBetween(Long value1, Long value2) {
            addCriterion("certification_id not between", value1, value2, "certificationId");
            return (Criteria) this;
        }

        public Criteria andDesigerIdIsNull() {
            addCriterion("desiger_id is null");
            return (Criteria) this;
        }

        public Criteria andDesigerIdIsNotNull() {
            addCriterion("desiger_id is not null");
            return (Criteria) this;
        }

        public Criteria andDesigerIdEqualTo(Long value) {
            addCriterion("desiger_id =", value, "desigerId");
            return (Criteria) this;
        }

        public Criteria andDesigerIdNotEqualTo(Long value) {
            addCriterion("desiger_id <>", value, "desigerId");
            return (Criteria) this;
        }

        public Criteria andDesigerIdGreaterThan(Long value) {
            addCriterion("desiger_id >", value, "desigerId");
            return (Criteria) this;
        }

        public Criteria andDesigerIdGreaterThanOrEqualTo(Long value) {
            addCriterion("desiger_id >=", value, "desigerId");
            return (Criteria) this;
        }

        public Criteria andDesigerIdLessThan(Long value) {
            addCriterion("desiger_id <", value, "desigerId");
            return (Criteria) this;
        }

        public Criteria andDesigerIdLessThanOrEqualTo(Long value) {
            addCriterion("desiger_id <=", value, "desigerId");
            return (Criteria) this;
        }

        public Criteria andDesigerIdIn(List<Long> values) {
            addCriterion("desiger_id in", values, "desigerId");
            return (Criteria) this;
        }

        public Criteria andDesigerIdNotIn(List<Long> values) {
            addCriterion("desiger_id not in", values, "desigerId");
            return (Criteria) this;
        }

        public Criteria andDesigerIdBetween(Long value1, Long value2) {
            addCriterion("desiger_id between", value1, value2, "desigerId");
            return (Criteria) this;
        }

        public Criteria andDesigerIdNotBetween(Long value1, Long value2) {
            addCriterion("desiger_id not between", value1, value2, "desigerId");
            return (Criteria) this;
        }

        public Criteria andPositionIsNull() {
            addCriterion("position is null");
            return (Criteria) this;
        }

        public Criteria andPositionIsNotNull() {
            addCriterion("position is not null");
            return (Criteria) this;
        }

        public Criteria andPositionEqualTo(String value) {
            addCriterion("position =", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotEqualTo(String value) {
            addCriterion("position <>", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThan(String value) {
            addCriterion("position >", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionGreaterThanOrEqualTo(String value) {
            addCriterion("position >=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThan(String value) {
            addCriterion("position <", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLessThanOrEqualTo(String value) {
            addCriterion("position <=", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionLike(String value) {
            addCriterion("position like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotLike(String value) {
            addCriterion("position not like", value, "position");
            return (Criteria) this;
        }

        public Criteria andPositionIn(List<String> values) {
            addCriterion("position in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotIn(List<String> values) {
            addCriterion("position not in", values, "position");
            return (Criteria) this;
        }

        public Criteria andPositionBetween(String value1, String value2) {
            addCriterion("position between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andPositionNotBetween(String value1, String value2) {
            addCriterion("position not between", value1, value2, "position");
            return (Criteria) this;
        }

        public Criteria andJobIsNull() {
            addCriterion("job is null");
            return (Criteria) this;
        }

        public Criteria andJobIsNotNull() {
            addCriterion("job is not null");
            return (Criteria) this;
        }

        public Criteria andJobEqualTo(String value) {
            addCriterion("job =", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotEqualTo(String value) {
            addCriterion("job <>", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThan(String value) {
            addCriterion("job >", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobGreaterThanOrEqualTo(String value) {
            addCriterion("job >=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThan(String value) {
            addCriterion("job <", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLessThanOrEqualTo(String value) {
            addCriterion("job <=", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobLike(String value) {
            addCriterion("job like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotLike(String value) {
            addCriterion("job not like", value, "job");
            return (Criteria) this;
        }

        public Criteria andJobIn(List<String> values) {
            addCriterion("job in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotIn(List<String> values) {
            addCriterion("job not in", values, "job");
            return (Criteria) this;
        }

        public Criteria andJobBetween(String value1, String value2) {
            addCriterion("job between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobNotBetween(String value1, String value2) {
            addCriterion("job not between", value1, value2, "job");
            return (Criteria) this;
        }

        public Criteria andJobYearIsNull() {
            addCriterion("job_year is null");
            return (Criteria) this;
        }

        public Criteria andJobYearIsNotNull() {
            addCriterion("job_year is not null");
            return (Criteria) this;
        }

        public Criteria andJobYearEqualTo(Integer value) {
            addCriterion("job_year =", value, "jobYear");
            return (Criteria) this;
        }

        public Criteria andJobYearNotEqualTo(Integer value) {
            addCriterion("job_year <>", value, "jobYear");
            return (Criteria) this;
        }

        public Criteria andJobYearGreaterThan(Integer value) {
            addCriterion("job_year >", value, "jobYear");
            return (Criteria) this;
        }

        public Criteria andJobYearGreaterThanOrEqualTo(Integer value) {
            addCriterion("job_year >=", value, "jobYear");
            return (Criteria) this;
        }

        public Criteria andJobYearLessThan(Integer value) {
            addCriterion("job_year <", value, "jobYear");
            return (Criteria) this;
        }

        public Criteria andJobYearLessThanOrEqualTo(Integer value) {
            addCriterion("job_year <=", value, "jobYear");
            return (Criteria) this;
        }

        public Criteria andJobYearIn(List<Integer> values) {
            addCriterion("job_year in", values, "jobYear");
            return (Criteria) this;
        }

        public Criteria andJobYearNotIn(List<Integer> values) {
            addCriterion("job_year not in", values, "jobYear");
            return (Criteria) this;
        }

        public Criteria andJobYearBetween(Integer value1, Integer value2) {
            addCriterion("job_year between", value1, value2, "jobYear");
            return (Criteria) this;
        }

        public Criteria andJobYearNotBetween(Integer value1, Integer value2) {
            addCriterion("job_year not between", value1, value2, "jobYear");
            return (Criteria) this;
        }

        public Criteria andGoodIsNull() {
            addCriterion("good is null");
            return (Criteria) this;
        }

        public Criteria andGoodIsNotNull() {
            addCriterion("good is not null");
            return (Criteria) this;
        }

        public Criteria andGoodEqualTo(Integer value) {
            addCriterion("good =", value, "good");
            return (Criteria) this;
        }

        public Criteria andGoodNotEqualTo(Integer value) {
            addCriterion("good <>", value, "good");
            return (Criteria) this;
        }

        public Criteria andGoodGreaterThan(Integer value) {
            addCriterion("good >", value, "good");
            return (Criteria) this;
        }

        public Criteria andGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("good >=", value, "good");
            return (Criteria) this;
        }

        public Criteria andGoodLessThan(Integer value) {
            addCriterion("good <", value, "good");
            return (Criteria) this;
        }

        public Criteria andGoodLessThanOrEqualTo(Integer value) {
            addCriterion("good <=", value, "good");
            return (Criteria) this;
        }

        public Criteria andGoodIn(List<Integer> values) {
            addCriterion("good in", values, "good");
            return (Criteria) this;
        }

        public Criteria andGoodNotIn(List<Integer> values) {
            addCriterion("good not in", values, "good");
            return (Criteria) this;
        }

        public Criteria andGoodBetween(Integer value1, Integer value2) {
            addCriterion("good between", value1, value2, "good");
            return (Criteria) this;
        }

        public Criteria andGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("good not between", value1, value2, "good");
            return (Criteria) this;
        }

        public Criteria andDesignPathIsNull() {
            addCriterion("design_path is null");
            return (Criteria) this;
        }

        public Criteria andDesignPathIsNotNull() {
            addCriterion("design_path is not null");
            return (Criteria) this;
        }

        public Criteria andDesignPathEqualTo(String value) {
            addCriterion("design_path =", value, "designPath");
            return (Criteria) this;
        }

        public Criteria andDesignPathNotEqualTo(String value) {
            addCriterion("design_path <>", value, "designPath");
            return (Criteria) this;
        }

        public Criteria andDesignPathGreaterThan(String value) {
            addCriterion("design_path >", value, "designPath");
            return (Criteria) this;
        }

        public Criteria andDesignPathGreaterThanOrEqualTo(String value) {
            addCriterion("design_path >=", value, "designPath");
            return (Criteria) this;
        }

        public Criteria andDesignPathLessThan(String value) {
            addCriterion("design_path <", value, "designPath");
            return (Criteria) this;
        }

        public Criteria andDesignPathLessThanOrEqualTo(String value) {
            addCriterion("design_path <=", value, "designPath");
            return (Criteria) this;
        }

        public Criteria andDesignPathLike(String value) {
            addCriterion("design_path like", value, "designPath");
            return (Criteria) this;
        }

        public Criteria andDesignPathNotLike(String value) {
            addCriterion("design_path not like", value, "designPath");
            return (Criteria) this;
        }

        public Criteria andDesignPathIn(List<String> values) {
            addCriterion("design_path in", values, "designPath");
            return (Criteria) this;
        }

        public Criteria andDesignPathNotIn(List<String> values) {
            addCriterion("design_path not in", values, "designPath");
            return (Criteria) this;
        }

        public Criteria andDesignPathBetween(String value1, String value2) {
            addCriterion("design_path between", value1, value2, "designPath");
            return (Criteria) this;
        }

        public Criteria andDesignPathNotBetween(String value1, String value2) {
            addCriterion("design_path not between", value1, value2, "designPath");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardIsNull() {
            addCriterion("ositive_card is null");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardIsNotNull() {
            addCriterion("ositive_card is not null");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardEqualTo(String value) {
            addCriterion("ositive_card =", value, "ositiveCard");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardNotEqualTo(String value) {
            addCriterion("ositive_card <>", value, "ositiveCard");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardGreaterThan(String value) {
            addCriterion("ositive_card >", value, "ositiveCard");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardGreaterThanOrEqualTo(String value) {
            addCriterion("ositive_card >=", value, "ositiveCard");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardLessThan(String value) {
            addCriterion("ositive_card <", value, "ositiveCard");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardLessThanOrEqualTo(String value) {
            addCriterion("ositive_card <=", value, "ositiveCard");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardLike(String value) {
            addCriterion("ositive_card like", value, "ositiveCard");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardNotLike(String value) {
            addCriterion("ositive_card not like", value, "ositiveCard");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardIn(List<String> values) {
            addCriterion("ositive_card in", values, "ositiveCard");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardNotIn(List<String> values) {
            addCriterion("ositive_card not in", values, "ositiveCard");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardBetween(String value1, String value2) {
            addCriterion("ositive_card between", value1, value2, "ositiveCard");
            return (Criteria) this;
        }

        public Criteria andOsitiveCardNotBetween(String value1, String value2) {
            addCriterion("ositive_card not between", value1, value2, "ositiveCard");
            return (Criteria) this;
        }

        public Criteria andTheCardIsNull() {
            addCriterion("the_card is null");
            return (Criteria) this;
        }

        public Criteria andTheCardIsNotNull() {
            addCriterion("the_card is not null");
            return (Criteria) this;
        }

        public Criteria andTheCardEqualTo(String value) {
            addCriterion("the_card =", value, "theCard");
            return (Criteria) this;
        }

        public Criteria andTheCardNotEqualTo(String value) {
            addCriterion("the_card <>", value, "theCard");
            return (Criteria) this;
        }

        public Criteria andTheCardGreaterThan(String value) {
            addCriterion("the_card >", value, "theCard");
            return (Criteria) this;
        }

        public Criteria andTheCardGreaterThanOrEqualTo(String value) {
            addCriterion("the_card >=", value, "theCard");
            return (Criteria) this;
        }

        public Criteria andTheCardLessThan(String value) {
            addCriterion("the_card <", value, "theCard");
            return (Criteria) this;
        }

        public Criteria andTheCardLessThanOrEqualTo(String value) {
            addCriterion("the_card <=", value, "theCard");
            return (Criteria) this;
        }

        public Criteria andTheCardLike(String value) {
            addCriterion("the_card like", value, "theCard");
            return (Criteria) this;
        }

        public Criteria andTheCardNotLike(String value) {
            addCriterion("the_card not like", value, "theCard");
            return (Criteria) this;
        }

        public Criteria andTheCardIn(List<String> values) {
            addCriterion("the_card in", values, "theCard");
            return (Criteria) this;
        }

        public Criteria andTheCardNotIn(List<String> values) {
            addCriterion("the_card not in", values, "theCard");
            return (Criteria) this;
        }

        public Criteria andTheCardBetween(String value1, String value2) {
            addCriterion("the_card between", value1, value2, "theCard");
            return (Criteria) this;
        }

        public Criteria andTheCardNotBetween(String value1, String value2) {
            addCriterion("the_card not between", value1, value2, "theCard");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("state is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("state is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Integer value) {
            addCriterion("state =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Integer value) {
            addCriterion("state <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Integer value) {
            addCriterion("state >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("state >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Integer value) {
            addCriterion("state <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Integer value) {
            addCriterion("state <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Integer> values) {
            addCriterion("state in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Integer> values) {
            addCriterion("state not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Integer value1, Integer value2) {
            addCriterion("state between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Integer value1, Integer value2) {
            addCriterion("state not between", value1, value2, "state");
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
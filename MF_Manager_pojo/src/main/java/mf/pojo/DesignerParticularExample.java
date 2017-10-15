package mf.pojo;

import java.util.ArrayList;
import java.util.List;

public class DesignerParticularExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DesignerParticularExample() {
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

        public Criteria andIntroductionIsNull() {
            addCriterion("introduction is null");
            return (Criteria) this;
        }

        public Criteria andIntroductionIsNotNull() {
            addCriterion("introduction is not null");
            return (Criteria) this;
        }

        public Criteria andIntroductionEqualTo(String value) {
            addCriterion("introduction =", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotEqualTo(String value) {
            addCriterion("introduction <>", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThan(String value) {
            addCriterion("introduction >", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionGreaterThanOrEqualTo(String value) {
            addCriterion("introduction >=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThan(String value) {
            addCriterion("introduction <", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLessThanOrEqualTo(String value) {
            addCriterion("introduction <=", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionLike(String value) {
            addCriterion("introduction like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotLike(String value) {
            addCriterion("introduction not like", value, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionIn(List<String> values) {
            addCriterion("introduction in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotIn(List<String> values) {
            addCriterion("introduction not in", values, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionBetween(String value1, String value2) {
            addCriterion("introduction between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andIntroductionNotBetween(String value1, String value2) {
            addCriterion("introduction not between", value1, value2, "introduction");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNull() {
            addCriterion("specialty is null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIsNotNull() {
            addCriterion("specialty is not null");
            return (Criteria) this;
        }

        public Criteria andSpecialtyEqualTo(String value) {
            addCriterion("specialty =", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotEqualTo(String value) {
            addCriterion("specialty <>", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThan(String value) {
            addCriterion("specialty >", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyGreaterThanOrEqualTo(String value) {
            addCriterion("specialty >=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThan(String value) {
            addCriterion("specialty <", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLessThanOrEqualTo(String value) {
            addCriterion("specialty <=", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyLike(String value) {
            addCriterion("specialty like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotLike(String value) {
            addCriterion("specialty not like", value, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyIn(List<String> values) {
            addCriterion("specialty in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotIn(List<String> values) {
            addCriterion("specialty not in", values, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyBetween(String value1, String value2) {
            addCriterion("specialty between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andSpecialtyNotBetween(String value1, String value2) {
            addCriterion("specialty not between", value1, value2, "specialty");
            return (Criteria) this;
        }

        public Criteria andAutographIsNull() {
            addCriterion("autograph is null");
            return (Criteria) this;
        }

        public Criteria andAutographIsNotNull() {
            addCriterion("autograph is not null");
            return (Criteria) this;
        }

        public Criteria andAutographEqualTo(String value) {
            addCriterion("autograph =", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographNotEqualTo(String value) {
            addCriterion("autograph <>", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographGreaterThan(String value) {
            addCriterion("autograph >", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographGreaterThanOrEqualTo(String value) {
            addCriterion("autograph >=", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographLessThan(String value) {
            addCriterion("autograph <", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographLessThanOrEqualTo(String value) {
            addCriterion("autograph <=", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographLike(String value) {
            addCriterion("autograph like", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographNotLike(String value) {
            addCriterion("autograph not like", value, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographIn(List<String> values) {
            addCriterion("autograph in", values, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographNotIn(List<String> values) {
            addCriterion("autograph not in", values, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographBetween(String value1, String value2) {
            addCriterion("autograph between", value1, value2, "autograph");
            return (Criteria) this;
        }

        public Criteria andAutographNotBetween(String value1, String value2) {
            addCriterion("autograph not between", value1, value2, "autograph");
            return (Criteria) this;
        }

        public Criteria andMatchgameIsNull() {
            addCriterion("matchGame is null");
            return (Criteria) this;
        }

        public Criteria andMatchgameIsNotNull() {
            addCriterion("matchGame is not null");
            return (Criteria) this;
        }

        public Criteria andMatchgameEqualTo(String value) {
            addCriterion("matchGame =", value, "matchgame");
            return (Criteria) this;
        }

        public Criteria andMatchgameNotEqualTo(String value) {
            addCriterion("matchGame <>", value, "matchgame");
            return (Criteria) this;
        }

        public Criteria andMatchgameGreaterThan(String value) {
            addCriterion("matchGame >", value, "matchgame");
            return (Criteria) this;
        }

        public Criteria andMatchgameGreaterThanOrEqualTo(String value) {
            addCriterion("matchGame >=", value, "matchgame");
            return (Criteria) this;
        }

        public Criteria andMatchgameLessThan(String value) {
            addCriterion("matchGame <", value, "matchgame");
            return (Criteria) this;
        }

        public Criteria andMatchgameLessThanOrEqualTo(String value) {
            addCriterion("matchGame <=", value, "matchgame");
            return (Criteria) this;
        }

        public Criteria andMatchgameLike(String value) {
            addCriterion("matchGame like", value, "matchgame");
            return (Criteria) this;
        }

        public Criteria andMatchgameNotLike(String value) {
            addCriterion("matchGame not like", value, "matchgame");
            return (Criteria) this;
        }

        public Criteria andMatchgameIn(List<String> values) {
            addCriterion("matchGame in", values, "matchgame");
            return (Criteria) this;
        }

        public Criteria andMatchgameNotIn(List<String> values) {
            addCriterion("matchGame not in", values, "matchgame");
            return (Criteria) this;
        }

        public Criteria andMatchgameBetween(String value1, String value2) {
            addCriterion("matchGame between", value1, value2, "matchgame");
            return (Criteria) this;
        }

        public Criteria andMatchgameNotBetween(String value1, String value2) {
            addCriterion("matchGame not between", value1, value2, "matchgame");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNull() {
            addCriterion("company_name is null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIsNotNull() {
            addCriterion("company_name is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyNameEqualTo(String value) {
            addCriterion("company_name =", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotEqualTo(String value) {
            addCriterion("company_name <>", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThan(String value) {
            addCriterion("company_name >", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("company_name >=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThan(String value) {
            addCriterion("company_name <", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("company_name <=", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameLike(String value) {
            addCriterion("company_name like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotLike(String value) {
            addCriterion("company_name not like", value, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameIn(List<String> values) {
            addCriterion("company_name in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotIn(List<String> values) {
            addCriterion("company_name not in", values, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameBetween(String value1, String value2) {
            addCriterion("company_name between", value1, value2, "companyName");
            return (Criteria) this;
        }

        public Criteria andCompanyNameNotBetween(String value1, String value2) {
            addCriterion("company_name not between", value1, value2, "companyName");
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
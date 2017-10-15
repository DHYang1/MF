package mf.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShopImageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ShopImageExample() {
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

        public Criteria andImageIdIsNull() {
            addCriterion("image_id is null");
            return (Criteria) this;
        }

        public Criteria andImageIdIsNotNull() {
            addCriterion("image_id is not null");
            return (Criteria) this;
        }

        public Criteria andImageIdEqualTo(Long value) {
            addCriterion("image_id =", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotEqualTo(Long value) {
            addCriterion("image_id <>", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThan(Long value) {
            addCriterion("image_id >", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("image_id >=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThan(Long value) {
            addCriterion("image_id <", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdLessThanOrEqualTo(Long value) {
            addCriterion("image_id <=", value, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdIn(List<Long> values) {
            addCriterion("image_id in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotIn(List<Long> values) {
            addCriterion("image_id not in", values, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdBetween(Long value1, Long value2) {
            addCriterion("image_id between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andImageIdNotBetween(Long value1, Long value2) {
            addCriterion("image_id not between", value1, value2, "imageId");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNull() {
            addCriterion("shop_id is null");
            return (Criteria) this;
        }

        public Criteria andShopIdIsNotNull() {
            addCriterion("shop_id is not null");
            return (Criteria) this;
        }

        public Criteria andShopIdEqualTo(Long value) {
            addCriterion("shop_id =", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotEqualTo(Long value) {
            addCriterion("shop_id <>", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThan(Long value) {
            addCriterion("shop_id >", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdGreaterThanOrEqualTo(Long value) {
            addCriterion("shop_id >=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThan(Long value) {
            addCriterion("shop_id <", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdLessThanOrEqualTo(Long value) {
            addCriterion("shop_id <=", value, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdIn(List<Long> values) {
            addCriterion("shop_id in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotIn(List<Long> values) {
            addCriterion("shop_id not in", values, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdBetween(Long value1, Long value2) {
            addCriterion("shop_id between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andShopIdNotBetween(Long value1, Long value2) {
            addCriterion("shop_id not between", value1, value2, "shopId");
            return (Criteria) this;
        }

        public Criteria andImagepathIsNull() {
            addCriterion("imagePath is null");
            return (Criteria) this;
        }

        public Criteria andImagepathIsNotNull() {
            addCriterion("imagePath is not null");
            return (Criteria) this;
        }

        public Criteria andImagepathEqualTo(String value) {
            addCriterion("imagePath =", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathNotEqualTo(String value) {
            addCriterion("imagePath <>", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathGreaterThan(String value) {
            addCriterion("imagePath >", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathGreaterThanOrEqualTo(String value) {
            addCriterion("imagePath >=", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathLessThan(String value) {
            addCriterion("imagePath <", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathLessThanOrEqualTo(String value) {
            addCriterion("imagePath <=", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathLike(String value) {
            addCriterion("imagePath like", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathNotLike(String value) {
            addCriterion("imagePath not like", value, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathIn(List<String> values) {
            addCriterion("imagePath in", values, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathNotIn(List<String> values) {
            addCriterion("imagePath not in", values, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathBetween(String value1, String value2) {
            addCriterion("imagePath between", value1, value2, "imagepath");
            return (Criteria) this;
        }

        public Criteria andImagepathNotBetween(String value1, String value2) {
            addCriterion("imagePath not between", value1, value2, "imagepath");
            return (Criteria) this;
        }

        public Criteria andCreatIsNull() {
            addCriterion("creat is null");
            return (Criteria) this;
        }

        public Criteria andCreatIsNotNull() {
            addCriterion("creat is not null");
            return (Criteria) this;
        }

        public Criteria andCreatEqualTo(Date value) {
            addCriterion("creat =", value, "creat");
            return (Criteria) this;
        }

        public Criteria andCreatNotEqualTo(Date value) {
            addCriterion("creat <>", value, "creat");
            return (Criteria) this;
        }

        public Criteria andCreatGreaterThan(Date value) {
            addCriterion("creat >", value, "creat");
            return (Criteria) this;
        }

        public Criteria andCreatGreaterThanOrEqualTo(Date value) {
            addCriterion("creat >=", value, "creat");
            return (Criteria) this;
        }

        public Criteria andCreatLessThan(Date value) {
            addCriterion("creat <", value, "creat");
            return (Criteria) this;
        }

        public Criteria andCreatLessThanOrEqualTo(Date value) {
            addCriterion("creat <=", value, "creat");
            return (Criteria) this;
        }

        public Criteria andCreatIn(List<Date> values) {
            addCriterion("creat in", values, "creat");
            return (Criteria) this;
        }

        public Criteria andCreatNotIn(List<Date> values) {
            addCriterion("creat not in", values, "creat");
            return (Criteria) this;
        }

        public Criteria andCreatBetween(Date value1, Date value2) {
            addCriterion("creat between", value1, value2, "creat");
            return (Criteria) this;
        }

        public Criteria andCreatNotBetween(Date value1, Date value2) {
            addCriterion("creat not between", value1, value2, "creat");
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
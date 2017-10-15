package mf.pojo;

import java.util.ArrayList;
import java.util.List;

public class DesignerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DesignerExample() {
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

        public Criteria andHeadPathIsNull() {
            addCriterion("head_path is null");
            return (Criteria) this;
        }

        public Criteria andHeadPathIsNotNull() {
            addCriterion("head_path is not null");
            return (Criteria) this;
        }

        public Criteria andHeadPathEqualTo(String value) {
            addCriterion("head_path =", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathNotEqualTo(String value) {
            addCriterion("head_path <>", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathGreaterThan(String value) {
            addCriterion("head_path >", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathGreaterThanOrEqualTo(String value) {
            addCriterion("head_path >=", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathLessThan(String value) {
            addCriterion("head_path <", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathLessThanOrEqualTo(String value) {
            addCriterion("head_path <=", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathLike(String value) {
            addCriterion("head_path like", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathNotLike(String value) {
            addCriterion("head_path not like", value, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathIn(List<String> values) {
            addCriterion("head_path in", values, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathNotIn(List<String> values) {
            addCriterion("head_path not in", values, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathBetween(String value1, String value2) {
            addCriterion("head_path between", value1, value2, "headPath");
            return (Criteria) this;
        }

        public Criteria andHeadPathNotBetween(String value1, String value2) {
            addCriterion("head_path not between", value1, value2, "headPath");
            return (Criteria) this;
        }

        public Criteria andHotDyedIsNull() {
            addCriterion("hot_dyed is null");
            return (Criteria) this;
        }

        public Criteria andHotDyedIsNotNull() {
            addCriterion("hot_dyed is not null");
            return (Criteria) this;
        }

        public Criteria andHotDyedEqualTo(Double value) {
            addCriterion("hot_dyed =", value, "hotDyed");
            return (Criteria) this;
        }

        public Criteria andHotDyedNotEqualTo(Double value) {
            addCriterion("hot_dyed <>", value, "hotDyed");
            return (Criteria) this;
        }

        public Criteria andHotDyedGreaterThan(Double value) {
            addCriterion("hot_dyed >", value, "hotDyed");
            return (Criteria) this;
        }

        public Criteria andHotDyedGreaterThanOrEqualTo(Double value) {
            addCriterion("hot_dyed >=", value, "hotDyed");
            return (Criteria) this;
        }

        public Criteria andHotDyedLessThan(Double value) {
            addCriterion("hot_dyed <", value, "hotDyed");
            return (Criteria) this;
        }

        public Criteria andHotDyedLessThanOrEqualTo(Double value) {
            addCriterion("hot_dyed <=", value, "hotDyed");
            return (Criteria) this;
        }

        public Criteria andHotDyedIn(List<Double> values) {
            addCriterion("hot_dyed in", values, "hotDyed");
            return (Criteria) this;
        }

        public Criteria andHotDyedNotIn(List<Double> values) {
            addCriterion("hot_dyed not in", values, "hotDyed");
            return (Criteria) this;
        }

        public Criteria andHotDyedBetween(Double value1, Double value2) {
            addCriterion("hot_dyed between", value1, value2, "hotDyed");
            return (Criteria) this;
        }

        public Criteria andHotDyedNotBetween(Double value1, Double value2) {
            addCriterion("hot_dyed not between", value1, value2, "hotDyed");
            return (Criteria) this;
        }

        public Criteria andMakeupsIsNull() {
            addCriterion("makeups is null");
            return (Criteria) this;
        }

        public Criteria andMakeupsIsNotNull() {
            addCriterion("makeups is not null");
            return (Criteria) this;
        }

        public Criteria andMakeupsEqualTo(Double value) {
            addCriterion("makeups =", value, "makeups");
            return (Criteria) this;
        }

        public Criteria andMakeupsNotEqualTo(Double value) {
            addCriterion("makeups <>", value, "makeups");
            return (Criteria) this;
        }

        public Criteria andMakeupsGreaterThan(Double value) {
            addCriterion("makeups >", value, "makeups");
            return (Criteria) this;
        }

        public Criteria andMakeupsGreaterThanOrEqualTo(Double value) {
            addCriterion("makeups >=", value, "makeups");
            return (Criteria) this;
        }

        public Criteria andMakeupsLessThan(Double value) {
            addCriterion("makeups <", value, "makeups");
            return (Criteria) this;
        }

        public Criteria andMakeupsLessThanOrEqualTo(Double value) {
            addCriterion("makeups <=", value, "makeups");
            return (Criteria) this;
        }

        public Criteria andMakeupsIn(List<Double> values) {
            addCriterion("makeups in", values, "makeups");
            return (Criteria) this;
        }

        public Criteria andMakeupsNotIn(List<Double> values) {
            addCriterion("makeups not in", values, "makeups");
            return (Criteria) this;
        }

        public Criteria andMakeupsBetween(Double value1, Double value2) {
            addCriterion("makeups between", value1, value2, "makeups");
            return (Criteria) this;
        }

        public Criteria andMakeupsNotBetween(Double value1, Double value2) {
            addCriterion("makeups not between", value1, value2, "makeups");
            return (Criteria) this;
        }

        public Criteria andHaircutIsNull() {
            addCriterion("haircut is null");
            return (Criteria) this;
        }

        public Criteria andHaircutIsNotNull() {
            addCriterion("haircut is not null");
            return (Criteria) this;
        }

        public Criteria andHaircutEqualTo(Double value) {
            addCriterion("haircut =", value, "haircut");
            return (Criteria) this;
        }

        public Criteria andHaircutNotEqualTo(Double value) {
            addCriterion("haircut <>", value, "haircut");
            return (Criteria) this;
        }

        public Criteria andHaircutGreaterThan(Double value) {
            addCriterion("haircut >", value, "haircut");
            return (Criteria) this;
        }

        public Criteria andHaircutGreaterThanOrEqualTo(Double value) {
            addCriterion("haircut >=", value, "haircut");
            return (Criteria) this;
        }

        public Criteria andHaircutLessThan(Double value) {
            addCriterion("haircut <", value, "haircut");
            return (Criteria) this;
        }

        public Criteria andHaircutLessThanOrEqualTo(Double value) {
            addCriterion("haircut <=", value, "haircut");
            return (Criteria) this;
        }

        public Criteria andHaircutIn(List<Double> values) {
            addCriterion("haircut in", values, "haircut");
            return (Criteria) this;
        }

        public Criteria andHaircutNotIn(List<Double> values) {
            addCriterion("haircut not in", values, "haircut");
            return (Criteria) this;
        }

        public Criteria andHaircutBetween(Double value1, Double value2) {
            addCriterion("haircut between", value1, value2, "haircut");
            return (Criteria) this;
        }

        public Criteria andHaircutNotBetween(Double value1, Double value2) {
            addCriterion("haircut not between", value1, value2, "haircut");
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

        public Criteria andHonorIsNull() {
            addCriterion("honor is null");
            return (Criteria) this;
        }

        public Criteria andHonorIsNotNull() {
            addCriterion("honor is not null");
            return (Criteria) this;
        }

        public Criteria andHonorEqualTo(String value) {
            addCriterion("honor =", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorNotEqualTo(String value) {
            addCriterion("honor <>", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorGreaterThan(String value) {
            addCriterion("honor >", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorGreaterThanOrEqualTo(String value) {
            addCriterion("honor >=", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorLessThan(String value) {
            addCriterion("honor <", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorLessThanOrEqualTo(String value) {
            addCriterion("honor <=", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorLike(String value) {
            addCriterion("honor like", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorNotLike(String value) {
            addCriterion("honor not like", value, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorIn(List<String> values) {
            addCriterion("honor in", values, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorNotIn(List<String> values) {
            addCriterion("honor not in", values, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorBetween(String value1, String value2) {
            addCriterion("honor between", value1, value2, "honor");
            return (Criteria) this;
        }

        public Criteria andHonorNotBetween(String value1, String value2) {
            addCriterion("honor not between", value1, value2, "honor");
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

        public Criteria andBeGoodIsNull() {
            addCriterion("be_good is null");
            return (Criteria) this;
        }

        public Criteria andBeGoodIsNotNull() {
            addCriterion("be_good is not null");
            return (Criteria) this;
        }

        public Criteria andBeGoodEqualTo(Integer value) {
            addCriterion("be_good =", value, "beGood");
            return (Criteria) this;
        }

        public Criteria andBeGoodNotEqualTo(Integer value) {
            addCriterion("be_good <>", value, "beGood");
            return (Criteria) this;
        }

        public Criteria andBeGoodGreaterThan(Integer value) {
            addCriterion("be_good >", value, "beGood");
            return (Criteria) this;
        }

        public Criteria andBeGoodGreaterThanOrEqualTo(Integer value) {
            addCriterion("be_good >=", value, "beGood");
            return (Criteria) this;
        }

        public Criteria andBeGoodLessThan(Integer value) {
            addCriterion("be_good <", value, "beGood");
            return (Criteria) this;
        }

        public Criteria andBeGoodLessThanOrEqualTo(Integer value) {
            addCriterion("be_good <=", value, "beGood");
            return (Criteria) this;
        }

        public Criteria andBeGoodIn(List<Integer> values) {
            addCriterion("be_good in", values, "beGood");
            return (Criteria) this;
        }

        public Criteria andBeGoodNotIn(List<Integer> values) {
            addCriterion("be_good not in", values, "beGood");
            return (Criteria) this;
        }

        public Criteria andBeGoodBetween(Integer value1, Integer value2) {
            addCriterion("be_good between", value1, value2, "beGood");
            return (Criteria) this;
        }

        public Criteria andBeGoodNotBetween(Integer value1, Integer value2) {
            addCriterion("be_good not between", value1, value2, "beGood");
            return (Criteria) this;
        }

        public Criteria andPopularIndexIsNull() {
            addCriterion("popular_index is null");
            return (Criteria) this;
        }

        public Criteria andPopularIndexIsNotNull() {
            addCriterion("popular_index is not null");
            return (Criteria) this;
        }

        public Criteria andPopularIndexEqualTo(Integer value) {
            addCriterion("popular_index =", value, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexNotEqualTo(Integer value) {
            addCriterion("popular_index <>", value, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexGreaterThan(Integer value) {
            addCriterion("popular_index >", value, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexGreaterThanOrEqualTo(Integer value) {
            addCriterion("popular_index >=", value, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexLessThan(Integer value) {
            addCriterion("popular_index <", value, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexLessThanOrEqualTo(Integer value) {
            addCriterion("popular_index <=", value, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexIn(List<Integer> values) {
            addCriterion("popular_index in", values, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexNotIn(List<Integer> values) {
            addCriterion("popular_index not in", values, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexBetween(Integer value1, Integer value2) {
            addCriterion("popular_index between", value1, value2, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexNotBetween(Integer value1, Integer value2) {
            addCriterion("popular_index not between", value1, value2, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andDesigerNameIsNull() {
            addCriterion("desiger_name is null");
            return (Criteria) this;
        }

        public Criteria andDesigerNameIsNotNull() {
            addCriterion("desiger_name is not null");
            return (Criteria) this;
        }

        public Criteria andDesigerNameEqualTo(String value) {
            addCriterion("desiger_name =", value, "desigerName");
            return (Criteria) this;
        }

        public Criteria andDesigerNameNotEqualTo(String value) {
            addCriterion("desiger_name <>", value, "desigerName");
            return (Criteria) this;
        }

        public Criteria andDesigerNameGreaterThan(String value) {
            addCriterion("desiger_name >", value, "desigerName");
            return (Criteria) this;
        }

        public Criteria andDesigerNameGreaterThanOrEqualTo(String value) {
            addCriterion("desiger_name >=", value, "desigerName");
            return (Criteria) this;
        }

        public Criteria andDesigerNameLessThan(String value) {
            addCriterion("desiger_name <", value, "desigerName");
            return (Criteria) this;
        }

        public Criteria andDesigerNameLessThanOrEqualTo(String value) {
            addCriterion("desiger_name <=", value, "desigerName");
            return (Criteria) this;
        }

        public Criteria andDesigerNameLike(String value) {
            addCriterion("desiger_name like", value, "desigerName");
            return (Criteria) this;
        }

        public Criteria andDesigerNameNotLike(String value) {
            addCriterion("desiger_name not like", value, "desigerName");
            return (Criteria) this;
        }

        public Criteria andDesigerNameIn(List<String> values) {
            addCriterion("desiger_name in", values, "desigerName");
            return (Criteria) this;
        }

        public Criteria andDesigerNameNotIn(List<String> values) {
            addCriterion("desiger_name not in", values, "desigerName");
            return (Criteria) this;
        }

        public Criteria andDesigerNameBetween(String value1, String value2) {
            addCriterion("desiger_name between", value1, value2, "desigerName");
            return (Criteria) this;
        }

        public Criteria andDesigerNameNotBetween(String value1, String value2) {
            addCriterion("desiger_name not between", value1, value2, "desigerName");
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
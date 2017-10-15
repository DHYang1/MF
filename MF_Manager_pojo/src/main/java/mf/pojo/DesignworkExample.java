package mf.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DesignworkExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DesignworkExample() {
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

        public Criteria andWorkIdIsNull() {
            addCriterion("work_id is null");
            return (Criteria) this;
        }

        public Criteria andWorkIdIsNotNull() {
            addCriterion("work_id is not null");
            return (Criteria) this;
        }

        public Criteria andWorkIdEqualTo(Long value) {
            addCriterion("work_id =", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotEqualTo(Long value) {
            addCriterion("work_id <>", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThan(Long value) {
            addCriterion("work_id >", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdGreaterThanOrEqualTo(Long value) {
            addCriterion("work_id >=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThan(Long value) {
            addCriterion("work_id <", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdLessThanOrEqualTo(Long value) {
            addCriterion("work_id <=", value, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdIn(List<Long> values) {
            addCriterion("work_id in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotIn(List<Long> values) {
            addCriterion("work_id not in", values, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdBetween(Long value1, Long value2) {
            addCriterion("work_id between", value1, value2, "workId");
            return (Criteria) this;
        }

        public Criteria andWorkIdNotBetween(Long value1, Long value2) {
            addCriterion("work_id not between", value1, value2, "workId");
            return (Criteria) this;
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

        public Criteria andTitleIsNull() {
            addCriterion("title is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("title is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("title =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("title <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("title >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("title >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("title <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("title <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("title like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("title not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("title in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("title not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("title between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("title not between", value1, value2, "title");
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

        public Criteria andCoverImageIsNull() {
            addCriterion("cover_image is null");
            return (Criteria) this;
        }

        public Criteria andCoverImageIsNotNull() {
            addCriterion("cover_image is not null");
            return (Criteria) this;
        }

        public Criteria andCoverImageEqualTo(String value) {
            addCriterion("cover_image =", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageNotEqualTo(String value) {
            addCriterion("cover_image <>", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageGreaterThan(String value) {
            addCriterion("cover_image >", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageGreaterThanOrEqualTo(String value) {
            addCriterion("cover_image >=", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageLessThan(String value) {
            addCriterion("cover_image <", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageLessThanOrEqualTo(String value) {
            addCriterion("cover_image <=", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageLike(String value) {
            addCriterion("cover_image like", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageNotLike(String value) {
            addCriterion("cover_image not like", value, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageIn(List<String> values) {
            addCriterion("cover_image in", values, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageNotIn(List<String> values) {
            addCriterion("cover_image not in", values, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageBetween(String value1, String value2) {
            addCriterion("cover_image between", value1, value2, "coverImage");
            return (Criteria) this;
        }

        public Criteria andCoverImageNotBetween(String value1, String value2) {
            addCriterion("cover_image not between", value1, value2, "coverImage");
            return (Criteria) this;
        }

        public Criteria andContentPictureIsNull() {
            addCriterion("content_picture is null");
            return (Criteria) this;
        }

        public Criteria andContentPictureIsNotNull() {
            addCriterion("content_picture is not null");
            return (Criteria) this;
        }

        public Criteria andContentPictureEqualTo(String value) {
            addCriterion("content_picture =", value, "contentPicture");
            return (Criteria) this;
        }

        public Criteria andContentPictureNotEqualTo(String value) {
            addCriterion("content_picture <>", value, "contentPicture");
            return (Criteria) this;
        }

        public Criteria andContentPictureGreaterThan(String value) {
            addCriterion("content_picture >", value, "contentPicture");
            return (Criteria) this;
        }

        public Criteria andContentPictureGreaterThanOrEqualTo(String value) {
            addCriterion("content_picture >=", value, "contentPicture");
            return (Criteria) this;
        }

        public Criteria andContentPictureLessThan(String value) {
            addCriterion("content_picture <", value, "contentPicture");
            return (Criteria) this;
        }

        public Criteria andContentPictureLessThanOrEqualTo(String value) {
            addCriterion("content_picture <=", value, "contentPicture");
            return (Criteria) this;
        }

        public Criteria andContentPictureLike(String value) {
            addCriterion("content_picture like", value, "contentPicture");
            return (Criteria) this;
        }

        public Criteria andContentPictureNotLike(String value) {
            addCriterion("content_picture not like", value, "contentPicture");
            return (Criteria) this;
        }

        public Criteria andContentPictureIn(List<String> values) {
            addCriterion("content_picture in", values, "contentPicture");
            return (Criteria) this;
        }

        public Criteria andContentPictureNotIn(List<String> values) {
            addCriterion("content_picture not in", values, "contentPicture");
            return (Criteria) this;
        }

        public Criteria andContentPictureBetween(String value1, String value2) {
            addCriterion("content_picture between", value1, value2, "contentPicture");
            return (Criteria) this;
        }

        public Criteria andContentPictureNotBetween(String value1, String value2) {
            addCriterion("content_picture not between", value1, value2, "contentPicture");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andFaceIsNull() {
            addCriterion("face is null");
            return (Criteria) this;
        }

        public Criteria andFaceIsNotNull() {
            addCriterion("face is not null");
            return (Criteria) this;
        }

        public Criteria andFaceEqualTo(Integer value) {
            addCriterion("face =", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotEqualTo(Integer value) {
            addCriterion("face <>", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceGreaterThan(Integer value) {
            addCriterion("face >", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceGreaterThanOrEqualTo(Integer value) {
            addCriterion("face >=", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceLessThan(Integer value) {
            addCriterion("face <", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceLessThanOrEqualTo(Integer value) {
            addCriterion("face <=", value, "face");
            return (Criteria) this;
        }

        public Criteria andFaceIn(List<Integer> values) {
            addCriterion("face in", values, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotIn(List<Integer> values) {
            addCriterion("face not in", values, "face");
            return (Criteria) this;
        }

        public Criteria andFaceBetween(Integer value1, Integer value2) {
            addCriterion("face between", value1, value2, "face");
            return (Criteria) this;
        }

        public Criteria andFaceNotBetween(Integer value1, Integer value2) {
            addCriterion("face not between", value1, value2, "face");
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

        public Criteria andPopularIndexEqualTo(Byte value) {
            addCriterion("popular_index =", value, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexNotEqualTo(Byte value) {
            addCriterion("popular_index <>", value, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexGreaterThan(Byte value) {
            addCriterion("popular_index >", value, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexGreaterThanOrEqualTo(Byte value) {
            addCriterion("popular_index >=", value, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexLessThan(Byte value) {
            addCriterion("popular_index <", value, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexLessThanOrEqualTo(Byte value) {
            addCriterion("popular_index <=", value, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexIn(List<Byte> values) {
            addCriterion("popular_index in", values, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexNotIn(List<Byte> values) {
            addCriterion("popular_index not in", values, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexBetween(Byte value1, Byte value2) {
            addCriterion("popular_index between", value1, value2, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andPopularIndexNotBetween(Byte value1, Byte value2) {
            addCriterion("popular_index not between", value1, value2, "popularIndex");
            return (Criteria) this;
        }

        public Criteria andAgeTypeIsNull() {
            addCriterion("age_type is null");
            return (Criteria) this;
        }

        public Criteria andAgeTypeIsNotNull() {
            addCriterion("age_type is not null");
            return (Criteria) this;
        }

        public Criteria andAgeTypeEqualTo(Byte value) {
            addCriterion("age_type =", value, "ageType");
            return (Criteria) this;
        }

        public Criteria andAgeTypeNotEqualTo(Byte value) {
            addCriterion("age_type <>", value, "ageType");
            return (Criteria) this;
        }

        public Criteria andAgeTypeGreaterThan(Byte value) {
            addCriterion("age_type >", value, "ageType");
            return (Criteria) this;
        }

        public Criteria andAgeTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("age_type >=", value, "ageType");
            return (Criteria) this;
        }

        public Criteria andAgeTypeLessThan(Byte value) {
            addCriterion("age_type <", value, "ageType");
            return (Criteria) this;
        }

        public Criteria andAgeTypeLessThanOrEqualTo(Byte value) {
            addCriterion("age_type <=", value, "ageType");
            return (Criteria) this;
        }

        public Criteria andAgeTypeIn(List<Byte> values) {
            addCriterion("age_type in", values, "ageType");
            return (Criteria) this;
        }

        public Criteria andAgeTypeNotIn(List<Byte> values) {
            addCriterion("age_type not in", values, "ageType");
            return (Criteria) this;
        }

        public Criteria andAgeTypeBetween(Byte value1, Byte value2) {
            addCriterion("age_type between", value1, value2, "ageType");
            return (Criteria) this;
        }

        public Criteria andAgeTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("age_type not between", value1, value2, "ageType");
            return (Criteria) this;
        }

        public Criteria andLastupdateTimeIsNull() {
            addCriterion("lastupdate_time is null");
            return (Criteria) this;
        }

        public Criteria andLastupdateTimeIsNotNull() {
            addCriterion("lastupdate_time is not null");
            return (Criteria) this;
        }

        public Criteria andLastupdateTimeEqualTo(Date value) {
            addCriterion("lastupdate_time =", value, "lastupdateTime");
            return (Criteria) this;
        }

        public Criteria andLastupdateTimeNotEqualTo(Date value) {
            addCriterion("lastupdate_time <>", value, "lastupdateTime");
            return (Criteria) this;
        }

        public Criteria andLastupdateTimeGreaterThan(Date value) {
            addCriterion("lastupdate_time >", value, "lastupdateTime");
            return (Criteria) this;
        }

        public Criteria andLastupdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("lastupdate_time >=", value, "lastupdateTime");
            return (Criteria) this;
        }

        public Criteria andLastupdateTimeLessThan(Date value) {
            addCriterion("lastupdate_time <", value, "lastupdateTime");
            return (Criteria) this;
        }

        public Criteria andLastupdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("lastupdate_time <=", value, "lastupdateTime");
            return (Criteria) this;
        }

        public Criteria andLastupdateTimeIn(List<Date> values) {
            addCriterion("lastupdate_time in", values, "lastupdateTime");
            return (Criteria) this;
        }

        public Criteria andLastupdateTimeNotIn(List<Date> values) {
            addCriterion("lastupdate_time not in", values, "lastupdateTime");
            return (Criteria) this;
        }

        public Criteria andLastupdateTimeBetween(Date value1, Date value2) {
            addCriterion("lastupdate_time between", value1, value2, "lastupdateTime");
            return (Criteria) this;
        }

        public Criteria andLastupdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("lastupdate_time not between", value1, value2, "lastupdateTime");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andPalaceIdIsNull() {
            addCriterion("palace_id is null");
            return (Criteria) this;
        }

        public Criteria andPalaceIdIsNotNull() {
            addCriterion("palace_id is not null");
            return (Criteria) this;
        }

        public Criteria andPalaceIdEqualTo(Long value) {
            addCriterion("palace_id =", value, "palaceId");
            return (Criteria) this;
        }

        public Criteria andPalaceIdNotEqualTo(Long value) {
            addCriterion("palace_id <>", value, "palaceId");
            return (Criteria) this;
        }

        public Criteria andPalaceIdGreaterThan(Long value) {
            addCriterion("palace_id >", value, "palaceId");
            return (Criteria) this;
        }

        public Criteria andPalaceIdGreaterThanOrEqualTo(Long value) {
            addCriterion("palace_id >=", value, "palaceId");
            return (Criteria) this;
        }

        public Criteria andPalaceIdLessThan(Long value) {
            addCriterion("palace_id <", value, "palaceId");
            return (Criteria) this;
        }

        public Criteria andPalaceIdLessThanOrEqualTo(Long value) {
            addCriterion("palace_id <=", value, "palaceId");
            return (Criteria) this;
        }

        public Criteria andPalaceIdIn(List<Long> values) {
            addCriterion("palace_id in", values, "palaceId");
            return (Criteria) this;
        }

        public Criteria andPalaceIdNotIn(List<Long> values) {
            addCriterion("palace_id not in", values, "palaceId");
            return (Criteria) this;
        }

        public Criteria andPalaceIdBetween(Long value1, Long value2) {
            addCriterion("palace_id between", value1, value2, "palaceId");
            return (Criteria) this;
        }

        public Criteria andPalaceIdNotBetween(Long value1, Long value2) {
            addCriterion("palace_id not between", value1, value2, "palaceId");
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
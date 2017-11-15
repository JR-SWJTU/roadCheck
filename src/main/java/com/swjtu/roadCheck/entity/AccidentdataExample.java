package com.swjtu.roadCheck.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AccidentdataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AccidentdataExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("_id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("_id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("_id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("_id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("_id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("_id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("_id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("_id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("_id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("_id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("_id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("_id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andRiqiIsNull() {
            addCriterion("riQI is null");
            return (Criteria) this;
        }

        public Criteria andRiqiIsNotNull() {
            addCriterion("riQI is not null");
            return (Criteria) this;
        }

        public Criteria andRiqiEqualTo(Date value) {
            addCriterion("riQI =", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotEqualTo(Date value) {
            addCriterion("riQI <>", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiGreaterThan(Date value) {
            addCriterion("riQI >", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiGreaterThanOrEqualTo(Date value) {
            addCriterion("riQI >=", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLessThan(Date value) {
            addCriterion("riQI <", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiLessThanOrEqualTo(Date value) {
            addCriterion("riQI <=", value, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiIn(List<Date> values) {
            addCriterion("riQI in", values, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotIn(List<Date> values) {
            addCriterion("riQI not in", values, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiBetween(Date value1, Date value2) {
            addCriterion("riQI between", value1, value2, "riqi");
            return (Criteria) this;
        }

        public Criteria andRiqiNotBetween(Date value1, Date value2) {
            addCriterion("riQI not between", value1, value2, "riqi");
            return (Criteria) this;
        }

        public Criteria andLatIsNull() {
            addCriterion("lat is null");
            return (Criteria) this;
        }

        public Criteria andLatIsNotNull() {
            addCriterion("lat is not null");
            return (Criteria) this;
        }

        public Criteria andLatEqualTo(Double value) {
            addCriterion("lat =", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotEqualTo(Double value) {
            addCriterion("lat <>", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThan(Double value) {
            addCriterion("lat >", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatGreaterThanOrEqualTo(Double value) {
            addCriterion("lat >=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThan(Double value) {
            addCriterion("lat <", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatLessThanOrEqualTo(Double value) {
            addCriterion("lat <=", value, "lat");
            return (Criteria) this;
        }

        public Criteria andLatIn(List<Double> values) {
            addCriterion("lat in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotIn(List<Double> values) {
            addCriterion("lat not in", values, "lat");
            return (Criteria) this;
        }

        public Criteria andLatBetween(Double value1, Double value2) {
            addCriterion("lat between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLatNotBetween(Double value1, Double value2) {
            addCriterion("lat not between", value1, value2, "lat");
            return (Criteria) this;
        }

        public Criteria andLngIsNull() {
            addCriterion("lng is null");
            return (Criteria) this;
        }

        public Criteria andLngIsNotNull() {
            addCriterion("lng is not null");
            return (Criteria) this;
        }

        public Criteria andLngEqualTo(Double value) {
            addCriterion("lng =", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotEqualTo(Double value) {
            addCriterion("lng <>", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThan(Double value) {
            addCriterion("lng >", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngGreaterThanOrEqualTo(Double value) {
            addCriterion("lng >=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThan(Double value) {
            addCriterion("lng <", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngLessThanOrEqualTo(Double value) {
            addCriterion("lng <=", value, "lng");
            return (Criteria) this;
        }

        public Criteria andLngIn(List<Double> values) {
            addCriterion("lng in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotIn(List<Double> values) {
            addCriterion("lng not in", values, "lng");
            return (Criteria) this;
        }

        public Criteria andLngBetween(Double value1, Double value2) {
            addCriterion("lng between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andLngNotBetween(Double value1, Double value2) {
            addCriterion("lng not between", value1, value2, "lng");
            return (Criteria) this;
        }

        public Criteria andIsWorkdayIsNull() {
            addCriterion("is_workday is null");
            return (Criteria) this;
        }

        public Criteria andIsWorkdayIsNotNull() {
            addCriterion("is_workday is not null");
            return (Criteria) this;
        }

        public Criteria andIsWorkdayEqualTo(Boolean value) {
            addCriterion("is_workday =", value, "isWorkday");
            return (Criteria) this;
        }

        public Criteria andIsWorkdayNotEqualTo(Boolean value) {
            addCriterion("is_workday <>", value, "isWorkday");
            return (Criteria) this;
        }

        public Criteria andIsWorkdayGreaterThan(Boolean value) {
            addCriterion("is_workday >", value, "isWorkday");
            return (Criteria) this;
        }

        public Criteria andIsWorkdayGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_workday >=", value, "isWorkday");
            return (Criteria) this;
        }

        public Criteria andIsWorkdayLessThan(Boolean value) {
            addCriterion("is_workday <", value, "isWorkday");
            return (Criteria) this;
        }

        public Criteria andIsWorkdayLessThanOrEqualTo(Boolean value) {
            addCriterion("is_workday <=", value, "isWorkday");
            return (Criteria) this;
        }

        public Criteria andIsWorkdayIn(List<Boolean> values) {
            addCriterion("is_workday in", values, "isWorkday");
            return (Criteria) this;
        }

        public Criteria andIsWorkdayNotIn(List<Boolean> values) {
            addCriterion("is_workday not in", values, "isWorkday");
            return (Criteria) this;
        }

        public Criteria andIsWorkdayBetween(Boolean value1, Boolean value2) {
            addCriterion("is_workday between", value1, value2, "isWorkday");
            return (Criteria) this;
        }

        public Criteria andIsWorkdayNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_workday not between", value1, value2, "isWorkday");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeIsNull() {
            addCriterion("carCollisionType is null");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeIsNotNull() {
            addCriterion("carCollisionType is not null");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeEqualTo(String value) {
            addCriterion("carCollisionType =", value, "carcollisiontype");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeNotEqualTo(String value) {
            addCriterion("carCollisionType <>", value, "carcollisiontype");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeGreaterThan(String value) {
            addCriterion("carCollisionType >", value, "carcollisiontype");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeGreaterThanOrEqualTo(String value) {
            addCriterion("carCollisionType >=", value, "carcollisiontype");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeLessThan(String value) {
            addCriterion("carCollisionType <", value, "carcollisiontype");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeLessThanOrEqualTo(String value) {
            addCriterion("carCollisionType <=", value, "carcollisiontype");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeLike(String value) {
            addCriterion("carCollisionType like", value, "carcollisiontype");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeNotLike(String value) {
            addCriterion("carCollisionType not like", value, "carcollisiontype");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeIn(List<String> values) {
            addCriterion("carCollisionType in", values, "carcollisiontype");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeNotIn(List<String> values) {
            addCriterion("carCollisionType not in", values, "carcollisiontype");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeBetween(String value1, String value2) {
            addCriterion("carCollisionType between", value1, value2, "carcollisiontype");
            return (Criteria) this;
        }

        public Criteria andCarcollisiontypeNotBetween(String value1, String value2) {
            addCriterion("carCollisionType not between", value1, value2, "carcollisiontype");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNull() {
            addCriterion("team_name is null");
            return (Criteria) this;
        }

        public Criteria andTeamNameIsNotNull() {
            addCriterion("team_name is not null");
            return (Criteria) this;
        }

        public Criteria andTeamNameEqualTo(String value) {
            addCriterion("team_name =", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotEqualTo(String value) {
            addCriterion("team_name <>", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThan(String value) {
            addCriterion("team_name >", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameGreaterThanOrEqualTo(String value) {
            addCriterion("team_name >=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThan(String value) {
            addCriterion("team_name <", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLessThanOrEqualTo(String value) {
            addCriterion("team_name <=", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameLike(String value) {
            addCriterion("team_name like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotLike(String value) {
            addCriterion("team_name not like", value, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameIn(List<String> values) {
            addCriterion("team_name in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotIn(List<String> values) {
            addCriterion("team_name not in", values, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameBetween(String value1, String value2) {
            addCriterion("team_name between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andTeamNameNotBetween(String value1, String value2) {
            addCriterion("team_name not between", value1, value2, "teamName");
            return (Criteria) this;
        }

        public Criteria andLumianlevIsNull() {
            addCriterion("luMianLev is null");
            return (Criteria) this;
        }

        public Criteria andLumianlevIsNotNull() {
            addCriterion("luMianLev is not null");
            return (Criteria) this;
        }

        public Criteria andLumianlevEqualTo(String value) {
            addCriterion("luMianLev =", value, "lumianlev");
            return (Criteria) this;
        }

        public Criteria andLumianlevNotEqualTo(String value) {
            addCriterion("luMianLev <>", value, "lumianlev");
            return (Criteria) this;
        }

        public Criteria andLumianlevGreaterThan(String value) {
            addCriterion("luMianLev >", value, "lumianlev");
            return (Criteria) this;
        }

        public Criteria andLumianlevGreaterThanOrEqualTo(String value) {
            addCriterion("luMianLev >=", value, "lumianlev");
            return (Criteria) this;
        }

        public Criteria andLumianlevLessThan(String value) {
            addCriterion("luMianLev <", value, "lumianlev");
            return (Criteria) this;
        }

        public Criteria andLumianlevLessThanOrEqualTo(String value) {
            addCriterion("luMianLev <=", value, "lumianlev");
            return (Criteria) this;
        }

        public Criteria andLumianlevLike(String value) {
            addCriterion("luMianLev like", value, "lumianlev");
            return (Criteria) this;
        }

        public Criteria andLumianlevNotLike(String value) {
            addCriterion("luMianLev not like", value, "lumianlev");
            return (Criteria) this;
        }

        public Criteria andLumianlevIn(List<String> values) {
            addCriterion("luMianLev in", values, "lumianlev");
            return (Criteria) this;
        }

        public Criteria andLumianlevNotIn(List<String> values) {
            addCriterion("luMianLev not in", values, "lumianlev");
            return (Criteria) this;
        }

        public Criteria andLumianlevBetween(String value1, String value2) {
            addCriterion("luMianLev between", value1, value2, "lumianlev");
            return (Criteria) this;
        }

        public Criteria andLumianlevNotBetween(String value1, String value2) {
            addCriterion("luMianLev not between", value1, value2, "lumianlev");
            return (Criteria) this;
        }

        public Criteria andJcktypeIsNull() {
            addCriterion("Jcktype is null");
            return (Criteria) this;
        }

        public Criteria andJcktypeIsNotNull() {
            addCriterion("Jcktype is not null");
            return (Criteria) this;
        }

        public Criteria andJcktypeEqualTo(String value) {
            addCriterion("Jcktype =", value, "jcktype");
            return (Criteria) this;
        }

        public Criteria andJcktypeNotEqualTo(String value) {
            addCriterion("Jcktype <>", value, "jcktype");
            return (Criteria) this;
        }

        public Criteria andJcktypeGreaterThan(String value) {
            addCriterion("Jcktype >", value, "jcktype");
            return (Criteria) this;
        }

        public Criteria andJcktypeGreaterThanOrEqualTo(String value) {
            addCriterion("Jcktype >=", value, "jcktype");
            return (Criteria) this;
        }

        public Criteria andJcktypeLessThan(String value) {
            addCriterion("Jcktype <", value, "jcktype");
            return (Criteria) this;
        }

        public Criteria andJcktypeLessThanOrEqualTo(String value) {
            addCriterion("Jcktype <=", value, "jcktype");
            return (Criteria) this;
        }

        public Criteria andJcktypeLike(String value) {
            addCriterion("Jcktype like", value, "jcktype");
            return (Criteria) this;
        }

        public Criteria andJcktypeNotLike(String value) {
            addCriterion("Jcktype not like", value, "jcktype");
            return (Criteria) this;
        }

        public Criteria andJcktypeIn(List<String> values) {
            addCriterion("Jcktype in", values, "jcktype");
            return (Criteria) this;
        }

        public Criteria andJcktypeNotIn(List<String> values) {
            addCriterion("Jcktype not in", values, "jcktype");
            return (Criteria) this;
        }

        public Criteria andJcktypeBetween(String value1, String value2) {
            addCriterion("Jcktype between", value1, value2, "jcktype");
            return (Criteria) this;
        }

        public Criteria andJcktypeNotBetween(String value1, String value2) {
            addCriterion("Jcktype not between", value1, value2, "jcktype");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionIsNull() {
            addCriterion("Tianqicondition is null");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionIsNotNull() {
            addCriterion("Tianqicondition is not null");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionEqualTo(String value) {
            addCriterion("Tianqicondition =", value, "tianqicondition");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionNotEqualTo(String value) {
            addCriterion("Tianqicondition <>", value, "tianqicondition");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionGreaterThan(String value) {
            addCriterion("Tianqicondition >", value, "tianqicondition");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionGreaterThanOrEqualTo(String value) {
            addCriterion("Tianqicondition >=", value, "tianqicondition");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionLessThan(String value) {
            addCriterion("Tianqicondition <", value, "tianqicondition");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionLessThanOrEqualTo(String value) {
            addCriterion("Tianqicondition <=", value, "tianqicondition");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionLike(String value) {
            addCriterion("Tianqicondition like", value, "tianqicondition");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionNotLike(String value) {
            addCriterion("Tianqicondition not like", value, "tianqicondition");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionIn(List<String> values) {
            addCriterion("Tianqicondition in", values, "tianqicondition");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionNotIn(List<String> values) {
            addCriterion("Tianqicondition not in", values, "tianqicondition");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionBetween(String value1, String value2) {
            addCriterion("Tianqicondition between", value1, value2, "tianqicondition");
            return (Criteria) this;
        }

        public Criteria andTianqiconditionNotBetween(String value1, String value2) {
            addCriterion("Tianqicondition not between", value1, value2, "tianqicondition");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelIsNull() {
            addCriterion("workPlaceRel is null");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelIsNotNull() {
            addCriterion("workPlaceRel is not null");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelEqualTo(String value) {
            addCriterion("workPlaceRel =", value, "workplacerel");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelNotEqualTo(String value) {
            addCriterion("workPlaceRel <>", value, "workplacerel");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelGreaterThan(String value) {
            addCriterion("workPlaceRel >", value, "workplacerel");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelGreaterThanOrEqualTo(String value) {
            addCriterion("workPlaceRel >=", value, "workplacerel");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelLessThan(String value) {
            addCriterion("workPlaceRel <", value, "workplacerel");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelLessThanOrEqualTo(String value) {
            addCriterion("workPlaceRel <=", value, "workplacerel");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelLike(String value) {
            addCriterion("workPlaceRel like", value, "workplacerel");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelNotLike(String value) {
            addCriterion("workPlaceRel not like", value, "workplacerel");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelIn(List<String> values) {
            addCriterion("workPlaceRel in", values, "workplacerel");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelNotIn(List<String> values) {
            addCriterion("workPlaceRel not in", values, "workplacerel");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelBetween(String value1, String value2) {
            addCriterion("workPlaceRel between", value1, value2, "workplacerel");
            return (Criteria) this;
        }

        public Criteria andWorkplacerelNotBetween(String value1, String value2) {
            addCriterion("workPlaceRel not between", value1, value2, "workplacerel");
            return (Criteria) this;
        }

        public Criteria andLeixingIsNull() {
            addCriterion("Leixing is null");
            return (Criteria) this;
        }

        public Criteria andLeixingIsNotNull() {
            addCriterion("Leixing is not null");
            return (Criteria) this;
        }

        public Criteria andLeixingEqualTo(String value) {
            addCriterion("Leixing =", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotEqualTo(String value) {
            addCriterion("Leixing <>", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingGreaterThan(String value) {
            addCriterion("Leixing >", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingGreaterThanOrEqualTo(String value) {
            addCriterion("Leixing >=", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingLessThan(String value) {
            addCriterion("Leixing <", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingLessThanOrEqualTo(String value) {
            addCriterion("Leixing <=", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingLike(String value) {
            addCriterion("Leixing like", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotLike(String value) {
            addCriterion("Leixing not like", value, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingIn(List<String> values) {
            addCriterion("Leixing in", values, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotIn(List<String> values) {
            addCriterion("Leixing not in", values, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingBetween(String value1, String value2) {
            addCriterion("Leixing between", value1, value2, "leixing");
            return (Criteria) this;
        }

        public Criteria andLeixingNotBetween(String value1, String value2) {
            addCriterion("Leixing not between", value1, value2, "leixing");
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
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
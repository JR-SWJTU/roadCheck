package com.swjtu.roadCheck.entity;

import java.util.ArrayList;
import java.util.List;

public class ChenzuoPeopelDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ChenzuoPeopelDataExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAqqnztIsNull() {
            addCriterion("aqqnzt is null");
            return (Criteria) this;
        }

        public Criteria andAqqnztIsNotNull() {
            addCriterion("aqqnzt is not null");
            return (Criteria) this;
        }

        public Criteria andAqqnztEqualTo(String value) {
            addCriterion("aqqnzt =", value, "aqqnzt");
            return (Criteria) this;
        }

        public Criteria andAqqnztNotEqualTo(String value) {
            addCriterion("aqqnzt <>", value, "aqqnzt");
            return (Criteria) this;
        }

        public Criteria andAqqnztGreaterThan(String value) {
            addCriterion("aqqnzt >", value, "aqqnzt");
            return (Criteria) this;
        }

        public Criteria andAqqnztGreaterThanOrEqualTo(String value) {
            addCriterion("aqqnzt >=", value, "aqqnzt");
            return (Criteria) this;
        }

        public Criteria andAqqnztLessThan(String value) {
            addCriterion("aqqnzt <", value, "aqqnzt");
            return (Criteria) this;
        }

        public Criteria andAqqnztLessThanOrEqualTo(String value) {
            addCriterion("aqqnzt <=", value, "aqqnzt");
            return (Criteria) this;
        }

        public Criteria andAqqnztLike(String value) {
            addCriterion("aqqnzt like", value, "aqqnzt");
            return (Criteria) this;
        }

        public Criteria andAqqnztNotLike(String value) {
            addCriterion("aqqnzt not like", value, "aqqnzt");
            return (Criteria) this;
        }

        public Criteria andAqqnztIn(List<String> values) {
            addCriterion("aqqnzt in", values, "aqqnzt");
            return (Criteria) this;
        }

        public Criteria andAqqnztNotIn(List<String> values) {
            addCriterion("aqqnzt not in", values, "aqqnzt");
            return (Criteria) this;
        }

        public Criteria andAqqnztBetween(String value1, String value2) {
            addCriterion("aqqnzt between", value1, value2, "aqqnzt");
            return (Criteria) this;
        }

        public Criteria andAqqnztNotBetween(String value1, String value2) {
            addCriterion("aqqnzt not between", value1, value2, "aqqnzt");
            return (Criteria) this;
        }

        public Criteria andCeshiresultIsNull() {
            addCriterion("ceshiresult is null");
            return (Criteria) this;
        }

        public Criteria andCeshiresultIsNotNull() {
            addCriterion("ceshiresult is not null");
            return (Criteria) this;
        }

        public Criteria andCeshiresultEqualTo(String value) {
            addCriterion("ceshiresult =", value, "ceshiresult");
            return (Criteria) this;
        }

        public Criteria andCeshiresultNotEqualTo(String value) {
            addCriterion("ceshiresult <>", value, "ceshiresult");
            return (Criteria) this;
        }

        public Criteria andCeshiresultGreaterThan(String value) {
            addCriterion("ceshiresult >", value, "ceshiresult");
            return (Criteria) this;
        }

        public Criteria andCeshiresultGreaterThanOrEqualTo(String value) {
            addCriterion("ceshiresult >=", value, "ceshiresult");
            return (Criteria) this;
        }

        public Criteria andCeshiresultLessThan(String value) {
            addCriterion("ceshiresult <", value, "ceshiresult");
            return (Criteria) this;
        }

        public Criteria andCeshiresultLessThanOrEqualTo(String value) {
            addCriterion("ceshiresult <=", value, "ceshiresult");
            return (Criteria) this;
        }

        public Criteria andCeshiresultLike(String value) {
            addCriterion("ceshiresult like", value, "ceshiresult");
            return (Criteria) this;
        }

        public Criteria andCeshiresultNotLike(String value) {
            addCriterion("ceshiresult not like", value, "ceshiresult");
            return (Criteria) this;
        }

        public Criteria andCeshiresultIn(List<String> values) {
            addCriterion("ceshiresult in", values, "ceshiresult");
            return (Criteria) this;
        }

        public Criteria andCeshiresultNotIn(List<String> values) {
            addCriterion("ceshiresult not in", values, "ceshiresult");
            return (Criteria) this;
        }

        public Criteria andCeshiresultBetween(String value1, String value2) {
            addCriterion("ceshiresult between", value1, value2, "ceshiresult");
            return (Criteria) this;
        }

        public Criteria andCeshiresultNotBetween(String value1, String value2) {
            addCriterion("ceshiresult not between", value1, value2, "ceshiresult");
            return (Criteria) this;
        }

        public Criteria andCeshitypeIsNull() {
            addCriterion("ceshitype is null");
            return (Criteria) this;
        }

        public Criteria andCeshitypeIsNotNull() {
            addCriterion("ceshitype is not null");
            return (Criteria) this;
        }

        public Criteria andCeshitypeEqualTo(String value) {
            addCriterion("ceshitype =", value, "ceshitype");
            return (Criteria) this;
        }

        public Criteria andCeshitypeNotEqualTo(String value) {
            addCriterion("ceshitype <>", value, "ceshitype");
            return (Criteria) this;
        }

        public Criteria andCeshitypeGreaterThan(String value) {
            addCriterion("ceshitype >", value, "ceshitype");
            return (Criteria) this;
        }

        public Criteria andCeshitypeGreaterThanOrEqualTo(String value) {
            addCriterion("ceshitype >=", value, "ceshitype");
            return (Criteria) this;
        }

        public Criteria andCeshitypeLessThan(String value) {
            addCriterion("ceshitype <", value, "ceshitype");
            return (Criteria) this;
        }

        public Criteria andCeshitypeLessThanOrEqualTo(String value) {
            addCriterion("ceshitype <=", value, "ceshitype");
            return (Criteria) this;
        }

        public Criteria andCeshitypeLike(String value) {
            addCriterion("ceshitype like", value, "ceshitype");
            return (Criteria) this;
        }

        public Criteria andCeshitypeNotLike(String value) {
            addCriterion("ceshitype not like", value, "ceshitype");
            return (Criteria) this;
        }

        public Criteria andCeshitypeIn(List<String> values) {
            addCriterion("ceshitype in", values, "ceshitype");
            return (Criteria) this;
        }

        public Criteria andCeshitypeNotIn(List<String> values) {
            addCriterion("ceshitype not in", values, "ceshitype");
            return (Criteria) this;
        }

        public Criteria andCeshitypeBetween(String value1, String value2) {
            addCriterion("ceshitype between", value1, value2, "ceshitype");
            return (Criteria) this;
        }

        public Criteria andCeshitypeNotBetween(String value1, String value2) {
            addCriterion("ceshitype not between", value1, value2, "ceshitype");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiIsNull() {
            addCriterion("ceshizhuangtai is null");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiIsNotNull() {
            addCriterion("ceshizhuangtai is not null");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiEqualTo(String value) {
            addCriterion("ceshizhuangtai =", value, "ceshizhuangtai");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiNotEqualTo(String value) {
            addCriterion("ceshizhuangtai <>", value, "ceshizhuangtai");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiGreaterThan(String value) {
            addCriterion("ceshizhuangtai >", value, "ceshizhuangtai");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiGreaterThanOrEqualTo(String value) {
            addCriterion("ceshizhuangtai >=", value, "ceshizhuangtai");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiLessThan(String value) {
            addCriterion("ceshizhuangtai <", value, "ceshizhuangtai");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiLessThanOrEqualTo(String value) {
            addCriterion("ceshizhuangtai <=", value, "ceshizhuangtai");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiLike(String value) {
            addCriterion("ceshizhuangtai like", value, "ceshizhuangtai");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiNotLike(String value) {
            addCriterion("ceshizhuangtai not like", value, "ceshizhuangtai");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiIn(List<String> values) {
            addCriterion("ceshizhuangtai in", values, "ceshizhuangtai");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiNotIn(List<String> values) {
            addCriterion("ceshizhuangtai not in", values, "ceshizhuangtai");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiBetween(String value1, String value2) {
            addCriterion("ceshizhuangtai between", value1, value2, "ceshizhuangtai");
            return (Criteria) this;
        }

        public Criteria andCeshizhuangtaiNotBetween(String value1, String value2) {
            addCriterion("ceshizhuangtai not between", value1, value2, "ceshizhuangtai");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoIsNull() {
            addCriterion("cheliangxunhao is null");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoIsNotNull() {
            addCriterion("cheliangxunhao is not null");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoEqualTo(String value) {
            addCriterion("cheliangxunhao =", value, "cheliangxunhao");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoNotEqualTo(String value) {
            addCriterion("cheliangxunhao <>", value, "cheliangxunhao");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoGreaterThan(String value) {
            addCriterion("cheliangxunhao >", value, "cheliangxunhao");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoGreaterThanOrEqualTo(String value) {
            addCriterion("cheliangxunhao >=", value, "cheliangxunhao");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoLessThan(String value) {
            addCriterion("cheliangxunhao <", value, "cheliangxunhao");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoLessThanOrEqualTo(String value) {
            addCriterion("cheliangxunhao <=", value, "cheliangxunhao");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoLike(String value) {
            addCriterion("cheliangxunhao like", value, "cheliangxunhao");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoNotLike(String value) {
            addCriterion("cheliangxunhao not like", value, "cheliangxunhao");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoIn(List<String> values) {
            addCriterion("cheliangxunhao in", values, "cheliangxunhao");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoNotIn(List<String> values) {
            addCriterion("cheliangxunhao not in", values, "cheliangxunhao");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoBetween(String value1, String value2) {
            addCriterion("cheliangxunhao between", value1, value2, "cheliangxunhao");
            return (Criteria) this;
        }

        public Criteria andCheliangxunhaoNotBetween(String value1, String value2) {
            addCriterion("cheliangxunhao not between", value1, value2, "cheliangxunhao");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingIsNull() {
            addCriterion("du_ping_lei_xing is null");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingIsNotNull() {
            addCriterion("du_ping_lei_xing is not null");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingEqualTo(String value) {
            addCriterion("du_ping_lei_xing =", value, "duPingLeiXing");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingNotEqualTo(String value) {
            addCriterion("du_ping_lei_xing <>", value, "duPingLeiXing");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingGreaterThan(String value) {
            addCriterion("du_ping_lei_xing >", value, "duPingLeiXing");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingGreaterThanOrEqualTo(String value) {
            addCriterion("du_ping_lei_xing >=", value, "duPingLeiXing");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingLessThan(String value) {
            addCriterion("du_ping_lei_xing <", value, "duPingLeiXing");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingLessThanOrEqualTo(String value) {
            addCriterion("du_ping_lei_xing <=", value, "duPingLeiXing");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingLike(String value) {
            addCriterion("du_ping_lei_xing like", value, "duPingLeiXing");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingNotLike(String value) {
            addCriterion("du_ping_lei_xing not like", value, "duPingLeiXing");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingIn(List<String> values) {
            addCriterion("du_ping_lei_xing in", values, "duPingLeiXing");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingNotIn(List<String> values) {
            addCriterion("du_ping_lei_xing not in", values, "duPingLeiXing");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingBetween(String value1, String value2) {
            addCriterion("du_ping_lei_xing between", value1, value2, "duPingLeiXing");
            return (Criteria) this;
        }

        public Criteria andDuPingLeiXingNotBetween(String value1, String value2) {
            addCriterion("du_ping_lei_xing not between", value1, value2, "duPingLeiXing");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaIsNull() {
            addCriterion("paochuzhuangta is null");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaIsNotNull() {
            addCriterion("paochuzhuangta is not null");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaEqualTo(String value) {
            addCriterion("paochuzhuangta =", value, "paochuzhuangta");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaNotEqualTo(String value) {
            addCriterion("paochuzhuangta <>", value, "paochuzhuangta");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaGreaterThan(String value) {
            addCriterion("paochuzhuangta >", value, "paochuzhuangta");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaGreaterThanOrEqualTo(String value) {
            addCriterion("paochuzhuangta >=", value, "paochuzhuangta");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaLessThan(String value) {
            addCriterion("paochuzhuangta <", value, "paochuzhuangta");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaLessThanOrEqualTo(String value) {
            addCriterion("paochuzhuangta <=", value, "paochuzhuangta");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaLike(String value) {
            addCriterion("paochuzhuangta like", value, "paochuzhuangta");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaNotLike(String value) {
            addCriterion("paochuzhuangta not like", value, "paochuzhuangta");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaIn(List<String> values) {
            addCriterion("paochuzhuangta in", values, "paochuzhuangta");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaNotIn(List<String> values) {
            addCriterion("paochuzhuangta not in", values, "paochuzhuangta");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaBetween(String value1, String value2) {
            addCriterion("paochuzhuangta between", value1, value2, "paochuzhuangta");
            return (Criteria) this;
        }

        public Criteria andPaochuzhuangtaNotBetween(String value1, String value2) {
            addCriterion("paochuzhuangta not between", value1, value2, "paochuzhuangta");
            return (Criteria) this;
        }

        public Criteria andPhonenumIsNull() {
            addCriterion("phonenum is null");
            return (Criteria) this;
        }

        public Criteria andPhonenumIsNotNull() {
            addCriterion("phonenum is not null");
            return (Criteria) this;
        }

        public Criteria andPhonenumEqualTo(String value) {
            addCriterion("phonenum =", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotEqualTo(String value) {
            addCriterion("phonenum <>", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThan(String value) {
            addCriterion("phonenum >", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumGreaterThanOrEqualTo(String value) {
            addCriterion("phonenum >=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThan(String value) {
            addCriterion("phonenum <", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLessThanOrEqualTo(String value) {
            addCriterion("phonenum <=", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumLike(String value) {
            addCriterion("phonenum like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotLike(String value) {
            addCriterion("phonenum not like", value, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumIn(List<String> values) {
            addCriterion("phonenum in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotIn(List<String> values) {
            addCriterion("phonenum not in", values, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumBetween(String value1, String value2) {
            addCriterion("phonenum between", value1, value2, "phonenum");
            return (Criteria) this;
        }

        public Criteria andPhonenumNotBetween(String value1, String value2) {
            addCriterion("phonenum not between", value1, value2, "phonenum");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeIsNull() {
            addCriterion("renyuantype is null");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeIsNotNull() {
            addCriterion("renyuantype is not null");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeEqualTo(String value) {
            addCriterion("renyuantype =", value, "renyuantype");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeNotEqualTo(String value) {
            addCriterion("renyuantype <>", value, "renyuantype");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeGreaterThan(String value) {
            addCriterion("renyuantype >", value, "renyuantype");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeGreaterThanOrEqualTo(String value) {
            addCriterion("renyuantype >=", value, "renyuantype");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeLessThan(String value) {
            addCriterion("renyuantype <", value, "renyuantype");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeLessThanOrEqualTo(String value) {
            addCriterion("renyuantype <=", value, "renyuantype");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeLike(String value) {
            addCriterion("renyuantype like", value, "renyuantype");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeNotLike(String value) {
            addCriterion("renyuantype not like", value, "renyuantype");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeIn(List<String> values) {
            addCriterion("renyuantype in", values, "renyuantype");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeNotIn(List<String> values) {
            addCriterion("renyuantype not in", values, "renyuantype");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeBetween(String value1, String value2) {
            addCriterion("renyuantype between", value1, value2, "renyuantype");
            return (Criteria) this;
        }

        public Criteria andRenyuantypeNotBetween(String value1, String value2) {
            addCriterion("renyuantype not between", value1, value2, "renyuantype");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiIsNull() {
            addCriterion("sgfsszhuangtai is null");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiIsNotNull() {
            addCriterion("sgfsszhuangtai is not null");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiEqualTo(String value) {
            addCriterion("sgfsszhuangtai =", value, "sgfsszhuangtai");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiNotEqualTo(String value) {
            addCriterion("sgfsszhuangtai <>", value, "sgfsszhuangtai");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiGreaterThan(String value) {
            addCriterion("sgfsszhuangtai >", value, "sgfsszhuangtai");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiGreaterThanOrEqualTo(String value) {
            addCriterion("sgfsszhuangtai >=", value, "sgfsszhuangtai");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiLessThan(String value) {
            addCriterion("sgfsszhuangtai <", value, "sgfsszhuangtai");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiLessThanOrEqualTo(String value) {
            addCriterion("sgfsszhuangtai <=", value, "sgfsszhuangtai");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiLike(String value) {
            addCriterion("sgfsszhuangtai like", value, "sgfsszhuangtai");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiNotLike(String value) {
            addCriterion("sgfsszhuangtai not like", value, "sgfsszhuangtai");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiIn(List<String> values) {
            addCriterion("sgfsszhuangtai in", values, "sgfsszhuangtai");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiNotIn(List<String> values) {
            addCriterion("sgfsszhuangtai not in", values, "sgfsszhuangtai");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiBetween(String value1, String value2) {
            addCriterion("sgfsszhuangtai between", value1, value2, "sgfsszhuangtai");
            return (Criteria) this;
        }

        public Criteria andSgfsszhuangtaiNotBetween(String value1, String value2) {
            addCriterion("sgfsszhuangtai not between", value1, value2, "sgfsszhuangtai");
            return (Criteria) this;
        }

        public Criteria andShenfentypeIsNull() {
            addCriterion("shenfentype is null");
            return (Criteria) this;
        }

        public Criteria andShenfentypeIsNotNull() {
            addCriterion("shenfentype is not null");
            return (Criteria) this;
        }

        public Criteria andShenfentypeEqualTo(String value) {
            addCriterion("shenfentype =", value, "shenfentype");
            return (Criteria) this;
        }

        public Criteria andShenfentypeNotEqualTo(String value) {
            addCriterion("shenfentype <>", value, "shenfentype");
            return (Criteria) this;
        }

        public Criteria andShenfentypeGreaterThan(String value) {
            addCriterion("shenfentype >", value, "shenfentype");
            return (Criteria) this;
        }

        public Criteria andShenfentypeGreaterThanOrEqualTo(String value) {
            addCriterion("shenfentype >=", value, "shenfentype");
            return (Criteria) this;
        }

        public Criteria andShenfentypeLessThan(String value) {
            addCriterion("shenfentype <", value, "shenfentype");
            return (Criteria) this;
        }

        public Criteria andShenfentypeLessThanOrEqualTo(String value) {
            addCriterion("shenfentype <=", value, "shenfentype");
            return (Criteria) this;
        }

        public Criteria andShenfentypeLike(String value) {
            addCriterion("shenfentype like", value, "shenfentype");
            return (Criteria) this;
        }

        public Criteria andShenfentypeNotLike(String value) {
            addCriterion("shenfentype not like", value, "shenfentype");
            return (Criteria) this;
        }

        public Criteria andShenfentypeIn(List<String> values) {
            addCriterion("shenfentype in", values, "shenfentype");
            return (Criteria) this;
        }

        public Criteria andShenfentypeNotIn(List<String> values) {
            addCriterion("shenfentype not in", values, "shenfentype");
            return (Criteria) this;
        }

        public Criteria andShenfentypeBetween(String value1, String value2) {
            addCriterion("shenfentype between", value1, value2, "shenfentype");
            return (Criteria) this;
        }

        public Criteria andShenfentypeNotBetween(String value1, String value2) {
            addCriterion("shenfentype not between", value1, value2, "shenfentype");
            return (Criteria) this;
        }

        public Criteria andSschengduIsNull() {
            addCriterion("sschengdu is null");
            return (Criteria) this;
        }

        public Criteria andSschengduIsNotNull() {
            addCriterion("sschengdu is not null");
            return (Criteria) this;
        }

        public Criteria andSschengduEqualTo(String value) {
            addCriterion("sschengdu =", value, "sschengdu");
            return (Criteria) this;
        }

        public Criteria andSschengduNotEqualTo(String value) {
            addCriterion("sschengdu <>", value, "sschengdu");
            return (Criteria) this;
        }

        public Criteria andSschengduGreaterThan(String value) {
            addCriterion("sschengdu >", value, "sschengdu");
            return (Criteria) this;
        }

        public Criteria andSschengduGreaterThanOrEqualTo(String value) {
            addCriterion("sschengdu >=", value, "sschengdu");
            return (Criteria) this;
        }

        public Criteria andSschengduLessThan(String value) {
            addCriterion("sschengdu <", value, "sschengdu");
            return (Criteria) this;
        }

        public Criteria andSschengduLessThanOrEqualTo(String value) {
            addCriterion("sschengdu <=", value, "sschengdu");
            return (Criteria) this;
        }

        public Criteria andSschengduLike(String value) {
            addCriterion("sschengdu like", value, "sschengdu");
            return (Criteria) this;
        }

        public Criteria andSschengduNotLike(String value) {
            addCriterion("sschengdu not like", value, "sschengdu");
            return (Criteria) this;
        }

        public Criteria andSschengduIn(List<String> values) {
            addCriterion("sschengdu in", values, "sschengdu");
            return (Criteria) this;
        }

        public Criteria andSschengduNotIn(List<String> values) {
            addCriterion("sschengdu not in", values, "sschengdu");
            return (Criteria) this;
        }

        public Criteria andSschengduBetween(String value1, String value2) {
            addCriterion("sschengdu between", value1, value2, "sschengdu");
            return (Criteria) this;
        }

        public Criteria andSschengduNotBetween(String value1, String value2) {
            addCriterion("sschengdu not between", value1, value2, "sschengdu");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongIsNull() {
            addCriterion("tuokuishiyong is null");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongIsNotNull() {
            addCriterion("tuokuishiyong is not null");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongEqualTo(String value) {
            addCriterion("tuokuishiyong =", value, "tuokuishiyong");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongNotEqualTo(String value) {
            addCriterion("tuokuishiyong <>", value, "tuokuishiyong");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongGreaterThan(String value) {
            addCriterion("tuokuishiyong >", value, "tuokuishiyong");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongGreaterThanOrEqualTo(String value) {
            addCriterion("tuokuishiyong >=", value, "tuokuishiyong");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongLessThan(String value) {
            addCriterion("tuokuishiyong <", value, "tuokuishiyong");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongLessThanOrEqualTo(String value) {
            addCriterion("tuokuishiyong <=", value, "tuokuishiyong");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongLike(String value) {
            addCriterion("tuokuishiyong like", value, "tuokuishiyong");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongNotLike(String value) {
            addCriterion("tuokuishiyong not like", value, "tuokuishiyong");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongIn(List<String> values) {
            addCriterion("tuokuishiyong in", values, "tuokuishiyong");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongNotIn(List<String> values) {
            addCriterion("tuokuishiyong not in", values, "tuokuishiyong");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongBetween(String value1, String value2) {
            addCriterion("tuokuishiyong between", value1, value2, "tuokuishiyong");
            return (Criteria) this;
        }

        public Criteria andTuokuishiyongNotBetween(String value1, String value2) {
            addCriterion("tuokuishiyong not between", value1, value2, "tuokuishiyong");
            return (Criteria) this;
        }

        public Criteria andXingbieIsNull() {
            addCriterion("xingbie is null");
            return (Criteria) this;
        }

        public Criteria andXingbieIsNotNull() {
            addCriterion("xingbie is not null");
            return (Criteria) this;
        }

        public Criteria andXingbieEqualTo(String value) {
            addCriterion("xingbie =", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotEqualTo(String value) {
            addCriterion("xingbie <>", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieGreaterThan(String value) {
            addCriterion("xingbie >", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieGreaterThanOrEqualTo(String value) {
            addCriterion("xingbie >=", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieLessThan(String value) {
            addCriterion("xingbie <", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieLessThanOrEqualTo(String value) {
            addCriterion("xingbie <=", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieLike(String value) {
            addCriterion("xingbie like", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotLike(String value) {
            addCriterion("xingbie not like", value, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieIn(List<String> values) {
            addCriterion("xingbie in", values, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotIn(List<String> values) {
            addCriterion("xingbie not in", values, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieBetween(String value1, String value2) {
            addCriterion("xingbie between", value1, value2, "xingbie");
            return (Criteria) this;
        }

        public Criteria andXingbieNotBetween(String value1, String value2) {
            addCriterion("xingbie not between", value1, value2, "xingbie");
            return (Criteria) this;
        }

        public Criteria andYinjiuIsNull() {
            addCriterion("yinjiu is null");
            return (Criteria) this;
        }

        public Criteria andYinjiuIsNotNull() {
            addCriterion("yinjiu is not null");
            return (Criteria) this;
        }

        public Criteria andYinjiuEqualTo(String value) {
            addCriterion("yinjiu =", value, "yinjiu");
            return (Criteria) this;
        }

        public Criteria andYinjiuNotEqualTo(String value) {
            addCriterion("yinjiu <>", value, "yinjiu");
            return (Criteria) this;
        }

        public Criteria andYinjiuGreaterThan(String value) {
            addCriterion("yinjiu >", value, "yinjiu");
            return (Criteria) this;
        }

        public Criteria andYinjiuGreaterThanOrEqualTo(String value) {
            addCriterion("yinjiu >=", value, "yinjiu");
            return (Criteria) this;
        }

        public Criteria andYinjiuLessThan(String value) {
            addCriterion("yinjiu <", value, "yinjiu");
            return (Criteria) this;
        }

        public Criteria andYinjiuLessThanOrEqualTo(String value) {
            addCriterion("yinjiu <=", value, "yinjiu");
            return (Criteria) this;
        }

        public Criteria andYinjiuLike(String value) {
            addCriterion("yinjiu like", value, "yinjiu");
            return (Criteria) this;
        }

        public Criteria andYinjiuNotLike(String value) {
            addCriterion("yinjiu not like", value, "yinjiu");
            return (Criteria) this;
        }

        public Criteria andYinjiuIn(List<String> values) {
            addCriterion("yinjiu in", values, "yinjiu");
            return (Criteria) this;
        }

        public Criteria andYinjiuNotIn(List<String> values) {
            addCriterion("yinjiu not in", values, "yinjiu");
            return (Criteria) this;
        }

        public Criteria andYinjiuBetween(String value1, String value2) {
            addCriterion("yinjiu between", value1, value2, "yinjiu");
            return (Criteria) this;
        }

        public Criteria andYinjiuNotBetween(String value1, String value2) {
            addCriterion("yinjiu not between", value1, value2, "yinjiu");
            return (Criteria) this;
        }

        public Criteria andYsxitongIsNull() {
            addCriterion("ysxitong is null");
            return (Criteria) this;
        }

        public Criteria andYsxitongIsNotNull() {
            addCriterion("ysxitong is not null");
            return (Criteria) this;
        }

        public Criteria andYsxitongEqualTo(String value) {
            addCriterion("ysxitong =", value, "ysxitong");
            return (Criteria) this;
        }

        public Criteria andYsxitongNotEqualTo(String value) {
            addCriterion("ysxitong <>", value, "ysxitong");
            return (Criteria) this;
        }

        public Criteria andYsxitongGreaterThan(String value) {
            addCriterion("ysxitong >", value, "ysxitong");
            return (Criteria) this;
        }

        public Criteria andYsxitongGreaterThanOrEqualTo(String value) {
            addCriterion("ysxitong >=", value, "ysxitong");
            return (Criteria) this;
        }

        public Criteria andYsxitongLessThan(String value) {
            addCriterion("ysxitong <", value, "ysxitong");
            return (Criteria) this;
        }

        public Criteria andYsxitongLessThanOrEqualTo(String value) {
            addCriterion("ysxitong <=", value, "ysxitong");
            return (Criteria) this;
        }

        public Criteria andYsxitongLike(String value) {
            addCriterion("ysxitong like", value, "ysxitong");
            return (Criteria) this;
        }

        public Criteria andYsxitongNotLike(String value) {
            addCriterion("ysxitong not like", value, "ysxitong");
            return (Criteria) this;
        }

        public Criteria andYsxitongIn(List<String> values) {
            addCriterion("ysxitong in", values, "ysxitong");
            return (Criteria) this;
        }

        public Criteria andYsxitongNotIn(List<String> values) {
            addCriterion("ysxitong not in", values, "ysxitong");
            return (Criteria) this;
        }

        public Criteria andYsxitongBetween(String value1, String value2) {
            addCriterion("ysxitong between", value1, value2, "ysxitong");
            return (Criteria) this;
        }

        public Criteria andYsxitongNotBetween(String value1, String value2) {
            addCriterion("ysxitong not between", value1, value2, "ysxitong");
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
package com.qf.j1902.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OperatuserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OperatuserExample() {
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

        public Criteria andUnameIsNull() {
            addCriterion("uname is null");
            return (Criteria) this;
        }

        public Criteria andUnameIsNotNull() {
            addCriterion("uname is not null");
            return (Criteria) this;
        }

        public Criteria andUnameEqualTo(String value) {
            addCriterion("uname =", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotEqualTo(String value) {
            addCriterion("uname <>", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThan(String value) {
            addCriterion("uname >", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameGreaterThanOrEqualTo(String value) {
            addCriterion("uname >=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThan(String value) {
            addCriterion("uname <", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLessThanOrEqualTo(String value) {
            addCriterion("uname <=", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameLike(String value) {
            addCriterion("uname like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotLike(String value) {
            addCriterion("uname not like", value, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameIn(List<String> values) {
            addCriterion("uname in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotIn(List<String> values) {
            addCriterion("uname not in", values, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameBetween(String value1, String value2) {
            addCriterion("uname between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andUnameNotBetween(String value1, String value2) {
            addCriterion("uname not between", value1, value2, "uname");
            return (Criteria) this;
        }

        public Criteria andOperatimeIsNull() {
            addCriterion("operaTime is null");
            return (Criteria) this;
        }

        public Criteria andOperatimeIsNotNull() {
            addCriterion("operaTime is not null");
            return (Criteria) this;
        }

        public Criteria andOperatimeEqualTo(Date value) {
            addCriterion("operaTime =", value, "operatime");
            return (Criteria) this;
        }

        public Criteria andOperatimeNotEqualTo(Date value) {
            addCriterion("operaTime <>", value, "operatime");
            return (Criteria) this;
        }

        public Criteria andOperatimeGreaterThan(Date value) {
            addCriterion("operaTime >", value, "operatime");
            return (Criteria) this;
        }

        public Criteria andOperatimeGreaterThanOrEqualTo(Date value) {
            addCriterion("operaTime >=", value, "operatime");
            return (Criteria) this;
        }

        public Criteria andOperatimeLessThan(Date value) {
            addCriterion("operaTime <", value, "operatime");
            return (Criteria) this;
        }

        public Criteria andOperatimeLessThanOrEqualTo(Date value) {
            addCriterion("operaTime <=", value, "operatime");
            return (Criteria) this;
        }

        public Criteria andOperatimeIn(List<Date> values) {
            addCriterion("operaTime in", values, "operatime");
            return (Criteria) this;
        }

        public Criteria andOperatimeNotIn(List<Date> values) {
            addCriterion("operaTime not in", values, "operatime");
            return (Criteria) this;
        }

        public Criteria andOperatimeBetween(Date value1, Date value2) {
            addCriterion("operaTime between", value1, value2, "operatime");
            return (Criteria) this;
        }

        public Criteria andOperatimeNotBetween(Date value1, Date value2) {
            addCriterion("operaTime not between", value1, value2, "operatime");
            return (Criteria) this;
        }

        public Criteria andOpratipIsNull() {
            addCriterion("opratIp is null");
            return (Criteria) this;
        }

        public Criteria andOpratipIsNotNull() {
            addCriterion("opratIp is not null");
            return (Criteria) this;
        }

        public Criteria andOpratipEqualTo(String value) {
            addCriterion("opratIp =", value, "opratip");
            return (Criteria) this;
        }

        public Criteria andOpratipNotEqualTo(String value) {
            addCriterion("opratIp <>", value, "opratip");
            return (Criteria) this;
        }

        public Criteria andOpratipGreaterThan(String value) {
            addCriterion("opratIp >", value, "opratip");
            return (Criteria) this;
        }

        public Criteria andOpratipGreaterThanOrEqualTo(String value) {
            addCriterion("opratIp >=", value, "opratip");
            return (Criteria) this;
        }

        public Criteria andOpratipLessThan(String value) {
            addCriterion("opratIp <", value, "opratip");
            return (Criteria) this;
        }

        public Criteria andOpratipLessThanOrEqualTo(String value) {
            addCriterion("opratIp <=", value, "opratip");
            return (Criteria) this;
        }

        public Criteria andOpratipLike(String value) {
            addCriterion("opratIp like", value, "opratip");
            return (Criteria) this;
        }

        public Criteria andOpratipNotLike(String value) {
            addCriterion("opratIp not like", value, "opratip");
            return (Criteria) this;
        }

        public Criteria andOpratipIn(List<String> values) {
            addCriterion("opratIp in", values, "opratip");
            return (Criteria) this;
        }

        public Criteria andOpratipNotIn(List<String> values) {
            addCriterion("opratIp not in", values, "opratip");
            return (Criteria) this;
        }

        public Criteria andOpratipBetween(String value1, String value2) {
            addCriterion("opratIp between", value1, value2, "opratip");
            return (Criteria) this;
        }

        public Criteria andOpratipNotBetween(String value1, String value2) {
            addCriterion("opratIp not between", value1, value2, "opratip");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNull() {
            addCriterion("sendTime is null");
            return (Criteria) this;
        }

        public Criteria andSendtimeIsNotNull() {
            addCriterion("sendTime is not null");
            return (Criteria) this;
        }

        public Criteria andSendtimeEqualTo(Date value) {
            addCriterion("sendTime =", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotEqualTo(Date value) {
            addCriterion("sendTime <>", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThan(Date value) {
            addCriterion("sendTime >", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sendTime >=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThan(Date value) {
            addCriterion("sendTime <", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeLessThanOrEqualTo(Date value) {
            addCriterion("sendTime <=", value, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeIn(List<Date> values) {
            addCriterion("sendTime in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotIn(List<Date> values) {
            addCriterion("sendTime not in", values, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeBetween(Date value1, Date value2) {
            addCriterion("sendTime between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andSendtimeNotBetween(Date value1, Date value2) {
            addCriterion("sendTime not between", value1, value2, "sendtime");
            return (Criteria) this;
        }

        public Criteria andUtitleIsNull() {
            addCriterion("utitle is null");
            return (Criteria) this;
        }

        public Criteria andUtitleIsNotNull() {
            addCriterion("utitle is not null");
            return (Criteria) this;
        }

        public Criteria andUtitleEqualTo(String value) {
            addCriterion("utitle =", value, "utitle");
            return (Criteria) this;
        }

        public Criteria andUtitleNotEqualTo(String value) {
            addCriterion("utitle <>", value, "utitle");
            return (Criteria) this;
        }

        public Criteria andUtitleGreaterThan(String value) {
            addCriterion("utitle >", value, "utitle");
            return (Criteria) this;
        }

        public Criteria andUtitleGreaterThanOrEqualTo(String value) {
            addCriterion("utitle >=", value, "utitle");
            return (Criteria) this;
        }

        public Criteria andUtitleLessThan(String value) {
            addCriterion("utitle <", value, "utitle");
            return (Criteria) this;
        }

        public Criteria andUtitleLessThanOrEqualTo(String value) {
            addCriterion("utitle <=", value, "utitle");
            return (Criteria) this;
        }

        public Criteria andUtitleLike(String value) {
            addCriterion("utitle like", value, "utitle");
            return (Criteria) this;
        }

        public Criteria andUtitleNotLike(String value) {
            addCriterion("utitle not like", value, "utitle");
            return (Criteria) this;
        }

        public Criteria andUtitleIn(List<String> values) {
            addCriterion("utitle in", values, "utitle");
            return (Criteria) this;
        }

        public Criteria andUtitleNotIn(List<String> values) {
            addCriterion("utitle not in", values, "utitle");
            return (Criteria) this;
        }

        public Criteria andUtitleBetween(String value1, String value2) {
            addCriterion("utitle between", value1, value2, "utitle");
            return (Criteria) this;
        }

        public Criteria andUtitleNotBetween(String value1, String value2) {
            addCriterion("utitle not between", value1, value2, "utitle");
            return (Criteria) this;
        }

        public Criteria andUtextIsNull() {
            addCriterion("utext is null");
            return (Criteria) this;
        }

        public Criteria andUtextIsNotNull() {
            addCriterion("utext is not null");
            return (Criteria) this;
        }

        public Criteria andUtextEqualTo(String value) {
            addCriterion("utext =", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextNotEqualTo(String value) {
            addCriterion("utext <>", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextGreaterThan(String value) {
            addCriterion("utext >", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextGreaterThanOrEqualTo(String value) {
            addCriterion("utext >=", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextLessThan(String value) {
            addCriterion("utext <", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextLessThanOrEqualTo(String value) {
            addCriterion("utext <=", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextLike(String value) {
            addCriterion("utext like", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextNotLike(String value) {
            addCriterion("utext not like", value, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextIn(List<String> values) {
            addCriterion("utext in", values, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextNotIn(List<String> values) {
            addCriterion("utext not in", values, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextBetween(String value1, String value2) {
            addCriterion("utext between", value1, value2, "utext");
            return (Criteria) this;
        }

        public Criteria andUtextNotBetween(String value1, String value2) {
            addCriterion("utext not between", value1, value2, "utext");
            return (Criteria) this;
        }

        public Criteria andLinkageIsNull() {
            addCriterion("linkage is null");
            return (Criteria) this;
        }

        public Criteria andLinkageIsNotNull() {
            addCriterion("linkage is not null");
            return (Criteria) this;
        }

        public Criteria andLinkageEqualTo(String value) {
            addCriterion("linkage =", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageNotEqualTo(String value) {
            addCriterion("linkage <>", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageGreaterThan(String value) {
            addCriterion("linkage >", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageGreaterThanOrEqualTo(String value) {
            addCriterion("linkage >=", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageLessThan(String value) {
            addCriterion("linkage <", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageLessThanOrEqualTo(String value) {
            addCriterion("linkage <=", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageLike(String value) {
            addCriterion("linkage like", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageNotLike(String value) {
            addCriterion("linkage not like", value, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageIn(List<String> values) {
            addCriterion("linkage in", values, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageNotIn(List<String> values) {
            addCriterion("linkage not in", values, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageBetween(String value1, String value2) {
            addCriterion("linkage between", value1, value2, "linkage");
            return (Criteria) this;
        }

        public Criteria andLinkageNotBetween(String value1, String value2) {
            addCriterion("linkage not between", value1, value2, "linkage");
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
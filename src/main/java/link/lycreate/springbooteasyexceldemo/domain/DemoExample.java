package link.lycreate.springbooteasyexceldemo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DemoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public DemoExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andDemoIdIsNull() {
            addCriterion("demo_id is null");
            return (Criteria) this;
        }

        public Criteria andDemoIdIsNotNull() {
            addCriterion("demo_id is not null");
            return (Criteria) this;
        }

        public Criteria andDemoIdEqualTo(Integer value) {
            addCriterion("demo_id =", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdNotEqualTo(Integer value) {
            addCriterion("demo_id <>", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdGreaterThan(Integer value) {
            addCriterion("demo_id >", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("demo_id >=", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdLessThan(Integer value) {
            addCriterion("demo_id <", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdLessThanOrEqualTo(Integer value) {
            addCriterion("demo_id <=", value, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdIn(List<Integer> values) {
            addCriterion("demo_id in", values, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdNotIn(List<Integer> values) {
            addCriterion("demo_id not in", values, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdBetween(Integer value1, Integer value2) {
            addCriterion("demo_id between", value1, value2, "demoId");
            return (Criteria) this;
        }

        public Criteria andDemoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("demo_id not between", value1, value2, "demoId");
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

        public Criteria andDemoDataIsNull() {
            addCriterion("demo_data is null");
            return (Criteria) this;
        }

        public Criteria andDemoDataIsNotNull() {
            addCriterion("demo_data is not null");
            return (Criteria) this;
        }

        public Criteria andDemoDataEqualTo(Date value) {
            addCriterionForJDBCDate("demo_data =", value, "demoData");
            return (Criteria) this;
        }

        public Criteria andDemoDataNotEqualTo(Date value) {
            addCriterionForJDBCDate("demo_data <>", value, "demoData");
            return (Criteria) this;
        }

        public Criteria andDemoDataGreaterThan(Date value) {
            addCriterionForJDBCDate("demo_data >", value, "demoData");
            return (Criteria) this;
        }

        public Criteria andDemoDataGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("demo_data >=", value, "demoData");
            return (Criteria) this;
        }

        public Criteria andDemoDataLessThan(Date value) {
            addCriterionForJDBCDate("demo_data <", value, "demoData");
            return (Criteria) this;
        }

        public Criteria andDemoDataLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("demo_data <=", value, "demoData");
            return (Criteria) this;
        }

        public Criteria andDemoDataIn(List<Date> values) {
            addCriterionForJDBCDate("demo_data in", values, "demoData");
            return (Criteria) this;
        }

        public Criteria andDemoDataNotIn(List<Date> values) {
            addCriterionForJDBCDate("demo_data not in", values, "demoData");
            return (Criteria) this;
        }

        public Criteria andDemoDataBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("demo_data between", value1, value2, "demoData");
            return (Criteria) this;
        }

        public Criteria andDemoDataNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("demo_data not between", value1, value2, "demoData");
            return (Criteria) this;
        }

        public Criteria andDataNumIsNull() {
            addCriterion("data_num is null");
            return (Criteria) this;
        }

        public Criteria andDataNumIsNotNull() {
            addCriterion("data_num is not null");
            return (Criteria) this;
        }

        public Criteria andDataNumEqualTo(Integer value) {
            addCriterion("data_num =", value, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumNotEqualTo(Integer value) {
            addCriterion("data_num <>", value, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumGreaterThan(Integer value) {
            addCriterion("data_num >", value, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("data_num >=", value, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumLessThan(Integer value) {
            addCriterion("data_num <", value, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumLessThanOrEqualTo(Integer value) {
            addCriterion("data_num <=", value, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumIn(List<Integer> values) {
            addCriterion("data_num in", values, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumNotIn(List<Integer> values) {
            addCriterion("data_num not in", values, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumBetween(Integer value1, Integer value2) {
            addCriterion("data_num between", value1, value2, "dataNum");
            return (Criteria) this;
        }

        public Criteria andDataNumNotBetween(Integer value1, Integer value2) {
            addCriterion("data_num not between", value1, value2, "dataNum");
            return (Criteria) this;
        }
    }

    /**
     */
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
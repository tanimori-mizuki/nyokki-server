package com.example.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class DailyReportsExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    public DailyReportsExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
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

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andTodayReportIsNull() {
            addCriterion("today_report is null");
            return (Criteria) this;
        }

        public Criteria andTodayReportIsNotNull() {
            addCriterion("today_report is not null");
            return (Criteria) this;
        }

        public Criteria andTodayReportEqualTo(String value) {
            addCriterion("today_report =", value, "todayReport");
            return (Criteria) this;
        }

        public Criteria andTodayReportNotEqualTo(String value) {
            addCriterion("today_report <>", value, "todayReport");
            return (Criteria) this;
        }

        public Criteria andTodayReportGreaterThan(String value) {
            addCriterion("today_report >", value, "todayReport");
            return (Criteria) this;
        }

        public Criteria andTodayReportGreaterThanOrEqualTo(String value) {
            addCriterion("today_report >=", value, "todayReport");
            return (Criteria) this;
        }

        public Criteria andTodayReportLessThan(String value) {
            addCriterion("today_report <", value, "todayReport");
            return (Criteria) this;
        }

        public Criteria andTodayReportLessThanOrEqualTo(String value) {
            addCriterion("today_report <=", value, "todayReport");
            return (Criteria) this;
        }

        public Criteria andTodayReportLike(String value) {
            addCriterion("today_report like", value, "todayReport");
            return (Criteria) this;
        }

        public Criteria andTodayReportNotLike(String value) {
            addCriterion("today_report not like", value, "todayReport");
            return (Criteria) this;
        }

        public Criteria andTodayReportIn(List<String> values) {
            addCriterion("today_report in", values, "todayReport");
            return (Criteria) this;
        }

        public Criteria andTodayReportNotIn(List<String> values) {
            addCriterion("today_report not in", values, "todayReport");
            return (Criteria) this;
        }

        public Criteria andTodayReportBetween(String value1, String value2) {
            addCriterion("today_report between", value1, value2, "todayReport");
            return (Criteria) this;
        }

        public Criteria andTodayReportNotBetween(String value1, String value2) {
            addCriterion("today_report not between", value1, value2, "todayReport");
            return (Criteria) this;
        }

        public Criteria andLevelAchievementlevelAchievementIsNull() {
            addCriterion("level_achievementlevel_achievement is null");
            return (Criteria) this;
        }

        public Criteria andLevelAchievementlevelAchievementIsNotNull() {
            addCriterion("level_achievementlevel_achievement is not null");
            return (Criteria) this;
        }

        public Criteria andLevelAchievementlevelAchievementEqualTo(Integer value) {
            addCriterion("level_achievementlevel_achievement =", value, "levelAchievementlevelAchievement");
            return (Criteria) this;
        }

        public Criteria andLevelAchievementlevelAchievementNotEqualTo(Integer value) {
            addCriterion("level_achievementlevel_achievement <>", value, "levelAchievementlevelAchievement");
            return (Criteria) this;
        }

        public Criteria andLevelAchievementlevelAchievementGreaterThan(Integer value) {
            addCriterion("level_achievementlevel_achievement >", value, "levelAchievementlevelAchievement");
            return (Criteria) this;
        }

        public Criteria andLevelAchievementlevelAchievementGreaterThanOrEqualTo(Integer value) {
            addCriterion("level_achievementlevel_achievement >=", value, "levelAchievementlevelAchievement");
            return (Criteria) this;
        }

        public Criteria andLevelAchievementlevelAchievementLessThan(Integer value) {
            addCriterion("level_achievementlevel_achievement <", value, "levelAchievementlevelAchievement");
            return (Criteria) this;
        }

        public Criteria andLevelAchievementlevelAchievementLessThanOrEqualTo(Integer value) {
            addCriterion("level_achievementlevel_achievement <=", value, "levelAchievementlevelAchievement");
            return (Criteria) this;
        }

        public Criteria andLevelAchievementlevelAchievementIn(List<Integer> values) {
            addCriterion("level_achievementlevel_achievement in", values, "levelAchievementlevelAchievement");
            return (Criteria) this;
        }

        public Criteria andLevelAchievementlevelAchievementNotIn(List<Integer> values) {
            addCriterion("level_achievementlevel_achievement not in", values, "levelAchievementlevelAchievement");
            return (Criteria) this;
        }

        public Criteria andLevelAchievementlevelAchievementBetween(Integer value1, Integer value2) {
            addCriterion("level_achievementlevel_achievement between", value1, value2, "levelAchievementlevelAchievement");
            return (Criteria) this;
        }

        public Criteria andLevelAchievementlevelAchievementNotBetween(Integer value1, Integer value2) {
            addCriterion("level_achievementlevel_achievement not between", value1, value2, "levelAchievementlevelAchievement");
            return (Criteria) this;
        }

        public Criteria andImpressionsIsNull() {
            addCriterion("impressions is null");
            return (Criteria) this;
        }

        public Criteria andImpressionsIsNotNull() {
            addCriterion("impressions is not null");
            return (Criteria) this;
        }

        public Criteria andImpressionsEqualTo(String value) {
            addCriterion("impressions =", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsNotEqualTo(String value) {
            addCriterion("impressions <>", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsGreaterThan(String value) {
            addCriterion("impressions >", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsGreaterThanOrEqualTo(String value) {
            addCriterion("impressions >=", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsLessThan(String value) {
            addCriterion("impressions <", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsLessThanOrEqualTo(String value) {
            addCriterion("impressions <=", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsLike(String value) {
            addCriterion("impressions like", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsNotLike(String value) {
            addCriterion("impressions not like", value, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsIn(List<String> values) {
            addCriterion("impressions in", values, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsNotIn(List<String> values) {
            addCriterion("impressions not in", values, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsBetween(String value1, String value2) {
            addCriterion("impressions between", value1, value2, "impressions");
            return (Criteria) this;
        }

        public Criteria andImpressionsNotBetween(String value1, String value2) {
            addCriterion("impressions not between", value1, value2, "impressions");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateIsNull() {
            addCriterion("registration_date is null");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateIsNotNull() {
            addCriterion("registration_date is not null");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateEqualTo(Date value) {
            addCriterionForJDBCDate("registration_date =", value, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("registration_date <>", value, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateGreaterThan(Date value) {
            addCriterionForJDBCDate("registration_date >", value, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("registration_date >=", value, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateLessThan(Date value) {
            addCriterionForJDBCDate("registration_date <", value, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("registration_date <=", value, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateIn(List<Date> values) {
            addCriterionForJDBCDate("registration_date in", values, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("registration_date not in", values, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("registration_date between", value1, value2, "registrationDate");
            return (Criteria) this;
        }

        public Criteria andRegistrationDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("registration_date not between", value1, value2, "registrationDate");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table daily_reports
     *
     * @mbggenerated do_not_delete_during_merge Tue Dec 01 15:39:47 JST 2020
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table daily_reports
     *
     * @mbggenerated Tue Dec 01 15:39:47 JST 2020
     */
    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

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

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value) {
            super();
            this.condition = condition;
            this.value = value;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.betweenValue = true;
        }
    }
}
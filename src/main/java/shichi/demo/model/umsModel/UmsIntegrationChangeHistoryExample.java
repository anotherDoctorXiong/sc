package shichi.demo.model.umsModel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UmsIntegrationChangeHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UmsIntegrationChangeHistoryExample() {
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

        public Criteria andChangeIdIsNull() {
            addCriterion("change_id is null");
            return (Criteria) this;
        }

        public Criteria andChangeIdIsNotNull() {
            addCriterion("change_id is not null");
            return (Criteria) this;
        }

        public Criteria andChangeIdEqualTo(String value) {
            addCriterion("change_id =", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdNotEqualTo(String value) {
            addCriterion("change_id <>", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdGreaterThan(String value) {
            addCriterion("change_id >", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdGreaterThanOrEqualTo(String value) {
            addCriterion("change_id >=", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdLessThan(String value) {
            addCriterion("change_id <", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdLessThanOrEqualTo(String value) {
            addCriterion("change_id <=", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdLike(String value) {
            addCriterion("change_id like", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdNotLike(String value) {
            addCriterion("change_id not like", value, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdIn(List<String> values) {
            addCriterion("change_id in", values, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdNotIn(List<String> values) {
            addCriterion("change_id not in", values, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdBetween(String value1, String value2) {
            addCriterion("change_id between", value1, value2, "changeId");
            return (Criteria) this;
        }

        public Criteria andChangeIdNotBetween(String value1, String value2) {
            addCriterion("change_id not between", value1, value2, "changeId");
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

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNull() {
            addCriterion("activity_id is null");
            return (Criteria) this;
        }

        public Criteria andActivityIdIsNotNull() {
            addCriterion("activity_id is not null");
            return (Criteria) this;
        }

        public Criteria andActivityIdEqualTo(String value) {
            addCriterion("activity_id =", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotEqualTo(String value) {
            addCriterion("activity_id <>", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThan(String value) {
            addCriterion("activity_id >", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdGreaterThanOrEqualTo(String value) {
            addCriterion("activity_id >=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThan(String value) {
            addCriterion("activity_id <", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLessThanOrEqualTo(String value) {
            addCriterion("activity_id <=", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdLike(String value) {
            addCriterion("activity_id like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotLike(String value) {
            addCriterion("activity_id not like", value, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdIn(List<String> values) {
            addCriterion("activity_id in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotIn(List<String> values) {
            addCriterion("activity_id not in", values, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdBetween(String value1, String value2) {
            addCriterion("activity_id between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andActivityIdNotBetween(String value1, String value2) {
            addCriterion("activity_id not between", value1, value2, "activityId");
            return (Criteria) this;
        }

        public Criteria andBeforeChangedCountIsNull() {
            addCriterion("before_changed_count is null");
            return (Criteria) this;
        }

        public Criteria andBeforeChangedCountIsNotNull() {
            addCriterion("before_changed_count is not null");
            return (Criteria) this;
        }

        public Criteria andBeforeChangedCountEqualTo(Integer value) {
            addCriterion("before_changed_count =", value, "beforeChangedCount");
            return (Criteria) this;
        }

        public Criteria andBeforeChangedCountNotEqualTo(Integer value) {
            addCriterion("before_changed_count <>", value, "beforeChangedCount");
            return (Criteria) this;
        }

        public Criteria andBeforeChangedCountGreaterThan(Integer value) {
            addCriterion("before_changed_count >", value, "beforeChangedCount");
            return (Criteria) this;
        }

        public Criteria andBeforeChangedCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("before_changed_count >=", value, "beforeChangedCount");
            return (Criteria) this;
        }

        public Criteria andBeforeChangedCountLessThan(Integer value) {
            addCriterion("before_changed_count <", value, "beforeChangedCount");
            return (Criteria) this;
        }

        public Criteria andBeforeChangedCountLessThanOrEqualTo(Integer value) {
            addCriterion("before_changed_count <=", value, "beforeChangedCount");
            return (Criteria) this;
        }

        public Criteria andBeforeChangedCountIn(List<Integer> values) {
            addCriterion("before_changed_count in", values, "beforeChangedCount");
            return (Criteria) this;
        }

        public Criteria andBeforeChangedCountNotIn(List<Integer> values) {
            addCriterion("before_changed_count not in", values, "beforeChangedCount");
            return (Criteria) this;
        }

        public Criteria andBeforeChangedCountBetween(Integer value1, Integer value2) {
            addCriterion("before_changed_count between", value1, value2, "beforeChangedCount");
            return (Criteria) this;
        }

        public Criteria andBeforeChangedCountNotBetween(Integer value1, Integer value2) {
            addCriterion("before_changed_count not between", value1, value2, "beforeChangedCount");
            return (Criteria) this;
        }

        public Criteria andChangedCountIsNull() {
            addCriterion("changed_count is null");
            return (Criteria) this;
        }

        public Criteria andChangedCountIsNotNull() {
            addCriterion("changed_count is not null");
            return (Criteria) this;
        }

        public Criteria andChangedCountEqualTo(Integer value) {
            addCriterion("changed_count =", value, "changedCount");
            return (Criteria) this;
        }

        public Criteria andChangedCountNotEqualTo(Integer value) {
            addCriterion("changed_count <>", value, "changedCount");
            return (Criteria) this;
        }

        public Criteria andChangedCountGreaterThan(Integer value) {
            addCriterion("changed_count >", value, "changedCount");
            return (Criteria) this;
        }

        public Criteria andChangedCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("changed_count >=", value, "changedCount");
            return (Criteria) this;
        }

        public Criteria andChangedCountLessThan(Integer value) {
            addCriterion("changed_count <", value, "changedCount");
            return (Criteria) this;
        }

        public Criteria andChangedCountLessThanOrEqualTo(Integer value) {
            addCriterion("changed_count <=", value, "changedCount");
            return (Criteria) this;
        }

        public Criteria andChangedCountIn(List<Integer> values) {
            addCriterion("changed_count in", values, "changedCount");
            return (Criteria) this;
        }

        public Criteria andChangedCountNotIn(List<Integer> values) {
            addCriterion("changed_count not in", values, "changedCount");
            return (Criteria) this;
        }

        public Criteria andChangedCountBetween(Integer value1, Integer value2) {
            addCriterion("changed_count between", value1, value2, "changedCount");
            return (Criteria) this;
        }

        public Criteria andChangedCountNotBetween(Integer value1, Integer value2) {
            addCriterion("changed_count not between", value1, value2, "changedCount");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNull() {
            addCriterion("admin_id is null");
            return (Criteria) this;
        }

        public Criteria andAdminIdIsNotNull() {
            addCriterion("admin_id is not null");
            return (Criteria) this;
        }

        public Criteria andAdminIdEqualTo(String value) {
            addCriterion("admin_id =", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotEqualTo(String value) {
            addCriterion("admin_id <>", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThan(String value) {
            addCriterion("admin_id >", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdGreaterThanOrEqualTo(String value) {
            addCriterion("admin_id >=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThan(String value) {
            addCriterion("admin_id <", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLessThanOrEqualTo(String value) {
            addCriterion("admin_id <=", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdLike(String value) {
            addCriterion("admin_id like", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotLike(String value) {
            addCriterion("admin_id not like", value, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdIn(List<String> values) {
            addCriterion("admin_id in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotIn(List<String> values) {
            addCriterion("admin_id not in", values, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdBetween(String value1, String value2) {
            addCriterion("admin_id between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andAdminIdNotBetween(String value1, String value2) {
            addCriterion("admin_id not between", value1, value2, "adminId");
            return (Criteria) this;
        }

        public Criteria andOperateNoteIsNull() {
            addCriterion("operate_note is null");
            return (Criteria) this;
        }

        public Criteria andOperateNoteIsNotNull() {
            addCriterion("operate_note is not null");
            return (Criteria) this;
        }

        public Criteria andOperateNoteEqualTo(String value) {
            addCriterion("operate_note =", value, "operateNote");
            return (Criteria) this;
        }

        public Criteria andOperateNoteNotEqualTo(String value) {
            addCriterion("operate_note <>", value, "operateNote");
            return (Criteria) this;
        }

        public Criteria andOperateNoteGreaterThan(String value) {
            addCriterion("operate_note >", value, "operateNote");
            return (Criteria) this;
        }

        public Criteria andOperateNoteGreaterThanOrEqualTo(String value) {
            addCriterion("operate_note >=", value, "operateNote");
            return (Criteria) this;
        }

        public Criteria andOperateNoteLessThan(String value) {
            addCriterion("operate_note <", value, "operateNote");
            return (Criteria) this;
        }

        public Criteria andOperateNoteLessThanOrEqualTo(String value) {
            addCriterion("operate_note <=", value, "operateNote");
            return (Criteria) this;
        }

        public Criteria andOperateNoteLike(String value) {
            addCriterion("operate_note like", value, "operateNote");
            return (Criteria) this;
        }

        public Criteria andOperateNoteNotLike(String value) {
            addCriterion("operate_note not like", value, "operateNote");
            return (Criteria) this;
        }

        public Criteria andOperateNoteIn(List<String> values) {
            addCriterion("operate_note in", values, "operateNote");
            return (Criteria) this;
        }

        public Criteria andOperateNoteNotIn(List<String> values) {
            addCriterion("operate_note not in", values, "operateNote");
            return (Criteria) this;
        }

        public Criteria andOperateNoteBetween(String value1, String value2) {
            addCriterion("operate_note between", value1, value2, "operateNote");
            return (Criteria) this;
        }

        public Criteria andOperateNoteNotBetween(String value1, String value2) {
            addCriterion("operate_note not between", value1, value2, "operateNote");
            return (Criteria) this;
        }

        public Criteria andDataStateIsNull() {
            addCriterion("data_state is null");
            return (Criteria) this;
        }

        public Criteria andDataStateIsNotNull() {
            addCriterion("data_state is not null");
            return (Criteria) this;
        }

        public Criteria andDataStateEqualTo(Boolean value) {
            addCriterion("data_state =", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotEqualTo(Boolean value) {
            addCriterion("data_state <>", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateGreaterThan(Boolean value) {
            addCriterion("data_state >", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateGreaterThanOrEqualTo(Boolean value) {
            addCriterion("data_state >=", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateLessThan(Boolean value) {
            addCriterion("data_state <", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateLessThanOrEqualTo(Boolean value) {
            addCriterion("data_state <=", value, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateIn(List<Boolean> values) {
            addCriterion("data_state in", values, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotIn(List<Boolean> values) {
            addCriterion("data_state not in", values, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateBetween(Boolean value1, Boolean value2) {
            addCriterion("data_state between", value1, value2, "dataState");
            return (Criteria) this;
        }

        public Criteria andDataStateNotBetween(Boolean value1, Boolean value2) {
            addCriterion("data_state not between", value1, value2, "dataState");
            return (Criteria) this;
        }

        public Criteria andChangedReasonIsNull() {
            addCriterion("changed_reason is null");
            return (Criteria) this;
        }

        public Criteria andChangedReasonIsNotNull() {
            addCriterion("changed_reason is not null");
            return (Criteria) this;
        }

        public Criteria andChangedReasonEqualTo(Integer value) {
            addCriterion("changed_reason =", value, "changedReason");
            return (Criteria) this;
        }

        public Criteria andChangedReasonNotEqualTo(Integer value) {
            addCriterion("changed_reason <>", value, "changedReason");
            return (Criteria) this;
        }

        public Criteria andChangedReasonGreaterThan(Integer value) {
            addCriterion("changed_reason >", value, "changedReason");
            return (Criteria) this;
        }

        public Criteria andChangedReasonGreaterThanOrEqualTo(Integer value) {
            addCriterion("changed_reason >=", value, "changedReason");
            return (Criteria) this;
        }

        public Criteria andChangedReasonLessThan(Integer value) {
            addCriterion("changed_reason <", value, "changedReason");
            return (Criteria) this;
        }

        public Criteria andChangedReasonLessThanOrEqualTo(Integer value) {
            addCriterion("changed_reason <=", value, "changedReason");
            return (Criteria) this;
        }

        public Criteria andChangedReasonIn(List<Integer> values) {
            addCriterion("changed_reason in", values, "changedReason");
            return (Criteria) this;
        }

        public Criteria andChangedReasonNotIn(List<Integer> values) {
            addCriterion("changed_reason not in", values, "changedReason");
            return (Criteria) this;
        }

        public Criteria andChangedReasonBetween(Integer value1, Integer value2) {
            addCriterion("changed_reason between", value1, value2, "changedReason");
            return (Criteria) this;
        }

        public Criteria andChangedReasonNotBetween(Integer value1, Integer value2) {
            addCriterion("changed_reason not between", value1, value2, "changedReason");
            return (Criteria) this;
        }

        public Criteria andManualChangedReasonIsNull() {
            addCriterion("manual_changed_reason is null");
            return (Criteria) this;
        }

        public Criteria andManualChangedReasonIsNotNull() {
            addCriterion("manual_changed_reason is not null");
            return (Criteria) this;
        }

        public Criteria andManualChangedReasonEqualTo(Integer value) {
            addCriterion("manual_changed_reason =", value, "manualChangedReason");
            return (Criteria) this;
        }

        public Criteria andManualChangedReasonNotEqualTo(Integer value) {
            addCriterion("manual_changed_reason <>", value, "manualChangedReason");
            return (Criteria) this;
        }

        public Criteria andManualChangedReasonGreaterThan(Integer value) {
            addCriterion("manual_changed_reason >", value, "manualChangedReason");
            return (Criteria) this;
        }

        public Criteria andManualChangedReasonGreaterThanOrEqualTo(Integer value) {
            addCriterion("manual_changed_reason >=", value, "manualChangedReason");
            return (Criteria) this;
        }

        public Criteria andManualChangedReasonLessThan(Integer value) {
            addCriterion("manual_changed_reason <", value, "manualChangedReason");
            return (Criteria) this;
        }

        public Criteria andManualChangedReasonLessThanOrEqualTo(Integer value) {
            addCriterion("manual_changed_reason <=", value, "manualChangedReason");
            return (Criteria) this;
        }

        public Criteria andManualChangedReasonIn(List<Integer> values) {
            addCriterion("manual_changed_reason in", values, "manualChangedReason");
            return (Criteria) this;
        }

        public Criteria andManualChangedReasonNotIn(List<Integer> values) {
            addCriterion("manual_changed_reason not in", values, "manualChangedReason");
            return (Criteria) this;
        }

        public Criteria andManualChangedReasonBetween(Integer value1, Integer value2) {
            addCriterion("manual_changed_reason between", value1, value2, "manualChangedReason");
            return (Criteria) this;
        }

        public Criteria andManualChangedReasonNotBetween(Integer value1, Integer value2) {
            addCriterion("manual_changed_reason not between", value1, value2, "manualChangedReason");
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
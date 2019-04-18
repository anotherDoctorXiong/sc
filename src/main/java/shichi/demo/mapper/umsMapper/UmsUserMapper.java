package shichi.demo.mapper.umsMapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import shichi.demo.model.umsModel.UmsIntegrationChangeHistory;
import shichi.demo.model.umsModel.UmsUser;
import shichi.demo.model.umsModel.UmsUserExample;
import shichi.demo.model.umsModel.UmsUserTagRelation;

import java.util.HashMap;
import java.util.List;
@Component
public interface UmsUserMapper {
    long countByExample(UmsUserExample example);

    int deleteByExample(UmsUserExample example);

    int insert(UmsUser record);

    int insertSelective(UmsUser record);

    List<UmsUser> selectByExample(UmsUserExample example);

    int updateByExampleSelective(@Param("record") UmsUser record, @Param("example") UmsUserExample example);

    int updateByExample(@Param("record") UmsUser record, @Param("example") UmsUserExample example);

    @Insert("INSERT INTO ums_user_tag_relation(user_id, tag_id) VALUES (#{userId}, #{tagId})")
    int insertTag(UmsUserTagRelation umsUserTagRelation);

    List<HashMap> selectUserAll();

    int updateUserStateByUserId(HashMap<String, Object> map);
    List<HashMap> selectUserByCondition(HashMap<String, Object> map);

    int insertChangeHistory(UmsIntegrationChangeHistory changeHistory);

    int updateIntegrationByUserId(@Param("integration") Integer integration, @Param("userId") String userId);

    int deleteRelationByUserId(String userId);

    /*@Select("SELECT date,SUM(new_user_num) AS new_user_num,SUM(active_user_num) AS active_user_num," +
            "SUM(report_num) AS report_num,SUM(activity_part_num) AS activity_part_num " +
            "FROM( " +
            "(SELECT DATE(register_time) AS date, COUNT(1) AS new_user_num, 0 AS active_user_num, 0 AS report_num, 0 AS activity_part_num FROM ums_user " +
            "WHERE register_time BETWEEN #{startTime[0]} AND #{startTime[1]} GROUP BY date) " +
            "UNION ALL " +
            "(SELECT DATE(last_visit_time) AS date, 0 AS new_user_num, COUNT(1) AS active_user_num, 0 AS report_num, 0 AS activity_part_num FROM ums_user WHERE last_visit_time BETWEEN #{startTime[0]} AND #{startTime[1]} GROUP BY date) " +
            "UNION ALL " +
            "(SELECT DATE(create_time) AS date, 0 AS new_user_num, 0 AS active_user_num, COUNT(1) AS report_num, 0 AS activity_part_num FROM rms_foretaste_report WHERE create_time BETWEEN #{startTime[0]} AND #{startTime[1]} GROUP BY date) " +
            "UNION ALL " +
            "(SELECT DATE(part_time) AS date,0 AS new_user_num, 0 AS active_user_num, 0 AS report_num, COUNT(1) AS activity_part_num FROM activity_user_relation WHERE part_time BETWEEN #{startTime[0]} AND #{startTime[1]} GROUP BY date) " +
            ") u " +
            "GROUP BY date ORDER BY date "
    )
    @Results({
            @Result(property = "date", column = "date"),
            @Result(property = "newUserNum", column = "new_user_num"),
            @Result(property = "activeUserNum", column = "active_user_num"),
            @Result(property = "reportNum", column = "report_num"),
            @Result(property = "activityPartNum", column = "activity_part_num")
    })*/
    List<HashMap> getCountData(HashMap<String, Object> map);
}
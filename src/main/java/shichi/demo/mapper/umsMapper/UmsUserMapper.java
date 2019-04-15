package shichi.demo.mapper.umsMapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
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
}
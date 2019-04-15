package shichi.demo.mapper.umsMapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import shichi.demo.model.umsModel.UmsTag;
import shichi.demo.model.umsModel.UmsTagExample;

import java.util.HashMap;
import java.util.List;
@Component
public interface UmsTagMapper {
    long countByExample(UmsTagExample example);

    int deleteByExample(UmsTagExample example);

    int insert(UmsTag record);

    int insertSelective(UmsTag record);

    List<UmsTag> selectByExample(UmsTagExample example);

    int updateByExampleSelective(@Param("record") UmsTag record, @Param("example") UmsTagExample example);

    int updateByExample(@Param("record") UmsTag record, @Param("example") UmsTagExample example);

    @Select("SELECT count(1) FROM ums_tag WHERE tag_name = #{tagName}")
    int getTagIdByTagName(@Param("tagName") String tagName);

    @Insert("INSERT INTO ums_tag(tag_id, tag_name, created_time, data_state) " +
            "VALUES (#{tagId}, #{tagName}, #{createdTime}, #{dataState})")
    int insertUmsTag(UmsTag umsTag);

    int updatePmsBrandSelective(UmsTag umsTag);

    List<HashMap> selectTagAll();

    UmsTag selectTagByTagName(String tagName);
}
package shichi.demo.mapper.umsMapper;

import org.apache.ibatis.annotations.Param;
import shichi.demo.model.umsModel.UmsIntegrationChangeHistory;
import shichi.demo.model.umsModel.UmsIntegrationChangeHistoryExample;

import java.util.HashMap;
import java.util.List;

public interface UmsIntegrationChangeHistoryMapper {
    long countByExample(UmsIntegrationChangeHistoryExample example);

    int deleteByExample(UmsIntegrationChangeHistoryExample example);

    int insert(UmsIntegrationChangeHistory record);

    int insertSelective(UmsIntegrationChangeHistory record);

    List<UmsIntegrationChangeHistory> selectByExample(UmsIntegrationChangeHistoryExample example);

    int updateByExampleSelective(@Param("record") UmsIntegrationChangeHistory record, @Param("example") UmsIntegrationChangeHistoryExample example);

    int updateByExample(@Param("record") UmsIntegrationChangeHistory record, @Param("example") UmsIntegrationChangeHistoryExample example);

    List<HashMap> selectAll();

    List<HashMap> selectByCondition(HashMap<String, Object> map);

    int updateChangeHistoryDataState(HashMap<String, Object> map);
}
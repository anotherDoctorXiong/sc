package shichi.demo.mapper.pmsMapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import shichi.demo.model.pmsModel.PmsProduce;
import shichi.demo.model.pmsModel.PmsProduceExample;

import java.util.List;
import java.util.Map;

@Component
public interface PmsProduceMapper {


    @Insert("insert into pms_produce(produce_id,brand_id,produce_name,brand_name,created_time,data_state) values(#{produceId}," +
            "#{brandId},#{produceName},#{brandName},#{createdTime},#{dataState})")
    int insertPmsProduce(PmsProduce pmsProduce);

    long countByExample(PmsProduceExample example);

    int deleteByExample(PmsProduceExample example);

    int insert(PmsProduce record);

    int insertSelective(PmsProduce record);

    List<PmsProduce> selectByExample(PmsProduceExample example);

    int updateByExampleSelective(@Param("record") PmsProduce record, @Param("example") PmsProduceExample example);

    int updateByExample(@Param("record") PmsProduce record, @Param("example") PmsProduceExample example);

    int updatePmsProduceSelective(PmsProduce pmsProduce);

    List<PmsProduce> getPmsProduceByCondition(@Param("record") Map<String, Object> map);
}
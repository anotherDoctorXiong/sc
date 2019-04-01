package shichi.demo.mapper.pmsMapper;

import org.apache.ibatis.annotations.Param;
import shichi.demo.model.pmsModel.PmsBrand;
import shichi.demo.model.pmsModel.PmsBrandExample;

import java.util.List;

public interface PmsBrandMapper {
    long countByExample(PmsBrandExample example);

    int deleteByExample(PmsBrandExample example);

    int insert(PmsBrand record);

    int insertSelective(PmsBrand record);

    List<PmsBrand> selectByExample(PmsBrandExample example);

    int updateByExampleSelective(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updateByExample(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updatePmsBrandSelective(PmsBrand pmsBrand);
}
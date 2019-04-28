package shichi.demo.mapper.pmsMapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import shichi.demo.model.pmsModel.PmsBrand;
import shichi.demo.model.pmsModel.PmsBrandExample;

import java.util.List;
@Component
public interface PmsBrandMapper {
    long countByExample(PmsBrandExample example);

    int deleteByExample(PmsBrandExample example);

    int insert(PmsBrand record);

    int insertSelective(PmsBrand record);

    List<PmsBrand> selectByExample(PmsBrandExample example);

    int updateByExampleSelective(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updateByExample(@Param("record") PmsBrand record, @Param("example") PmsBrandExample example);

    int updatePmsBrandSelective(PmsBrand pmsBrand);

    List selectByBrandName(@Param("brandName") String brandName);

    @Select("SELECT brand_name FROM pms_brand WHERE brand_id = #{brandId}")
    @Results({
            @Result(property = "brandName", column = "brand_Name")
    })
    String getBrandNameByBrandId(@Param("brandId") String brandId);

    /**
     * 根据品牌id 更新产品表里的品牌名称
     * @param brandId
     * @param brandName
     * @return
     */
    int updatePmsProduceByBrandId(String brandId, String brandName);

    /**
     * 根据品牌名称查询是否已有品牌信息
     * @param brandName
     * @return
     */
    PmsBrand getBrandByBrandName(String brandName);

    int getProduceByBrandName(String brandName);
}
package shichi.demo.service.impl.pmsImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shichi.demo.mapper.pmsMapper.PmsBrandMapper;
import shichi.demo.model.pmsModel.PmsBrand;
import shichi.demo.model.pmsModel.PmsBrandExample;
import shichi.demo.service.pmsService.PmsBrandService;
import shichi.demo.util.StringUtil;

import java.util.Date;
import java.util.List;

/**
 * 品牌Service实现类
 */
@Service
public class pmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    /**
     * 新建品牌
     * @param pmsBrand
     * @return
     */
    @Override
    public int createPmsBrand(PmsBrand pmsBrand) {
        pmsBrand.setBrandId(StringUtil.getRandomString(6));
        Date createdTime = new Date();
        //System.out.println(createdTime.toString());
        pmsBrand.setCreatedTime(createdTime);
        return pmsBrandMapper.insert(pmsBrand);
    }

    /**
     * 修改品牌
     * @param pmsBrand
     * @return
     */
    @Override
    public int updatePmsBrand(PmsBrand pmsBrand) {
        String brandId = pmsBrand.getBrandId();
        String brandName = pmsBrand.getBrandName();
        PmsBrand pmsBrand1 = pmsBrandMapper.getBrandByBrandName(brandName);
        int count1, count2 = 0;
        if(pmsBrand1 == null) {
            count1 = pmsBrandMapper.updatePmsBrandSelective(pmsBrand);
            count2 = pmsBrandMapper.updatePmsProduceByBrandId(brandId, brandName);
        }
        if (!pmsBrand1.getBrandId().equals(brandId)) {
            count1 =-1;
        }else {
            count1 = pmsBrandMapper.updatePmsBrandSelective(pmsBrand);
            count2 = pmsBrandMapper.updatePmsProduceByBrandId(brandId, brandName);
        }
        if ( count1 == 1 && count2 >= 1) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * 获取所有品牌信息列表
     * @return
     */
    @Override
    public List<PmsBrand> getPmsBrandAllList() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    /**
     * 分页查询品牌信息列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List getPmsBrandList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsBrandExample pmsBrandExample = new PmsBrandExample();
        //pmsBrandExample.setOrderByClause("sort desc");
        return pmsBrandMapper.selectByExample(pmsBrandExample);
    }

    /**
     * 根据品牌名称查询品牌列表
     * @param brandName
     * @return
     */
    @Override
    public List getPmsBrandByBrandName(String brandName) {
        return pmsBrandMapper.selectByBrandName(brandName);
    }
}

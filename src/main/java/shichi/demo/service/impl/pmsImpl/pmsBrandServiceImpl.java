package shichi.demo.service.impl.pmsImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shichi.demo.mapper.pmsMapper.PmsBrandMapper;
import shichi.demo.model.pmsModel.PmsBrand;
import shichi.demo.model.pmsModel.PmsBrandExample;
import shichi.demo.service.pmsService.PmsBrandService;
import shichi.demo.util.StringUtil;

import java.util.List;

/**
 * 品牌Service实现类
 */
@Service
public class pmsBrandServiceImpl implements PmsBrandService {
    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public int createPmsBrand(PmsBrand pmsBrand) {
        pmsBrand.setBrandId(StringUtil.getRandomString(6));
        return pmsBrandMapper.insertSelective(pmsBrand);
    }

    @Override
    public int updatePmsBrand(PmsBrand pmsBrand) {
        return pmsBrandMapper.updatePmsBrandSelective(pmsBrand);
    }

    @Override
    public List<PmsBrand> getPmsBrandAllList() {
        return pmsBrandMapper.selectByExample(new PmsBrandExample());
    }

    @Override
    public List getPmsBrandList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsBrandExample pmsBrandExample = new PmsBrandExample();
        //pmsBrandExample.setOrderByClause("sort desc");
        return pmsBrandMapper.selectByExample(pmsBrandExample);
    }
}

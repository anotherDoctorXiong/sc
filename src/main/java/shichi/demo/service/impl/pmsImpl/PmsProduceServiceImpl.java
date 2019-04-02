package shichi.demo.service.impl.pmsImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shichi.demo.mapper.pmsMapper.PmsBrandMapper;
import shichi.demo.mapper.pmsMapper.PmsProduceMapper;
import shichi.demo.model.pmsModel.PmsProduce;
import shichi.demo.model.pmsModel.PmsProduceExample;
import shichi.demo.service.pmsService.PmsProduceService;
import shichi.demo.util.StringUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 产品Service实现类
 */
@Service
public class PmsProduceServiceImpl implements PmsProduceService {
    @Autowired
    private PmsProduceMapper pmsProduceMapper;

    @Autowired
    private PmsBrandMapper pmsBrandMapper;

    @Override
    public int createPmsProduce(PmsProduce pmsProduce) {
        pmsProduce.setProduceId(StringUtil.getRandomString(6));
        String brandName = pmsBrandMapper.getBrandNameByBrandId(pmsProduce.getBrandId());
        pmsProduce.setBrandName(brandName);
        Date createdTime = new Date();
        pmsProduce.setCreatedTime(createdTime);
        return pmsProduceMapper.insertPmsProduce(pmsProduce);
    }

    @Override
    public int updatePmsProduce(PmsProduce pmsProduce) {
        String brandName = pmsBrandMapper.getBrandNameByBrandId(pmsProduce.getBrandId());
        pmsProduce.setBrandName(brandName);
        return pmsProduceMapper.updatePmsProduceSelective(pmsProduce);
    }

    @Override
    public List<PmsProduce> getPmsProduceAllList() {
        return pmsProduceMapper.selectByExample(new PmsProduceExample());
    }

    @Override
    public List getPmsProduceList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProduceExample pmsProduceExample = new PmsProduceExample();
        return pmsProduceMapper.selectByExample(pmsProduceExample);
    }

    @Override
    public List<PmsProduce> getPmsProduceByCondition(HashMap<String, Object> map) {
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        PageHelper.startPage(pageNum, pageSize);
        return pmsProduceMapper.getPmsProduceByCondition(map);
        // return null;
    }




}

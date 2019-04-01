package shichi.demo.service.impl.pmsImpl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shichi.demo.mapper.pmsMapper.PmsProduceMapper;
import shichi.demo.model.pmsModel.PmsProduce;
import shichi.demo.model.pmsModel.PmsProduceExample;
import shichi.demo.service.pmsService.PmsProduceService;
import shichi.demo.util.StringUtil;

import java.util.List;
import java.util.Map;

/**
 * 产品Service实现类
 */
@Service
public class PmsProduceServiceImpl implements PmsProduceService {
    @Autowired
    private PmsProduceMapper pmsProduceMapper;

    @Override
    public int createPmsProduce(PmsProduce pmsProduce) {
        pmsProduce.setProduceId(StringUtil.getRandomString(6));
        return pmsProduceMapper.insertPmsProduce(pmsProduce);
    }

    @Override
    public int updatePmsProduce(PmsProduce pmsProduce) {
        return pmsProduceMapper.updatePmsProduceSelective(pmsProduce);
    }

    @Override
    public List getPmsProduceList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        PmsProduceExample pmsProduceExample = new PmsProduceExample();
        return pmsProduceMapper.selectByExample(pmsProduceExample);
    }

    @Override
    public List<PmsProduce> getPmsProduceByCondition(Map<String, Object> map) {
        return pmsProduceMapper.getPmsProduceByCondition(map);
    }


}

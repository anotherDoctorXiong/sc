package shichi.demo.service.pmsService;

import shichi.demo.model.pmsModel.PmsProduce;

import java.util.List;
import java.util.Map;

public interface PmsProduceService {
    int createPmsProduce(PmsProduce pmsProduce);

    int updatePmsProduce(PmsProduce pmsProduce);

    List getPmsProduceList(Integer pageNum, Integer pageSize);

    List<PmsProduce> getPmsProduceByCondition(Map<String, Object> map);
}

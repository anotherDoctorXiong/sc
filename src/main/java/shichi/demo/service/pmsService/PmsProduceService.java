package shichi.demo.service.pmsService;

import shichi.demo.model.pmsModel.PmsProduce;

import java.util.HashMap;
import java.util.List;

public interface PmsProduceService {
    int createPmsProduce(PmsProduce pmsProduce);

    int updatePmsProduce(PmsProduce pmsProduce);

    List getPmsProduceList(Integer pageNum, Integer pageSize);

    List<PmsProduce> getPmsProduceByCondition(HashMap<String, Object> map);

    List<PmsProduce> getPmsProduceAllList();
}

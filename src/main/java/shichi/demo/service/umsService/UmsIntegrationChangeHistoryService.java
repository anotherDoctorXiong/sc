package shichi.demo.service.umsService;

import java.util.HashMap;
import java.util.List;

public interface UmsIntegrationChangeHistoryService {

    List<HashMap> getChangeHistoryListPage(Integer pageNum, Integer pageSize);

    List getChangeHistoryAll();

    List getChangeHistoryByCondition(HashMap<String, Object> map);

    List getChangeHistoryAllByCondition(HashMap<String, Object> map);

    int updateChangeHistoryDataState(HashMap<String, Object> map);
}

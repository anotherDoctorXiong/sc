package shichi.demo.service.umsService;

import java.util.HashMap;
import java.util.List;

public interface UmsUserService {
    int setUmsUserTag(HashMap<String, Object> map);

    List getUmsUserList(Integer pageNum, Integer pageSize);

    int updateUmsUserState(HashMap<String, Object> map);

    List getUmsUserListAllByCondition(HashMap<String, Object> map);

    List getUmsUserALLList();

    int updateUserIntegration(HashMap<String, Object> map);

    List getUmsUserListPageByCondition(HashMap<String, Object> map);

    List getCountData(HashMap<String, Object> map);
}

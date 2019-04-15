package shichi.demo.service.impl.umsImpl;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shichi.demo.mapper.umsMapper.UmsIntegrationChangeHistoryMapper;
import shichi.demo.mapper.umsMapper.UmsUserMapper;
import shichi.demo.model.umsModel.UmsIntegrationChangeHistory;
import shichi.demo.model.umsModel.UmsUserTagRelation;
import shichi.demo.service.umsService.UmsUserService;
import shichi.demo.util.StringUtil;

import java.util.*;

/**
 * 用户管理Service实现类
 */
@Service
public class UmsUserServiceImpl implements UmsUserService {
    private static final Logger logger = LoggerFactory.getLogger(UmsUserServiceImpl.class);
    @Autowired
    private UmsUserMapper umsUserMapper;

    @Autowired
    private UmsIntegrationChangeHistoryMapper integrationChangeHistoryMapper;

    /**
     * 设置用户标签
     *
     * @param hashMap
     * @return
     */
    @Override
    public int setUmsUserTag(HashMap<String, Object> hashMap) {
        UmsUserTagRelation umsUserTagRelation = new UmsUserTagRelation();
        int count = 0;
        //Map map = (Map) hashMap.get("user");
        String userId = (String) hashMap.get("userId");
        umsUserMapper.deleteRelationByUserId(userId);
        ArrayList tagIdList = (ArrayList) hashMap.get("tags");
        for (int i = 0; i < tagIdList.size(); i++) {
            String tagId = (String) tagIdList.get(i);
            umsUserTagRelation.setUserId(userId);
            umsUserTagRelation.setTagId(tagId);
            count = umsUserMapper.insertTag(umsUserTagRelation);
        }
        if (count == 1) {
            logger.info("向用户标签关系表插入数据成功!");
            return 1;
        } else {
            logger.info("向用户标签关系表插入数据失败!");
            return 0;
        }
    }

    /**
     * 分页查询用户信息列表
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List getUmsUserList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return umsUserMapper.selectUserAll();
    }

    /**
     * 批量更新用户账号状态
     *
     * @param map
     * @return
     */
    @Override
    public int updateUmsUserState(HashMap<String, Object> map) {
        return umsUserMapper.updateUserStateByUserId(map);
    }

    /**
     * 按条件查询所有用户信息列表(不分页)
     *
     * @param map
     * @return
     */
    @Override
    public List getUmsUserListAllByCondition(HashMap<String, Object> map) {
        String s = (String) map.get("user");
        if (!StringUtil.isNullOrEmpty(s)) {
            //判断字符串是否是中文
            if (s.matches("[\\u4E00-\\u9FA5]+")) {
                map.put("nickname", s);
                map.put("userId", "");
            } else {
                map.put("userId", s);
                map.put("nickname", "");
            }
        } else {
            map.put("userId", "");
            map.put("nickname", "");
        }
        return umsUserMapper.selectUserByCondition(map);
    }

    /**
     * 按条件分页查询用户信息列表
     *
     * @param map
     * @return
     */
    @Override
    public List getUmsUserListPageByCondition(HashMap<String, Object> map) {
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        String s = (String) map.get("user");
        if (!StringUtil.isNullOrEmpty(s)) {
            //判断字符串是否是中文
            if (s.matches("[\\u4E00-\\u9FA5]+")) {
                map.put("nickname", s);
                map.put("userId", "");
            } else {
                map.put("userId", s);
                map.put("nickname", "");
            }
        } else {
            map.put("userId", "");
            map.put("nickname", "");
        }
        PageHelper.startPage(pageNum, pageSize);
        return umsUserMapper.selectUserByCondition(map);
    }

    /**
     * 查询所有用户信息列表
     *
     * @return
     */
    @Override
    public List getUmsUserALLList() {
        return umsUserMapper.selectUserAll();
    }

    /**
     * 手动加减用户积分
     *
     * @param map
     * @return
     */
    @Override
    public int updateUserIntegration(HashMap<String, Object> map) {
        UmsIntegrationChangeHistory changeHistory = new UmsIntegrationChangeHistory();
        String userId = (String) map.get("userId");
        //变更前的积分
        Integer integrationHistory = (Integer) map.get("integration");
        Integer changedCount = (Integer) map.get("changedCount");
        String operateNote = (String) map.get("operationNote");
        String adminId = (String) map.get("adminId");
        String manualReason = (String) map.get("manualChangedReason");
        Boolean dataState = (Boolean) map.get("dataState");
        //变更后的积分
        Integer integration = integrationHistory + changedCount;
        //设置积分变更历史实体的字段值
        changeHistory.setChangeId(StringUtil.getRandomString(6));
        changeHistory.setUserId(userId);
        changeHistory.setCreatedTime(new Date());
        changeHistory.setBeforeChangedCount(integrationHistory);
        changeHistory.setChangedCount(changedCount);
        changeHistory.setChangedReason("后台手动加减");
        changeHistory.setManualChangedReason(manualReason);
        changeHistory.setOperateNote(operateNote);
        changeHistory.setAdminId(adminId);
        changeHistory.setDataState(dataState);
        int count2 = 0;
        int count1 = integrationChangeHistoryMapper.insert(changeHistory);
        if (dataState == true) {
            count2 = umsUserMapper.updateIntegrationByUserId(integration, userId);
        }
        if (count1 == 1) {
            logger.info("手动加减用户积分成功!");
        }
        if (count2 == 1) {
            logger.info("成功插入一条用户积分变更记录!");
        }
        return 1;
    }
}

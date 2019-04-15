package shichi.demo.service.impl.umsImpl;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shichi.demo.mapper.umsMapper.UmsIntegrationChangeHistoryMapper;
import shichi.demo.service.umsService.UmsIntegrationChangeHistoryService;
import shichi.demo.util.StringUtil;

import java.util.HashMap;
import java.util.List;

/**
 * 星币日志Service实现类
 */
@Service
public class UmsIntegrationChangeHistoryServiceImpl implements UmsIntegrationChangeHistoryService {
    private static final Logger logger = LoggerFactory.getLogger(UmsIntegrationChangeHistoryServiceImpl.class);

    @Autowired
    private UmsIntegrationChangeHistoryMapper integrationChangeHistoryMapper;

    /**
     * 分页查询积分历史变更记录
     * @param pageNum 当前页
     * @param pageSize 每页的数据数量
     * @return List
     */
    @Override
    public List<HashMap> getChangeHistoryListPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return integrationChangeHistoryMapper.selectAll();
    }

    /**
     * 查询所有积分历史变更记录
     * @return List
     */
    @Override
    public List getChangeHistoryAll() {
        return integrationChangeHistoryMapper.selectAll();
    }

    /**
     * 按条件分页查询积分变更历史记录
     * @param map 条件参数
     * @return List
     */
    @Override
    public List getChangeHistoryByCondition(HashMap<String, Object> map) {
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        String s = (String) map.get("user");
        //判断user字符是否为空
        if (! StringUtil.isNullOrEmpty(s)) {
            //判断字符串是否是中文
            if (s.matches("[\\u4E00-\\u9FA5]+")) {
                map.put("nickname", s);
                map.put("userId", "");
            } else {
                map.put("userId", s);
                map.put("nickname", "");
            }
        }else {
            map.put("userId", "");
            map.put("nickname", "");
        }
        PageHelper.startPage(pageNum, pageSize);
        return integrationChangeHistoryMapper.selectByCondition(map);
    }

    /**
     * 按条件查询所有积分变更历史记录(非分页)
     * @param map
     * @return
     */
    @Override
    public List getChangeHistoryAllByCondition(HashMap<String, Object> map) {
        String s = (String) map.get("user");
        //判断user字符是否为空
        if (! StringUtil.isNullOrEmpty(s)) {
            //判断字符串是否是中文
            if (s.matches("[\\u4E00-\\u9FA5]+")) {
                map.put("nickname", s);
                map.put("userId", "");
            } else {
                map.put("userId", s);
                map.put("nickname", "");
            }
        }else {
            map.put("userId", "");
            map.put("nickname", "");
        }
        return integrationChangeHistoryMapper.selectByCondition(map);
    }

    /**
     * 批量更新积分变更历史记录的数据状态
     * @param map 更新参数
     * @return int
     */
    @Override
    public int updateChangeHistoryDataState(HashMap<String, Object> map) {
        return integrationChangeHistoryMapper.updateChangeHistoryDataState(map);
    }
}

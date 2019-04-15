package shichi.demo.service.impl.umsImpl;

import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import shichi.demo.mapper.umsMapper.UmsTagMapper;
import shichi.demo.model.umsModel.UmsTag;
import shichi.demo.model.umsModel.UmsTagExample;
import shichi.demo.service.umsService.UmsTagService;
import shichi.demo.util.StringUtil;

import java.util.Date;
import java.util.List;

/**
 * 标签Service实现类
 */
@Service
public class UmsTagServiceImpl implements UmsTagService {
    private static final  Logger logger = LoggerFactory.getLogger(UmsTagServiceImpl.class);
    @Autowired
    private UmsTagMapper umsTagMapper;

    /**
     * 新建标签
     * @param umsTag
     * @return
     */
    @Override
    public int createUmsTag(UmsTag umsTag) {
        int count = umsTagMapper.getTagIdByTagName(umsTag.getTagName());
        if (count == 0) {
            String tagId = StringUtil.getRandomString(6);
            umsTag.setTagId(tagId);
            Date createdTime = new Date();
            umsTag.setCreatedTime(createdTime);
            return umsTagMapper.insertUmsTag(umsTag);
        }else {
            logger.error("该标签已存在,新建标签失败!");
            return 0;
        }
    }

    /**
     * 修改标签
     * @param umsTag
     * @return
     */
    @Override
    public int updateUmsTag(UmsTag umsTag) {
        UmsTag umsTag1 = umsTagMapper.selectTagByTagName(umsTag.getTagName());
        if (umsTag1 == null){
            return umsTagMapper.updatePmsBrandSelective(umsTag);
        }
        if (umsTag1.getTagId() != umsTag.getTagId()){
            return -1;
        }
        return umsTagMapper.updatePmsBrandSelective(umsTag);
    }

    /**
     * 分页查询标签信息列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Override
    public List getUmsTagList(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        return umsTagMapper.selectTagAll();
    }

    /**
     * 查询所有标签信息列表
     * @return
     */
    @Override
    public List<UmsTag> getUmsTagAllList() {
        return umsTagMapper.selectByExample(new UmsTagExample());
    }
}

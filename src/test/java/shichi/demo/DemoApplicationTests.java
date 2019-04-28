package shichi.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import shichi.demo.mapper.pmsMapper.PmsBrandMapper;
import shichi.demo.mapper.pmsMapper.PmsProduceMapper;
import shichi.demo.mapper.umsMapper.UmsIntegrationChangeHistoryMapper;
import shichi.demo.mapper.umsMapper.UmsTagMapper;
import shichi.demo.mapper.umsMapper.UmsUserMapper;
import shichi.demo.model.pmsModel.PmsProduce;
import shichi.demo.util.JsonUtil;
import shichi.demo.util.ReadFileUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private PmsProduceMapper pmsProduceMapper;

	@Autowired
	private PmsBrandMapper pmsBrandMapper;

	@Autowired
	private UmsTagMapper umsTagMapper;

	@Autowired
	private UmsUserMapper umsUserMapper;

	@Autowired
	private UmsIntegrationChangeHistoryMapper integrationChangeHistoryMapper;

	@Test
	public void contextLoads() {
		HashMap<String,Object> map = new HashMap<>();
		map.put("produceName","哇哈哈");
		map.put("brandId","6H0GkO");
		map.put("dataState",false);
		System.out.println(map.toString());
		List<PmsProduce> pmsProduceByCondition = pmsProduceMapper.getPmsProduceByCondition(map);

		System.out.println(pmsProduceByCondition);

	}

	@Test
	public void getUmsTagList() {
		List<HashMap> mapList = umsTagMapper.selectTagAll();
		System.out.println(mapList);
	}

	@Test
	public void getUmsUserAll() {
		List<HashMap> mapList = umsUserMapper.selectUserAll();
		System.out.println(mapList);
	}

	@Test
	public void getUmsIntegrationChangeList() {
		List<HashMap> mapList = integrationChangeHistoryMapper.selectAll();
		System.out.println(mapList);
	}

	@Test
	public void getUserListByCondition(){
		HashMap<String, Object> map = new HashMap<>();
		map.put("pageNum", 1);
		map.put("pageSize", 10);
		map.put("user", "10010");
//		List registerTime = new ArrayList();
//		registerTime.add(1553054400);
//		registerTime.add(1554868800);
//		map.put("registerTime", registerTime);
		//map.put("tagId", "UMla1P");
		List<HashMap> mapList = umsUserMapper.selectUserByCondition(map);
		System.out.println(mapList);
	}

	@Test
	@Transactional
	public void updateUmsUserState() {
		HashMap<String, Object> map = new HashMap<>();
		map.put("state", "0");
		List<String> idList = new ArrayList<>();
		idList.add("10010");
		idList.add("10020");
		idList.add("10030");
		map.put("idList", idList);
		int count = umsUserMapper.updateUserStateByUserId(map);
		System.out.println(count);
	}

	@Test
	public void Test(){
		String path = "E:\\java project\\sc\\src\\main\\resources\\json\\ChangedReason.json";
		System.out.println(ReadFileUtil.readFileToString(path));
		System.out.println(JsonUtil.StringToJSONArray(ReadFileUtil.readFileToString(path)));
	}

	@Test
	public void getCountData(){
		HashMap<String, Object> map = new HashMap<>();
		List startTime = new ArrayList();
		startTime.add("2019-04-01");
		startTime.add("2019-04-30");
		map.put("startTime", startTime);
		System.out.println(map.toString());
		List mapList = umsUserMapper.getCountData(map);
		System.out.println(mapList);
	}

	@Test
	public void getProduceByBrandName(){
		String brandName = "测试2";
		int count = pmsBrandMapper.getProduceByBrandName(brandName);
		System.out.println(count);
	}


}

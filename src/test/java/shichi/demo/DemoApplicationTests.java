package shichi.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import shichi.demo.mapper.pmsMapper.PmsProduceMapper;
import shichi.demo.model.pmsModel.PmsProduce;

import java.util.HashMap;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	private PmsProduceMapper pmsProduceMapper;

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

}

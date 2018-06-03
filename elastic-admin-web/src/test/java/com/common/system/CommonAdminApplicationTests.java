package com.common.system;

import com.biantech.elastic.admin.entity.TreeGridNode;
import com.biantech.elastic.admin.entity.TreeGridWrapper;
import com.common.system.service.RcBaseAreaService;
import com.common.system.service.TreeGridService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommonAdminApplicationTests {

	Logger LOG = LoggerFactory.getLogger("CommonAdminApplicationTests");

	@Autowired
	private RcBaseAreaService baseAreaService;
	@Autowired
	private TreeGridService treeGridService;

	@Test
	public void contextLoads() {
		List<TreeGridNode> list = treeGridService.getMenuTreeGridNodes();
		TreeGridWrapper wrapper = new TreeGridWrapper();
		wrapper.setRows(list);
		wrapper.setTotal(list.size());
		LOG.info(wrapper.toString());
	}
//	@Test
//	public void Insert(){
//		System.out.println("sdadada");
//		JsonObject main = new JsonParser().parse(AreaData.AREA).getAsJsonObject();
//		JsonArray jsonArray = main.getAsJsonArray("children");
//		DistrictArea baseArea = new Gson().fromJson(AreaData.AREA,new TypeToken<DistrictArea>(){}.getType());
//		//第一级
//		baseArea.setCreateTime(new Date());
//		baseArea.setLevel(1);
//		baseArea.setParentCode("0");
//		baseAreaService.insert(baseArea);
//		//第二级
//		List<DistrictArea> childList  = baseArea.getChildren();
//		if (childList != null){
//			for (DistrictArea child:childList
//					) {
//				child.setCreateTime(new Date());
//				child.setParentCode(baseArea.getCode());
//				child.setLevel(2);
//				baseAreaService.insert(child);
//				//第三集
//				List<DistrictArea> sunList = child.getChildren();
//				if (sunList != null){
//					for (DistrictArea sun:sunList
//							) {
//						sun.setCreateTime(new Date());
//						sun.setParentCode(child.getCode());
//						sun.setLevel(3);
//						baseAreaService.insert(sun);
//					}
//				}
//
//			}
//		}
//
//
//	}
}

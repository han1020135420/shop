package manman.pro.db;

import manman.pro.db.dao.ShopUserMapper;
import manman.pro.db.domain.ShopUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class ApplicationTests {

	@Test
	public void contextLoads() {
	}
	@Autowired
	private ShopUserMapper shopUserMapper;

	@Test
	public void testUser() {
		ShopUser result = shopUserMapper.selectByPrimaryKey(1);
		System.out.println(result);
	}
}

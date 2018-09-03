package manman.pro.db.service;

import manman.pro.db.dao.ShopUserMapper;
import manman.pro.db.domain.ShopUser;
import manman.pro.db.domain.ShopUserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 13:12
 */
@Service
public class ShopUserService {

    @Autowired
    private ShopUserMapper userMapper;

    public ShopUser findById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    public List<ShopUser> queryByUsername(String username) {
        ShopUserExample example = new ShopUserExample();
        example.or().andUsernameEqualTo(username).andDeletedEqualTo(false);
        return userMapper.selectByExample(example);
    }

    public ShopUser queryByOid(String openId) {
        ShopUserExample example = new ShopUserExample();
        example.or().andWeixinOpenidEqualTo(openId).andDeletedEqualTo(false);
        return userMapper.selectOneByExample(example);
    }

    public int add(ShopUser user) {
        return userMapper.insertSelective(user);
    }

    public int update(ShopUser user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public List<ShopUser> queryByMobile(String mobile) {
        ShopUserExample example = new ShopUserExample();
        example.or().andMobileEqualTo(mobile).andDeletedEqualTo(false);
        return userMapper.selectByExample(example);
    }
}

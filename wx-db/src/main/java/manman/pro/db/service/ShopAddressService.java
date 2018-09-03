package manman.pro.db.service;

import manman.pro.db.dao.ShopAddressMapper;
import manman.pro.db.domain.ShopAddress;
import manman.pro.db.domain.ShopAddressExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 15:53
 */
@Service
public class ShopAddressService {
    @Autowired
    private ShopAddressMapper addressMapper;

    public List<ShopAddress> queryByUid(Integer uid) {
        ShopAddressExample example = new ShopAddressExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        return addressMapper.selectByExample(example);
    }

    public ShopAddress findById(Integer id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    public void resetDefault(Integer userId) {
        ShopAddress address = new ShopAddress();
        address.setIsDefault(false);
        ShopAddressExample example = new ShopAddressExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        addressMapper.updateByExampleSelective(address, example);
    }

    public int add(ShopAddress address) {
        return addressMapper.insertSelective(address);
    }

    public int update(ShopAddress address) {
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    public void delete(Integer id) {
        addressMapper.logicalDeleteByPrimaryKey(id);
    }

    public ShopAddress findDefault(Integer userId) {
        ShopAddressExample example = new ShopAddressExample();
        example.or().andUserIdEqualTo(userId).andIsDefaultEqualTo(true).andDeletedEqualTo(false);
        return addressMapper.selectOneByExample(example);
    }
}

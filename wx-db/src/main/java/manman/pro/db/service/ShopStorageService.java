package manman.pro.db.service;

import manman.pro.db.dao.ShopStorageMapper;
import manman.pro.db.domain.ShopStorage;
import manman.pro.db.domain.ShopStorageExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 10:24
 */
@Service
public class ShopStorageService {
    @Autowired
    private ShopStorageMapper shopStorageMapper;


    public ShopStorage findByKey(String key) {
        ShopStorageExample example = new ShopStorageExample();
        example.or().andKeyEqualTo(key).andDeletedEqualTo(false);
        return shopStorageMapper.selectOneByExample(example);
    }

    public void add(ShopStorage shopStorage) {
        shopStorageMapper.insertSelective(shopStorage);
    }

    public ShopStorage findById(Integer id) {
        return shopStorageMapper.selectByPrimaryKey(id);
    }
}

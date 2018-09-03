package manman.pro.db.service;

import manman.pro.db.dao.ShopAdMapper;
import manman.pro.db.domain.ShopAd;
import manman.pro.db.domain.ShopAdExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 10:52
 */
@Service
public class ShopAdService {
    @Autowired
    private ShopAdMapper adMapper;


    public List<ShopAd> queryByApid(int i) {
        ShopAdExample example = new ShopAdExample();
        example.or().andPositionEqualTo(i).andDeletedEqualTo(false);
        return adMapper.selectByExample(example);
    }
}

package manman.pro.db.service;

import manman.pro.db.dao.ShopGoodsAttributeMapper;
import manman.pro.db.domain.ShopGoodsAttribute;
import manman.pro.db.domain.ShopGoodsAttributeExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 13:02
 */
@Service
public class ShopGoodsAttributeService {

    @Autowired
    private ShopGoodsAttributeMapper goodsAttributeMapper;

    public List<ShopGoodsAttribute> queryByGid(Integer goodsId) {
        ShopGoodsAttributeExample example = new ShopGoodsAttributeExample();
        example.or().andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return goodsAttributeMapper.selectByExample(example);
    }
}

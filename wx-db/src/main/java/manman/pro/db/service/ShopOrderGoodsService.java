package manman.pro.db.service;

import manman.pro.db.dao.ShopOrderGoodsMapper;
import manman.pro.db.domain.ShopOrderGoods;
import manman.pro.db.domain.ShopOrderGoodsExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-08-15 14:35
 */
@Service
public class ShopOrderGoodsService {
    @Resource
    private ShopOrderGoodsMapper orderGoodsMapper;


    public int add(ShopOrderGoods orderGoods) {
        return orderGoodsMapper.insertSelective(orderGoods);
    }

    public List<ShopOrderGoods> queryByOid(Integer orderId) {
        ShopOrderGoodsExample example = new ShopOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }

    public List<ShopOrderGoods> findByOidAndGid(Integer orderId, Integer goodsId) {
        ShopOrderGoodsExample example = new ShopOrderGoodsExample();
        example.or().andOrderIdEqualTo(orderId).andGoodsIdEqualTo(goodsId).andDeletedEqualTo(false);
        return orderGoodsMapper.selectByExample(example);
    }
}

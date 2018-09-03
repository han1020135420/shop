package manman.pro.db.service;

import manman.pro.db.dao.ShopCartMapper;
import manman.pro.db.domain.ShopCart;
import manman.pro.db.domain.ShopCartExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 13:17
 */
@Service
public class ShopCartService {
    @Autowired
    private ShopCartMapper cartMapper;

    public List<ShopCart> queryByUid(int userId) {
        ShopCartExample example = new ShopCartExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return cartMapper.selectByExample(example);
    }

    public ShopCart queryExist(Integer goodsId, Integer productId, Integer userId) {
        ShopCartExample example = new ShopCartExample();
        example.or().andGoodsIdEqualTo(goodsId).andProductIdEqualTo(productId).andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return cartMapper.selectOneByExample(example);
    }

    public void add(ShopCart cart) {
        cartMapper.insertSelective(cart);
    }

    public void update(ShopCart cart) {
        cartMapper.updateByPrimaryKey(cart);
    }

    public List<ShopCart> queryByUidAndChecked(Integer userId) {
        ShopCartExample example = new ShopCartExample();
        example.or().andUserIdEqualTo(userId).andCheckedEqualTo(true).andDeletedEqualTo(false);
        return cartMapper.selectByExample(example);
    }

    public ShopCart findById(Integer id) {
        return cartMapper.selectByPrimaryKey(id);
    }

    public void clearGoods(Integer userId) {
        ShopCartExample example = new ShopCartExample();
        example.or().andUserIdEqualTo(userId).andCheckedEqualTo(true);
        ShopCart cart = new ShopCart();
        cart.setDeleted(true);
        cartMapper.updateByExampleSelective(cart, example);
    }

    public int delete(List<Integer> productIdList, int userId) {
        ShopCartExample example = new ShopCartExample();
        example.or().andUserIdEqualTo(userId).andProductIdIn(productIdList);
        return cartMapper.logicalDeleteByExample(example);
    }

    public int updateCheck(Integer userId, List<Integer> idsList, Boolean checked) {
        ShopCartExample example = new ShopCartExample();
        example.or().andUserIdEqualTo(userId).andProductIdIn(idsList).andDeletedEqualTo(false);
        ShopCart cart = new ShopCart();
        cart.setChecked(checked);
        return cartMapper.updateByExampleSelective(cart, example);
    }
}

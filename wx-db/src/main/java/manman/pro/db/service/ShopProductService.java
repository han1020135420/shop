package manman.pro.db.service;

import manman.pro.db.dao.ShopProductMapper;
import manman.pro.db.domain.ShopProduct;
import manman.pro.db.domain.ShopProductExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 13:07
 */
@Service
public class ShopProductService {

    @Autowired
    private ShopProductMapper productMapper;

    public List<ShopProduct> queryByGid(Integer gid) {
        ShopProductExample example = new ShopProductExample();
        example.or().andGoodsIdEqualTo(gid).andDeletedEqualTo(false);
        return productMapper.selectByExample(example);
    }

    public ShopProduct findById(Integer productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    public void updateById(ShopProduct product) {
        productMapper.updateByPrimaryKeySelective(product);
    }
}

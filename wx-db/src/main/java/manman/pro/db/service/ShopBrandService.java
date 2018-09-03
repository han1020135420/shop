package manman.pro.db.service;

import com.github.pagehelper.PageHelper;
import manman.pro.db.dao.ShopBrandMapper;
import manman.pro.db.domain.ShopBrand;
import manman.pro.db.domain.ShopBrandExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 10:53
 */
@Service
public class ShopBrandService {
    @Autowired
    private ShopBrandMapper brandMapper;


    public List<ShopBrand> query(int offset, int limit) {
        ShopBrandExample example = new ShopBrandExample();
        example.or().andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return brandMapper.selectByExample(example);
    }

    public ShopBrand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    public int queryTotalCount() {
        ShopBrandExample example = new ShopBrandExample();
        example.or().andDeletedEqualTo(false);
        return (int)brandMapper.countByExample(example);
    }
}

package manman.pro.db.service;

import com.github.pagehelper.PageHelper;
import manman.pro.db.dao.ShopCategoryMapper;
import manman.pro.db.domain.ShopCategory;
import manman.pro.db.domain.ShopCategoryExample;
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
public class ShopCategoryService {

    @Autowired
    private ShopCategoryMapper categoryMapper;

    private ShopCategory.Column[] CHANNEL = {ShopCategory.Column.id, ShopCategory.Column.name, ShopCategory.Column.iconUrl};

    public List<ShopCategory> queryChannel() {
        ShopCategoryExample example = new ShopCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExampleSelective(example, CHANNEL);
    }

    public List<ShopCategory> queryL1WithoutRecommend(int offset, int limit) {
        ShopCategoryExample example = new ShopCategoryExample();
        example.or().andLevelEqualTo("L1").andNameNotEqualTo("推荐").andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return categoryMapper.selectByExample(example);
    }

    public List<ShopCategory> queryByPid(Integer pid) {
        ShopCategoryExample example = new ShopCategoryExample();
        example.or().andParentIdEqualTo(pid).andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);

    }

    public ShopCategory findById(Integer id) {
        return categoryMapper.selectByPrimaryKey(id);
    }

    public List<ShopCategory> queryL2ByIds(List<Integer> ids) {
        ShopCategoryExample example = new ShopCategoryExample();
        example.or().andIdIn(ids).andLevelEqualTo("L2").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }

    public List<ShopCategory> queryL1() {
        ShopCategoryExample example = new ShopCategoryExample();
        example.or().andLevelEqualTo("L1").andDeletedEqualTo(false);
        return categoryMapper.selectByExample(example);
    }
}

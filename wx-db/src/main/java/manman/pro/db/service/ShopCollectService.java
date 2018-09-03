package manman.pro.db.service;

import com.github.pagehelper.PageHelper;
import manman.pro.db.dao.ShopCollectMapper;
import manman.pro.db.domain.ShopCollect;
import manman.pro.db.domain.ShopCollectExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 13:13
 */
@Service
public class ShopCollectService {
    @Autowired
    private ShopCollectMapper collectMapper;

    public int count(int uid, Integer gid) {
        ShopCollectExample example = new ShopCollectExample();
        example.or().andUserIdEqualTo(uid).andValueIdEqualTo(gid).andDeletedEqualTo(false);
        return (int)collectMapper.countByExample(example);
    }

    public List<ShopCollect> queryByType(Integer userId, Integer typeId, Integer page, Integer size) {
        ShopCollectExample example = new ShopCollectExample();
        example.or().andUserIdEqualTo(userId).andTypeIdEqualTo(typeId).andDeletedEqualTo(false);
        example.setOrderByClause(ShopCollect.Column.addTime.desc());
        PageHelper.startPage(page, size);
        return collectMapper.selectByExample(example);
    }

    public int countByType(Integer userId, Integer typeId) {
        ShopCollectExample example = new ShopCollectExample();
        example.or().andUserIdEqualTo(userId).andTypeIdEqualTo(typeId).andDeletedEqualTo(false);
        return (int)collectMapper.countByExample(example);
    }

    public ShopCollect queryByTypeAndValue(Integer userId, Integer typeId, Integer valueId) {
        ShopCollectExample example = new ShopCollectExample();
        example.or().andUserIdEqualTo(userId).andValueIdEqualTo(valueId).andTypeIdEqualTo(typeId).andDeletedEqualTo(false);
        return collectMapper.selectOneByExample(example);
    }

    public void deleteById(Integer id) {
        collectMapper.logicalDeleteByPrimaryKey(id);
    }

    public int add(ShopCollect collect) {
        return collectMapper.insertSelective(collect);
    }
}

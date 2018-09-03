package manman.pro.db.service;

import com.github.pagehelper.PageHelper;
import manman.pro.db.dao.ShopFootprintMapper;
import manman.pro.db.domain.ShopFootprint;
import manman.pro.db.domain.ShopFootprintExample;
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
public class ShopFootprintService {


    @Autowired
    private ShopFootprintMapper footprintMapper;

    public void add(ShopFootprint footprint) {
        footprintMapper.insertSelective(footprint);
    }

    public ShopFootprint findById(Integer id) {
        return footprintMapper.selectByPrimaryKey(id);
    }

    public void deleteById(Integer id) {
        footprintMapper.logicalDeleteByPrimaryKey(id);
    }

    public List<ShopFootprint> queryByAddTime(Integer userId, Integer page, Integer size) {
        ShopFootprintExample example = new ShopFootprintExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        example.setOrderByClause(ShopFootprint.Column.addTime.desc());
        PageHelper.startPage(page, size);
        return footprintMapper.selectByExample(example);
    }

    public int countByAddTime(Integer userId, Integer page, Integer size) {
        ShopFootprintExample example = new ShopFootprintExample();
        example.or().andUserIdEqualTo(userId).andDeletedEqualTo(false);
        return (int)footprintMapper.countByExample(example);
    }
}

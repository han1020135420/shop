package manman.pro.db.service;

import manman.pro.db.dao.ShopRegionMapper;
import manman.pro.db.domain.ShopRegion;
import manman.pro.db.domain.ShopRegionExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 15:53
 */
@Service
public class ShopRegionService {
    @Autowired
    private ShopRegionMapper regionMapper;

    public List<ShopRegion> queryByPid(Integer parentId) {
        ShopRegionExample example = new ShopRegionExample();
        example.or().andPidEqualTo(parentId);
        return regionMapper.selectByExample(example);
    }

    public ShopRegion findById(Integer id) {
        return regionMapper.selectByPrimaryKey(id);
    }
}

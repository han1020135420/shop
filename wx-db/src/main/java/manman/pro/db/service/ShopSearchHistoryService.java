package manman.pro.db.service;

import manman.pro.db.dao.ShopSearchHistoryMapper;
import manman.pro.db.domain.ShopSearchHistory;
import manman.pro.db.domain.ShopSearchHistoryExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 13:28
 */
@Service
public class ShopSearchHistoryService {
    @Autowired
    private ShopSearchHistoryMapper searchHistoryMapper;

    public void save(ShopSearchHistory searchHistory) {
        searchHistoryMapper.insertSelective(searchHistory);
    }

    public List<ShopSearchHistory> queryByUid(Integer uid) {
        ShopSearchHistoryExample example = new ShopSearchHistoryExample();
        example.or().andUserIdEqualTo(uid).andDeletedEqualTo(false);
        example.setDistinct(true);
        return searchHistoryMapper.selectByExampleSelective(example, ShopSearchHistory.Column.keyword);
    }

    public void deleteByUid(Integer uid) {
        ShopSearchHistoryExample example = new ShopSearchHistoryExample();
        example.or().andUserIdEqualTo(uid);
        searchHistoryMapper.logicalDeleteByExample(example);
    }
}

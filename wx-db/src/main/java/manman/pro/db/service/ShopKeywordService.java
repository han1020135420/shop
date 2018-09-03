package manman.pro.db.service;

import com.github.pagehelper.PageHelper;
import manman.pro.db.dao.ShopKeywordMapper;
import manman.pro.db.domain.ShopKeyword;
import manman.pro.db.domain.ShopKeywordExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 17:34
 */
@Service
public class ShopKeywordService {
    @Autowired
    private ShopKeywordMapper keywordsMapper;
    public ShopKeyword queryDefault() {
        ShopKeywordExample example = new ShopKeywordExample();
        example.or().andIsDefaultEqualTo(true).andDeletedEqualTo(false);
        return keywordsMapper.selectOneByExample(example);
    }

    public List<ShopKeyword> queryHots() {
        ShopKeywordExample example = new ShopKeywordExample();
        example.or().andIsHotEqualTo(true).andDeletedEqualTo(false);
        return keywordsMapper.selectByExample(example);
    }

    public List<ShopKeyword> queryByKeyword(String keyword, Integer page, Integer size) {
        ShopKeywordExample example = new ShopKeywordExample();
        example.setDistinct(true);
        example.or().andKeywordLike("%" + keyword + "%").andDeletedEqualTo(false);
        PageHelper.startPage(page, size);
        return keywordsMapper.selectByExampleSelective(example, ShopKeyword.Column.keyword);
    }
}

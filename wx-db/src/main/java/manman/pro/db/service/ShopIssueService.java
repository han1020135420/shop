package manman.pro.db.service;

import manman.pro.db.dao.ShopIssueMapper;
import manman.pro.db.domain.ShopIssue;
import manman.pro.db.domain.ShopIssueExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 13:08
 */
@Service
public class ShopIssueService {

    @Autowired
    private ShopIssueMapper issueMapper;

    public List<ShopIssue> query() {
        ShopIssueExample example = new ShopIssueExample();
        example.or().andDeletedEqualTo(false);
        return issueMapper.selectByExample(example);
    }
}

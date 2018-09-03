package manman.pro.db.service;

import com.github.pagehelper.PageHelper;
import manman.pro.db.dao.ShopTopicMapper;
import manman.pro.db.domain.ShopTopic;
import manman.pro.db.domain.ShopTopicExample;
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
public class ShopTopicService {
    @Autowired
    private ShopTopicMapper topicMapper;


    public List<ShopTopic> queryList(int offset, int limit) {
        ShopTopicExample example = new ShopTopicExample();
        example.or().andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return topicMapper.selectByExampleWithBLOBs(example);
    }

    public int queryTotal() {
        ShopTopicExample example = new ShopTopicExample();
        example.or().andDeletedEqualTo(false);
        return (int)topicMapper.countByExample(example);
    }

    public ShopTopic findById(Integer id) {
        ShopTopicExample example = new ShopTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        return topicMapper.selectOneByExampleWithBLOBs(example);
    }

    public List<ShopTopic> queryRelatedList(Integer id, int offset, int limit) {
        ShopTopicExample example = new ShopTopicExample();
        example.or().andIdEqualTo(id).andDeletedEqualTo(false);
        List<ShopTopic> topics = topicMapper.selectByExample(example);
        if(topics.size() == 0){
            return queryList(offset, limit);
        }
        ShopTopic topic = topics.get(0);

        example = new ShopTopicExample();
        example.or().andIdNotEqualTo(topic.getId()).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        List<ShopTopic> relateds = topicMapper.selectByExampleWithBLOBs(example);
        if(relateds.size() != 0){
            return relateds;
        }

        return queryList(offset, limit);
    }
}

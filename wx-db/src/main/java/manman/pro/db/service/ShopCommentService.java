package manman.pro.db.service;

import com.github.pagehelper.PageHelper;
import manman.pro.db.dao.ShopCommentMapper;
import manman.pro.db.domain.ShopComment;
import manman.pro.db.domain.ShopCommentExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-06-30 13:10
 */
@Service
public class ShopCommentService {

    @Autowired
    private ShopCommentMapper commentMapper;

    public List<ShopComment> queryGoodsByGid(Integer id, int offset, int limit) {
        ShopCommentExample example = new ShopCommentExample();
        example.setOrderByClause(ShopComment.Column.addTime.desc());
        example.or().andValueIdEqualTo(id).andTypeIdEqualTo((byte)0).andDeletedEqualTo(false);
        PageHelper.startPage(offset, limit);
        return commentMapper.selectByExample(example);
    }

    public int countGoodsByGid(Integer id, int offset, int limit) {
        ShopCommentExample example = new ShopCommentExample();
        example.or().andValueIdEqualTo(id).andTypeIdEqualTo((byte)0).andDeletedEqualTo(false);
        return (int)commentMapper.countByExample(example);
    }

    public int save(ShopComment comment) {
        return commentMapper.insertSelective(comment);
    }

    public int count(Byte typeId, Integer valueId, int showType, int offset, int size) {
        ShopCommentExample example = new ShopCommentExample();
        if(showType == 0) {
            example.or().andValueIdEqualTo(valueId).andTypeIdEqualTo(typeId).andDeletedEqualTo(false);
        }
        else if(showType == 1){
            example.or().andValueIdEqualTo(valueId).andTypeIdEqualTo(typeId).andHasPictureEqualTo(true).andDeletedEqualTo(false);
        }
        else{
            Assert.state(false, "");
        }
        return (int)commentMapper.countByExample(example);
    }

    public List<ShopComment> query(Byte typeId, Integer valueId, Integer showType, Integer offset, Integer limit) {
        ShopCommentExample example = new ShopCommentExample();
        example.setOrderByClause(ShopComment.Column.addTime.desc());
        if(showType == 0) {
            example.or().andValueIdEqualTo(valueId).andTypeIdEqualTo(typeId).andDeletedEqualTo(false);
        }
        else if(showType == 1){
            example.or().andValueIdEqualTo(valueId).andTypeIdEqualTo(typeId).andHasPictureEqualTo(true).andDeletedEqualTo(false);
        }
        else{
            Assert.state(false, "showType不支持");
        }
        PageHelper.startPage(offset, limit);
        return commentMapper.selectByExample(example);
    }
}

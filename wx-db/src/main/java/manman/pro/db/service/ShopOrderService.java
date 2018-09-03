package manman.pro.db.service;

import manman.pro.db.dao.ShopOrderMapper;
import manman.pro.db.domain.ShopOrder;
import manman.pro.db.domain.ShopOrderExample;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-08-15 14:35
 */
@Service
public class ShopOrderService {
    @Resource
    private ShopOrderMapper orderMapper;

    // TODO 这里应该产生一个唯一的订单，但是实际上这里仍然存在两个订单相同的可能性
    public String generateOrderSn(Integer userId) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyyMMdd");
        String now = df.format(LocalDate.now());
        String orderSn = now + getRandomNum(6);
        while(countByOrderSn(userId, orderSn) != 0){
            orderSn = getRandomNum(6);
        }
        return orderSn;
    }

    public int add(ShopOrder order) {
        return orderMapper.insertSelective(order);
    }

    private String getRandomNum(Integer num) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < num; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }
    public int countByOrderSn(Integer userId, String orderSn){
        ShopOrderExample example = new ShopOrderExample();
        example.or().andUserIdEqualTo(userId).andOrderSnEqualTo(orderSn).andDeletedEqualTo(false);
        return (int)orderMapper.countByExample(example);
    }

    public ShopOrder findById(Integer orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }

    public void updateById(ShopOrder order) {
        orderMapper.updateByPrimaryKeySelective(order);
    }

    public int update(ShopOrder order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    public List<ShopOrder> queryByOrderStatus(Integer userId, List<Short> orderStatus) {
        ShopOrderExample example = new ShopOrderExample();
        example.orderBy(ShopOrder.Column.addTime.desc());
        ShopOrderExample.Criteria criteria = example.or();
        criteria.andUserIdEqualTo(userId);
        if(orderStatus != null) {
            criteria.andOrderStatusIn(orderStatus);
        }
        criteria.andDeletedEqualTo(false);
        return orderMapper.selectByExample(example);
    }

    public int countByOrderStatus(Integer userId, List<Short> orderStatus) {
        ShopOrderExample example = new ShopOrderExample();
        ShopOrderExample.Criteria criteria = example.or();
        criteria.andUserIdEqualTo(userId);
        if(orderStatus != null) {
            criteria.andOrderStatusIn(orderStatus);
        }
        criteria.andDeletedEqualTo(false);
        return (int)orderMapper.countByExample(example);
    }

    public ShopOrder findBySn(String orderSn) {
        ShopOrderExample example = new ShopOrderExample();
        example.or().andOrderSnEqualTo(orderSn).andDeletedEqualTo(false);
        return orderMapper.selectOneByExample(example);
    }

    public void deleteById(Integer id) {
        orderMapper.logicalDeleteByPrimaryKey(id);
    }
}

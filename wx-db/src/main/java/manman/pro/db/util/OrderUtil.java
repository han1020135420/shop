package manman.pro.db.util;

import manman.pro.db.domain.ShopOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author hanpeng
 * @create 2018-08-15 14:38
 */
public class OrderUtil {
    public static final Short STATUS_CREATE = 101;
    public static final Short STATUS_PAY = 201;
    public static final Short STATUS_SHIP = 301;
    public static final Short STATUS_CONFIRM = 401;
    public static final Short STATUS_CANCEL = 102;
    public static final Short STATUS_AUTO_CANCEL = 103;
    public static final Short STATUS_REFUND = 202;
    public static final Short STATUS_REFUND_CONFIRM = 203;
    public static final Short STATUS_AUTO_CONFIRM = 402;


    public static String orderStatusText(ShopOrder order) {
        int status = order.getOrderStatus().intValue();

        if (status == 101) {
            return "未付款";
        }

        if (status == 102) {
            return "已取消";
        }

        if (status == 103) {
            return "已取消(系统)";
        }

        if (status == 201) {
            return "已付款";
        }

        if (status == 202) {
            return "订单取消，退款中";
        }

        if (status == 203) {
            return "已退款";
        }

        if (status == 301) {
            return "已发货";
        }

        if (status == 401) {
            return "已收货";
        }

        if (status == 402) {
            return "已收货(系统)";
        }

        throw new IllegalStateException("orderStatus不支持");
    }


    public static OrderHandleOption build(ShopOrder order){
        int status = order.getOrderStatus().intValue();
        OrderHandleOption handleOption = new OrderHandleOption();

        if (status == 101) {
            // 如果订单没有被取消，且没有支付，则可支付，可取消
            handleOption.setCancel(true);
            handleOption.setPay(true);
        }
        else if (status == 102 || status == 103) {
            // 如果订单已经取消或是已完成，则可删除
            handleOption.setDelete(true);
        }
        else if (status == 201) {
            // 如果订单已付款，没有发货，则可退款
            handleOption.setRefund(true);
        }
        else if (status == 202) {
            // 如果订单申请退款中，没有相关操作
        }
        else if (status == 203) {
            // 如果订单已经退款，则可删除
            handleOption.setDelete(true);
        }
        else if (status == 301) {
            // 如果订单已经发货，没有收货，则可收货操作,
            // 此时不能取消订单
            handleOption.setConfirm(true);
        }
        else if (status ==  401 || status == 402) {
            // 如果订单已经支付，且已经收货，则可删除、去评论和再次购买
            handleOption.setDelete(true);
            handleOption.setComment(true);
            handleOption.setRebuy(true);
        }
        else {
            throw new IllegalStateException("status不支持");
        }

        return handleOption;
    }

    public static List<Short> orderStatus(Integer showType){
        // 全部订单
        if (showType == 0) {
            return null;
        }

        List<Short> status = new ArrayList<Short>(2);

        if (showType.equals(1)) {
            // 待付款订单
            status.add((short)101);
        }
        else if (showType.equals(2)) {
            // 待发货订单
            status.add((short)201);
        }
        else if (showType.equals(3)) {
            // 待收货订单
            status.add((short)301);
        }
        else if (showType.equals(4)) {
            // 待评价订单
            status.add((short)401);
//            系统超时自动取消，此时应该不支持评价
//            status.add((short)402);
        }
        else {
            return null;
        }

        return status;
    }


    public static boolean isCreateStatus(ShopOrder shopOrder) {
        return OrderUtil.STATUS_CREATE == shopOrder.getOrderStatus().shortValue();
    }

    public static boolean isPayStatus(ShopOrder shopOrder) {
        return OrderUtil.STATUS_PAY == shopOrder.getOrderStatus().shortValue();
    }

    public static boolean isShipStatus(ShopOrder shopOrder) {
        return OrderUtil.STATUS_SHIP == shopOrder.getOrderStatus().shortValue();
    }

    public static boolean isConfirmStatus(ShopOrder shopOrder) {
        return OrderUtil.STATUS_CONFIRM == shopOrder.getOrderStatus().shortValue();
    }

    public static boolean isCancelStatus(ShopOrder shopOrder) {
        return OrderUtil.STATUS_CANCEL == shopOrder.getOrderStatus().shortValue();
    }

    public static boolean isAutoCancelStatus(ShopOrder shopOrder) {
        return OrderUtil.STATUS_AUTO_CANCEL == shopOrder.getOrderStatus().shortValue();
    }

    public static boolean isRefundStatus(ShopOrder shopOrder) {
        return OrderUtil.STATUS_REFUND == shopOrder.getOrderStatus().shortValue();
    }

    public static boolean isRefundConfirmStatus(ShopOrder shopOrder) {
        return OrderUtil.STATUS_REFUND_CONFIRM == shopOrder.getOrderStatus().shortValue();
    }

    public static boolean isAutoConfirmStatus(ShopOrder shopOrder) {
        return OrderUtil.STATUS_AUTO_CONFIRM == shopOrder.getOrderStatus().shortValue();
    }
}

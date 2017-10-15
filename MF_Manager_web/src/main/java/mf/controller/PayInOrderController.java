package mf.controller;

import MF_Utils.IDUtils;
import MF_Utils.JpushClientUtil;
import MF_Utils.Result;
import mf.mapper.*;
import mf.pojo.*;
import mf.service.CommodityService;
import mf.service.PayInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Controller
public class PayInOrderController{
    @Autowired
    PayInOrderService payInOrderService;
    @Autowired
    PayInOrderDetailMapper payInOrderDetailMapper;
    @Autowired
    CommodityService commodityService;
    @Autowired
    DesignerMapper designerMapper;
    @Autowired
    DesignerWalletMapper designerWalletMapper;
    @Autowired
    PayLogMapper payLogMapper;
    @Autowired
    ShopcategoriesMapper shopcategoriesMapper;
    @Autowired
    ShopMapper shopMapper;
    @Autowired
    UserCenterMapper userCenterMapper;
//    @RequestMapping("/pay/creat")
//    @ResponseBody
//    public Result creat(long userId,Integer[] servicesId,long desigerId,long[] commodityIds,int style){
//        PayInOrder payInOrder=new PayInOrder();
//        payInOrder.setCtime(new Date());
//        payInOrder.setPayInOrderId(IDUtils.getUserId());
//        if (style!=0&0<style&style<3){
//            payInOrder.setPayVendorId((long) style);
//        }
//        double amount = 0;
//        /**
//         * 计算设计师的价格
//         */
//        for (int i = 0; i <servicesId.length; i++) {
//            PayInOrderDetail payInOrderDetail=new PayInOrderDetail();
//            payInOrderDetail.setPayInOrderDetailId(IDUtils.getUserId());
//            payInOrderDetail.setProductId(desigerId);
//            payInOrderDetail.setPayInOrderId(payInOrder.getPayInOrderId());
//            payInOrderDetail.setProductCount(1);
//            Byte a=1;
//            payInOrderDetail.setType(a);
//            Designer designer=designerMapper.selectByPrimaryKey(desigerId);
//            if(servicesId[i]==1){
//                payInOrderDetail.setProductName("剪发");
//                payInOrderDetail.setProductPrice(designer.getHaircut());
//                BigDecimal d1 = new BigDecimal(payInOrderDetail.getProductPrice()+"");
//                BigDecimal d2 = new BigDecimal(payInOrderDetail.getProductCount()+"");
//                payInOrderDetail.setProductSubtotal(d1.multiply(d2).doubleValue());
//            }else if(servicesId[i]==2){
//                payInOrderDetail.setProductName("烫染");
//                payInOrderDetail.setProductPrice(designer.getHotDyed());
//                BigDecimal d1 = new BigDecimal(payInOrderDetail.getProductPrice()+"");
//                BigDecimal d2 = new BigDecimal(payInOrderDetail.getProductCount()+"");
//                payInOrderDetail.setProductSubtotal(d1.multiply(d2).doubleValue());
//            }else if(servicesId[i]==3){
//                payInOrderDetail.setProductName("美妆");
//                payInOrderDetail.setProductPrice(designer.getMakeups());
//                BigDecimal d1 = new BigDecimal(payInOrderDetail.getProductPrice()+"");
//                BigDecimal d2 = new BigDecimal(payInOrderDetail.getProductCount()+"");
//                payInOrderDetail.setProductSubtotal(d1.multiply(d2).doubleValue());
//            }
//            payInOrderDetailMapper.insertSelective(payInOrderDetail);
//            amount=amount+payInOrderDetail.getProductSubtotal();
//        }
//        /**
//         * 计算店铺服务的价格
//         */
//        for (int i = 0; i <commodityIds.length; i++) {
//            PayInOrderDetail payInOrderDetail = new PayInOrderDetail();
//            payInOrderDetail.setPayInOrderId(payInOrder.getPayInOrderId());
//            payInOrderDetail.setPayInOrderDetailId(IDUtils.getUserId());
//            payInOrderDetail.setProductCount(1);
//            Byte a = 2;
//            payInOrderDetail.setType(a);
//            payInOrderDetail.setProductId(commodityIds[i]);
//            Commodity commodity = commodityService.selectByPrimaryKey(payInOrderDetail.getProductId());
//            payInOrderDetail.setProductName(commodity.getCommodityName());
//            payInOrderDetail.setProductPrice(commodity.getPrice());
//            BigDecimal d1 = new BigDecimal(payInOrderDetail.getProductPrice() + "");
//            BigDecimal d2 = new BigDecimal(payInOrderDetail.getProductCount() + "");
//            payInOrderDetail.setProductSubtotal(d1.multiply(d2).doubleValue());
//            payInOrderDetailMapper.insertSelective(payInOrderDetail);
//            amount = amount + payInOrderDetail.getProductSubtotal();
//        }
//        payInOrder.setAmount(amount);
//        payInOrder.setUserId(userId);
//        payInOrderService.insertSelective(payInOrder);
//        return Result.ok();
//    }
    @RequestMapping("/pay/update")
    @ResponseBody
    public Result update(long payInOrderId,Byte status){
        PayInOrder payInOrder=payInOrderService.selectByPrimaryKey(payInOrderId);
        if(payInOrder.getStatus()!=4){
            payInOrder.setStatus(status);
            PayLog payLog=new PayLog();
            payLog.setLogId(IDUtils.getUserId());
            payLog.setPayInOrderId(payInOrderId);
            payLog.setTime(new Date());
            payInOrderService.updateByPrimaryKeySelective(payInOrder);
            if (status==2){
                payLog.setMsg("设计师已确认，等待服务");
            }else if(status==3){
                payLog.setMsg("服务完成，设计师已确认");
            }else if (status==4){
                payLog.setMsg("用户已确认，订单完成");
            }
            payLogMapper.insert(payLog);
            /**
             * 订单完成
             */
            if(payInOrder.getStatus()==4){
                PayInOrderDetailExample payInOrderDetailExample=new PayInOrderDetailExample();
                payInOrderDetailExample.or().andPayInOrderIdEqualTo(payInOrder.getPayInOrderId());
                payInOrderDetailExample.or().andTypeEqualTo((byte)1);
                List<PayInOrderDetail> payInOrderDetailList=payInOrderDetailMapper.selectByExample(payInOrderDetailExample);
                double amount = 0;
                for (int i = 0; i <payInOrderDetailList.size() ; i++) {
                    if(payInOrderDetailList.get(i).getType()==1){
                        BigDecimal a1 = new BigDecimal(Double.toString(amount));
                        BigDecimal a2 = new BigDecimal(Double.toString(payInOrderDetailList.get(i).getProductSubtotal()));
                        amount=a1.add(a2).doubleValue();
                    }
                }
                DesignerWallet designerWallet=designerWalletMapper.selectByPrimaryKey(payInOrderDetailList.get(0).getProductId());
                BigDecimal b1 = new BigDecimal(Double.toString(amount));
                BigDecimal b2 = new BigDecimal(Double.toString(designerWallet.getIncomeCount()));
                double inCount=b1.add(b2).doubleValue();
                designerWallet.setIncomeCount(inCount);
                BigDecimal c1 = new BigDecimal(Double.toString(designerWallet.getBalance()));
                designerWallet.setBalance(b1.add(c1).doubleValue());
                designerWalletMapper.updateByPrimaryKeySelective(designerWallet);
            }
        }
        return Result.ok();
    }
    @RequestMapping("/pay/example")
    @ResponseBody
    public Result example(long userId,Byte state){
        PayInOrderExample payInOrderExample=new PayInOrderExample();
        payInOrderExample.or().andUserIdEqualTo(userId);
        payInOrderExample.or().andStatusEqualTo(state);
        List<PayInOrder> payInOrders=payInOrderService.selectByExample(payInOrderExample);
        for (int i = 0; i <payInOrders.size() ; i++) {
            List<PayInOrderDetail> payInOrderDetails=payInOrders.get(i).getPayInOrderDetailList();
            for (int j = 0; j <payInOrderDetails.size() ; j++) {
                if(payInOrderDetails.get(j).getType()==1){
                    if(payInOrders.get(i).getDesignerImage()==null){
                        Designer designer=designerMapper.selectByPrimaryKey(payInOrderDetails.get(j).getProductId());
                        payInOrders.get(i).setDesignerImage(designer.getHeadPath());
                    }
                }else if(payInOrderDetails.get(j).getType()==2){
                    if(payInOrders.get(i).getShopImage()==null){
                        Commodity commodity=commodityService.selectByPrimaryKey(payInOrderDetails.get(j).getProductId());
                        Shopcategories shopcategories=shopcategoriesMapper.selectByPrimaryKey(commodity.getCategoriesId());
                        Shop shop=shopMapper.selectByPrimaryKey(shopcategories.getShopId());
                        payInOrders.get(i).setShopImage(shop.getThumbnails());
                    }
                }
            }
        }
        return Result.ok(payInOrders);
    }
    @RequestMapping("/pay/primarykey")
    @ResponseBody
    public Result primarykey(Long payInOrderId){
        PayInOrder payInOrder=payInOrderService.selectByPrimaryKey(payInOrderId);
        return Result.ok(payInOrder);
    }

    @RequestMapping("/pay/timeChange")
    @ResponseBody
    public Result timeChange(Long payInOrderId,Integer timeSlot,String ordertime){
        JpushClientUtil jpushClientUtil=new JpushClientUtil();
        PayInOrder payInOrder=payInOrderService.selectByPrimaryKey(payInOrderId);
        if(payInOrder.getStatus()!=3&payInOrder.getStatus()!=4){
            payInOrder.setOrdertime(ordertime);
            payInOrder.setTimeSlot(timeSlot);
            payInOrder.setStatus((byte) 5);
        }
        payInOrderService.insertSelective(payInOrder);
        PayInOrderDetailExample payInOrderDetailExample=new PayInOrderDetailExample();
        payInOrderDetailExample.or().andPayInOrderIdEqualTo(payInOrderId);
        List<PayInOrderDetail> payInOrderDetails= payInOrderDetailMapper.selectByExample(payInOrderDetailExample);
        String alias=null;
        for (int i = 0; i < payInOrderDetails.size(); i++) {
            if(payInOrderDetails.get(i).getType()==1){
                if(alias==null){
                    alias=payInOrderDetails.get(i).getProductId().toString();
                }
            }
        }
        String time=null;
        if(timeSlot==1){
            time="9:00-12:00";
        }else if(timeSlot==2){
            time="14:00-17:00";
        }else if(timeSlot==3){
            time="18:00-21:00";
        }
        String notification_title="预约时间修改";
        String msg_title="用户申请修改预约时间";
        String msg_content="用户将预约时间修改为："+time;
        String extrasparam=null;
        jpushClientUtil.sendToAlias(alias,notification_title,msg_title,msg_content,extrasparam);
        return Result.ok();
    }
    @RequestMapping("/pay/refund")
    @ResponseBody
    public Result refund(Long payInOrderId,Byte status){
        JpushClientUtil jpushClientUtil=new JpushClientUtil();
        PayInOrder payInOrder=payInOrderService.selectByPrimaryKey(payInOrderId);
        if(payInOrder.getStatus()!=3&payInOrder.getStatus()!=4){
            payInOrder.setStatus(status);
        }
        payInOrderService.insertSelective(payInOrder);
        PayInOrderDetailExample payInOrderDetailExample=new PayInOrderDetailExample();
        payInOrderDetailExample.or().andPayInOrderIdEqualTo(payInOrderId);
        List<PayInOrderDetail> payInOrderDetails= payInOrderDetailMapper.selectByExample(payInOrderDetailExample);
        String alias=null;
        for (int i = 0; i < payInOrderDetails.size(); i++) {
            if(payInOrderDetails.get(i).getType()==1){
                if(alias==null){
                    alias=payInOrderDetails.get(i).getProductId().toString();
                }
            }
        }
        UserCenter userCenter=userCenterMapper.selectByPrimaryKey(payInOrder.getUserId());
        String notification_title="退款申请";
        String msg_title="用户申请退款";
        String msg_content=userCenter.getNickname()+"申请退款，等待确认";
        String extrasparam=null;
        jpushClientUtil.sendToAlias(alias,notification_title,msg_title,msg_content,extrasparam);
        return Result.ok();
    }
}

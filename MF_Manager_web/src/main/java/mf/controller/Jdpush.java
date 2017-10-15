package mf.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import MF_Utils.JpushClientUtil;

@Controller
public class Jdpush {

	JpushClientUtil JpushClientUtil=new JpushClientUtil();
    /**
     * 推送给设备标识参数的用户
     * @param alias 设备别名
     * @param notification_title 通知内容标题
     * @param msg_title 消息内容标题
     * @param msg_content 消息内容
     * @param extrasparam 扩展字段
     * @return 0推送失败，1推送成功
     */
    @RequestMapping("/jpush/alias")
    @ResponseBody
    public int sendToAlias(String alias,String notification_title, String msg_title, String msg_content, String extrasparam){
        int state=JpushClientUtil.sendToAlias(alias,notification_title,msg_title,msg_content,extrasparam);
        return state;
    }

    /**
     * 推送给设备RegistrationId参数的用户
     * @param registrationId 设备标识
     * @param notification_title 通知内容标题
     * @param msg_title 消息内容标题
     * @param msg_content 消息内容
     * @param extrasparam 扩展字段
     * @return 0推送失败，1推送成功
     */
    @RequestMapping("/jpush/make")
    @ResponseBody
    public int sendToRegistrationId(String registrationId,String notification_title, String msg_title, String msg_content, String extrasparam){
        int state=JpushClientUtil.sendToRegistrationId(registrationId,notification_title,msg_title,msg_content,extrasparam);
        return state;
    }
    /**
     * 发送给所有安卓用户
     * @param notification_title 通知内容标题
     * @param msg_title 消息内容标题
     * @param msg_content 消息内容
     * @param extrasparam 扩展字段
     * @return 0推送失败，1推送成功
     */
    @RequestMapping("/jpush/android")
    @ResponseBody
    public int sendToAllAndroid(String notification_title, String msg_title, String msg_content, String extrasparam){
        int state=JpushClientUtil.sendToAllAndroid(notification_title,msg_title,msg_content,extrasparam);
        return state;
    }
    /**
     * 发送给所有IOS用户
     * @param notification_title 通知内容标题
     * @param msg_title 消息内容标题
     * @param msg_content 消息内容
     * @param extrasparam 扩展字段
     * @return 0推送失败，1推送成功
     */
    @RequestMapping("/jpush/ios")
    @ResponseBody
    public int sendToAllIos(String notification_title, String msg_title, String msg_content, String extrasparam){
        int state=JpushClientUtil.sendToAllIos(notification_title, msg_title, msg_content, extrasparam);
        return state;
    }
    /**
     * 发送给所有用户
     * @param notification_title 通知内容标题
     * @param msg_title 消息内容标题
     * @param msg_content 消息内容
     * @param extrasparam 扩展字段
     * @return 0推送失败，1推送成功
     */
   @RequestMapping("/jpush/all")
    @ResponseBody
    public int sendToAll( String notification_title, String msg_title, String msg_content, String extrasparam){
        int state=JpushClientUtil.sendToAll(notification_title, msg_title, msg_content, extrasparam);
        return state;
    }
}

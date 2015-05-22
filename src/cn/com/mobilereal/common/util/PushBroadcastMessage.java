package cn.com.mobilereal.common.util;

import com.baidu.yun.channel.auth.ChannelKeyPair;
import com.baidu.yun.channel.client.BaiduChannelClient;
import com.baidu.yun.channel.exception.ChannelClientException;
import com.baidu.yun.channel.exception.ChannelServerException;
import com.baidu.yun.channel.model.PushBroadcastMessageRequest;
import com.baidu.yun.channel.model.PushBroadcastMessageResponse;
import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;

public class PushBroadcastMessage {
    
    private PushBroadcastMessage(){}
    
    public static PushBroadcastMessage pushBroadcastMessage = null;
    
    public static PushBroadcastMessage getInstance(){
        if (pushBroadcastMessage == null){
            pushBroadcastMessage = new PushBroadcastMessage();
        }
        return pushBroadcastMessage;
    }
    /**
     * <p>Description: 群发</p>
     * @param title 发送的内容
     */
    public  void pushBroadcast(String title)
    {
         /*
         * @brief 推送单播通知(Android Push SDK拦截并解析) message_type = 1 (默认为0)
         */
        // 1. 设置developer平台的ApiKey/SecretKey
        ChannelKeyPair pair = new ChannelKeyPair(ConfigInfo.getInstance().getApikey(), 
                ConfigInfo.getInstance().getSecretkey());
        // 2. 创建BaiduChannelClient对象实例
        BaiduChannelClient channelClient = new BaiduChannelClient(pair);
        // 3. 若要了解交互细节，请注册YunLogHandler类
        channelClient.setChannelLogHandler(new YunLogHandler() {
            public void onHandle(YunLogEvent event) {
                System.out.println(event.getMessage());
            }
        });
        try {
            // 4. 创建请求类对象
            PushBroadcastMessageRequest request = new PushBroadcastMessageRequest();
            PushBroadcastMessageRequest requestI = new PushBroadcastMessageRequest();
            //request.setDeviceType(3); // device_type => 1: web 2: pc 3:android
                                      // 4:ios 5:wp
            request.setDeviceType(3);
            requestI.setDeviceType(4);
            //
            
            // 若要通知
             request.setMessageType(1);
             //request.setMessage("{\"title\":\"GD\",\"description\":\""+ title +"\",\"custom_content\":{\"type\":\""+pushType+"\"}}");
             request.setMessage("{\"title\":\"GD\",\"description\":\""+ title +"\"");
             //requestI.setDeployStatus(1);// DeployStatus => 1: Developer   2: Production
             requestI.setDeployStatus(2);
             requestI.setMessageType(1);
             //requestI.setMessage("{\"title\":\"GD\",\"description\":\""+ title +"\",\"type\":\""+pushType+"\"}");
             requestI.setMessage("{\"title\":\"GD\",\"description\":\""+ title +"\"");
            // 5. 调用pushMessage接口
            PushBroadcastMessageResponse response = channelClient
                    .pushBroadcastMessage(request);
           
            PushBroadcastMessageResponse responseI = channelClient
                    .pushBroadcastMessage(requestI);
            
            // 6. 认证推送成功
            System.out.println("push amount : " + response.getSuccessAmount());
            System.out.println("pushI amount : " + responseI.getSuccessAmount());
            
        } catch (ChannelClientException e) {
            // 处理客户端错误异常
            e.printStackTrace();
        } catch (ChannelServerException e) {
            // 处理服务端错误异常
            System.out.println(String.format(
                    "request_id: %d, error_code: %d, error_message: %s",
                    e.getRequestId(), e.getErrorCode(), e.getErrorMsg()));
        }
    }

}

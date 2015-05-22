package cn.com.mobilereal.common.util;

import com.baidu.yun.channel.auth.ChannelKeyPair;
import com.baidu.yun.channel.client.BaiduChannelClient;
import com.baidu.yun.channel.exception.ChannelClientException;
import com.baidu.yun.channel.exception.ChannelServerException;
import com.baidu.yun.channel.model.PushUnicastMessageRequest;
import com.baidu.yun.channel.model.PushUnicastMessageResponse;
import com.baidu.yun.core.log.YunLogEvent;
import com.baidu.yun.core.log.YunLogHandler;

public class PushUnicastMessage {
    public PushUnicastMessage(){}
    
    public static PushUnicastMessage message = null;
    
    public static PushUnicastMessage getInstance(){
        if (message == null){
            message = new PushUnicastMessage();
        }
        return message;
    }

    /**
     * <p>Description: 单发</p>
     * @param channelId 百度channelId
     * @param userId 百度userId
     * @param title 推送的内容
     * @param deviceType 设备号 A 标识 Android I 标识ios
     */
    public  void PushUnicast(long channelId,String userId,String title,String deviceType)
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
            //request.setDeviceType(3); // device_type => 1: web 2: pc 3:android
            // 4:ios 5:wp
            if("A".equalsIgnoreCase(deviceType))
            {
                PushUnicastMessageRequest request = new PushUnicastMessageRequest();
                request.setDeviceType(3);
                request.setChannelId(channelId);
                request.setUserId(userId);
                // 若要通知
                request.setMessageType(1);
                //request.setMessage("{\"title\":\"GD\",\"description\":\""+ title +"\",\"custom_content\":{\"type\":\""+pushType+"\"}}");
                request.setMessage("{\"title\":\"GD\",\"description\":\""+ title +"\"");
                // 5. 调用pushMessage接口
                PushUnicastMessageResponse response = channelClient
                       .pushUnicastMessage(request);
                // 6. 认证推送成功
                System.out.println("pushUnicast amount : " + response.getSuccessAmount());
            }else
            {
                PushUnicastMessageRequest requestI = new PushUnicastMessageRequest();
                requestI.setDeviceType(4);
                requestI.setChannelId(channelId);
                requestI.setUserId(userId);
                //requestI.setDeployStatus(1);// DeployStatus => 1: Developer   2: Production
                requestI.setDeployStatus(2);
                requestI.setMessageType(1);
                //requestI.setMessage("{\"title\":\"GD\",\"description\":\""+ title +"\",\"type\":\""+pushType+"\"}");
                requestI.setMessage("{\"title\":\"GD\",\"description\":\""+ title +"\"");
                // 5. 调用pushMessage接口
                 PushUnicastMessageResponse responseI = channelClient
                        .pushUnicastMessage(requestI);
                System.out.println("pushUnicastI amount : " + responseI.getSuccessAmount());
            }
            
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

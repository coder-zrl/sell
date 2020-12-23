package com.example.sell.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author zrl
 * @date 2020-12-23 15:23
 */
@Component
@ServerEndpoint("/websocket")
@Slf4j
public class Websocket {
    private Session session;
    //    存储websocket
    private static CopyOnWriteArraySet<Websocket> webSocketSet = new CopyOnWriteArraySet<>();
    @OnOpen
    public void onOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("有新的客户端连接，当前总数为：{}",webSocketSet.size());
    }
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("客户端关闭，当前总数为：{}",webSocketSet.size());
    }
//    @OnError
//    public void onError() {
//        log.info("通信出错");
//    }
    @OnMessage
    public void onMessage(String message) {
        log.info("【收到消息：{}】",message);
    }
    public void sendMessage(String message) {
        for(Websocket websocket:webSocketSet) {
            log.info("【websocket广播消息，message={}】",message);
            try {
                websocket.session.getBasicRemote().sendText(message);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

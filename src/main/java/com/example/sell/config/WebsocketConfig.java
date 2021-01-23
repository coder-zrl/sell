package com.example.sell.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * @author zrl
 * @date 2020-12-28 14:11
 */
@Configuration
public class WebsocketConfig {
    public class WebSocketConfig {
        /**
         * ServerEndpointExporter 作用
         * 这个Bean会自动注册使用@ServerEndpoint注解声明的websocket endpoint
         * @return
         */
        @Bean
        public ServerEndpointExporter serverEndpointExporter() {
            return new ServerEndpointExporter();
        }
    }
}

//package com.mercury.springbootlearning.controller;
//
//import com.mercury.springbootlearning.pojo.WSMessage;
//import com.mercury.springbootlearning.pojo.WSResponse;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Controller;
//
//import java.security.Principal;
//
///**
// * 测试webSocket传输
// */
//
//@Slf4j
//@Controller
//public class WSController {
//
//    @Autowired
//    private SimpMessagingTemplate simpMessagingTemplate;
//
//    @MessageMapping("/welcome")
//    @SendTo("/topic/getResponse")
//    public WSResponse say(WSMessage message) throws InterruptedException {
//        log.info("Websocket request message:{}", message.toString());
//        Thread.sleep(5000);
//        return WSResponse.builder()
//                .responseMessage("Welcome:" + message.getName() + "!")
//                .build();
//    }
//
//    @MessageMapping("/chat")
//    public void handleChat(Principal principal, String msg) {
//        if (principal.getName().equals("mercury")) {
//            simpMessagingTemplate.convertAndSendToUser("jackMa", "/queue/notifications",
//                    principal.getName() + "-send:" + msg);
//        } else {
//            simpMessagingTemplate.convertAndSendToUser("mercury", "/queue/notifications",
//                    principal.getName() + "-send:" + msg);
//        }
//    }
//}

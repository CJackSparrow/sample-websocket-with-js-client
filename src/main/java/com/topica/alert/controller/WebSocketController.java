package com.topica.alert.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@Slf4j
public class WebSocketController {

  @MessageMapping("/lms/fullClass")
  @SendTo("/topic/lms/fullClass")
  @CrossOrigin
  public String sendToLMS(String message) throws Exception {
    log.info("Receiver Message : fullClassAlert: {}", message);
    return null;
  }

  @MessageMapping("/lms-vip/fullClass")
  @SendTo("/topic/lms-vip/fullClass")
  @CrossOrigin
  public String sendToLMSVIP(String message) throws Exception {
    log.info("Receiver Message : fullClassAlert: {}", message);
    return null;
  }
}

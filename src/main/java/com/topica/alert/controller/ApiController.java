package com.topica.alert.controller;

import com.topica.alert.model.response.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alert")
@Slf4j
public class ApiController {

  @Autowired
  private SimpMessagingTemplate webSocket;

  @Value("${app.private.key}")
  private String authKey;

  @PostMapping
  public ApiResponse sendAlert(@RequestHeader String key,
      @RequestHeader String site,
      @RequestBody Object message) {
    try {
      log.info("(sendAlert) key {}, site {}, message {}",key, site, message);
      if (!key.trim().equalsIgnoreCase(authKey.trim())) {
        log.info("(sendAlert) invalid key {}",key);
        return new ApiResponse(HttpStatus.BAD_REQUEST, "Private key not valid!");
      }
      webSocket.convertAndSend("/topic/" + site + "/fullClass", message);
      return new ApiResponse(HttpStatus.OK, "Success!");
    } catch (Exception e) {
      return new ApiResponse(HttpStatus.BAD_REQUEST, "Server Err");

    }
  }
}



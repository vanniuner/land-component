package com.land.base.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author LZJ
 **/
@Data
@Slf4j
@RestController
@NoArgsConstructor
public class Healthchecker {

    /**
     * 健康检查
     */
    @RequestMapping("/healthCheck")
    public ResponseEntity<String> welcome() {
        log.info("==== [log]: {}");
        return ResponseEntity.ok("pong");
    }

}

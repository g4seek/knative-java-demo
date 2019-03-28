/**
 * @(#)HelloworldController.java, 2019年03月28日.
 * Copyright 2019 Netease, Inc. All rights reserved.
 * NETEASE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.example.helloworld;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hzlvzimin
 */
@RestController
public class HelloworldController {

    @Value("${TARGET:World}")
    String target;

    @GetMapping("/")
    String hello() {
        return "Hello " + target + "!";
    }
}

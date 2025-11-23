package com.example.school.controller;

import com.example.school.service.SchoolInfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QueryController {

    Logger logger = LoggerFactory.getLogger(QueryController.class);

    private final ChatClient.Builder chatClientBuilder;
    private final JdbcTemplate jdbcTemplate;
    SchoolInfoService service;

    public QueryController(SchoolInfoService service, ChatClient.Builder chatClientBuilder, JdbcTemplate jdbcTemplate){
        this.service = service;
        this.chatClientBuilder = chatClientBuilder;
        this.jdbcTemplate = jdbcTemplate;

    }

    @GetMapping("/api/sql")
    public String querySql(@RequestParam String sql) {
        logger.info("Your sql is: " + sql);
        return "OK";
    }

    @GetMapping("/api/ask")
    public String queryInfo(@RequestParam String query) {
        logger.info("You asked for: " + query);
        return "OK";
    }
}

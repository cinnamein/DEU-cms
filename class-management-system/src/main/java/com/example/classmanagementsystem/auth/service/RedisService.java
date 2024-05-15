package com.example.classmanagementsystem.auth.service;

import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
public class RedisService {
    private final RedisTemplate<String, String> redisTemplate;

    /**
     * 인증번호 삭제
     *
     * @param user
     */
    public void deleteKey(String user) {
        redisTemplate.delete(user);
    }
    private void expireCode(String user) {
        redisTemplate.expire(user, 1, TimeUnit.HOURS);
    }
}

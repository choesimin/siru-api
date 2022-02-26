package com.simin.siru.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simin.siru.dto.EmpathyDeleteRequest;
import com.simin.siru.dto.EmpathyRegistRequest;
import com.simin.siru.service.EmpathyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/empathy")
public class EmpathyController {
    private final EmpathyService empathyService;

    @PostMapping()
    public void regist(@RequestBody EmpathyRegistRequest request) {
        empathyService.save(request.toEntity());
    }

    @DeleteMapping()
    public void delete(@RequestBody EmpathyDeleteRequest request) {
        empathyService.delete(request.getPostId(), request.getMemberId());
    }
}
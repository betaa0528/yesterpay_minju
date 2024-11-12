package com.yesterpay.swaggerTest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/test")
public class TestController implements TestControllerDocs {

    private final TestService testService;

    @PostMapping("/save")
    public ResponseEntity<String> testPost(@RequestBody TestEntity userInfo) {
        log.info("유저 정보 저장 컨트롤러 실행");
        try {
            testService.save(userInfo);
            return ResponseEntity.ok("유저 정보 저장 완료");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body("유저 정보 저장 실패");
        }
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<TestEntity>> testGet() {
        log.info("유저 정보 반환 컨트롤러 실행");

        try {
            List<TestEntity> testEntity = testService.findAll();
            return ResponseEntity.ok(testEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(400).body(null);
        }
    }

}
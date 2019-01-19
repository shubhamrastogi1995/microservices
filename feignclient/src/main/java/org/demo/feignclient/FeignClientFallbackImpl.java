package org.demo.feignclient;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class FeignClientFallbackImpl implements FeignInterface{

    @Override
    public ResponseEntity<Long> getId(Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(new Long(0));
    }

    @Override
    public ResponseEntity<String> getName() {
        return ResponseEntity.status(HttpStatus.OK).body("Default Fallback logic using Hystrix");
    }
}

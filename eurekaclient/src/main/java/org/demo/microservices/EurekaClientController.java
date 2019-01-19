package org.demo.microservices;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/producerservice")
public class EurekaClientController {

    @RequestMapping(value = "/id/{id}", method = { RequestMethod.GET })
    public ResponseEntity<Long> getId(@PathVariable("id") Long id) {

        return ResponseEntity.status(HttpStatus.OK).body(id);
    }

    @RequestMapping(value = "/name", method = { RequestMethod.GET })
    public ResponseEntity<String> getName() {

        return ResponseEntity.status(HttpStatus.OK).body("Shubham");
    }
}

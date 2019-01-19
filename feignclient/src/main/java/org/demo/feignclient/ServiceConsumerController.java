package org.demo.feignclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/feignservice")
public class ServiceConsumerController {

    @Autowired
    FeignInterface feignInterface;

    @RequestMapping(value = "/id/{id}", method = { RequestMethod.GET })
    public  ResponseEntity<Long> getId(@PathVariable("id") Long id){
            return this.feignInterface.getId(id);
    }

    @RequestMapping(value = "/name", method = { RequestMethod.GET })
    public ResponseEntity<String> getName() {
       return this.feignInterface.getName();
    }

}

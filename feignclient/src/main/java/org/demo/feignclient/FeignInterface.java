package org.demo.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "EUREKACLIENT" , fallback = FeignClientFallbackImpl.class)
public interface FeignInterface {

    @RequestMapping(value = "/producerservice/id/{id}", method = { RequestMethod.GET })
    public ResponseEntity<Long> getId(@PathVariable("id") Long id);

    @RequestMapping(value = "/producerservice/name", method = { RequestMethod.GET })
    public ResponseEntity<String> getName() ;

}

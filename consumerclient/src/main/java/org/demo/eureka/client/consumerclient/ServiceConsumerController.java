package org.demo.eureka.client.consumerclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/consumerservice")
public class ServiceConsumerController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/id/{id}", method = { RequestMethod.GET })
    public  ResponseEntity<Long> getId(@PathVariable("id") Long id){

        String url = "http://EUREKACLIENT/producerservice/id/{id}";
        Map<String, Long> uriParams = new HashMap<String, Long>();
        uriParams.put("id", id);
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);

        System.out.println(builder.buildAndExpand(uriParams).toUri());

        ResponseEntity<Long> response = this.restTemplate.exchange(builder.buildAndExpand(uriParams).toUri(), HttpMethod.GET, null ,Long.class);

            return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
    }

    @RequestMapping(value = "/name", method = { RequestMethod.GET })
    public ResponseEntity<String> getName() {
        ResponseEntity<String> response = this.restTemplate.exchange("http://EUREKACLIENT/producerservice/name", HttpMethod.GET,null,String.class);
        return ResponseEntity.status(HttpStatus.OK).body(response.getBody());
    }

}

package study.springmvc.http.basic.response;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import study.springmvc.http.basic.HelloData;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
//@Controller
//@ResponseBody
@RestController
public class ResponseBodyController {

    @GetMapping(value = "/response-body-string-v1")
    public void responseBodyStringV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok v1");
    }

    @GetMapping(value = "/response-body-string-v2")
    public ResponseEntity responseBodyStringV2() {
        return new ResponseEntity<>("ok v2", HttpStatus.OK);
    }

    @GetMapping(value = "/response-body-string-v3")
    //@ResponseBody
    public String responseBodyStringV3() {
        return "ok v3";
    }

    @GetMapping(value = "/response-body-json-v1")
    public ResponseEntity<HelloData> responseBodyJsonV1() {
        HelloData helloData = new HelloData();
        helloData.setUsername("hello spring1");
        helloData.setAge(33);
        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }

    @GetMapping(value = "/response-body-json-v2")
    //@ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public HelloData responseBodyJsonV2() {
        HelloData helloData = new HelloData();
        helloData.setUsername("hello spring2");
        helloData.setAge(33);
        return helloData;
    }

}

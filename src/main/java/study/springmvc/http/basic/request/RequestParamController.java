package study.springmvc.http.basic.request;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping(value = "/request-param-v1")
    public void requestParamV1(
            HttpServletRequest request,
            HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        log.info("username={}, age={}", username, age);

        response.getWriter().write("ok");
    }

    @RequestMapping(value = "/request-param-v2")
    @ResponseBody
    public String requestParamV2(
            @RequestParam("username") String username,
            @RequestParam("age") int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping(value = "/request-param-v3")
    @ResponseBody
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping(value = "/request-param-v4")
    @ResponseBody
    public String requestParamV4(
            String username,
            int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping(value = "/request-param-required")
    @ResponseBody
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) int age) {
        // int a = null -> 기본형(primitive) 안됨
        // Integer a = null -> 객체형이기 때문에 됨
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping(value = "/request-param-default")
    @ResponseBody
    public String requestParamDefault(
            @RequestParam(required = true, defaultValue = "guest") String username,
            @RequestParam(required = false, defaultValue = "-1") int age) {
        log.info("username={}, age={}", username, age);
        return "ok";
    }

    @RequestMapping(value = "/request-param-map")
    @ResponseBody
    public String requestParamMap(
            @RequestParam Map<String, Object> paramMap) {
        log.info("username={}, age={}", paramMap.get("username"), paramMap.get("age"));
        return "ok";
    }









}

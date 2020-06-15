package top.dayu.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname HomeController
 * @Description TODO
 * @Date 2020/6/10 11:02
 * @Author by ldy
 */

@RestController
public class HomeController {

    @GetMapping("index")
    public String index(){
        return "hello";
    }

}

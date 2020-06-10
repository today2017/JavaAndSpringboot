package top.dayu.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname JavaAndSpringboot
 * @Description 项目的启动类
 * @Date 2020/6/10 10:57
 * @Author by ldy
 */

@SpringBootApplication
public class JavaAndSpringboot {

    public static void main(String[] args) {

        //main方法的参数在命令行启动时指定参数使用： java -jar Test.jar Hello Java 启动后args中就有 Hello Java 两个元素
        SpringApplication.run( JavaAndSpringboot.class , args ) ;
    }

}

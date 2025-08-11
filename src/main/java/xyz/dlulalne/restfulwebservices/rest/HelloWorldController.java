package xyz.dlulalne.restfulwebservices.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import xyz.dlulalne.restfulwebservices.model.HelloWorldBean;

@RestController
public class HelloWorldController {

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello from bean");
    }

    /**
     * /hello-world/path-varieble/SihleDlulane
     */
    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldFromPathVariable(@PathVariable("name") String pathv){
        return new HelloWorldBean(String.format("Hello World to, %s", pathv));
    }
}

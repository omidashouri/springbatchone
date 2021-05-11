package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.controller;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.beans.TestModel;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.execute.ExecuteUsers;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables.C1;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/")
@AllArgsConstructor
public class UserController {

    private final ExecuteUsers executeUsers;


//    http://localhost:8080/concurrent
    @GetMapping("c1")
    public String executeC1() {
        return "concurrent";
    }


    @PostMapping("concurrent")
    public void concurrent(@RequestParam(name="name", required=false, defaultValue="World") String name,
                      Map<String,Object> model) {

        executeUsers.execute();
    }





//    ------------------------------------------------------------




//    http://localhost:8080/greeting.html -> read from static/mypage1.html



//    http://localhost:8080/1?
    @GetMapping("1")
    public String one(@RequestParam(name="name", required=false, defaultValue="World") String name,
                           Map<String,Object> model) {

        model.put("name", "ddddddddd");
        return "mypage1";
    }


//    http://localhost:8080/2
    @PostMapping("2")
    public String two(@RequestParam(name = "myid" ,defaultValue = "10") String myid,
                           Map<String,Object> model) {

        System.out.println(myid);
        return "mypage2";
    }



//    ---------------------------------------------------


    //    http://localhost:8080/10?    or     http://localhost:8080/10?myId=700000
    @GetMapping("10")
    public ModelAndView ten(@RequestParam(name="myId", required=false, defaultValue="90000") String name) {

        ModelAndView model = new ModelAndView("mypage10");
        model.addObject("testModel", new TestModel(name));
        return model;
    }


    //    http://localhost:8080/10?
    @PostMapping("20")
    public ModelAndView twenty(@ModelAttribute("testModel") TestModel testModel) {

        ModelAndView model = new ModelAndView("mypage20");
        String a = testModel.getMyId();
        System.out.println(a);
        model.addObject("testModel2",new TestModel(a+"_ 100_000_000"));
        return model;
    }

//    -------------------------------------------------------

}

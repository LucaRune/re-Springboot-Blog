package com.example.myblogproject.test;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
// Controller 는 해당 경로 이하에 있는 파일을 리턴해줌
// 데이터 리턴말고 파일 리턴
public class TempControllerTest {

    //http://localhost:8000/blog/temp/home
    @GetMapping("/temp/home")
    public String tempHome(){
        System.out.println("tempHome");
        // 파일을 리턴할때의 기본경로 : src/main/resources/static 이 경로에 있는 파일을 리턴하라는 것
        // return "home.html" 일 때
        // 못찾는 이유는 src/main/resources/statichome.html 이렇게 되니까 못찾는 것
        // 리턴명을 :/home.html 이라해야함
        // 전체 풀경로 :src/main/resources/static/home.html
        return "/home.html";
    }

    @GetMapping("/temp/img")
    public String tempImg(){
        return "/pin.png";
    }

    @GetMapping("/temp/jsp")
    public String tempJsp(){
        // prefix: /WEB-INF/views/
        // suffix: .jsp
        // 풀경로는 : /WEB-INF/views/test.jsp
        return "test";
    }
}

/*
템플릿 파일을 html 로 쓸게 아니라 jsp 파일을 사용
스프링 부트는 기본적으로 jsp 를 지원하지 않음
jsp 파일을 리턴해줘도 스프링 부트가 정상적으로 작동하지 않음
*/

// static 은 정적 파일을 놓는 경로
// static 아래 파일들은 브라우저가 인식할 수 있는 파일
// 브라우저가 인식할 수 있는 파일 = 정적 파일
// jsp 는 자바파일로 동적 파일, 컴파일이 일어나야하는 파일
// jsp 는 동적 파일이라 브라우저가 인식을 못해서 불러오지못함
// -> 경로를 바꿔야댐


// 통신 할 때 : 자바 오브젝트 -> JSON 한다는 것은 전송한다는 것
// JSON 은 공용어 같은 느낌
// 통신 할 때 JSON 을 중간 데이터로 사용
package com.example.myblogproject.test;

import org.springframework.web.bind.annotation.*;

//사용자가 요청 -> 응답(HTML파일)
//@Controller

@RestController //사용자가 요청 -> 응답(Data)
// RestController 가 String 을 리턴했을 때는 문자 그 자체를 리턴. => ex) lombok test 완료   리턴
public class HttpControllerTest {

    private static final String TAG = "HttpControllerTest : ";

    //localhost:8000/blog/http/lombok
    @GetMapping("/http/lombok")
    public String lombokTest(){
        Member m = new Member(1, "sujin", "1234", "email");
        System.out.println(TAG + "getter : " + m.getId());
        m.setId(5000);
        System.out.println(TAG + "setter : " + m.getId());
        return "lombok test 완료";
    }

    //인터넷 브라우저 요청은 무조건 get 요정만 할 수 있다.
    //get 말고는 오류 발생
    //get 요청은 쿼리스트링 방법 뿐
    //http://localhost:8080/http/get (select)
    /*@GetMapping("/http/get")
    public String getTest(@RequestParam int id, @RequestParam String username){  //@RequestParam은 하나씩 다 적어줘야 함
        return "get 요청 : " + id + "  username : " + username;}  //문자열을 리턴*/

    @GetMapping("/http/get")     //Member는 알아서 매핑
    public String getTest(Member m){
        //?id=1&username=sujin&password=1234&email=su@naver.com ?뒤에껄
        // Member에 넣어주는 것도 스프링이 하는 일(MessageConverter)

        return "get 요청 : " + m.getId() +","+ m.getUsername() +","+ m.getPassword() +","+ m.getEmail();}

    //http://localhost:8080/http/post (insert)
    /*@PostMapping("/http/post")  //text/plain
    public String postTest(@RequestBody String text){
        return "post 요청 : " + text;
    }*/
    @PostMapping("/http/post")  //application/json
    public String postTest(@RequestBody Member m){  // MessageConverter (스프링부트)
        return "post 요청" + m.getId() +","+ m.getUsername() +","+ m.getPassword() +","+ m.getEmail();
    }

    //http://localhost:8080/http/put (update)
    @PutMapping("/http/put")
    public String putTest(@RequestBody Member m){
        return "put 요청 : " + m.getId() +","+ m.getUsername() +","+ m.getPassword() +","+ m.getEmail();
    }

    //http://localhost:8080/http/delete (delete)
    @DeleteMapping("/http/delete")
    public String deleteTest(){
        return "delete 요청";
    }
}

//Body에 데이터를 실어서 보내면 스프링에서는 간단하게 오브젝트로 매핑해서 받을 수 있는데
//RequestBody라는 어노테이션을 통해 매핑해서 받는다.

//postman에서 401 오류
//Authorization 탭 -> Basic Auth에서
//Username에는 user를 Password에는 실행시킬 때 나온 security password를 입력 후 Send

/*
http 통신
통신 방법 4가지
- Get : 데이터를 달라 (select)
- Post : 데이터를 추가하라 (insert)
- Put : 데이터를 수정하라 (update)
- Delete : 데이터를 삭제하라 (delet)
*/

/*ex ) http://localhost:8080/http/get?id-1 -> ?id-1 을 쿼리 스트링이라고 함
쿼리 스트링 : 사용자가 입력한 데이터를 서버로 전달하는 가장 단순한 방법
get 방식으로 요청했을 때 URL 주소 뒤에 입력 데이터를 제공하는 방법이다.
쿼리 스트링은 이름과 값으로 구성되어있음 ex ) ?where=nexearch&sm=top_hty...
where : 쿼리스트링 이름
nexearch :쿼리스트링 값
여러개의 이름&값은 &기호로 구분된다.
*/

/* lib를 외부에 두면 장점은 파일 하나로 양쪽에서 사용할 수 있다는 점
    단점은 배포하게 되면 또 연결해야한다는 점

    파일앞에 .붙은건 숨김 파일 ex) .user

    Maven은 프로젝트 관리 도구
    pom.xml에 필요한 걸 기술 -> .m2 파일의 repository에서 빌드해서 씀
    배포해야하는 서버에 프로젝트 그대로 넣고, maven설치만 해주면 사용 가능
*/

/* yaml 야몰파일
king: Pod => : 다음 스페이스바 한칸
metadata 안에 name 이면
metadata:
  name: hello-pod
이렇게 괄호 대신 들여쓰기
들여쓰기는 스페이스 두칸

스프링에서는 yml 하나로 관리
 */
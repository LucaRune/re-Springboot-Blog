package com.example.myblogproject.test;

import lombok.*;

//@Getter
//@Setter
@Data //Getter + Setter
//@AllArgsConstructor //모든 필드를 다 쓰는 생성자를 만듬
//@RequiredArgsConstructor //final 붙은 애들에 대한 constructor를 만들어줌
@NoArgsConstructor//빈 생성자

public class Member {
    //자바에서 변수는 다 private로 만듬
    //private 변수를 수정할 수 있게 게터앤세터를 만들어줌
    //단축키 [ALT]+[INS]

    //@AllArgsConstructor보단 final을 붙여서 사용, 불변성 유지
    //값을 변경할 일이 있으면 final을 붙이지 않음
    private int id;
    private String username;
    private String password;
    private String email;

    @Builder
    public Member(int id, String username, String password, String email){
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }
}


    /*
    //constructor
    public Member(int id, String username, String password, String email) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    //Getter and Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
*/

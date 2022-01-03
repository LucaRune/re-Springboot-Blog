package com.example.myblogproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.sql.Timestamp;

// ORM -> Java(or 다른언어) Object -> 테이블로 매핑해주는 기술

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder    // 빌더 패턴 !!
@Entity     // User 클래스가 MYSQL 에 테이블이 생성이 된다.
// @DynamicInsert // insert 시에 null 인 필드를 제외시켜준다.
public class User {

    @Id // Primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다/.
    private int id; // 오라클에선 시퀀스, MYSQL 에선 auto_incremnet

    @Column(nullable = false, length = 30) // 아이디 값이 null 이 될 수 없고, 길이는 30까지
    private String username;    // 아이디

    @Column(nullable = false, length = 100) // 12345 => 해쉬(비밀번호 암호화) 하기때문에 넉넉하게 잡기
    private String password;

    @Column(nullable = false, length = 50)
    private String email;

    //@ColumnDefault("user")
    // DB 는 RoleType 이라는게 없다.
    @Enumerated(EnumType.STRING)
    private RoleType role;    // Enum 을 쓰는게 좋다. 어떤 데이터의 도메인을 만들 수 있음.  // 도메인은 어떤 범위가 정해졌다는 것  ex)대학생이면 1~4
    // ADMIN=관리자, USER 등의 권한을 줄 수 있음

    @CreationTimestamp // 시간이 자동으로 입력
    private Timestamp createDate;
}


//@ManyToMany 는 잘 사용하지 않음
package com.example.myblogproject.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder    // 빌더 패턴 !!
@Entity
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private int id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob    // 대용량 데이터를 사용할 때 사용
    private String content;     // 섬머노트 라이브러리 <html> 태그가 섞여서 디자인이 됨 -> 데이터 크기가 커짐

    @ColumnDefault("0")
    private int count; // 조회수

    @ManyToOne(fetch = FetchType.EAGER)  // 보드가 Many, 유저가 One    한 명의 유저는 여러개의 글을 쓸 수 있음
    @JoinColumn(name = "userId")
    private User user;    // DB는 오브젝트를 저장할 수 없다. FK,자바는 오브젝트를 저장할 수 있다.

    @OneToMany(mappedBy = "board", fetch = FetchType.EAGER)  // mappedBy 가 적혀있으면 연관관계의 주인이 아님 (난 FK 가 아니에요) DB 에 칼럼을 만들지 마세요
    private List<Reply> reply;

    @CreationTimestamp
    private Timestamp createDate;
}

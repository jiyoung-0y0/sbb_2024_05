package com.sbs.sbb.Question;

import com.sbs.sbb.Answer.Answer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity // question 테이블
@ToString
public class Question {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto_increment
    private Integer id;

    @Column(length = 200) // VARCHAR(200)
    private String subject;

    @Column(columnDefinition = "TEXT") // TEXT
    private String content;

    private LocalDateTime createDate;

    // mappedBy Answer 클래스의 question 변수 이름을 적어야 함.
    // CascadeType.REMOVE를 하면 Question을 삭제할 때 답변도 같이 삭제됨.
    // OneToMany는 테이블의 컬럼으로 생성되지 않음.
    // 선택
    @OneToMany(mappedBy = "question", cascade = CascadeType.REMOVE)
    private List<Answer> answerList;
}

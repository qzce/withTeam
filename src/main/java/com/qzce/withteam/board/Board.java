package com.qzce.withteam.board;

import com.qzce.withteam.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bid;

    @Column
    private String title;

    @Column
    private String content;

    @Builder
    public Board(Long bid, String title, String content) {
        this.bid = bid;
        this.title = title;
        this.content = content;
    }

}

package com.qzce.withteam.board.dto;

import com.qzce.withteam.board.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class BoardWriteDto {

    private Long bid;
    private String title;
    private String content;

    public Board toEntity() {
        return Board.builder()
                .bid(bid)
                .title(title)
                .content(content)
                .build();
    }

}
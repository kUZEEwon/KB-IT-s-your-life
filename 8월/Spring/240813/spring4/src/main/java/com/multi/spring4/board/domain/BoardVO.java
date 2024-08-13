package com.multi.spring4.board.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardVO {

    private int no;
    private String title;
    private String content;
    private String writer;

    /*
    use shop2;
    CREATE TABLE `board` (
      `no` int NOT NULL AUTO_INCREMENT,
      `title` varchar(45) NOT NULL,
      `content` varchar(45) NOT NULL,
      `writer` varchar(45) NOT NULL,
      PRIMARY KEY (`no`)
    ) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
    */
}

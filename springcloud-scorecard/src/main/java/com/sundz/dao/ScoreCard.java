package com.sundz.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Data
@Log4j2
@AllArgsConstructor
@NoArgsConstructor
public class ScoreCard {
    private Integer id;

    private Integer userId;

    private Integer scoreNumber;

    private String remark;

}
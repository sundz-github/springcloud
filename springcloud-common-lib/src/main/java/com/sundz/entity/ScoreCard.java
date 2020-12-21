package com.sundz.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreCard {
    private Integer id;

    private Integer userId;

    private Integer scoreNumber;

    private String remark;

}
package com.icesi.sarec.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TollDTO {

    private String name;
    private int line;
    private Long category1Price;
    private Long category2Price;
    private Long category3Price;
    private Long category4Price;
    private Long category5Price;
    private Long category6Price;
    private Long category7Price;

}

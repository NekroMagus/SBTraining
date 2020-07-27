package com.github.SBTraining.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class JwtUserReqDto {

    private String login;
    private String password;
}

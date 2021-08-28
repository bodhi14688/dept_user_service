package com.bodhi.user.VO;

import com.bodhi.user.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTempleteVO {

    private User user;
    private Department department;
    private String message;
}

package com.ryosms.security.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;

/**
 * Created by ryosms on 2016/12/25.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserForm {

    @NotBlank
    @Size(min = 6, max = 255)
    private String loginId;

    @NotBlank
    @Size(min = 6)
    private String password;

    @NotBlank
    @Size(max = 100)
    private String userName;

}

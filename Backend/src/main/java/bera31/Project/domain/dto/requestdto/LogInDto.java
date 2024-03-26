package bera31.Project.domain.dto.requestdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LogInDto {
    @NotBlank(message = "이메일을 입력해주세요!")
    String email;
    @NotBlank(message = "비밀번호를 입력해주세요!")
    String password;
}

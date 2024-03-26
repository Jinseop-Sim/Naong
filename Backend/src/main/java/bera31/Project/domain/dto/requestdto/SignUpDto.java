package bera31.Project.domain.dto.requestdto;

import bera31.Project.domain.Address;
import bera31.Project.domain.member.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class SignUpDto {
    @NotBlank(message = "이메일은 필수 값입니다.")
    @Email(message = "이메일 형식을 맞추어 주시길 바랍니다.")
    String email;
    @NotBlank(message = "비밀번호는 필수 값입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$)", message = "비밀번호는 반드시 숫자, 영대소문자, 특수문자가 포함되어야 합니다.")
    @Size(min = 8, max = 12, message = "비밀번호는 8 ~ 12자리의 길이로 만들어 주십시오.")
    String password;
    @NotBlank(message = "닉네임은 필수 값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9ㄱ-ㅎ]*$]", message = "닉네임에는 특수문자 사용이 불가합니다.")
    String nickname;
    String dong;
    String gu;
}

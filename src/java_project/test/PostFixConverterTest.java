package java_project.test;

import java_project.converter.PostFixConverter;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class PostFixConverterTest {

    private PostFixConverter converter = new PostFixConverter();

    @Test
    void 후위표현식_변환_괄호없음_성공(){
        String 중위표현식_요청 = "1 + 3";
        String 후위표현식 = converter.convert(중위표현식_요청);
        assertThat(후위표현식).isEqualTo("1 3 +");
    }

    @Test
    void 후위표현식_변환_괄호있음_성공(){
        String 중위표현식_요청 = "1 * (3 + 1)";
        String 후위표현식 = converter.convert(중위표현식_요청);
        assertThat(후위표현식).isEqualTo("1 3 1 + *");
    }

    @Test
    void 후위표현식_변환_괄호개수_불일치_실패(){
        String 중위표현식_요청 = "1 * (3 + 1";
        assertThatThrownBy(() -> converter.convert(중위표현식_요청))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("괄호 불일치");
    }
}

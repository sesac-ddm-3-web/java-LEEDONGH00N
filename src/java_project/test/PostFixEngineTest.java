package java_project.test;


import java_project.calculate.PostFixEngine;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@SuppressWarnings("NonAsciiCharacters")
public class PostFixEngineTest {

    private PostFixEngine postFixEngine = new PostFixEngine();

    @Test
    void 후위식_계산_성공(){
        String 후위식 = "1 3 +";
        assertThat(postFixEngine.calculate(후위식)).isEqualTo(4);
    }

    @Test
    void 빈_후위식_실패(){
        assertThatThrownBy(() -> postFixEngine.calculate(""))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 후위식입니다.");
    }

    @Test
    void null_입력_실패() {
        assertThatThrownBy(() -> postFixEngine.calculate(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("빈 후위식입니다.");
    }

    @Test
    void 피연산자_부족_실패() {
        assertThatThrownBy(() -> postFixEngine.calculate("1 +"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("피연산자 부족");
    }

    @Test
    void 남는_피연산자_실패() {
        assertThatThrownBy(() -> postFixEngine.calculate("1 2"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("남는 피연산자");
    }

    @Test
    void 영_나누기_실패() {
        assertThatThrownBy(() -> postFixEngine.calculate("4 0 /"))
                .isInstanceOf(ArithmeticException.class)
                .hasMessage("0으로 나눌 수 없습니다");
    }
}

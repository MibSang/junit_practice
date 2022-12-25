package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
    //요구사항 1.
    @Test
    public void split_1and2() throws Exception {
        String str = "1,2";
        String[] arr;

        arr = str.split(",");

        assertThat(arr)
                .isNotEmpty()
                .containsExactly("1", "2")
                .hasSize(2);
    }

    @Test
    public void split_1() throws Exception {
        String str = "1";
        String[] arr;

        arr = str.split(",");

        assertThat(arr)
                .isNotEmpty()
                .contains("1")
                .hasSize(1);
    }

    //요구사항 2.
    @Test
    public void substring_and_split_1and2() throws Exception {
        String str = "(1,2)";

        str = str.substring(1, str.length()-1);

        assertThat(str)
                .isEqualTo("1,2");
    }

    //요구사항 3.
    @DisplayName("String.charAt 정상 동작 테스트")
    @Test
    public void charAt_b() throws Exception {
        String str = "abc";
        char c;

        c = str.charAt(1);

        assertThat(c)
                .isEqualTo('b');
    }

    @DisplayName("String.charAt OutOfBound 예외 동작 테스트")
    @Test
    public void charAt_OutOfBound() throws Exception {
        String str = "abc";

        assertThatThrownBy(() -> {
            char c = str.charAt(3);
        }).isInstanceOf(IndexOutOfBoundsException.class);

        //다른 방법 1.
        assertThatExceptionOfType(IndexOutOfBoundsException.class)
                .isThrownBy(() -> {
                    char c = str.charAt(3);
                });

        //다른 방법 2.
        assertThatIndexOutOfBoundsException()
                .isThrownBy(() -> {
                    char c = str.charAt(3);
                });
    }
}

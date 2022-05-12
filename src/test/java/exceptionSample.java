import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class exceptionSample {

    /*
     * 자주 쓰는 Exception에 대해서는 제공
     * assertThatNullPointerException()
     * assertThatIllegalArgumentException()
     * assertThatIllegalStateException()
     * assertThatIOException() 등등...
     * */
    @Test
    public void nullPointerException() {
        String test = null;
        assertThatNullPointerException().isThrownBy(() -> {
            test.length();
        });
    }

    /*
     * IllegalArgumentException과 IllegalStateException의 차이
     * IllegalArgumentException는 메소드의 아규먼트의 값이 잘못됐을때
     * IllegalStateException는 메소드의 호출이 적절하지 않았을때
     * */
    @Test
    public void 차이() {
        assertThatIllegalArgumentException().isThrownBy(() -> {
            Member member = new Member("김나박이");
        });
        assertThatIllegalStateException().isThrownBy(() -> {
            MemberGroup memberGroup = new MemberGroup();
            memberGroup.addMembers(new Member("김나박"));
            memberGroup.addMembers(new Member("김나박"));
        });
    }

    /*
     * 자주 쓰는 Exception의 제외하고는 assertThatThrownBy로 받는다
     * Exception의 type check 가능 (isInstanceOf)
     * Exception message에 대해서도 check 가능 (hasMessageContaining)
     * 메시지의 시작, 끝, 문자 포함여부도 check 가능
     * */
    @Test
    public void assertThatThrownBySample() {
        assertThatThrownBy(() -> {
            List<String> list = Arrays.asList("One", "Two");
            list.get(2);
        }).isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("2");
    }

    @Test
    public void when과then의_분리() {
        Throwable throwable = catchThrowable(() -> {
            int a = 2 / 0;
        });
        assertThat(throwable).isInstanceOf(ArithmeticException.class);
    }

    /*
    * 발생한 exception의 원인(cause)에 대해서도 check 가능
    * */
    @Test
    public void cause() {
        NullPointerException cause = new NullPointerException("1");
        RuntimeException exception = new RuntimeException("2", cause);

        assertThat(exception).hasCauseInstanceOf(NullPointerException.class);
    }

    /*
    * 어떤 Exception이 발생했는지 먼저 쓰는게 가능하다.
    * */
    @Test
    public void Exception타입_먼저() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
                    throw new RuntimeException((new IllegalArgumentException("cause")));
                }).havingCause()
                .withMessage("cause");
    }

}

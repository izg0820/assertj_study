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

}

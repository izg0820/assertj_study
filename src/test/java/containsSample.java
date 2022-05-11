import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class containsSample {

    private static List<String> list;

    @BeforeAll
    public static void setUp() {
        list = Arrays.asList("A", "B", "C");
    }

    @Test
    public void isEqualTo() {
        assertThat(list.size()).isNotZero().isEqualTo(3);
    }

    /*
    * contains : 순서 상관없이 기대값이 포함되어 있으면 pass
    * containsAll : 순서 상관없이 기대값이 모두 포함되어 있으면 pass (컬렉션)
    * containsExactly : 순서와 요소가 정확히 일치해야 pass
    * containsSequence : 중간요소를 건너뛰지 않는 순서와 요소가 일치해야 pass
    * containsSubsequence : 중간요소를 건너뛰어도 되자만 순서를 바꿔서는 안됨
    * */
    @Test
    public void contains() {
        //fail
//        assertThat(list).contains("D")
//                .containsAll(Arrays.asList("A", "D"))
//                .containsExactly("A", "C", "B")
//                .containsSequence("A", "C")
//                .containsSubsequence("B", "A");

        //pass
        assertThat(list).contains("A")
                .containsAll(Arrays.asList("A", "C", "B"))
                .containsAll(Arrays.asList("A", "B"))
                .containsExactly("A", "B", "C")
                .containsSequence("A", "B")
                .containsSequence("B", "C")
                .containsSubsequence("B", "C")
                .containsSubsequence("A", "C");
    }
}

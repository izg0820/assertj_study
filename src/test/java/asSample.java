import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class asSample {

    /*
    * as는 assert의 설명을 입력할 때 사용된다.
    * assertion 뒤에 사용하면 재대로 동작하지 않는다..
    * */
    @Test
    public void as() {
        String sample = "1|2|3";
        assertThat(sample.split("\\|")).containsExactly("3").as("여기에다가 쓰면 동작 X");
        assertThat(sample.split("\\|")).as("테스트1").containsExactly("1","2","3");
        assertThat(sample.split("\\|")).as("테스트2").contains("1");
    }
}

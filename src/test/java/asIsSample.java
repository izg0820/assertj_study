import org.assertj.core.api.Condition;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class asIsSample {

    /*
     * as는 assert의 설명을 입력할 때 사용된다.
     * assertion 뒤에 사용하면 재대로 동작하지 않는다.
     * */
    @Test
    public void as() {
        String sample = "1|2|3";
        assertThat(sample.split("\\|")).containsExactly("3").as("여기에다가 쓰면 동작 X");
        assertThat(sample.split("\\|")).as("테스트1").containsExactly("1", "2", "3");
        assertThat(sample.split("\\|")).as("테스트2").contains("1");
    }

    /*
    * haveExactly, doNotHave와 같이 condition을 파라미터로 하는 assertion
    * Condition 클래스가 파라미터로 들어가며
    * predicate를 파라미터로 하는 생성자로 Condition 클래스를 생성할 수 있다.
    * */
    @Test
    public void is() {
        Condition<Member> senior = new Condition<>(
                m -> m.getAge() >= 60, "senior");
        Member member = new Member("홍길동", 70);
        assertThat(member).is(senior);
    }
}

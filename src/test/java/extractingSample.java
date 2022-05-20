import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class extractingSample {

    /*
    * extracting은 객체의 특정 프로퍼티를 뽑는 assertion
    * filteredOn는 특정 조건에 대해서 값을 추출
    * */
    @Test
    public void extractingSample() {
        List<Member> members = new ArrayList<>();
        members.add(new Member("김", 10));
        members.add(new Member("나", 11));
        members.add(new Member("박", 12));
        members.add(new Member("이", 13));
        assertThat(members).extracting("age").containsExactly(10, 11, 12, 13);
    }
}

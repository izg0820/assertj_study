import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class filterSample {

    private static List<Member> members;

    @BeforeAll
    public static void setUp() {
        members = new ArrayList<>();
        members.add(new Member("김개똥", 14));
    }

    @Test
    public void filteredTest() {
        Member hong = new Member("홍길동", 25);
        members.add(hong);
        assertThat(members).as("람다식")
                .filteredOn(p -> p.getName().contains("홍"))
                .containsExactly(hong);

        assertThat(members).as("객체 프로퍼티 접근")
                .filteredOn("age", 25)
                .containsExactly(hong);

        assertThat(members).as("객체 프로퍼티 값에 대한 조건")
                .filteredOn("age", notIn(14))
                .containsExactly(hong);
    }
}

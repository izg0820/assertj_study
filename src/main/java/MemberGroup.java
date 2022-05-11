import java.util.ArrayList;
import java.util.List;

public class MemberGroup {

    List<Member> members;

    public MemberGroup() {
        this.members = new ArrayList<>();
    }

    public void addMembers(Member member) {
        validate(member);
        this.members.add(member);
    }

    public void validate(Member member) {
        if (members.contains(member)) {
            throw new IllegalStateException("중복됨");
        }
    }
}

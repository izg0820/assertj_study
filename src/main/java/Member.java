public class Member {

    private final static int MAX_NAME_LENGTH = 3;

    private String name;

    public Member(String name) {
        validate(name);
        this.name = name;
    }

    public void validate(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("최대길이 초과");
        }
    }

    @Override
    public boolean equals(Object obj) {
        Member member = (Member) obj;
        return this.name.equals(member.name);
    }
}

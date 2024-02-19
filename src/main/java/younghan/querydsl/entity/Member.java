package younghan.querydsl.entity;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter // 실무에선 쓰지 않는다.
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    public Member(String username) {
        this(username, 0, null);
    }

    public Member(String username, int age) {
        this(username, age, null);
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if(team != null) {
            changeTeam(team);
        }
    }

    // 연관관계 메서드
    private void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }




}

package com.temelt.issuemanagement.entity;

import lombok.*;
import org.apache.catalina.LifecycleState;
import sun.security.util.Password;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Table(name = "users")

public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "uName",length = 100,unique = true)
    private String userName;

    @Column(name = "nameSurname",length = 300)
    private String nameSurname;

    @Column(name = "pwd",length = 100)
    private String password;

    @Column(name = "email",length = 100)
    private String email;

    @JoinColumn(name = "issues")
    @OneToMany(fetch = FetchType.LAZY)
    //bir kullanıcıya birçok ıssue bağlanabilir
    private List<Issue> issues;

}

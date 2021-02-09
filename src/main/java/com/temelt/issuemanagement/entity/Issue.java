package com.temelt.issuemanagement.entity;

import lombok.*;
import org.apache.catalina.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
//nesnenin boş bir constructor ını yaratır
@AllArgsConstructor
// tüm fieldlar kullanılarak oluşturulmuş constructor
@ToString
@EqualsAndHashCode
@Table(name = "issue")
//veritababınında ISsue bir tabloya denk geldiği için entity anotation ı eklenir
public class Issue extends BaseEntity{
    @Id
    //ıssue nun bir entity olması için gerekli olan zorunluluk id dir
    @GeneratedValue(strategy = GenerationType.AUTO)
    //id nin otomatik olarak oluşturulmasını sağlar
    private Long id;

    @Column( name = "description",length = 1000)
    private String description;

    @Column(name = "date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @Column(name = "issueStatus")
    @Enumerated(EnumType.STRING)
    //veritabanında verinn durma şekli
    //stringle verinin ismi tutulur open,closed vs gibi
    //ordinal ile numara tutulur daha az yer kaplar dezavantajı ise araya veri eklendiğinde diğer veriler bozulur
    private IssueStatus issueStatus;

    @Column(name = "details",length = 4000)
    private String details;

    @JoinColumn(name = "assignee_user_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    //bircok issue class ı tek user a bağlanabilir
    //optional true bir issue oluşturulurken onun assignee sini vermesen de olur
    //lazy gerek duyulduğunda verileri getirir
    private User assignee;

    @JoinColumn(name = "project_id")
    @ManyToOne(optional = true,fetch = FetchType.LAZY)
    private Project project;
}

package ua.goit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "developers")
public class Developer implements BaseEntity<Long>{

    private static final long serialVersionUID = 6225466248402352490L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",length = 45)
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender",length = 6)
    private String gender;

    @Column(name = "salary")
    private Integer salary;

    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToMany(mappedBy = "developers")
    private Set<Project> projects;

    @ManyToMany(mappedBy = "developers")
    private Set<Skill> skills;

}

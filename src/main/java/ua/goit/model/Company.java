package ua.goit.model;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(exclude = "projects")
@ToString(exclude = "projects")
@Entity(name = "companies")
public class Company implements BaseEntity<Long>{
    @Serial
    private static final long serialVersionUID = 1785452969944528159L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "code",length = 10)
    private String code;

    @OneToMany(mappedBy="company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Project> projects;

    @OneToMany(mappedBy="company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Developer> developers;
}

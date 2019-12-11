package io.nology.springbootreference.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="job")
public class Job {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="title")
    @NotNull
    private String title;

    @Column(name="salary")
    @Min(0)
    private int salary;

//    @OneToMany(cascade = CascadeType.ALL,
//            fetch = FetchType.LAZY,
//            mappedBy = "post")
//    private Set<Employee> comments = new HashSet<>();

    public Job() {}

    public Job(int id, String title, int salary) {
        this.id = id;
        this.title = title;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

//    public Set<Employee> getComments() {
//    return comments;
//}
//
//    public void setComments(Set<Employee> comments) {
//        this.comments = comments;
//    }
}

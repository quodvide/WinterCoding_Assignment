package todolist.domain;

import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Setter
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = true)
    private LocalDate dueDate;
}

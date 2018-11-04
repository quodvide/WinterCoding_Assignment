package todolist.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todolist.domain.Todo;
import todolist.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ApiToDoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/todos")
    public List<Todo> getTodoList() {
        List<Todo> list = todoService.getTodoList();
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        return list;
    }

}

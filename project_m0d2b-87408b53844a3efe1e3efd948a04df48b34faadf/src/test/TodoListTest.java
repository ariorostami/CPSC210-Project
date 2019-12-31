import model.RegularTodo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Unit test for TodoList
public class TodoListTest {
    private ArrayList<RegularTodo> data;
    private ArrayList<RegularTodo> test1;
    private ArrayList<RegularTodo> newList;
    private RegularTodo regularTodo1;
    private RegularTodo regularTodo2;
    private StringBuilder sb;



    @BeforeEach
    public void runBefore() {
        data = new ArrayList<>();
        test1 = new ArrayList<>();
        newList = new ArrayList<>();
        regularTodo1 = new RegularTodo("Go.");
        regularTodo2 = new RegularTodo("Stop.");
        regularTodo1.setStatus();
        test1.add(regularTodo1);
        data.add(regularTodo1);
        data.add(regularTodo2);
        sb  = new StringBuilder();
        sb.append(regularTodo1.name);
        sb.append(regularTodo2.name);
    }

    @Test
    public void testAddTodo() {
        newList.add(regularTodo1);
        assertEquals(test1, newList);
    }

}

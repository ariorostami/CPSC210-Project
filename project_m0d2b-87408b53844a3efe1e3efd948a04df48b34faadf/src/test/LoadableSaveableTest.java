import exceptions.WrongIndex;
import model.RegularTodo;
import model.Todo;
import model.TodoList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

// Unit tests forTodo
public class LoadableSaveableTest {
    private RegularTodo test;
    private RegularTodo test1;
    private RegularTodo test2;
    private ArrayList<Todo> a;
    private ArrayList<Todo> b;
    private Object WrongIndex;

    @BeforeEach
    public void runBefore() throws IOException {
        test = new RegularTodo();
        test1 = new RegularTodo();
        test2 = new RegularTodo();
        a = new ArrayList<>();
        b= new ArrayList<>();
        test.name = "Go to the store.";
        test1.name = "Buy detergent.";
        test2.name = "Go home.";
//        TodoList.addTodoToList("Go to the store.", a);
//        TodoList.addTodoToList("Buy detergent.", a);
    }

//    @Test
//    public void testLoad() throws IOException {
//        TodoList.load();
//        assertEquals(a.get(0).name, b.get(0).name);
//        assertEquals(a.get(1).name, b.get(1).name);
//    }


    public String bigMeme(int i) {
        String sp = "ooferino";
        try {smallMeme(i);
        } catch (WrongIndex wrongIndex) {
            sp = "oof";
        } finally {
            System.out.println("smile :D");
        }
        return sp;
    }

    public void smallMeme(int i) throws WrongIndex {
        if (i != 1) {
            throw new WrongIndex();
        }
    }

    @Test
    public void testWrongIndex() {
        assertEquals("oof", bigMeme(2));
        assertEquals("ooferino", bigMeme(1));
    }

}
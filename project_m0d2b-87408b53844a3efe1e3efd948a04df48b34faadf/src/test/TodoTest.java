import model.RegularTodo;

import model.Todo;
import model.UrgentTodo;
import observer.Subject;
import observer.TodoListObserver;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ui.ExampleList;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

// Unit tests forTodo
public class TodoTest {
    private static final int NUMITEMS = 5000;
    private RegularTodo testRegularTodo;
    private RegularTodo testTrueRegularTodo;
    private UrgentTodo testUrgentTodo;
    private Todo testUrgentTodoAlt;
    private Subject obama;

    @BeforeEach
    public void runBefore() {
        testRegularTodo = new RegularTodo();
        testTrueRegularTodo = new RegularTodo();
        testTrueRegularTodo.setStatus();
        testUrgentTodo = new UrgentTodo("obama");
        testUrgentTodoAlt = new UrgentTodo();
        testUrgentTodoAlt.setStatus();
        obama = new ExampleList();
    }

    @Test
    public void testGetStatus() {
        assertFalse(testRegularTodo.getStatus());
        assertTrue(testTrueRegularTodo.getStatus());
        assertFalse(testUrgentTodo.getStatus());
        assertTrue(testUrgentTodoAlt.getStatus());

    }

    @Test
    public void testCompleteOrNot() {
        assertEquals("not completed.", testRegularTodo.completeOrNot());
        assertEquals("completed.", testTrueRegularTodo.completeOrNot());
    }

    @Test
    public void testShouldIFreakOut() {
        testRegularTodo.changeObjective("bing");
        assertEquals("bing", testRegularTodo.name);
        assertEquals("Oh yeah, it's freakout time.", testUrgentTodo.shouldIFreakOut());
        assertEquals("Stop and smell the roses.", testRegularTodo.shouldIFreakOut());
    }

    @Test
    public void testComplete() {
        testRegularTodo.complete();
        assertTrue(testRegularTodo.getStatus());
        testUrgentTodo.deadline = "bing";
        testUrgentTodo.name = "bong";
        assertEquals("bong", testUrgentTodo.name);
        assertEquals("bing", testUrgentTodo.deadline);
        assertTrue(true);
        assertEquals(testRegularTodo,testRegularTodo);
        int c = testRegularTodo.hashCode();
        testRegularTodo.update();
        assertEquals(c, testRegularTodo.hashCode());
        assertFalse(testRegularTodo.equals(5));
        assertFalse(testRegularTodo.equals(null));
        boolean b = testRegularTodo.getStatus();
        testRegularTodo.setStatus();
        assertFalse(b == testRegularTodo.getStatus());
    }
    @Test
    public void testUrgent() {
        assertEquals(testUrgentTodo.name, "obama");
        testUrgentTodo.setDate("b");
        assertEquals(testUrgentTodo.deadline, "b");
        obama.addObserver(testRegularTodo);
        obama.addObserver(testRegularTodo);
        obama.notifyObservers();
        List<TodoListObserver> a = new ArrayList<>();
        a.add(testRegularTodo);
        assertEquals(obama.observers,a);
    }
}

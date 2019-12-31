package observer;

import model.TodoList;

import java.util.ArrayList;
import java.util.List;

public abstract class Subject {
    public static List<TodoListObserver> observers = new ArrayList<>();

    public static void addObserver(TodoListObserver tdObserver) {
        if (!observers.contains(tdObserver)) {
            observers.add(tdObserver);
        }
    }

    public static void notifyObservers() {
        for (TodoListObserver observer : observers) {
            observer.update();
        }
    }
}

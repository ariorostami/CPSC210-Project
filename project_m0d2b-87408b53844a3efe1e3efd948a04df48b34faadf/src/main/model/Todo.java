package model;

import observer.TodoListObserver;
import ui.UserInput;

import java.util.Objects;

import static model.TodoList.locations;

public abstract class Todo implements Objective, Task, TodoListObserver {
    public String name;
    boolean status;
    public String location;


    //Modifies: This
    //Effects: Toggles status
    public void setStatus() {
        this.status = !this.status;
    }

    //Effects: returns atodo task status boolean as true or false
    public boolean getStatus() {
        return this.status;
    }

    //Effects: If given todotask has status true, return "completed" otherwise return "not coompleted"
    public String completeOrNot() {
        if (this.getStatus()) {
            return "completed.";
        } else {
            return "not completed.";
        }
    }


    public void changeObjective(String a) {
        name = a;
    }

    public void complete() {
        status = true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Todo todo = (Todo) o;
        return name.equals(todo.name);
    }


    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public void update() {
        System.out.println(this.name + " I Survived!");
    }


}

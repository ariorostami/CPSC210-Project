package model;

public class RegularTodo extends Todo {

    public RegularTodo() {
        name = null;
        status = false;
        location = null;
    }

    // Effects: Constructs atodo task with a name
    public RegularTodo(String name) {
        this.name = name;
    }

    public RegularTodo(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public String shouldIFreakOut() {
        return "Stop and smell the roses.";
    }
}



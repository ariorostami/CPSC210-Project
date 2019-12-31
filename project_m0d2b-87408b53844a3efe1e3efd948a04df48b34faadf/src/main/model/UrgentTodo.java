package model;

import java.util.Date;

public class UrgentTodo extends Todo {
    public String deadline;


    public UrgentTodo() {
        name = null;
        status = false;
        deadline = null;
    }

    public UrgentTodo(String name) {
        this.name = name;
    }

    public void setDate(String d) {
        this.deadline = d;
    }

    public String shouldIFreakOut() {
        return "Oh yeah, it's freakout time.";
    }
}

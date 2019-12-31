package ui;

import observer.Subject;

import java.util.ArrayList;
import java.util.List;

public class ExampleList extends Subject {
    public List<String> listOfString;

    public ExampleList() {
        this.listOfString = new ArrayList<>();
    }
}

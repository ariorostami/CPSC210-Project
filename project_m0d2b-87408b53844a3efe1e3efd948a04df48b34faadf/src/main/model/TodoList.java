package model;

import network.ReadWebPageEx;
import observer.Subject;
import ui.MainFrame;
import ui.UserInput;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class TodoList extends Subject implements Loadable {
    public static ArrayList<Todo> todoList;
    public static Boolean projectStatus = true;
    public static Map<Todo, String> locations;

    //Effects: Creates a new TodoList with Todos from SaveList.txt
    public TodoList() throws IOException {
        ReadWebPageEx.showInternet();
        todoList = new ArrayList<>();
        locations = new HashMap<>();
        Todo a = new RegularTodo("Store#Go to the store.", "Store#");
        Todo b = new RegularTodo("School#Study.", "School#");
        Todo c = new RegularTodo("Home#Go home.", "Home#");
        locations.put(a, "Store#");
        locations.put(b, "School#");
        locations.put(c, "Home#");
        UserInput.processOperations();

    }





    public static void splitOnSpace(String line) {
        String splits = String.valueOf(line.split("#"));
        Todo a = new RegularTodo(line, splits);
        locations.put(a, splits);
    }

//    //implements load() behaviour generically for any .txt file
//    public static void loadExample(String name, ArrayList<todo> t) throws IOException {
//        List<String> importer = Files.readAllLines(Paths.get(name));
//        for (String s : importer) {
//            addTodoToList(s, t);
//        }
//    }

    //Implements save behaviour generically for testing purposes
//    public static void saveExample(
//            String name, ArrayList<Todo> t) throws FileNotFoundException, UnsupportedEncodingException {
//        ArrayList<String> lines = new ArrayList<String>();
//        for (Todo to : t) {
//            lines.add(to.name);
//        }
//        PrintWriter writer = new PrintWriter(name, "UTF-8");
//        for (String line: lines) {
//            writer.println(line);
//        }
//        writer.close();
//    }
}

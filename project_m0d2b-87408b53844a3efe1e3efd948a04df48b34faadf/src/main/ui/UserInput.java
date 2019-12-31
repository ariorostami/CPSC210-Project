package ui;

import exceptions.WrongIndex;
import model.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.invoke.WrongMethodTypeException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

import static model.TodoList.*;

public class UserInput {
    public static Scanner scan = new Scanner(System.in);
    public static String operation = "";
    public static boolean loop = true;
    public static String input;
    public static String output;

    public static String handleInteraction() {
        return scan.nextLine();
    }

    public static void processOperations() throws IOException {
        load();
        while (projectStatus) {
            MainFrame.appendTextArea("Type [add] to add todo  item,"
                    + " [cross] to delete, [see] to view,or type [quit] to quit");
            stay();
            MainFrame.appendTextArea("you selected: " + input);
            pickmethod();
            save();
        }
    }

    //Modifies: This
    //Effects: Loads saved TodoList into new list.
    public static void load() throws IOException {
        List<String> importer = Files.readAllLines(Paths.get("data/SaveList.txt"));
        for (String s : importer) {
            //splitOnSpace(s);
            UserInput.addTodo("n", s);
        }
    }

    public static void stay() {
        while (loop) {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                loop = true;
                break;
            }
        }
    }


    public static void pickmethod() {
        if (input.equals("cross")) {
            portcross();
        } else if (input.equals("loc")) {
            showLoc();
        } else if (input.equals("add")) {
            handleAdd();
        } else if (input.equals("see")) {
            printList();
        } else if (input.equals("quit")) {
            projectStatus = false;
        } else {
            MainFrame.appendTextArea("Sorry. I didn't quite catch that.");
        }
    }



    private static void portcross() {
        try {
            handleCross();
        } catch (WrongIndex wrongIndex) {
            MainFrame.appendTextArea("Wrong Index, try again.");
        } finally {
            MainFrame.appendTextArea("smile :D");
        }
    }

    //Effects: Prints out list of all todotasks.
    private static void printList() {
        StringBuilder s = new StringBuilder();
        for (Todo t : todoList) {
            s.append(t.name);
            s.append(" ");
        }
        MainFrame.appendTextArea(s.toString());
    }

    //Modifies: This
    //Effects: Adds a new Todotask typed by user at the end of the TodoList.
    private static void handleAdd() {
        String n = "n";
        MainFrame.appendTextArea("please type the name of the desired todo task, of form Location#Todo.");
        stay();
        addTodo(n, input);
        MainFrame.appendTextArea("Your task has been added to the list");
    }

    //Modifies: This
    //Effects: Removes from TodoList thetodo in numbered place given by user.
    private static void handleCross() throws WrongIndex {
        StringBuilder s = new StringBuilder();
        for (Todo t : todoList) {
            s.append(t.name);
            s.append(" ");
        }
        MainFrame.appendTextArea(("Your current todos are: " + s));
        MainFrame.appendTextArea("please type the number of the todo you wish to cross off (starting from 0 up)");
        stay();
        String lala = input;
        int lala1 = Integer.parseInt(lala);
        if (lala1 > todoList.size() - 1) {
            throw new WrongIndex();
        }
        observers.remove(lala1);
        todoList.remove(lala1);

        MainFrame.appendTextArea("that item has been removed");
        printList();
    }

    //Modifies: This
    public static void addTodo(String urgency, String b) {
        if (urgency == "y") {
            UrgentTodo a = new UrgentTodo(b);
            MainFrame.appendTextArea("When is the deadline? Format DDMMYYYY.");
            stay();
            a.setDate(input);
            todoList.add(a);
        } else {
            RegularTodo a = new RegularTodo((b));
            String loci = input;
            todoList.add(a);
            TodoList.addObserver(a);
        }
    }

    public static void showLoc() {
        MainFrame.appendTextArea("Which todo's location do you wish to look up?");
        stay();
        Todo locus = new RegularTodo(input, "");
        MainFrame.appendTextArea(locations.get(locus));
    }

    //Modifies: SaveList.txt
    //Effect: Updates saved list of todos.
    public static void save() throws FileNotFoundException, UnsupportedEncodingException {
        ArrayList<String> lines = new ArrayList<String>();
        for (Todo t : todoList) {
            String splits = String.valueOf(t.name.split("#"));
            locations.put(t, splits);
            lines.add(t.name);
        }
        PrintWriter writer = new PrintWriter("data/SaveList.txt", "UTF-8");
        for (String line: lines) {
            writer.println(line);
        }
        writer.close();
        MainFrame.appendTextArea("Your TodoList has been automatically saved.");
        notifyObservers();
    }



}

package network;

import ui.MainFrame;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.io.BufferedReader;

public class ReadWebPageEx {

    public static void showInternet() throws MalformedURLException, IOException {

        BufferedReader br = null;

        try {
            String theURL = "https://www.students.cs.ubc.ca/~cs-210/2018w1/welcomemsg.html"; //this can point to any URL
            URL url = new URL(theURL);
            br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;

            StringBuilder sb = new StringBuilder();

            while ((line = br.readLine()) != null) {

                sb.append(line);
                sb.append(System.lineSeparator());
                sb.append("Press Enter to Begin.");
            }

            MainFrame.appendTextArea(sb.toString());
        } finally {

            if (br != null) {
                br.close();
            }
        }
    }
}

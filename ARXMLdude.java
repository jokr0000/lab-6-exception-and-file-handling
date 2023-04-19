/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class ARXMLdude {

    public static void main(String[] args) throws Exception {
        try {
            String fn = args[0];
            File f = new File(fn);
            if (!fn.endsWith(".arxml")) {
                throw new NotVaildAutosarFileException("no");

            }
            if (f.length() == 0) {

                throw new EmptyAutosarFileException("no");

            }
            String version = "";
            String encoding = "";
            // FileInputStream sin=new FileInputStream(f);

            FileInputStream sin = new FileInputStream(f);
            int d;
            StringBuilder sb = new StringBuilder();
            while ((d = sin.read()) != -1) {
                sb.append((char) d);
            }
            int cntofcontainers = 0;
            String data = sb.toString();
            Scanner sc = new Scanner(data);
            ArrayList<container> containers = new ArrayList<>();
            while (sc.hasNextLine()) {
                String Line = sc.nextLine();

                if (Line.contains("version=")) {
                    version = Line.substring(Line.indexOf("version=") + 8, Line.indexOf(" encoding="));

                }
                if (Line.contains(" encoding=")) {
                    encoding = Line.substring(Line.indexOf("encoding=") + 9, Line.indexOf("?>"));

                }
                if (Line.contains("<CONTAINER")) {
                    container c = new container();

                    c.setUuid(Line.substring(Line.indexOf("<CONTAINER") + 10, Line.indexOf(">")));
                    containers.add(c);

                } else if (Line.contains("<SHORT-NAME>")) {
                    containers.get(cntofcontainers).setShortname(
                            Line.substring(Line.indexOf("<SHORT-NAME>") + 12, Line.indexOf("</SHORT-NAME>")));

                } else if (Line.contains("<LONG-NAME>")) {
                    containers.get(cntofcontainers).setLongname(
                            Line.substring(Line.indexOf("<LONG-NAME>") + 11, Line.indexOf("</LONG-NAME>")));
                    cntofcontainers++;
                }
            }
            Collections.sort(containers);
            fn = fn.substring(0, fn.indexOf(".arxml")) + "_mod" + ".arxml";
            PrintWriter fout = new PrintWriter(new FileWriter(fn));
            fout.print("<?xmlversion=");
            fout.print(version);
            fout.print("encoding=");
            fout.print(encoding);
            fout.println("?>");
            fout.println("<AUTOSAR>");
            for (int i = 0; i < containers.size(); i++) {
                containers.get(i).wstring(fout);

            }
            fout.println("</AUTOSAR>");
            fout.flush();
            fout.close();

        } catch (NotVaildAutosarFileException e) {

            System.out.println("not valid extension");

        }

    }
}
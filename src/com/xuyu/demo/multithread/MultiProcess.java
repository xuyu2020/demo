package com.xuyu.demo.multithread;

import java.io.*;
/**
 * Created by simbo on 2020/2/6.
 */
public class MultiProcess {
    public static void main(String args[]) throws IOException {
        ProcessBuilder pb = new ProcessBuilder("sh","/Users/simbo/Workspace/shell/echotime.sh");
        Process p1 = pb.start();

        Runtime run = Runtime.getRuntime();
        Process p2 = run.exec("sh /Users/simbo/Workspace/shell/echotime.sh");

        BufferedInputStream in1 = new BufferedInputStream(p1.getInputStream());
        BufferedReader br1 = new BufferedReader(new InputStreamReader(in1));
        String s1;
        while ((s1 = br1.readLine()) != null) {
            System.out.println("ProcessBuilder: " + s1);
        }


        BufferedInputStream in2 = new BufferedInputStream(p2.getInputStream());
        BufferedReader br2 = new BufferedReader(new InputStreamReader(in2));
        String s2;
        while ((s2 = br2.readLine()) != null) {
            System.out.println("Runtime: " + s2);
        }

    }
}

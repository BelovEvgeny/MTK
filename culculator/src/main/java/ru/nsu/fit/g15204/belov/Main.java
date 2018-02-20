package ru.nsu.fit.g15204.belov;
//Created by Evgeny on 09.02.2018.

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        File f = new File("in.txt");
        Reader reader = new FileReader(f);

        Lexer lexer = new Lexer(reader);
        System.out.println(new Parser(lexer).parseString());
    }



}

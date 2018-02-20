package ru.nsu.fit.g15204.belov;
//Created by Evgeny on 09.02.2018.

import java.io.IOException;
import java.io.Reader;

class Lexer {
    private Reader reader;
    private int curChar;

    Lexer(Reader reader) throws IOException {
        this.reader = reader;
        curChar = reader.read();
    }

    String getLexeme() throws IOException {
        StringBuilder lexeme = new StringBuilder();
        if (curChar == -1) {
            return "@";
        }
        if (Character.isDigit(curChar)) {
            while (Character.isDigit(curChar)) {
                lexeme.append((char) curChar);
                curChar = reader.read();
            }
        } else {
            lexeme.append((char) curChar);
            curChar = reader.read();
        }
        while (Character.isSpaceChar(curChar)){
            curChar = reader.read();
        }
        return lexeme.toString();
    }



    int checkNextChar() {
        return curChar;
    }

}

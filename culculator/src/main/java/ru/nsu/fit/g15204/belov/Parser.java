package ru.nsu.fit.g15204.belov;
//Created by Evgeny on 09.02.2018.

import java.io.IOException;

class Parser {
    private Lexer lexer;

    Parser(Lexer lexer) {
        this.lexer = lexer;
    }

    double parseString() throws IOException {
        double sum = 0;
        sum += parseExpr();
        if (lexer.checkNextChar() == -1) {
            return sum;
        }
        throw new IOException();
    }

    double parseExpr() throws IOException {
        double result = parseTerm();
        while (lexer.checkNextChar() == '+' || lexer.checkNextChar() == '-') {
            if ("+".equals(lexer.getLexeme())) {
                result += parseTerm();
            } else {
                result -= parseTerm();
            }
        }
        return result;
    }

    double parseTerm() throws IOException {
        double result = parseFactor();
        while (lexer.checkNextChar() == '*' || lexer.checkNextChar() == '/') {
            if ("*".equals(lexer.getLexeme())) {
                result *= parseFactor();
            } else {
                result /= parseFactor();
            }
        }
        return result;
    }

    double parseFactor() throws IOException {
        double result = parsePower();
        if (lexer.checkNextChar() == '^') {
            lexer.getLexeme();
            result = Math.pow(result, parseFactor());
        }
        return result;
    }

    double parsePower() throws IOException {
        if (lexer.checkNextChar() == '-') {
            lexer.getLexeme();
            return -parseAtom();
        }
        return parseAtom();
    }

    double parseAtom() throws IOException {
        String lexeme = lexer.getLexeme();
        if (lexeme.equals("(")) {
            double result = parseExpr();
            if (!")".equals(lexer.getLexeme())) {
                throw new IOException("need )");
            }

            return result;
        }
        if (Character.isDigit(lexeme.charAt(0))) {
            return Integer.valueOf(lexeme);
        } else {
            throw new IOException("wrong character");
        }
    }
}

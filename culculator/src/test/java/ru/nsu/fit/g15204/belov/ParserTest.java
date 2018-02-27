package ru.nsu.fit.g15204.belov;

import org.junit.Test;

import java.io.IOException;
import java.io.StringReader;

import static org.junit.Assert.*;

//Created by Evgeny on 09.02.2018.

public class ParserTest {

    @Test
    public void parseString1() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("45+10")));
        assertEquals(55, parser.parseString(),0);
    }
    @Test(expected = IOException.class)
    public void parseString2() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("break")));
        parser.parseString();
    }
    @Test(expected = IOException.class)
    public void parseString3() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("4+15t")));
        parser.parseString();
    }

    @Test
    public void parseExpr1() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("15+5-3")));
        assertEquals(17, parser.parseExpr(),0);
    }

    @Test
    public void parseExpr2() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("2^((5+15)/2)")));
        assertEquals(1024, parser.parseExpr(),0);
    }

    @Test
    public void parseTerm1() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("1*3+2*6")));
        assertEquals(3, parser.parseTerm(),0);
    }

    @Test
    public void parseTerm2() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("33/11")));
        assertEquals(3, parser.parseTerm(),0);
    }
    @Test
    public void parseFactor1() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("25")));
        assertEquals(25, parser.parseFactor(),0);
    }
    public void parseFactor2() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("2^2^3")));
        assertEquals(256, parser.parseFactor(),0);
    }

    @Test
    public void parsePower1() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("10-9")));
        assertEquals(10, parser.parsePower(),0);
    }

    @Test
    public void parsePower2() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("-10-9")));
        assertEquals(-10, parser.parsePower(),0);
    }

    @Test
    public void parseAtom1() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("110+55")));
        assertEquals(110, parser.parseAtom(),0);
    }
    @Test
    public void parseAtom2() throws Exception {
        Parser parser = new Parser(new Lexer(new StringReader("(1+1)")));
        assertEquals(2, parser.parseAtom(),0);
    }


}
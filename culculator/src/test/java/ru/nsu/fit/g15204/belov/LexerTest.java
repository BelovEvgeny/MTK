package ru.nsu.fit.g15204.belov;

import org.junit.Test;

import java.io.StringReader;

import static org.junit.Assert.*;

//Created by Evgeny on 09.02.2018.

public class LexerTest {
    private Lexer lexer;
    @Test
    public void test1() throws Exception {
        lexer = new Lexer(new StringReader("15+97*8-(35)"));
        assertEquals("15",lexer.getLexeme());
        assertEquals("+",lexer.getLexeme());
        assertEquals("97",lexer.getLexeme());
        assertEquals("*",lexer.getLexeme());
        assertEquals('8',lexer.checkNextChar());
        assertEquals("8",lexer.getLexeme());
        assertEquals('-',lexer.checkNextChar());
        assertEquals("-",lexer.getLexeme());
        assertEquals('(',lexer.checkNextChar());
        assertEquals("(",lexer.getLexeme());
        assertEquals("35",lexer.getLexeme());
        assertEquals(")",lexer.getLexeme());
        assertEquals("@",lexer.getLexeme());
    }

    @Test
    public void test2() throws Exception {
        lexer = new Lexer(new StringReader("99999-444+5"));
        assertEquals("99999",lexer.getLexeme());
        assertEquals("-",lexer.getLexeme());
        assertEquals("444",lexer.getLexeme());
        assertEquals("+",lexer.getLexeme());
        assertEquals('5',lexer.checkNextChar());
        assertEquals("5",lexer.getLexeme());
        assertEquals("@",lexer.getLexeme());
        assertEquals(-1,lexer.checkNextChar());
    }



}
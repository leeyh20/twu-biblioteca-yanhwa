package com.twu.biblioteca;


import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BibliotecaAppTest {

    private String[] lastSysOutmessage;

    @Before
    public void injectLastSysOutDelegate() {
        BibliotecaApp.setSysOutDelegate(new FakeSysOut());
    }

    @Test
    public void shouldShowWelcomeMessage() {
        BibliotecaApp.main(new String[]{});

        assertEquals("Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!", lastSysOutmessage[0]);
    }

    @Test
    public void shouldShowListOfLibraryBooks() {
        BibliotecaApp.main(new String[]{});
        List<String> books = BibliotecaApp.getListOfLibraryBooks();
        assertEquals("Library Books\n" + String.join(" ", books), lastSysOutmessage[1]);
    }

    private class FakeSysOut implements SysOutDelegate {
        @Override
        public void println(String[] val) {
            lastSysOutmessage = val;
        }
    }
}

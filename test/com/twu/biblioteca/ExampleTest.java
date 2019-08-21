package com.twu.biblioteca;


import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class ExampleTest {

    String lastSysOutmessage;

    @Before
    public void injectLastSysOutDelegate() {
        BibliotecaApp.setSysOutDelegate(new FakeSysOut());
    }

    @Test
    public void shouldShowWelcomeMessage() {
        BibliotecaApp.main(new String[]{});

        assertEquals("Welcome!", lastSysOutmessage);
    }

    private class FakeSysOut implements SysOutDelegate {
        @Override
        public void println(String val) {
            lastSysOutmessage = val;
        }
    }
}

package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private static SysOutDelegate sysOutDelegate = new RealSysOut();

    public static void main(String[] args) {
        sysOutDelegate.println(new String[]{"Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!",
                String.join(" ", getListOfLibraryBooks())});
    }

    /**
     * Should I test this method or test that the list of library books were printed? I currently test how the list is printed
     * @return
     */
    public static List<String> getListOfLibraryBooks() {
        List<String> books = new ArrayList<>();
        return books;
    }

    protected static void setSysOutDelegate(SysOutDelegate val) {
        sysOutDelegate = val;
    }

    private static class RealSysOut implements SysOutDelegate {
        @Override
        public void println(String[] val) {
            System.out.print(String.join(" ", val));
        }
    }
}

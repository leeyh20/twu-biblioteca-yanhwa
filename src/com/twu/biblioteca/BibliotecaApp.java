package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

public class BibliotecaApp {

    private static SysOutDelegate sysOutDelegate = new RealSysOut();
    private static List<String> libraryBooks = new ArrayList<>();

    public static void main(String[] args) {
        sysOutDelegate.println(new String[]{"Welcome to Biblioteca. Your one-stop-shop for great book titles in Bangalore!",
                "Library Books\n" + String.join(" ", getListOfLibraryBooks())});
    }

    public static List<String> getListOfLibraryBooks() {
        return libraryBooks;
    }

    protected static void setListOfLibraryBooks(String[] books) {
        for(int i = 0; i < books.length; i++) {
            libraryBooks.add(books[i]);
        }
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

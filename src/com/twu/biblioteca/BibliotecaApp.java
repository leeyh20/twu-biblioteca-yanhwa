package com.twu.biblioteca;

public class BibliotecaApp {

    private static SysOutDelegate sysOutDelegate = new RealSysOut();

    public static void main(String[] args) {
        sysOutDelegate.println("hello");
    }

    protected static void setSysOutDelegate(SysOutDelegate val) {
        sysOutDelegate = val;
    }

    private static class RealSysOut implements SysOutDelegate {
        @Override
        public void println(String val) {
            System.out.print(val);
        }
    }
}

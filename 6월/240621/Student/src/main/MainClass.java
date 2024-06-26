package main;

import dao.StudentDao;

public class MainClass {
    public static void main(String[] args) {
        // menu
        StudentDao dao = new StudentDao();

        dao.create();
        dao.create();

        dao.read();

        dao.delete();

        dao.read();
    }
}

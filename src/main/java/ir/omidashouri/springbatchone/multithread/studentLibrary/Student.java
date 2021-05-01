package ir.omidashouri.springbatchone.multithread.studentLibrary;

import java.util.Random;

public class Student implements Runnable{

    private int id;
    private Book[] books;

    public Student(int id, Book[] books) {
        this.id = id;
        this.books = books;
    }

    public void run(){
        Random random = new Random();

        while (true){
            int bookId = random.nextInt(Constants.Number_OD_BOOKS);

            try{
                books[bookId].read(this);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                '}';
    }
}

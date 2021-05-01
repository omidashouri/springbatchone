package ir.omidashouri.springbatchone.multithread.studentLibrary;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecuteStudentLibrary {



    public static void execute(){

        ExecutorService executorService = Executors.newFixedThreadPool(Constants.Number_OD_STUDENTS);
        Student[] students = null;
        Book[] books = null;

        try {
            books = new Book[Constants.Number_OD_BOOKS];
            students = new Student[Constants.Number_OD_STUDENTS];

            for(int i=0;i<Constants.Number_OD_STUDENTS;i++){
                students[i] = new Student(i,books);
                executorService.execute(students[i]);
            }

        }catch (Exception exception){
            exception.printStackTrace();
            executorService.shutdown();
        }finally {
            executorService.shutdown();
        }

    }
}

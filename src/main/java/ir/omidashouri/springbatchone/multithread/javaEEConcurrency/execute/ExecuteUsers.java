package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.execute;

import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables.C1;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service.UserService;
import ir.omidashouri.springbatchone.multithread.javaEEConcurrency.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
@AllArgsConstructor
public class ExecuteUsers {

    private final UserService userService;

    public void execute() {
        ExecutorService executors = Executors.newSingleThreadExecutor();
        List<String> stringUsers = getUsersFromFile("javaeeconcurencyfiles/newusers.txt");
        for (String s : stringUsers) {
            Future<Long> longFuture = executors.submit(new C1(userService ,s));
            try {
                System.out.println("Resukt of Futer is: "+longFuture.get().toString());
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        }
        executors.shutdown();
        System.out.println("Execution Finished...............");
    }

    public static List<String> getUsersFromFile(String fileName) {
        List<String> stringUsers = new ArrayList<>();
        try {
            ResourceLoader resourceLoader = new DefaultResourceLoader();
            Resource resource = resourceLoader.getResource(fileName);
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (reader.ready()) {
                String line = reader.readLine();
                System.out.println(Thread.currentThread().getName() + " >> " + line);
                stringUsers.add(line);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
        return stringUsers;
    }
}

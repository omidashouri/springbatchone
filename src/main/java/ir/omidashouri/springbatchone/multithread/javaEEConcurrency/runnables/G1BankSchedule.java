package ir.omidashouri.springbatchone.multithread.javaEEConcurrency.runnables;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

@Component
@RequiredArgsConstructor
public class G1BankSchedule implements Runnable {


    private static final String urlName = "http://www.google.com";

    @Override
    public void run() {

        System.out.println("Thread Name is: "+Thread.currentThread().getName());
        String statusOfApp = "";
        URL url = null;
        try {
            url = new URL(urlName);

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();

            int responseCode = httpURLConnection.getResponseCode();

            if (responseCode == 200) {
                statusOfApp = "Yes, it is working";
            } else {
                statusOfApp = "Sorry! Something went wrong";
            }

        } catch (IOException e ) {
            e.printStackTrace();
        }

        System.out.println("Status of the app: " + statusOfApp);
    }
}

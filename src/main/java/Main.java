import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class Main {

    private static final int AMOUNT_EMAIL_ADRESSES = 10;

    public static void main(String[] agrs) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\ChromeWebDriver\\chromedriver.exe");

        ThreadFactory threadFactory = new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        };

        System.setProperty("java.awt.headless", "true");

        ScheduledExecutorService threadPoolExecutor = Executors.newScheduledThreadPool(10, threadFactory);

        threadPoolExecutor.scheduleWithFixedDelay(new SneakerRaffleBot(createEmailAdressList()),0,1000,TimeUnit.MILLISECONDS);
       // threadPoolExecutor.scheduleWithFixedDelay(new SneakerRaffleBot(createEmailAdressList()),0,1000,TimeUnit.MILLISECONDS);
       // threadPoolExecutor.scheduleWithFixedDelay(new SneakerRaffleBot(createEmailAdressList()),0,1000,TimeUnit.MILLISECONDS);
       // threadPoolExecutor.scheduleWithFixedDelay(new SneakerRaffleBot(createEmailAdressList()),0,1000,TimeUnit.MILLISECONDS);
       // threadPoolExecutor.scheduleWithFixedDelay(new SneakerRaffleBot(createEmailAdressList()),0,1000,TimeUnit.MILLISECONDS);
       // threadPoolExecutor.scheduleWithFixedDelay(new SneakerRaffleBot(createEmailAdressList()),0,1000,TimeUnit.MILLISECONDS);

        Thread.sleep(20000);

        threadPoolExecutor.shutdown();

    }

    private static List<String> createEmailAdressList() {
        List<String> emailList = new ArrayList<>();

        Faker faker = new Faker();

        for (int i = 0; i < AMOUNT_EMAIL_ADRESSES; i++) {
            String emailAdress = faker.funnyName().name();
            emailAdress += new Random().nextInt(1000);
            emailList.add(emailAdress.replaceAll(" ", ".").replaceAll("\\.\\.", ".") + "@kai-nortmann.de");
        }

        return emailList;
    }
}

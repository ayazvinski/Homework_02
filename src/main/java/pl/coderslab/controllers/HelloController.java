package pl.coderslab.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;


@Controller
public class HelloController {
    static final Logger logger = LoggerFactory.getLogger(HelloController.class);

    @GetMapping("/workers")
    public String workersAction(Model model) {
        model.addAttribute("worker",getWorker());
        return "workers";
    }

    public String getWorker(){

        String row;
        String worker = null;

        try {
            Scanner scan = new Scanner(new File("/Users/mac/Documents/CodersLab/Homework_02/Workers.txt"));
            HashMap<Integer,String> workersMap = new HashMap<>();

            while (scan.hasNextLine()){
                row = scan.nextLine();
                String[] keyValuePair = row.split(",",2);
                int key = Integer.parseInt(keyValuePair[0]);
                String value = keyValuePair[1];
                workersMap.put(key,value);
            }

            worker = workersMap.get(new Random().nextInt(30) + 1);

        } catch (FileNotFoundException nf) {
            logger.debug(nf + " No File!");
        }

        return worker;
    }
}

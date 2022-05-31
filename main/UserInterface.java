package main;

import static java.util.logging.Level.INFO;

import java.util.Scanner;
import java.util.logging.Logger;

public class UserInterface {

static Logger logger = Logger.getLogger(UserInterface.class.getName());
    public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);
      logger.info("Please select an option below.");

      int selection = scanner.nextInt();
      switch (selection) {
        case 1:
          
          break;
        case 2:
      
        default:
          break;
      }
      scanner.close();
      logger.info("fin");
    }
}

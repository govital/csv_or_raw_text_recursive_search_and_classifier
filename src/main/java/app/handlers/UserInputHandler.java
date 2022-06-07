package app.handlers;

import app.interfaces.IUserInput;

import java.util.Scanner;

public class UserInputHandler implements IUserInput {
    Scanner scanner = new Scanner(System.in);

    public String getUserInput() {
        return scanner.nextLine();
    }

}

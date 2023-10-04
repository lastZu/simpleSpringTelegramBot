package github.lastzu;

import github.lastzu.answer.AnswerFactory;
import github.lastzu.answer.DefaultAnswerFactory;
import github.lastzu.answer.EmptyAnswer;
import github.lastzu.contract.Request;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hi");
        AnswerFactory factory = new DefaultAnswerFactory(new EmptyAnswer());
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        factory.setRequest(
                new Request(
                        text,
                        ""
                )
        );
        String answer = factory.getResponse().text();
        System.out.println(answer);
    }
}
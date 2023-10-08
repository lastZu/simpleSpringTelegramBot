package github.lastzu;

import github.lastzu.answer.*;
import github.lastzu.contract.Request;
import github.lastzu.contract.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Scanner;

public class HandlingCLI {
    private AnswerFactory<Request, Response> answerFactory;
    Logger log = LoggerFactory.getLogger(this.getClass());

    public HandlingCLI(AnswerFactory<Request, Response> answerFactory) {
        this.answerFactory = answerFactory;
    }

    public static void main(String[] args) {
        Answer answer = new EchoAnswer();
        Answer firstAnswer = new StartAnswer(answer);
        HandlingCLI cli = new HandlingCLI(new CLIMaker<>(firstAnswer));
        cli.run();
    }

    public void run() {
        Request request = new Request(
                "id",
                "",
                ""
        );

        Scanner scanner = new Scanner(System.in);

        Response response = new Response("", new ArrayList<>(), "");
        while (true) {
            response = answerFactory
                    .setRequest(request)
                    .setRequestHandler(r -> r)
                    .setResponseHandler(r -> r)
                    .activate();

            if (response == null) {
                break;
            }

            System.out.println(response.text());
            for (String command : response.commands()) {
                System.out.print(" | " + command);
            }
            System.out.println(" | ");

            String command = scanner.nextLine();
            request = new Request(
                    "id",
                    command,
                    command
            );
        }
    }
}

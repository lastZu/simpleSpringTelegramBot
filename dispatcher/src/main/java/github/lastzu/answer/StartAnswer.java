package github.lastzu.answer;

import github.lastzu.contract.Request;
import github.lastzu.contract.Response;

import java.util.ArrayList;
import java.util.List;

public class StartAnswer implements Answer{
    private final Answer next;

    private boolean goNext;

    public StartAnswer(Answer next) {
        this.next = next;
    }

    @Override
    public Response getResponse(Request request) {
        String command = request.command();
        if (command.equals("echo")) {
            this.goNext = true;
            return this.next.getResponse(request);
        }
        if (command.equals("exit")) {
            return null;
        }

        List<String> commands = new ArrayList<>();
        commands.add("echo");
        commands.add("exit");
        return new Response(
                request.id(),
                commands,
                "Please print command"
        );
    }

    @Override
    public Answer next() {
        if (goNext) {
            return next;
        }
        return this;
    }
}

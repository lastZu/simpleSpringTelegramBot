package github.lastzu.answer;

import github.lastzu.contract.Request;
import github.lastzu.contract.Response;

import java.util.ArrayList;
import java.util.List;

public class EchoAnswer implements Answer{
    @Override
    public Response getResponse(Request request) {
        if (request.command().equals("exit")) {
            return null;
        }

        List<String> commands = new ArrayList<>();
        commands.add("exit");
        return new Response(
                request.id(),
                commands,
                request.text()
        );
    }

    @Override
    public Answer next() {
        return this;
    }
}

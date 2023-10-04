package github.lastzu.answer;

import github.lastzu.contract.Request;
import github.lastzu.contract.Response;

import java.util.ArrayList;
import java.util.List;

public class EmptyAnswer implements Answer {
    @Override
    public Response getResponse(Request request) {
        if (request.command().equals("start")) {
            return new Response(
                    "",
                    List.of("Test", "Rest"),
                    "What a you wont?"
            );
        }

        return new Response(
                "",
                new ArrayList<>(),
                ""
        );
    }
}

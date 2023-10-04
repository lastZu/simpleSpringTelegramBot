package github.lastzu.answer;

import github.lastzu.contract.Request;

final public class Answers {
    public static AnswerFactory getDefaultAnswerFactory() {
        return null; // TODO
    }

    public static Request getEmptyRequest() {
        return new Request(
                "",
                ""
        );
    }
}

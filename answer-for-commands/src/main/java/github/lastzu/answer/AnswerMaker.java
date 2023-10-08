package github.lastzu.answer;

import github.lastzu.contract.Request;
import github.lastzu.contract.RequestHandler;
import github.lastzu.contract.Response;
import github.lastzu.contract.ResponseHandler;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class AnswerMaker<T, R> extends AbstractAnswerMaker<T, R> {

    public AnswerMaker(Answer answer) {
        setAnswer(answer);
    }

    @Override
    protected void beforeActivationWork() {

    }

    @Override
    protected void afterActivationWork() {

    }
}

package github.lastzu.answer;

import github.lastzu.contract.RequestHandler;
import github.lastzu.contract.ResponseHandler;

public class CLIMaker<T, R> extends AbstractAnswerMaker<T, R>{
    private Answer firstAnswer;

    public CLIMaker(Answer answer) {
        setAnswer(answer);
        this.firstAnswer = answer;
    }

    @Override
    protected void beforeActivationWork() {

    }

    @Override
    protected void afterActivationWork() {
        firstAnswer = firstAnswer.next();
        setAnswer(firstAnswer);
    }
}

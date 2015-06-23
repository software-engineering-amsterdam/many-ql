package nl.uva.softwcons.ql.validation;

import java.util.ArrayList;
import java.util.List;

public abstract class Checker {
    private final List<Error> errorsFound;

    public Checker() {
        this.errorsFound = new ArrayList<>();
    }

    public void addError(final Error e) {
        this.errorsFound.add(e);
    }

    public List<Error> getErrors() {
        return this.errorsFound;
    }

}

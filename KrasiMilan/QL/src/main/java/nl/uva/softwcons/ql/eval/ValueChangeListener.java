package nl.uva.softwcons.ql.eval;

import nl.uva.softwcons.ql.eval.value.Value;

public interface ValueChangeListener<T extends Value> {
    void processValueChange(T oldValue, T newValue);
}

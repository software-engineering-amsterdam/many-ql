package nl.uva.softwcons.eval;

import nl.uva.softwcons.eval.value.Value;

public interface ValueChangeListener<T extends Value> {
    void processValueChange(T oldValue, T newValue);
}

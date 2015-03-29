package ql.gui;

import ql.semantics.ValueTable;
import ql.semantics.values.Value;

/**
 * Created by Nik on 3-3-15.
 */
public interface Refreshable
{
    public void refreshElement(ValueTable valueTable);
    public Value evaluate(ValueTable valueTable);
    //TODO: prerequisites method
}

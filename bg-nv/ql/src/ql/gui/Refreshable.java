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
    // TODO: is refresh prerequisite for what?
    // N: well, for refreshing :) i.e. other elements might need the value of this thing to know their own state
    public Boolean isRefreshPrerequisite();
}

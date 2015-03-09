package lang.ql.gui;

import lang.ql.semantics.ValueTable;
import lang.ql.semantics.values.Value;

/**
 * Created by Nik on 3-3-15.
 */
public interface Refreshable
{
    public void update(ValueTable valueTable);

    public Value evaluate(ValueTable valueTable);

    public Boolean isPrerequisite();
}

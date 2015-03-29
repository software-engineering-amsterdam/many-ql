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
<<<<<<< HEAD
    public Boolean isRefreshPrerequisite();
=======
    //TODO: prerequisites method
>>>>>>> 85dc25ba21df0a41365fea3cff36ad4bc9fb340b
}

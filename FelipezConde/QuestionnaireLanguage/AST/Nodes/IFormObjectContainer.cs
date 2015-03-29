using System.Collections.Generic;

namespace AST.Nodes
{
    public interface IFormObjectContainer
    {
        IList<FormObjects.FormObject> GetBody();
    }
}

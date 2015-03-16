using System.Collections.Generic;
using AST.Nodes.FormObjects;

namespace AST.Nodes
{
    public interface IFormObjectContainer
    {
        IList<FormObjects.FormObject> GetBody();
    }
}

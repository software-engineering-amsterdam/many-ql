using System.Collections.Generic;
using AST.Nodes.FormObject;

namespace AST.Nodes.Interfaces
{
    public interface IFormObjectContainer
    {
        IList<FormObject.FormObject> GetBody();
    }
}

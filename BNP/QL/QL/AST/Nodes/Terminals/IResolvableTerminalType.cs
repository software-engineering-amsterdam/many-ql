using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Model.Terminals
{
    /// <summary>
    /// A marker interface indicating the terminal can be used as a type indicator
    /// </summary>
    public interface IResolvableTerminalType : ITerminalType, ITypeStatic
    {
       
    }
}

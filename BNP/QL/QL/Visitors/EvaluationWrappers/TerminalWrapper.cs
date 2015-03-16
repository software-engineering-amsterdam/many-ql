using QL.Model.Terminals;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Visitors
{
    public abstract class TerminalWrapper//TODO change to  struct
    {
     public static NumberWrapper CreateWrapper(Number a){
         return new NumberWrapper(a);
     }
    public static YesnoWrapper CreateWrapper(Yesno a){
                return new YesnoWrapper(a);

    }
    public static TextWrapper CreateWrapper(Text a)
    {
        return new TextWrapper(a);

    }
    public static TerminalWrapper CreateWrapper(IResolvableTerminalType a)
    {
        return (TerminalWrapper)CreateWrapper((dynamic)a);

    }


    }

}

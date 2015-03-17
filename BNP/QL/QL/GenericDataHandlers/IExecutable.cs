using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.GenericDataHandlers
{
    public interface IExecutable
    {
        bool execute(DataContext context);
    }
}

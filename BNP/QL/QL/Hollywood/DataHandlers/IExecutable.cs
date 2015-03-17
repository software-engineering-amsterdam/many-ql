using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.GenericDataHandlers
{
    public interface IExecutable
        /* All data handlers that want to be registered to QLBuilder are required to be of this type.
         * Context with all relevant (and unrelevant) data is provided.
         * Hollywood
         */
    {
        bool execute(DataContext context);
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.UI.Interfaces
{
    public interface IWidget
    {
        object Value { get; set; }
        object Text { get; set; }
    }
}

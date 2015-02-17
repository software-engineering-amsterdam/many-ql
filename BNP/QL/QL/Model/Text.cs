using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Model
{
    class Text : TerminalBase
    {
        string value;

        public override string ToString()
        {
            if (value== null) {
                throw new ArgumentNullException();
            }
            else {
                return value;
            }
        }
    }
}

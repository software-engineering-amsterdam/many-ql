using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Model
{
    class Yesno : TerminalBase
    {
        bool value;

        public override string ToString()
        {
            if (value == null)
            {
                throw new Exception();
            }
            else if (value) { 
                return "Yes"; 
            }

            else { 
                return "No"; 
            }
        }
    }
}

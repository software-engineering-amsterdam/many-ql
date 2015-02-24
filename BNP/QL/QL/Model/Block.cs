using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Model
{
    public class Block : TreeElementBase
    {
        public Block()
        { }

        public Block(params TreeElementBase[] childUnits)
        {
            this.Children = childUnits;
        }

    }
}

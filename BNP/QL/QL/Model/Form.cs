using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Terminals;

namespace QL.Model
{
    public class Form : TreeElementBase
    {
        public Identifier Identifier { get; set; }
        public Block Block { get; set; }
    }
}

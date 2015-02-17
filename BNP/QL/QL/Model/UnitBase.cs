using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Terminals;

namespace QL.Model
{
    public abstract class UnitBase : TreeElementBase
    {
        public Identifier Id { get; set; }
        public string DisplayText { get; set; }

        protected UnitBase()
        {
            
        }
    }
}

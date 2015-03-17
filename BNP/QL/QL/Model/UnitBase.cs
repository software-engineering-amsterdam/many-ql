using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Terminals;

namespace QL.Model
{
    public abstract class UnitBase : ElementBase
    {
        public IResolvableTerminalType DataType { get; set; }
        public Identifier Identifier { get; set; }
        public string DisplayText { get; set; }
        
        protected UnitBase()
        {
            
        }
    }
}

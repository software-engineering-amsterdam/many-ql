using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Enums;

namespace QL.Model
{
    public class ControlBlock : AbstractNodeBase
    {
        public ControlBlockType Type { get; set; }
    }
}

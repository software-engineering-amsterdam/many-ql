﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Model
{
    public abstract class UnitBase : AbstractNodeBase
    {
        public Identifier Id { get; set; }
        public string DisplayText { get; set; }

        protected UnitBase()
        {
            
        }
    }
}

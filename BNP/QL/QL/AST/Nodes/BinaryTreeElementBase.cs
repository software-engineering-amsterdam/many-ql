using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Terminals;

namespace QL.Model
{
    public abstract class BinaryTreeElementBase : ElementBase
    {
        public ElementBase Left{get;set;}
        public ElementBase Right;
        protected BinaryTreeElementBase() { }
       
    }
}
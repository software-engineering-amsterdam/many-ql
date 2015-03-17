using QL.Model.Operators;
using QL.Model.Terminals;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Model
{
    public class Expression : ElementBase, ITypeInferred
    {
        public ElementBase Left{get; private set;}
        
        
        public Expression() { }
        public Expression(ElementBase child) 
        {
            Left = child;
        }
        
        
    }
}

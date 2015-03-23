using QL.Exceptions.Errors;
using System;

namespace QL.AST.Nodes.Terminals
{
    public class Yesno : BinaryTreeElementBase, IStaticReturnType
    {

        public bool? Value { get; set; }

        public Yesno()
        { }

        
        public Yesno(string unparsedValue)
        {
             if (unparsedValue.ToLowerInvariant() == "yes")
            {
                Value = true;
            }
            else if (unparsedValue.ToLowerInvariant() == "no")
            {
                Value = false;
            }
            else
            {
                throw new QLError("Cannot parse the value:" + unparsedValue);
            }         
        }
        public Yesno(string unparsedValue, AST.SourceLocation sourceLocation):this(unparsedValue)
        {
         SourceLocation=sourceLocation;       
        }

        public Type GetReturnType()
        {
            return GetType();
        }

        public override string ToString()
        {
            if (!Value.HasValue)
            {
                throw new Exception();
            }
            

            return Value.Value ? "yes" : "no";
        }
       

    }
}

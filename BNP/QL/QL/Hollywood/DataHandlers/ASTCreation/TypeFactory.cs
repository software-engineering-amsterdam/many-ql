using QL.AST.Nodes;
using QL.AST.Nodes.Terminals;
using QL.Exceptions.Errors;
using QL.Grammar;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Hollywood.DataHandlers.ASTCreation
{
    class TypeFactory
    {
        public TypeFactory() { }
        IStaticReturnType _GetTypeInstance(QLParser.YesnoTypeContext typeContext)
        {
            return new Yesno();
        }
         IStaticReturnType _GetTypeInstance(QLParser.NumberTypeContext typeContext)
        {
            return new Number();
        }
         IStaticReturnType _GetTypeInstance(QLParser.TextTypeContext typeContext)
        {
            return new Text();
        }
         IStaticReturnType _GetTypeInstance(QLParser.TypeContext typeContext)
        {
            throw new ParserError("type not recognized" + typeContext.ToString());

        }
        public  IStaticReturnType GetTypeInstance(QLParser.TypeContext typeContext)
        {
            return _GetTypeInstance((dynamic)typeContext);

        }
    }
}

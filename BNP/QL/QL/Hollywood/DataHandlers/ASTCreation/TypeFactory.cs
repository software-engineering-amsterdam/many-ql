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
        static IStaticReturnType _getTypeInstance(QLParser.YesnoTypeContext typeContext)
        {
            return new Yesno();
        }
        static IStaticReturnType _getTypeInstance(QLParser.NumberTypeContext typeContext)
        {
            return new Number();
        }
        static IStaticReturnType _getTypeInstance(QLParser.TextTypeContext typeContext)
        {
            return new Text();
        }
        static IStaticReturnType _getTypeInstance(QLParser.TypeContext typeContext)
        {
            throw new ParserError("type not recognized" + typeContext.ToString());

        }
        public static IStaticReturnType GetTypeInstance(QLParser.TypeContext typeContext)
        {
            return _getTypeInstance((dynamic)typeContext);

        }
    }
}

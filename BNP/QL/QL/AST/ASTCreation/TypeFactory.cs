using QL.AST.Nodes;
using QL.AST.Nodes.Terminals;
using QL.Exceptions.Errors;
using QL.Grammar;

namespace QL.AST.ASTCreation
{
    public sealed class TypeFactory
    {
        public IStaticReturnType GetTypeInstance(QLParser.TypeContext typeContext)
        {
            return GetTypeInstanceFor((dynamic)typeContext);
        }

        private IStaticReturnType GetTypeInstanceFor(QLParser.YesnoTypeContext typeContext)
        {
            return new Yesno();
        }

        private IStaticReturnType GetTypeInstanceFor(QLParser.NumberTypeContext typeContext)
        {
            return new Number();
        }

        private IStaticReturnType GetTypeInstanceFor(QLParser.TextTypeContext typeContext)
        {
            return new Text();
        }

        private IStaticReturnType GetTypeInstanceFor(QLParser.TypeContext typeContext)
        {
            throw new ParserError("Unrecognised type: " + typeContext);
        }
    }
}

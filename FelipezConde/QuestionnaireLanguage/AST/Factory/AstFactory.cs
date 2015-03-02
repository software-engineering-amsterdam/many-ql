using AST.Factory.PartialFactories;
using AST.Nodes.Interfaces;
using AST.Nodes.KeyValuePair;
using Grammar;

namespace AST.Factory
{
    public static class ASTFactory
    {
        #region FormElements
        public static IASTNode GetNode(QLMainParser.FormContext context)       
        { return FormElements.GetNode(context); }
        public static IASTNode GetNode(QLMainParser.FormSectionContext context)
        { return FormElements.GetNode(context); }
        public static IASTNode GetNode(QLMainParser.QuestionContext context)   
        { return FormElements.GetNode(context); }
        public static IASTNode GetNode(QLMainParser.ConditionalContext context)
        { return FormElements.GetNode(context); }
        #endregion

        #region Expressions
        public static IASTNode GetNode(QLMainParser.PrimitiveTypeNameContext context)
        { return Expressions.GetNode(context); }
        public static IASTNode GetNode(QLMainParser.GenericTypeNameContext context)
        { return Expressions.GetNode(context); }
        public static IASTNode GetNode(QLMainParser.PriorityExpressionContext context)
        { return Expressions.GetNode(context); }
        public static IASTNode GetNode(QLMainParser.IdContext context)
        { return Expressions.GetNode(context); }
        public static IASTNode GetNode(QLMainParser.ExpressionIdContext context)
        { return Expressions.GetNode(context); }
        public static IASTNode GetNode(QLMainParser.AndContext context)
        { return Expressions.GetNode(context); }
        public static IASTNode GetNode(QLMainParser.ExpressionTypeContext context)
        { return Expressions.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.NegateContext context)
        { return Expressions.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.OrContext context)
        { return Expressions.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.EqualityContext context)
        { return Expressions.GetNode(context); } 
        #endregion

        #region Comparison
        internal static IASTNode GetNode(QLMainParser.PriorityComparisonContext context)
        { return Comparisson.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.ArithmeticComparisonContext context)
        { return Comparisson.GetNode(context); }
        #endregion

        #region Arithmetic
        internal static IASTNode GetNode(QLMainParser.PriorityArithmeticContext context)
        { return Arithmetic.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.SubAddContext context)
        { return Arithmetic.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.DivMulContext context)
        { return Arithmetic.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.ArithmeticIdContext context)
        { return Arithmetic.GetNode(context); }
        #endregion

        #region Types
        internal static IASTNode GetNode(QLMainParser.NumIntContext context)
        { return Types.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.NumMoneyContext context)
        { return Types.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.NumDecimalContext context)
        { return Types.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.BoolValueContext context)
        { return Types.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.StringValueContext context)
        { return Types.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.DateValueContext context)
        { return Types.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.ListContext context)
        { return Types.GetNode(context); }
        #endregion

        #region KeyValue
        internal static IASTNode GetNode(QLMainParser.KeyValuePairContext context)
        { return KeyValue.GetNode(context); }
        internal static IASTNode GetNode(QLMainParser.KeyValuePairsContext context)
        { return new KeyValuePairs(); }
        #endregion 
    }
}

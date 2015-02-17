using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Grammar;
using AST.Nodes;
using AST.Nodes.FormSection;
using Antlr4.Runtime.Tree;
using Antlr4.Runtime;
using AST.Nodes.FormElement;
using AST.Nodes.FormObject;
using AST.Nodes.GenericTypeName;
using AST.Factory;
using AST.Nodes.Interfaces;

namespace AST
{
    public class MainVisitor : QLMainBaseVisitor<IASTNode>
    {
        private IEnumerable<IASTNode> VisitChildren(ParserRuleContext context)
        {
            foreach (IParseTree child in context.children)
            {
                IASTNode visitedElement = Visit(child);

                if (visitedElement != null)
                    yield return visitedElement;
            }
        }

        public override IASTNode VisitForm(QLMainParser.FormContext context)
        {
            IASTNode ast = new Form();

            foreach (IASTNode child in VisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitFormSection(QLMainParser.FormSectionContext context)
        {
            IASTNode ast = new FormSection();

            foreach (IASTNode child in VisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitFormObject(QLMainParser.FormObjectContext context)
        {
            IASTNode ast = new FormSection();

            foreach (IASTNode child in VisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitFormElement(QLMainParser.FormElementContext context)
        {
            IASTNode ast = new FormElement();

            foreach (IASTNode child in VisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitConditional(QLMainParser.ConditionalContext context)
        {
            IASTNode ast = new Conditional();

            foreach (IASTNode child in VisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override IASTNode VisitTypeName(QLMainParser.TypeNameContext context)
        {
            IASTNode ast = new GenericTypeName();

            //if (context.GetText().Equals("genericTypeName"))
            //    ast = new GenericTypeNameNode();
            //else

            foreach (IASTNode child in VisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

    }

    /*
    /// <summary>
    /// This Partial class contains the visitors that handle the form structure productions
    /// </summary>
    public partial class QLVisitor: GrammarProject.IQLMainVisitor<RoseTree>
    {
        Dictionary<string, string> symbolTable = new Dictionary<string, string>();
        RoseTree AST;

        ArithmeticVisitor arithmeticVis = new ArithmeticVisitor();
        ExpressionVisitor expressionVis = new ExpressionVisitor();
        KeyValPairVisitor keyValPairVis = new KeyValPairVisitor();
        FormVisitor formVis = new FormVisitor();
        TypeVisitor typeVis = new TypeVisitor();

    }

    /// <summary>
    /// This partial class contains the visitors that handle the type related productions 
    /// </summary>
    public partial class QLVisitor : GrammarProject.IQLMainVisitor<RoseTree>
    {
        ArithmeticVisitor arVis = new ArithmeticVisitor();


        RoseTree Antlr4.Runtime.Tree.IParseTreeVisitor<RoseTree>.Visit(Antlr4.Runtime.Tree.IParseTree tree)
        {
            throw new NotImplementedException();
        }

        RoseTree Antlr4.Runtime.Tree.IParseTreeVisitor<RoseTree>.VisitChildren(Antlr4.Runtime.Tree.IRuleNode node)
        {
            throw new NotImplementedException();
        }

        RoseTree Antlr4.Runtime.Tree.IParseTreeVisitor<RoseTree>.VisitErrorNode(Antlr4.Runtime.Tree.IErrorNode node)
        {
            throw new NotImplementedException();
        }

        RoseTree Antlr4.Runtime.Tree.IParseTreeVisitor<RoseTree>.VisitTerminal(Antlr4.Runtime.Tree.ITerminalNode node)
        {
            throw new NotImplementedException();
        }
    }

    /// <summary>
    /// This partial class contains the visitors that handle the KeyValPairs productions
    /// </summary>
    public partial class QLVisitor : GrammarProject.QLMainBaseVisitor<RoseTree>
    {
        RoseTree IQLMainVisitor<RoseTree>.VisitKeyValPair(QLMainParser.KeyValPairContext context)
        {
            throw new NotImplementedException();
        }
    }

    /// <summary>
    /// This partial class contains the visitors that handle the expression productions
    /// </summary>
    public partial class QLVisitor : GrammarProject.QLMainBaseVisitor<RoseTree>
    {

    }

    /// <summary>
    /// This partial class contains the visitors that handle the arithmetic productions
    /// </summary>
    public partial class QLVisitor : GrammarProject.QLMainBaseVisitor<RoseTree>
    {

    }
     */
}

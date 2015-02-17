using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using GrammarProject;
using QuestionnaireLanguage.AST.Nodes;
using QuestionnaireLanguage.AST.Nodes.FormSection;
using Antlr4.Runtime.Tree;
using Antlr4.Runtime;
using QuestionnaireLanguage.AST.Nodes.FormElement;
using QuestionnaireLanguage.AST.Nodes.FormObject;
using QuestionnaireLanguage.AST.Nodes.GenericTypeName;
using QuestionnaireLanguage.AST.Factory;

namespace QuestionnaireLanguage.AST
{
    public class QLMainVisitor : QLMainBaseVisitor<iASTNode>
    {
        private IEnumerable<iASTNode> VisitChildren(ParserRuleContext context)
        {
            foreach (IParseTree child in context.children)
            {
                iASTNode visitedElement = Visit(child);

                if (visitedElement != null)
                    yield return visitedElement;
            }
        }

        public override iASTNode VisitForm(QLMainParser.FormContext context)
        {
            iASTNode ast = new FormNode();

            foreach (iASTNode child in VisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override iASTNode VisitFormSection(QLMainParser.FormSectionContext context)
        {
            iASTNode ast = new FormSectionNode();

            foreach (iASTNode child in VisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override iASTNode VisitFormObject(QLMainParser.FormObjectContext context)
        {
            iASTNode ast = new FormSectionNode();

            foreach (iASTNode child in VisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override iASTNode VisitFormElem(QLMainParser.FormElemContext context)
        {
            iASTNode ast = new FormElementNode();

            foreach (iASTNode child in VisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override iASTNode VisitConditional(QLMainParser.ConditionalContext context)
        {
            iASTNode ast = new ConditionalNode();

            foreach (iASTNode child in VisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override iASTNode VisitFormElemType(QLMainParser.FormElemTypeContext context)
        {
            iASTNode ast = AstFactory.GetNodeFactory().GetFormObjectNode(context.GetText());

            foreach (iASTNode child in VisitChildren(context))
                ast.AddChild(child);

            return ast;
        }

        public override iASTNode VisitTypeName(QLMainParser.TypeNameContext context)
        {
            iASTNode ast = new GenericTypeNameNode();

            //if (context.GetText().Equals("genericTypeName"))
            //    ast = new GenericTypeNameNode();
            //else

            foreach (iASTNode child in VisitChildren(context))
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

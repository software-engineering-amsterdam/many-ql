using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime.Tree;
using QL;
using QL.Model;
using System.Diagnostics;
using QL.Model.Terminals;
using Antlr4.Runtime;
using QL.Model.Operators;


namespace QL.Grammars
{
    public class QLListener : QLBaseListener
    {
        #region Common 
        private readonly Stack<Stack<ElementBase>> _childrenStack;
        private ElementBase _astRootNode;

        public QLListener()
        {
            _childrenStack = new Stack<Stack<ElementBase>>();
        }

        public void InitializeNewLevel()
        {
            _childrenStack.Push(new Stack<ElementBase>());
        }

        public bool AstExists
        {
            get { return _astRootNode != null; }
        }

        public AstHandler GetAst()
        {
            if (AstExists)
            {
                return new AstHandler(_astRootNode);
            }
            throw new Exception("Ast is not created");
        }

        private IList<ElementBase> GetChildren()
        {
            Debug.Assert(_childrenStack.Any(), "Level with children should be always initialized before appending one.");//TODO maybe throw it out
            Stack<ElementBase> children = _childrenStack.Pop();
            //stack has opposite ordering, need to be reversed to have the order as it was created.  // todo use queue instead          
            IList<ElementBase> reversed = children.Reverse().ToList();
            return reversed;
        }

        private void AppendToAST(ElementBase newChild)
        {
            if (_childrenStack.Any())
            {
                Stack<ElementBase> siblings = _childrenStack.Peek();
                siblings.Push(newChild);
            }
            else
            {
                //this is the last one
                _astRootNode = newChild;
            }
        }

        #endregion
        # region  Overridden listener methods
        public override void EnterFormBlock(QLParser.FormBlockContext context)
        {
            InitializeNewLevel();
            
        }
        public override void ExitFormBlock(QLParser.FormBlockContext context)
        {                       
            IList<ElementBase> children = GetChildren();

            Debug.Assert((children.Count() == 1), "Form block could have only one child - block. Maybe you changed IDENTIFIER as a parser rule?");
            
            Identifier formBlockId = new Identifier(context.IDENTIFIER().GetText());
            Block bodyBlock = (Block) children[0];
            Form form = new Form(formBlockId, bodyBlock);
            form.SourceLocation = SourceLocation.CreateFor(context);           
            AppendToAST(form);
        }

        public override void EnterBlock(QLParser.BlockContext context)
        {
            InitializeNewLevel();
        }

        public override void ExitBlock(QLParser.BlockContext context)
        {
            Block block = new Block();
            block.SourceLocation = SourceLocation.CreateFor(context);
            block.Children = GetChildren();
            AppendToAST(block);
        }

        public override void EnterQuestionUnit(QLParser.QuestionUnitContext context)
        {
            InitializeNewLevel();
        }

        public override void ExitQuestionUnit(QLParser.QuestionUnitContext context)
        {
            IList<ElementBase> children = GetChildren();//either call this or remove the InitializeNewLevel above
            Debug.Assert(!children.Any(), "A unit should syntactically not have any children.");

            Identifier identifier = new Identifier(context.IDENTIFIER().GetText());
            ITerminalType dataType = GetTypeInstance(context.type());
            dataType.SetValue(context.type().GetText());
            string unitText = context.TEXT().GetText();
            
            QuestionUnit question = new QuestionUnit();

            question.Identifier = identifier;
            question.DataType = dataType;
            question.DisplayText = unitText;
            question.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(question);
        }
        
        public override void EnterStatementUnit(QLParser.StatementUnitContext context)
        {
            InitializeNewLevel();            
        }

        public override void ExitStatementUnit(QLParser.StatementUnitContext context)
        {
            IList<ElementBase> children = GetChildren();
            Debug.Assert((children.Count() == 1), "A unit should syntactically not have any children.");

            Identifier identifier = new Identifier(context.IDENTIFIER().GetText());
            ITerminalType dataType = GetTypeInstance(context.type());
            dataType.SetValue(context.type().GetText());
            string unitText = context.TEXT().GetText();

            StatementUnit statement = new StatementUnit();

            statement.Expression = (Expression)children[0];
            statement.Identifier = identifier;
            statement.DataType = dataType;
            statement.DisplayText = unitText;
            statement.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(statement);
        }

        public ITerminalType GetTypeInstance(QLParser.TypeContext context)
        {
            if (context as QLParser.YesnoContext != null) return new Yesno();

            if (context as QLParser.NumberContext != null) return new Number();

            if (context as QLParser.TextContext != null) return new Text();

            Debug.Assert(false, "No appropriate subtype for the type has been evaluated");
            return null; // formality
        }

        public override void EnterControlUnit(QLParser.ControlUnitContext context)
        {
            InitializeNewLevel();       
        }

        public override void ExitControlUnit(QLParser.ControlUnitContext context)
        {
            IList<ElementBase> children = GetChildren();

            ControlUnit controlUnit = new ControlUnit();
            Debug.Assert(children.Count() == 2 || children.Count() == 3, "Bad number of controlUnit children");

            if (children.Count() == 3)
            {   //                         expresion                if block            else block
                controlUnit.HandleChildren((Expression)children[0], (Block)children[1], (Block)children[2]);
            }
            else if (children.Count() == 2)
            {   //                         expression               if block
                controlUnit.HandleChildren((Expression)children[0], (Block)children[1]);
            }

            controlUnit.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(controlUnit);
        } 

        public override void EnterLiteral(QLParser.LiteralContext context)
        {
            InitializeNewLevel();
        }

        public override void ExitLiteral(QLParser.LiteralContext context)
        {
            IList<ElementBase> children = GetChildren();

            AppendLiteral<Yesno>(context, context.YESNO());
            AppendLiteral<Number>(context, context.NUMBER());
            AppendLiteral<Identifier>(context, context.IDENTIFIER());
            AppendLiteral<Text>(context, context.TEXT());

            Debug.Assert(!children.Any(), "Children of the literal are not empty");
        }

        public void AppendLiteral<T>(QLParser.LiteralContext context, ITerminalNode node) where T : BinaryTreeElementBase, ITerminalType, new()
        {
            if (node == null) return;

            T literal = new T();
            literal.SetValue(node.GetText());
            literal.SourceLocation = SourceLocation.CreateFor(context);
            
            AppendToAST(literal);
        }

        public override void EnterExpression(QLParser.ExpressionContext context)
        {
            InitializeNewLevel();
        }

        public override void ExitExpression(QLParser.ExpressionContext context)
        {
            IList<ElementBase> children = GetChildren();
            Expression expression = new Expression();
            if (children.Count() == 1)
            {
                expression.HandleChildren(children[0]);
            }
            else if (children.Count() == 2 && context.children.Count() == 5)
            {
                BinaryTreeElementBase op;
                switch (context.children[2].GetText())
                {
                    case ("+"):
                        {
                            op = new AndOperator();
                            break;
                        }
                    case ("=="):
                        {
                            op = new EqualsOperator();
                            break;
                        }
                    case "!=":
                        {
                            op = new NotEqualsOperator();
                            break;
                        }
                    default:
                        throw new Exception(" operator not identified");
                    
                }
                op.HandleChildren((ElementBase)children[0], (ElementBase)children[1]);
                op.SourceLocation = SourceLocation.CreateFor(context);
                expression.SourceLocation = SourceLocation.CreateFor(context);

                expression.HandleChildren(op);
            }
            
            AppendToAST(expression);

            //TODO
        }
        
        
        

        #endregion
    }

    
}

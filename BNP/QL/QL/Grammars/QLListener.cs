using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL;
using QL.Model;
using System.Diagnostics;
using QL.Model.Terminals;
using QL.Factories;
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
        public bool AstExists()
        {
            return _astRootNode != null; 
        }

        public AstHandler GetAst()
        {
            if (AstExists())
            {
                return new AstHandler(_astRootNode);
            }
            else
            {
                throw new Exception(" Ast is not created");
            }
        }

        private IList<ElementBase> GetChildren()
        {
            Debug.Assert(_childrenStack.Any(), "Level with children should be always initialized before appending one.");//TODO maybe throw it out
            IList<ElementBase> e = _childrenStack.Pop().ToList();
            //stack has opposite ordering, need to be reversed to have the order as it was created.           
            IList<ElementBase> reversed = e.Reverse().ToList();
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
        # region  Overriden listener methods
        public override void EnterFormBlock(QLParser.FormBlockContext context)
        {
            InitializeNewLevel();
            
        }
        public override void ExitFormBlock(QLParser.FormBlockContext context)
        {                       
            IList<ElementBase> children = GetChildren();

            Debug.Assert((children.Count() == 1), "Form block could have only one child - block. Maybe you changed IDENTIFIER as a parser rule?");
            
            
            Identifier formBlockId = new Identifier(context.IDENTIFIER().GetText());
            Block block = (Block) children[0];
            Form form = new Form(formBlockId, block);
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
            block.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(block);
        }


        
        public override void EnterQuestionUnit(QLParser.QuestionUnitContext context)
        {
            InitializeNewLevel();

            
        }
        public override void ExitQuestionUnit(QLParser.QuestionUnitContext context)
        {
            
            IList<ElementBase> children = GetChildren();//either call this or remove the InitializeNewLevel  above
            Debug.Assert(!children.Any(), "A unit should syntactically not have any children.");

            Identifier identifier = new Identifier(context.IDENTIFIER().GetText());
            string typeName = context.type().GetText();
            string unitText = context.TEXT().GetText();

            TerminalTypeFactory typeFactory = new TerminalTypeFactory(typeName);
            ITerminalType dataType = typeFactory.Create();

            QuestionUnit question = new QuestionUnit();
            question.Identifier = identifier;
            question.DataType = dataType;
            question.DisplayText = unitText;
            // todo: extract required attribute from unit
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
            Debug.Assert((children.Count() == 1), "Form block could have one and only one child - expression.");

            Identifier identifier = new Identifier(context.IDENTIFIER().GetText());
            string typeName = context.type().GetText();
            string unitText = context.TEXT().GetText();

            TerminalTypeFactory typeFactory = new TerminalTypeFactory(typeName);
            ITerminalType dataType = typeFactory.Create();

            StatementUnit statement = new StatementUnit();

            statement.Expression = (Expression)children[0];
            statement.Identifier = identifier;
            statement.DataType = dataType;
            statement.DisplayText = unitText;
            statement.SourceLocation = SourceLocation.CreateFor(context);

            AppendToAST(statement);
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
        if (children.Count()==3)
        {
            controlUnit.HandleChildren((Expression)children[0], (Block)children[1], (Block)children[2]);                
        }
        else if (children.Count() ==2)
        {
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

            if (context.YESNO() != null)
            {

                Yesno literal = new Yesno();
                literal.Value = context.YESNO().ToString()=="yes"?true:false;
                literal.SourceLocation = SourceLocation.CreateFor(context);

                AppendToAST(literal);
            }
            else if (context.NUMBER() != null) {
                Number literal = new Number();
                literal.Value = Int32.Parse(context.NUMBER().ToString());
                literal.SourceLocation = SourceLocation.CreateFor(context);

                AppendToAST(literal);

                }
            else if (context.IDENTIFIER() != null) {
                //todo assign not to value but just pointer probably, value will be determined later
                Identifier literal = new Identifier();
                literal.PointerName = context.IDENTIFIER().ToString();
                literal.SourceLocation = SourceLocation.CreateFor(context);

                AppendToAST(literal);

            }
            else if (context.TEXT() != null)
            {
                Text literal = new Text();
                literal.Value = context.TEXT().ToString();
                literal.SourceLocation = SourceLocation.CreateFor(context);


                AppendToAST(literal);


            }
            else {
                Debug.Assert(children.Count()>0, " children of a literal are  not empty" );
            }
            ;



        }

        public override void EnterExpression(QLParser.ExpressionContext context)
        {
            InitializeNewLevel();

 	         
        }
        public override void ExitExpression(QLParser.ExpressionContext context)
        {
            IList<ElementBase> children = GetChildren();
            Expression e = new Expression();
            if (children.Count()==1)
            {
                e.HandleChildren(children[0]);
            }
            else if (children.Count() == 2 &&(context.children.Count()==5)) {
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
                e.SourceLocation = SourceLocation.CreateFor(context);

                e.HandleChildren(op);
            }
            
            AppendToAST(e);

            //TODO
        }
        
        
        

        #endregion
    }

    
}

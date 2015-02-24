using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Antlr4.Runtime;
using Antlr4.Runtime.Tree;
using QL.Grammars;
using QL.Model.Terminals;
using System.Diagnostics;

namespace QL.Model
{
    public sealed class NodeMapper
    {
        private readonly Stack<Stack<ElementBase>> _childrenStack;
        private ElementBase _astRootNode;
        
        public NodeMapper()
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

        private IList<ElementBase> GetChildren()
        {
            Debug.Assert(_childrenStack.Any(), "Level with children should be always initialized before appending one.");//TODO maybe throw it out
            return _childrenStack.Pop().ToList();
        }

        private void PutIntoTree(ElementBase newChild)
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

        
        
        #region Model creation methods
        public UnitBase Create(QLParser.QuestionUnitContext context)
        {
            Identifier identifier = new Identifier(context.IDENTIFIER().GetText());
            string typeName = context.typeName().GetText();
            string unitText = context.TEXT().GetText();

            TerminalTypeFactory typeFactory = new TerminalTypeFactory(typeName);
            ITerminalType answerType = typeFactory.Create();

            QuestionUnit question = new QuestionUnit(identifier, answerType, unitText, true); //true == todo

            return question;
        }

        public UnitBase Create(QLParser.StatementUnitContext context)
        {
            Identifier identifier = new Identifier(context.IDENTIFIER().GetText());
            string typeName = context.typeName().ToString();
            string unitText = context.TEXT().GetText();

            TerminalTypeFactory typeFactory = new TerminalTypeFactory(typeName);
            ITerminalType answerType = typeFactory.Create();

            StatementUnit statement = new StatementUnit(identifier, answerType, unitText);

            return statement;
        }

       
        public TreeElementBase Create(QLParser.UnitContext context)
        {
            // todo: not use 'is' operator, but not sure how to do that now
           
            throw new ArgumentOutOfRangeException("context");
        }

        public void Create(QLParser.ControlBlockContext context)
        {
            IList<ElementBase> children = GetChildren();

            ControlBlock controlBlock = new ControlBlock();

            controlBlock.HandleChildren(children);


            PutIntoTree(controlBlock);
        }

        public Block Create(QLParser.BlockContext context)
        {
            TreeElementBase[] childUnits = context.unit().Select(Create) as TreeElementBase[];
            return new Block(childUnits);
        }

        // todo: move to own mapper
        public Form Create(QLParser.FormBlockContext context)
        {
            Identifier formBlockId = new Identifier(context.IDENTIFIER().GetText());
            Block formBody = Create(context.block());
            Form retVal = new Form(formBlockId, formBody);
            retVal.SourceLocation = SourceLocation.Create(context);

            return retVal;
        }

        internal void Create(ParserRuleContext context)
        {

            throw new NotImplementedException()
        }

        #endregion
    }
}

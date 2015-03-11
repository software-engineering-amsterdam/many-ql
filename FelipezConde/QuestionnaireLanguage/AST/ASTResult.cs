using AST.Nodes;
using AST.Nodes.Expression;
using AST.Nodes.Interfaces;
using AST.Nodes.Values;
using AST.Notification;
using AST.Representation;
using AST.Storage;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace AST
{
    public class ASTResult : IASTResult
    {
        public IFormObjectContainer Ast { get; private set; }
        private SymbolTable table;
        private List<INotification> notifications;

        public ASTResult(IFormObjectContainer tree)
        {
            this.Ast = tree;
            table = new SymbolTable();
            
            //todo: traverse AST and typecheck
            //todo: init notifications and stuff
            //todo: probably something else

        }

        public void SetValue(Id key, Value value)
        {
            table.SetUpdateValue(key, value);
        }

        public Value GetValue(Id key)
        {
            return table.GetValue(key);
        }

        public bool IsTypeCorrect()
        {
            throw new NotImplementedException();
        }

        public bool HasDuplicateIdentifiers()
        {
            throw new NotImplementedException();
        }

        public bool IsCorrect()
        {
            throw new NotImplementedException();
        }

        public void SetValue(string key, ObjectValue value)
        {
            throw new NotImplementedException();
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Enums;
using QL.Exceptions;
using QL.Evaluation;

namespace QL.Model
{
    public abstract class ElementBase : IVisitable
    {
        public SourceLocation SourceLocation { get; set; }
        public IList<ElementBase> Children { get; set; }
        protected List<TypeException> TypeExceptions;
        /// <summary>
        /// Gets an ElementType indicating if this element is a leaf or a node.
        /// </summary>
        public abstract ElementType ElementType { get; }
        protected ElementBase ()
        {
            Children = new List<ElementBase>();
            TypeExceptions = new List<TypeException>();
        }

        internal void HandleChildren(IList<ElementBase> list)
        {
            Children = list;
            
        }
        public virtual Type GetReturnType(){
            return GetType();
        }

        protected virtual bool _CheckType(){return true;}//make abstract when implemented

        public bool CheckType()
        {
            bool ok = _CheckType();

            foreach (ElementBase child in Children)
            {
                ok &= child.CheckType();
            }

            return ok;
        }

        public List<TypeException> CollectTypeExceptions()
        {
            List<TypeException> retval = TypeExceptions;
            foreach (ElementBase child in Children)
            {
                retval.AddRange(child.CollectTypeExceptions());
            }
            return retval;
        }

        public virtual bool Evaluate() { return false; }
        
        public virtual void Accept(IVisitor visitor)
        {
            visitor.Visit((dynamic) this); //dynamic!! BECAUSE It's cloning to implement this for everything as the same
            
            foreach(ElementBase child in Children){
                child.Accept(visitor);
            }
        }
    }
}

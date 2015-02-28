using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model;
using QL.Exceptions;

namespace QL
{
    public class AstHandler
    {
        public ElementBase RootNode {  get; private set; }
         public IList<TypeException> TypeCheckerExceptions {   get; private set; }
         public IList<QLException> EvaluationExceptions {  get; private set; }

         public AstHandler(ElementBase root)
         {
             RootNode = root;
             TypeCheckerExceptions= new List<TypeException>();
             EvaluationExceptions= new List<QLException>();
         }

         
         public bool CheckType()
         {
             bool ok = RootNode.CheckType();//implement visit here
             if (!ok) {
             TypeCheckerExceptions = RootNode.CollectTypeExceptions();
             }

             return ok;
         }
         public bool Evaluate()
         {
             RootNode.Evaluate();//implement visit here
             return EvaluationExceptions.Any();
         }
    }
}

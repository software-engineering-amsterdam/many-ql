using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Model
{
    public abstract class AbstractNodeBase
    {
        public SourceLocation SourceLocation { get; protected set; }
        public IList<AbstractNodeBase> Children { get; private set; }

        protected AbstractNodeBase()
        {
            Children = new List<AbstractNodeBase>();
        }
    }
}

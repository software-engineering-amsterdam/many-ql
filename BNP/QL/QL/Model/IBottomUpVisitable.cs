using QL.Visitors;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace QL.Model

{
    public interface IBottomUpVisitable
    {
        void AcceptBottomUp(IVisitor visitor);
    }
}

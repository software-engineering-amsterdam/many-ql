using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Evaluation
{
    public interface IValueVisitor<T>
    {
        T Visit(Values.String value);

        T Visit(Values.Int value);

        T Visit(Values.Bool value);
    }
}

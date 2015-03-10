using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace AST
{
    public interface IAST
    {
        IASTResult getASTResult(File file);
    }
}

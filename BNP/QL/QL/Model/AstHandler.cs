using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model;

namespace QL
{
    public class AstHandler
    {
        RootNode root;
        public AstHandler(List<Form> formBlocks){
            root = new RootNode(formBlocks);
            
        }


    }
}

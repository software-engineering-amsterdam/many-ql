using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using QL.Model.Terminals;

namespace QL.Model
{
    public class Form : ElementBase
    {
        public Identifier Identifier { get; set; }
        public Block Block {
                            get { return (Block) Children[0]; }
                            set {
                                Children.Clear();
                                Children.Add(value);
                                }
                            }

        public Form()
        { }

        public Form(Identifier identifier, Block block)
        {
            Identifier = identifier;
            Block = block;
        }
        public Form(Identifier identifier, ElementBase block)
        {
            throw new Exception(identifier+": "+block.ToString()+" is not a block");
            
        }

    }
}

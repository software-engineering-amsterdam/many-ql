﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model
{
    /// <summary>
    /// Represents the root of a questionnaire style sheet AST.
    /// </summary>
    public class StyleSheet : QLSNode
    {
        public Identifier Id
        {
            get;
            private set;
        }

        public IEnumerable<Page> Pages
        {
            get;
            private set;
        }

        internal StyleSheet(Identifier id, IEnumerable<Page> pages, TextPosition position)
            : base(position)
        {
            Id = id;
            Pages = pages;
        }

        public override void Accept(IQLSVisitor visitor)
        {
            visitor.VisitStyleSheet(this);
        }

        public override T Accept<T>(IQLSVisitor<T> visitor)
        {
            return visitor.VisitStyleSheet(this);
        }
    }
}
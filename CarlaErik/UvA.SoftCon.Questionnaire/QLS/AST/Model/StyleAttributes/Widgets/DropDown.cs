﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using UvA.SoftCon.Questionnaire.Common.AST.Model;

namespace UvA.SoftCon.Questionnaire.QLS.AST.Model.StyleAttributes.Widgets
{
    public class DropDown : Widget
    {
        public string TrueLabel
        {
            get;
            private set;
        }

        public string FalseLabel
        {
            get;
            private set;
        }

        internal DropDown(string trueLabel, string falseLabel, TextPosition position)
            : base(position) 
        {
            TrueLabel = trueLabel;
            FalseLabel = falseLabel;
        }

        public override T Accept<T>(IQLSVisitor<T> visitor)
        {
            return visitor.VisitDropDown(this);
        }

        public override bool SupportsDataType(DataType dataType)
        {
            return dataType == DataType.Boolean;
        }
    }
}
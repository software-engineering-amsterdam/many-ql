using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public abstract class Widget : IWidget
    {
        public virtual string Id { get; set; }

        public virtual bool IsComputed { get; set; }

        public abstract UIElement CreateUIControl(dynamic value);
    }
}

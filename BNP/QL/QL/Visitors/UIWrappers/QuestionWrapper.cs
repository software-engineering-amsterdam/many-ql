using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace QL.Visitors.UIWrappers
{
    public class QuestionWrapper :IRenderable
    {
        private Model.QuestionUnit node;
        private TerminalWrapper terminalWrapper;
        public string _text;


        public string _widgetType;

        public bool _editable;
        public string _value;
        
        public QuestionWrapper(Model.QuestionUnit node, TerminalWrapper terminalWrapper)
        {
            // TODO: Complete member initialization
            this.node = node;
            this.terminalWrapper = terminalWrapper;
        }



        public string GetText()
        {
            return _text;
        }
        public string GetWidgetType()
        {
            return _widgetType;
        }

        public bool Editable()
        {
            return _editable;
        }

        public string GetValue()
        {
            return _value;

        }

        public void SetValue(string value)
        {
            _value = value;
        }
    }

}

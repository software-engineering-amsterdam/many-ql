using QuestionnaireLanguage.GUI.CustomUIElements.CustomPanel;
using QuestionnaireLanguage.GUI.Interfaces.Widgets;
using System;
using System.Collections.Generic;
using System.Configuration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;
using System.Windows.Controls;

namespace QuestionnaireLanguage.GUI.Widgets
{
    public class StackPanelWidget : Widget
    {
        private static int conditionalCount;
        private bool visible;

        public static int ConditionalCount
        {
            get { return conditionalCount; }
            private set { conditionalCount = value; }
        }

        public StackPanelWidget(bool visible)
        {
            Id = ConfigurationSettings.AppSettings["stackPanelId"].ToString() + conditionalCount.ToString();
            conditionalCount++;
            this.visible = visible;

        }

        public override UIElement CreateUIControl()
        {
            return new CustomStackPanel() { Name = Id, 
                                            Visibility = this.visible ? Visibility.Visible : Visibility.Hidden};
        }
    }
}

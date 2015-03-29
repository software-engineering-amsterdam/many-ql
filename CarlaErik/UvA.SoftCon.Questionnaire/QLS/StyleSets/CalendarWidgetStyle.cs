namespace UvA.SoftCon.Questionnaire.QLS.StyleSets
{
    public class CalendarWidgetStyle : WidgetStyle
    {
        public static CalendarWidgetStyle Default
        {
            get
            {
                return new CalendarWidgetStyle();
            }
        }

        public override object CreateWidgetControl(IWidgetFactory factory)
        {
            return factory.CreateCalendarWidget();
        }
    }
}

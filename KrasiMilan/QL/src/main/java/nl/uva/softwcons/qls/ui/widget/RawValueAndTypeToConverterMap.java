package nl.uva.softwcons.qls.ui.widget;

import static nl.uva.softwcons.ql.ast.type.BooleanType.BOOLEAN_TYPE;
import static nl.uva.softwcons.ql.ast.type.DateType.DATE_TYPE;
import static nl.uva.softwcons.ql.ast.type.NumberType.NUMBER_TYPE;
import static nl.uva.softwcons.ql.ast.type.StringType.STRING_TYPE;
import nl.uva.softwcons.ql.ast.type.Type;
import nl.uva.softwcons.ql.ui.converter.BooleanToBooleanValueConverter;
import nl.uva.softwcons.ql.ui.converter.StringToNumberValueConverter;
import nl.uva.softwcons.ql.ui.converter.StringToStringValueConverter;
import nl.uva.softwcons.ql.ui.converter.ValueConverter;
import nl.uva.softwcons.ql.ui.widget.CheckboxWidget;
import nl.uva.softwcons.ql.ui.widget.TextFieldWidget;
import nl.uva.softwcons.ql.ui.widget.Widget;
import nl.uva.softwcons.qls.ui.converter.NumberToNumberValueConverter;
import nl.uva.softwcons.qls.ui.converter.StringToBooleanValueConverter;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public final class RawValueAndTypeToConverterMap {
    @SuppressWarnings("rawtypes")
    public static final Table<Class<? extends Widget>, Type, ValueConverter> TABLE = HashBasedTable.create();
    static {
        TABLE.put(TextFieldWidget.class, STRING_TYPE, new StringToStringValueConverter());
        TABLE.put(TextFieldWidget.class, NUMBER_TYPE, new StringToNumberValueConverter());
        TABLE.put(TextFieldWidget.class, DATE_TYPE, new StringToStringValueConverter());
        TABLE.put(CheckboxWidget.class, BOOLEAN_TYPE, new BooleanToBooleanValueConverter());
        TABLE.put(DropdownWidget.class, BOOLEAN_TYPE, new StringToBooleanValueConverter());
        TABLE.put(RadioButtonWidget.class, BOOLEAN_TYPE, new BooleanToBooleanValueConverter());
        TABLE.put(SliderWidget.class, NUMBER_TYPE, new NumberToNumberValueConverter());
    }

    private RawValueAndTypeToConverterMap() {
    }

}

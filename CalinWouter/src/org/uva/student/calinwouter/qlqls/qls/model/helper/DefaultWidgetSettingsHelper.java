package org.uva.student.calinwouter.qlqls.qls.model.helper;

import org.uva.student.calinwouter.qlqls.ql.types.BoolValue;
import org.uva.student.calinwouter.qlqls.ql.types.IntegerValue;
import org.uva.student.calinwouter.qlqls.ql.types.StringValue;
import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.components.Checkbox;
import org.uva.student.calinwouter.qlqls.qls.model.components.Textbox;

import java.util.HashMap;

public class DefaultWidgetSettingsHelper {

    private static WidgetSettingsModel createDefaultBoolWidgetSettings() throws NoSuchFieldException,
            IllegalAccessException {
        return new WidgetSettingsModel(new Checkbox(), "Arial", 12, 0, 400);
    }

    private static WidgetSettingsModel createDefaultIntegerWidgetSettings() throws NoSuchFieldException,
            IllegalAccessException {
        return new WidgetSettingsModel(new Textbox(), "Arial", 12, 0, 400);
    }

    private static WidgetSettingsModel createDefaultStringWidgetSettings() throws NoSuchFieldException,
            IllegalAccessException {
        return new WidgetSettingsModel(new Textbox(), "Arial", 12, 0, 400);
    }

    public static HashMap<String, WidgetSettingsModel> createDefaultTypeToWidgetSettingsModel()
            throws NoSuchFieldException, IllegalAccessException {
        HashMap<String, WidgetSettingsModel> defaultTypeToWidgetSettingsModel = new HashMap<String, WidgetSettingsModel>();
        defaultTypeToWidgetSettingsModel.put(BoolValue.TYPE_REFERENCE, createDefaultBoolWidgetSettings());

        defaultTypeToWidgetSettingsModel.put(IntegerValue.TYPE_REFERENCE, createDefaultIntegerWidgetSettings());

        defaultTypeToWidgetSettingsModel.put(StringValue.TYPE_REFERENCE, createDefaultStringWidgetSettings());
        return defaultTypeToWidgetSettingsModel;
    }
}

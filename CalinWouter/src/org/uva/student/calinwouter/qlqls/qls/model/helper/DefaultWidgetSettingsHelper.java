package org.uva.student.calinwouter.qlqls.qls.model.helper;

import org.uva.student.calinwouter.qlqls.ql.types.TBool;
import org.uva.student.calinwouter.qlqls.ql.types.TInteger;
import org.uva.student.calinwouter.qlqls.ql.types.TString;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Checkbox;
import org.uva.student.calinwouter.qlqls.qls.model.functions.Textbox;

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
        HashMap<String,WidgetSettingsModel> defaultTypeToWidgetSettingsModel = new HashMap<String, WidgetSettingsModel>();
        defaultTypeToWidgetSettingsModel.put(TBool.TYPE_REFERENCE, createDefaultBoolWidgetSettings());

        defaultTypeToWidgetSettingsModel.put(TInteger.TYPE_REFERENCE, createDefaultIntegerWidgetSettings());

        defaultTypeToWidgetSettingsModel.put(TString.TYPE_REFERENCE, createDefaultStringWidgetSettings());
        return defaultTypeToWidgetSettingsModel;
    }
}

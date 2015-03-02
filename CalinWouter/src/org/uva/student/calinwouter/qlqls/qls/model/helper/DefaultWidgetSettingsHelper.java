package org.uva.student.calinwouter.qlqls.qls.model.helper;

import org.uva.student.calinwouter.qlqls.ql.types.TBool;
import org.uva.student.calinwouter.qlqls.ql.types.TInteger;
import org.uva.student.calinwouter.qlqls.ql.types.TString;
import org.uva.student.calinwouter.qlqls.qls.QLSInterpreter;
import org.uva.student.calinwouter.qlqls.qls.model.WidgetSettingsModel;
import org.uva.student.calinwouter.qlqls.qls.model.components.Checkbox;
import org.uva.student.calinwouter.qlqls.qls.model.components.Textbox;

import java.util.HashMap;

public class DefaultWidgetSettingsHelper {

    private static WidgetSettingsModel createDefaultBoolWidgetSettings(QLSInterpreter qlsInterpreter) throws NoSuchFieldException,
            IllegalAccessException {
        return new WidgetSettingsModel(new Checkbox(qlsInterpreter), "Arial", 12, 0, 400);
    }

    private static WidgetSettingsModel createDefaultIntegerWidgetSettings(QLSInterpreter qlsInterpreter) throws NoSuchFieldException,
            IllegalAccessException {
        return new WidgetSettingsModel(new Textbox(qlsInterpreter), "Arial", 12, 0, 400);
    }

    private static WidgetSettingsModel createDefaultStringWidgetSettings(QLSInterpreter qlsInterpreter) throws NoSuchFieldException,
            IllegalAccessException {
        return new WidgetSettingsModel(new Textbox(qlsInterpreter), "Arial", 12, 0, 400);
    }

    public static HashMap<String, WidgetSettingsModel> createDefaultTypeToWidgetSettingsModel(QLSInterpreter qlsInterpreter)
            throws NoSuchFieldException, IllegalAccessException {
        HashMap<String,WidgetSettingsModel> defaultTypeToWidgetSettingsModel = new HashMap<String, WidgetSettingsModel>();
        defaultTypeToWidgetSettingsModel.put(TBool.TYPE_REFERENCE, createDefaultBoolWidgetSettings(qlsInterpreter));

        defaultTypeToWidgetSettingsModel.put(TInteger.TYPE_REFERENCE, createDefaultIntegerWidgetSettings(qlsInterpreter));

        defaultTypeToWidgetSettingsModel.put(TString.TYPE_REFERENCE, createDefaultStringWidgetSettings(qlsInterpreter));
        return defaultTypeToWidgetSettingsModel;
    }
}

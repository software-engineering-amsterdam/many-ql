package org.uva.student.calinwouter.qlqls.qls.model;

import org.uva.student.calinwouter.qlqls.ql.interpreter.TypeDescriptor;

import java.util.HashMap;
import java.util.Map;

/**
 * This class stores all widget settings for every type.
 */
public class TypeToWidgetSettingsModel {
    private final HashMap<String, WidgetSettingsModel> typeToWidgetSettingsModelMap;

    /**
     * Get the widget settings for the specified type.
     */
    public WidgetSettingsModel getWidgetSettingsModel(TypeDescriptor<?> type) {
        return getWidgetSettingsModel(type.toString());
    }

    /**
     * Get the widget settings for the specified type.
     */
    public WidgetSettingsModel getWidgetSettingsModel(String type) {
        return typeToWidgetSettingsModelMap.get(type);
    }

    // TODO refactor...

    /**
     * Create a combination of two TypeToWidgetSettingsModels with the child settings overriding the parent settings.
     */
    public TypeToWidgetSettingsModel(TypeToWidgetSettingsModel parentTypeToWidgetSettingsModel,
                                     TypeToWidgetSettingsModel childTypeToWidgetSettingsModel)
            throws NoSuchFieldException, IllegalAccessException {
        typeToWidgetSettingsModelMap =
                new HashMap<String, WidgetSettingsModel>(
                        parentTypeToWidgetSettingsModel.typeToWidgetSettingsModelMap);

        for (Map.Entry<String, WidgetSettingsModel> entry : childTypeToWidgetSettingsModel
                .typeToWidgetSettingsModelMap.entrySet()) {
            if (parentTypeToWidgetSettingsModel.getWidgetSettingsModel(entry.getKey()) == null) {
                typeToWidgetSettingsModelMap.put(entry.getKey(), entry.getValue());
                continue;
            }
            typeToWidgetSettingsModelMap.put(entry.getKey(),
                    WidgetSettingsModel.combineSettingsModels(
                            parentTypeToWidgetSettingsModel.getWidgetSettingsModel(entry.getKey()), entry.getValue()));
        }
    }

    public TypeToWidgetSettingsModel(TypeToWidgetSettingsModel parentTypeToWidgetSettingsModel,
                                     TypeDescriptor<?> typeDescriptor, WidgetSettingsModel widgetSettingsModel)
            throws NoSuchFieldException, IllegalAccessException {
        this(parentTypeToWidgetSettingsModel, new TypeToWidgetSettingsModel(typeDescriptor, widgetSettingsModel));
    }

    public TypeToWidgetSettingsModel(TypeDescriptor<?> typeDescriptor, WidgetSettingsModel widgetSettingsModel) {
        typeToWidgetSettingsModelMap = new HashMap<String, WidgetSettingsModel>();
        typeToWidgetSettingsModelMap.put(typeDescriptor.toString(), widgetSettingsModel);
    }

    public TypeToWidgetSettingsModel(HashMap<String, WidgetSettingsModel> typeToWidgetSettingsModelMap) {
        this.typeToWidgetSettingsModelMap = typeToWidgetSettingsModelMap;
    }

    /**
     * Create a new (default) type to widget settings model.
     */
    public TypeToWidgetSettingsModel() {
        this(new HashMap<String, WidgetSettingsModel>());
    }

}

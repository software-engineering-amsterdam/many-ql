package org.uva.student.calinwouter.qlqls.qls;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is used for dynamically creating new components or widgets from the provided component/widget paths.
 */
public class QLSReflection {
    private final String componentPath;
    private final String widgetPath;

    private String getComponentPath(String className) {
        return componentPath + className.replace(".", "");
    }

    private String getWidgetPath(String className) {
        return widgetPath + className.replace(".", "");
    }

    /**
     * Get the component or widget class based on the name.
     *
     * When able to get the component from the components package, the method also checks if the component is in
     * the widgets package and throws a runtime exception if that is the case (due to ambiguity).
     */
    private Class findComponentOrWidgetClass(final String className) throws ClassNotFoundException {
        final String potentialComponentPath = getComponentPath(className);
        final String potentialWidgetPath = getWidgetPath(className);
        try {
            Class componentClass = Class.forName(potentialComponentPath);
            try {
                Class.forName(potentialWidgetPath);
                throw new RuntimeException("Class is both in the components and the components.widgets package.");
            } catch(ClassNotFoundException e) {
                return componentClass;
            }
        } catch(ClassNotFoundException e) {
            return Class.forName(potentialWidgetPath);
        }
    }

    /**
     * Get the constructor's last parameter element's class.
     */
    private Class<? extends Object[]> getLastConstructorParameterTypeElement(Constructor c) {
        assert c.isVarArgs();
        Class[] parameterTypes = c.getParameterTypes();
        return (Class<? extends Object[]>) parameterTypes[parameterTypes.length - 1];
    }

    /**
     * Convert the object-array to the array of the type of the var args.
     */
    private Object[] castConstructorVarArgsArgumentsUp(List<Object> varArgsArguments, Constructor constructor) {
        Object[] varArgsArgumentArray = varArgsArguments.toArray();
        return Arrays.copyOf(varArgsArgumentArray, varArgsArgumentArray.length,
                getLastConstructorParameterTypeElement(constructor));
    }

    /**
     * Convert varargs parameters to normal call parameters.
     */
    private Object[] newInstanceParametersUsingVarArgs(List<Object> args, Constructor constructor) {
        final int origLength = constructor.getParameterTypes().length;
        final List<Object> varArgsArguments = new LinkedList<Object>();
        final List<Object> results = new LinkedList<Object>();
        while (args.size() >= origLength) {
            Object lastArgument = args.remove(args.size() - 1);
            varArgsArguments.add(0, lastArgument);
        }
        results.addAll(args);
        results.add(castConstructorVarArgsArgumentsUp(varArgsArguments, constructor));
        return results.toArray();
    }

    /**
     * Try to create a new instance using the provided constructor and the provided arguments.
     *
     * In case of failure, this method returns null.
     */
    private Object tryCreateNewInstance(Constructor c, List<Object> args) throws IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            if (c.isVarArgs() && args.size() >= c.getParameterTypes().length) {
                return c.newInstance((Object[]) newInstanceParametersUsingVarArgs(args, c));
            }
            return c.newInstance((Object[]) args.toArray());
        } catch(IllegalArgumentException e) {
            return null;
        }
    }

    /**
     * This method creates an instance of the class to be found by the specified name, with
     * this QLSAdapter as constructor parameter.
     */
    protected Object newInstanceForClassPath(String classPath, List<Object> args)
            throws NoSuchMethodException, IllegalAccessException, InstantiationException,
            InvocationTargetException, ClassNotFoundException {
        Class clazz = findComponentOrWidgetClass(classPath);
        for (Constructor c : clazz.getConstructors()) {
            Object newInstance = tryCreateNewInstance(c, args);
            if (newInstance != null) {
                return newInstance;
            }
        }
        // TODO custom exception!
        throw new RuntimeException("Constructor not found for class: " + clazz);
    }

    protected QLSReflection(String componentPath, String widgetPath) {
        this.componentPath = componentPath;
        this.widgetPath = widgetPath;
    }
}

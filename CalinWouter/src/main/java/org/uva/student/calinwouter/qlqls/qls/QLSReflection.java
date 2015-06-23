package org.uva.student.calinwouter.qlqls.qls;

import org.uva.student.calinwouter.qlqls.qls.exceptions.CouldNotFindMatchingQLSComponentException;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * This class is used for dynamically creating new functions or widgets from the provided component/widget paths.
 */
public class QLSReflection {
    private final List<String> searchPaths;

    private Class<?> fetchClassOrNull(String classPath) {
        try {
            return Class.forName(classPath);
        } catch(ClassNotFoundException e) {
            return null;
        }
    }

    private Class findClassInAllowedPaths(final String className) throws ClassNotFoundException {
        for (String path : searchPaths) {
            final String classPath = path + className;
            final Class<?> classOrNull = fetchClassOrNull(classPath);
            if (classOrNull != null) {
                return classOrNull;
            }
        }
        throw new ClassNotFoundException();
    }

    /**
     * Get the constructor's last parameter element's class, used for casting a var args object array to the type
     * of the var args' elements.
     */
    private Class<? extends Object[]> getLastConstructorParameterTypeElement(Constructor c) {
        assert c.isVarArgs();
        final Class[] parameterTypes = c.getParameterTypes();
        return (Class<? extends Object[]>) parameterTypes[parameterTypes.length - 1];
    }

    /**
     * Convert the object-array to the array of the type of the var args.
     */
    private Object[] castConstructorVarArgsArgumentsUp(List<Object> varArgsArguments, Constructor constructor) {
        final Object[] varArgsArgumentArray = varArgsArguments.toArray();
        final Integer varArgsArgumentArrayLength = varArgsArgumentArray.length;
        final Class<? extends Object[]> lastConstructorParameterTypeElement
                = getLastConstructorParameterTypeElement(constructor);
        return Arrays.copyOf(varArgsArgumentArray, varArgsArgumentArrayLength, lastConstructorParameterTypeElement);
    }

    /**
     * Convert varargs constructor's parameters to normal call parameters (because reflection converts varargs to
     * an array).
     */
    private Object[] newInstanceParametersUsingVarArgs(List<Object> args, Constructor constructor) {
        List<Object> argsCopy = new LinkedList<Object>(args);
        final int origLength = constructor.getParameterTypes().length;
        final List<Object> varArgsArguments = new LinkedList<Object>();
        final List<Object> results = new LinkedList<Object>();
        while (argsCopy.size() >= origLength) {
            Object lastArgument = argsCopy.remove(argsCopy.size() - 1);
            varArgsArguments.add(0, lastArgument);
        }
        results.addAll(argsCopy);
        final Object[] castedConstructorVarArgs = castConstructorVarArgsArgumentsUp(varArgsArguments, constructor);
        results.add(castedConstructorVarArgs);
        return results.toArray();
    }

    private Object createNewInstance(Constructor constructor, List<Object> args)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
        if (constructor.isVarArgs()) {
            final Object[] newInstanceParametersUsingVarArgs = newInstanceParametersUsingVarArgs(args, constructor);
            return constructor.newInstance(newInstanceParametersUsingVarArgs);
        }
        return constructor.newInstance(args.toArray());
    }

    private Object createNewInstanceOrReturnNull(Constructor constructor, List<Object> args)
            throws IllegalAccessException, InvocationTargetException, InstantiationException {
        try {
            return createNewInstance(constructor, args);
        } catch (IllegalArgumentException e) {
            return null;
        } catch (ArrayStoreException e) {
            return null;
        }
    }

    /**
     * This method creates an instance of the class to be found by the specified name, with
     * this QLSAdapter as constructor parameter.
     */
    protected Object newComponentInstance(String componentName, List<Object> args)
            throws NoSuchMethodException, IllegalAccessException, InstantiationException,
            InvocationTargetException, ClassNotFoundException, CouldNotFindMatchingQLSComponentException {
        final Class<?> clazz = findClassInAllowedPaths(componentName);
        for (Constructor c : clazz.getConstructors()) {
            final Object newInstance = createNewInstanceOrReturnNull(c, args);
            if (newInstance != null) {
                return newInstance;
            }
        }
        throw new CouldNotFindMatchingQLSComponentException(componentName);
    }

    protected QLSReflection(List<String> searchPaths) {
        this.searchPaths = searchPaths;
    }
}

package com.juliana.calculator;

import com.juliana.operations.Operacao;
import org.reflections.Reflections;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class OperacaoUtil {
    private static final Map<String, Operacao> operations = new HashMap<>();
    private static final String OPERATION_PACKAGE = "com.juliana.operations";

    static {
        loadOperations();
    }

    private OperacaoUtil() {
    }

    public static Map<String, Operacao> getOperations() {
        return operations;
    }

    private static void loadOperations() {
        getOperationClasses().forEach(oc -> operations.put(
                oc.getDeclaredAnnotation(Simbolo.class).value(),
                getInstanceOf(oc)
        ));
    }

    private static Set<Class<?>> getOperationClasses() {
        Reflections reflections = new Reflections(OPERATION_PACKAGE);
        return reflections.getTypesAnnotatedWith(Simbolo.class);
    }

    private static Operacao getInstanceOf(Class<?> clazz) {
        try {
            return (Operacao) clazz.getConstructors()[0].newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }
}

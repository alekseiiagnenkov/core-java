package corejava.chapter6.lab25;

import corejava.chapter6.Arrays;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;

public class Lab25 {

    public static void main(String[] args) {
        String declaration = getDeclarationMethodByClassAndName(Arrays.class, "repeat");
        System.out.println(declaration);
    }

    private static String getDeclarationMethodByClassAndName(Class<?> cl, String methodName) {
        Method[] methods = cl.getMethods();
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                return genericDeclaration(method);
            }
        }
        return "";
    }

    public static String genericDeclaration(Method m) {
        return new StringBuilder()
                .append(getModifier(m.getModifiers()))
                .append(" ")
                .append(getGenericTypes(m.getTypeParameters()))
                .append(" ")
                .append(m.getGenericReturnType())
                .append(" ")
                .append(m.getName())
                .append(" ")
                .append(getParams(m.getGenericParameterTypes()))
                .toString();
    }

    private static String getModifier(int modifier){
        return Modifier.toString(modifier);
    }

    private static String getGenericTypes(TypeVariable<Method>[] genericTypes) {
        return "<" + arrayToString(genericTypes) + ">";
    }

    private static String getParams(Type[] genericTypes) {
        return "(" + arrayToString(genericTypes) + ")";
    }

    private static <T> String arrayToString(T[] genericTypes) {
        StringBuilder sb = new StringBuilder();
        if (genericTypes.length > 0) {
            sb.append(genericTypes[0]);
        }
        for (int i = 1; i < genericTypes.length; i++) {
            sb.append(", ").append(genericTypes[i]);
        }
        return sb.toString();
    }
}
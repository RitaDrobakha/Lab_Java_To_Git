package Lab_2;

import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, NoSuchFieldException {
        SLAY slay = new SLAY(new int[][]{{1, -1}, {3, 2}}, new int[]{7, 16});
        Class clss = slay.getClass();

        Method[] method = clss.getDeclaredMethods();
        for(Method md: method){
            System.out.println(md.getName());
            MyAnnotation annotation = (MyAnnotation) md.getAnnotation(MyAnnotation.class);
            if(annotation != null) {
                try {
                    System.out.println(md.toString());
                    Method startEngineMethod = clss.getDeclaredMethod(md.getName());
                    startEngineMethod.setAccessible(true);
                    startEngineMethod.invoke(slay);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println("Interfaces:");
        Class[] interfaces = clss.getInterfaces();
        for (Class cInterface : interfaces) {
            System.out.println(cInterface.toString());
        }

        System.out.println("Fields:");
        Field[] fields = clss.getDeclaredFields();
        for (Field fld : fields) {
            System.out.println("Name: " + fld.getName());
            System.out.println("Type: " + fld.getType().getName());
            System.out.println("Annotation: " + fld.getAnnotatedType());
        }


        MyInterface slay1 = (MyInterface) Proxy.newProxyInstance(SLAY.class.getClassLoader(), SLAY.class.getInterfaces(), new MyProxy(slay));
        slay1.getFreeMember();
        slay1.setFreeMember(new int[]{1, 2});
    }
}

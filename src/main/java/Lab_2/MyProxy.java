package Lab_2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MyProxy implements InvocationHandler {

    private Object object;

    public MyProxy(Object object) {
        this.object = object;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName() + " was called");
        if (method.getName().startsWith("set")) {
            throw new Exception("You can't call setters");
        }
        return method.invoke(object, args);
    }
}
package org.annotations;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class AnnotationsInjector {
    private HashMap<String, Object> componentsbeans = new HashMap<>();

    public AnnotationsInjector(String packagename) throws IllegalAccessException {
        Finder finder = new Finder(packagename);
        Collection<Class<?>> classCollection = finder.scanClasses();

        //Instantiate all components
        for (Class<?> class_ : classCollection) {
            if (class_.isAnnotationPresent(Component.class)) {
                String name = class_.getAnnotation(Component.class).name().equals("") ? class_.getCanonicalName() : class_.getAnnotation(Component.class).name();
                InstantiateComponentClasse(class_.getName(), name);
            }
        }



        for (Class<?> class_ : classCollection) {
            Field fields[] = class_.getDeclaredFields();
            for (Field field : fields) {
                if (field.isAnnotationPresent(Autowired.class)) {
                    Object servicebean,clientbean = null;
                    if (!field.getAnnotation(Autowired.class).name().equals("")) {
                        servicebean = getBean(field.getAnnotation(Autowired.class).name());
                    } else
                        servicebean = getBean(field.getType());
                    if (field.getDeclaringClass().isAnnotationPresent(Component.class)) {
                        if (!field.getDeclaringClass().getAnnotation(Component.class).name().equals("")) {
                            clientbean = getBean(field.getDeclaringClass().getAnnotation(Component.class).name());
                        } else clientbean = getBean(field.getDeclaringClass().getName());
                    }
                    field.setAccessible(true);
                    field.set(clientbean, servicebean);
                }
            }
        }



    }

    private void InstantiateComponentClasse(String classname, String BeanName) {
        try {
            Class beanclasse = Class.forName(classname);
            Object beanobj = beanclasse.newInstance();
            componentsbeans.put(BeanName, beanobj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Object getBean(String beaname) {
        Object object;
        for (HashMap.Entry<String, Object> entry : componentsbeans.entrySet()) {
            if (entry.getKey().contains(beaname)) {
                object= entry.getValue();
                return object;
            }
        }
        return null;
    }

    public Object getBean(Class classz) {
        for (HashMap.Entry<String, Object> entry : componentsbeans.entrySet()) {
            if (Arrays.toString(entry.getValue().getClass().getInterfaces()).contains(classz.getName()) || entry.getValue().getClass().getName().equals(classz.getName())) {
                return entry.getValue();
            }
        }
        return null;
    }
}

package org.mianmian.java.beans;


import javafx.scene.Parent;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyEditorSupport;
import java.util.stream.Stream;

/**
 * @Author : zhangyi
 * @Date : 2020-02-02 17:54
 */
public class BeanInfoDemo {

    public static void main(String[] args) throws IntrospectionException {

        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class, Object.class);

        Stream.of(beanInfo.getPropertyDescriptors()).forEach(
                propertyDescriptor -> {
                    if("age".equals(propertyDescriptor.getName())){
                        propertyDescriptor.setPropertyEditorClass(StringToIntegerPropertyEditor.class);
                    }
                }
        );
    }

    static class StringToIntegerPropertyEditor extends PropertyEditorSupport{

        public String getAsText(String text) {

            Integer value = Integer.valueOf(text);
            setValue(value);
        }
    }
}

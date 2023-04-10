package miu.edu.lab4_Demo.aspect.annotation;

import javax.swing.text.Element;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
public @interface ExecutionTime {
}

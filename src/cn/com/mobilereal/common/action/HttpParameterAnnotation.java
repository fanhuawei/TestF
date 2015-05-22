/**
 * $Id:$
 */
package cn.com.mobilereal.common.action;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;

/**
 * struts2 风格的action.
 * 在Action的子类中增加这个注解，系统会自动注入请求参数到Action对象的属性中，
 * 优点: 没有线程安全问题，不需要写request.getParameter()这样的代码
 * 缺点: 每次请求都会创建一个新Action对象。
 *  
 * struts 1.x 风格的action.
 * 在Action的子类中没有这个注解，考虑到线程安全，Action对象不允许定义属性
 * 优点：这个子类在系统中只会创建一个对象，每次关联的请求都是使用同一个对象，节省创建对象的开销
 * 缺点：请求参数较多时，会有大量的request.getParameter()这样的代码。
 * 
 * @author Fanhuawei
 *
 */

@java.lang.annotation.Target(value={ElementType.TYPE})
@java.lang.annotation.Retention(value=RetentionPolicy.RUNTIME)
public @interface HttpParameterAnnotation {

}

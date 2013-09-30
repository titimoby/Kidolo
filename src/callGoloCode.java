import fr.insalyon.citi.golo.compiler.GoloClassLoader;

import java.io.FileInputStream;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA.
 * User: thierry
 * Date: 9/26/13
 * Time: 3:51 PM
 */
public class callGoloCode {
    public static void main(String... args) throws Throwable {
        GoloClassLoader classLoader = new GoloClassLoader();
        Class<?> moduleClass = classLoader.load("foo.golo", new FileInputStream("/home/thierry/Documents/perso/Kidolo/src/foo.golo"));
        Method bar = moduleClass.getMethod("bar", Object.class);
        bar.invoke(null, "golo golo");
    }
}

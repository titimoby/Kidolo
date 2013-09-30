import fr.insalyon.citi.golo.compiler.GoloClassLoader;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


/**
 * Created with IntelliJ IDEA.
 * User: thierry
 * Date: 9/26/13
 * Time: 3:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class KidoloForm {

    private JButton newButton;
    private JButton openButton;
    private JButton saveButton;
    private JEditorPane outputPane;
    private JPanel mainPanel;
    private JButton runButton;
    private RSyntaxTextArea mCodeEditor;

    public KidoloForm() {
        runButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                GoloClassLoader classLoader = new GoloClassLoader();
                Class<?> moduleClass = null;
                try {
                   // moduleClass = classLoader.load("foo.golo", new FileInputStream("/home/thierry/Documents/perso/Kidolo/src/foo.golo"));
                    String editorText = mCodeEditor.getText();
                    InputStream editorInputStream = new ByteArrayInputStream( editorText.getBytes() );
                    moduleClass = classLoader.load("editor.golo", editorInputStream);
                    Method bar = moduleClass.getMethod("bar", Object.class);
                    bar.invoke(null, "golo golo");
                } catch (InvocationTargetException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (NoSuchMethodException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                } catch (IllegalAccessException e1) {
                    e1.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
                }

            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("KidoloForm");
        frame.setContentPane(new KidoloForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}

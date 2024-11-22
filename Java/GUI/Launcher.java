import java.awt.EventQueue;

public class Launcher {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override // instructs the compiler that you intend to override a method in the superclass
            // Needed since a subclass (public void run()) needs to define a behavior in a diff. way than the superclass
            public void run() {
                startFrame sf = new startFrame();
                sf.show();
            }
        });
    }
}
import javax.swing.*;

public class PewPewDriver {

    public static void main(String args[]) {
        launchDesigner();
    }

    private static void launchDesigner() {
        JFrame f = new JFrame("Pew Pew");

        PewPanel panel = new PewPanel();
        f.add(panel);

        // fullscreen
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        f.setUndecorated(true);

        f.pack();
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        f.setVisible(true);
    }
}

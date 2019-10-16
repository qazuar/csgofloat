package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MExitListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(33);
    }

}

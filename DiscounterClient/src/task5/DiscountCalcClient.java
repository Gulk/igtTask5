package task5;

import java.net.ConnectException;
import java.rmi.RemoteException;

import javax.swing.JOptionPane;

import org.apache.axis2.AxisFault;

public class DiscountCalcClient {

    public static void main(String[] args) {

        try {
            String username = JOptionPane.showInputDialog("Please enter a username:");
            DiscountCalcStub stub = new DiscountCalcStub();
            DiscountCalcStub.GetDiscountAmount getDiscountAmount = new DiscountCalcStub.GetDiscountAmount();
            getDiscountAmount.setUsername(username);
            DiscountCalcStub.GetDiscountAmountResponse response = stub.getDiscountAmount(getDiscountAmount);

            if (response.get_return() > 0) {
                JOptionPane.showConfirmDialog(null, username + " receives " + response.get_return() + "% discount.",
                        "DiscountCalc", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showConfirmDialog(null, "No discount for " + username + ".",
                        "DiscountCalc", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (AxisFault axisFault) {
            if (axisFault.getCause() instanceof ConnectException) {
                JOptionPane.showConfirmDialog(null, "Failed to connect to the server!",
                        "Connection issues", JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE);
            }
            axisFault.printStackTrace();
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}

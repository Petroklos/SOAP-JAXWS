// Based on the results of WSImport.
// wsimport -keep -verbose -s ./src/ -d ./bin/ <WSDL URL>

package soapClientJAXWS;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.soapwebservicejaxws.ScoreInterface;
import com.soapwebservicejaxws.ScoreServiceService;

public class ScoreClient {
	public static void main (String[] args) {
		ScoreInterface webServiceInteface = new ScoreServiceService().getScoreServicePort();
		webServiceInteface.resetScores();
		userIntefaceInit(webServiceInteface);
	}
	
	public static void userIntefaceInit(ScoreInterface webServiceInteface) {
        
        JFrame frame = new JFrame("Score Tracker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
        frame.setSize(640, 480);
        
        // Create an outer panel with padding
        JPanel outerPanel = new JPanel();
        outerPanel.setBorder(new EmptyBorder(frame.getHeight()/10, frame.getWidth()/10, frame.getHeight()/10, frame.getWidth()/10)); // Add padding

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 3, frame.getHeight()/5, frame.getWidth()/10)); // 4 rows, 3 columns, horizontal and vertical gaps

        frame.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                outerPanel.setBorder(new EmptyBorder(frame.getHeight()/10, frame.getWidth()/10, frame.getHeight()/10, frame.getWidth()/10)); // Add padding
                panel.setLayout(new GridLayout(3, 3, frame.getHeight()/5, frame.getWidth()/5));
            }
        });
        
        JLabel winsLabel = new JLabel();    
        winsLabel.setHorizontalAlignment(JLabel.CENTER);  
        winsLabel.setVerticalAlignment(JLabel.CENTER);
        
        JLabel lossesLabel = new JLabel();        
        lossesLabel.setHorizontalAlignment(JLabel.CENTER);
        lossesLabel.setVerticalAlignment(JLabel.CENTER);
        
        JLabel tiesLabel = new JLabel();
        tiesLabel.setHorizontalAlignment(JLabel.CENTER);
        tiesLabel.setVerticalAlignment(JLabel.CENTER);
        
        updateLabels(webServiceInteface, winsLabel, lossesLabel, tiesLabel);        

        JButton incrementWinsButton = new JButton("+1 Win");
        incrementWinsButton.setHorizontalAlignment(JButton.CENTER);
        incrementWinsButton.setVerticalAlignment(JButton.CENTER);
        incrementWinsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	webServiceInteface.increaseWins();
                updateLabels(webServiceInteface, winsLabel, lossesLabel, tiesLabel);
            }
        });
        
        JButton incrementLossesButton = new JButton("+1 Loss");
        incrementLossesButton.setHorizontalAlignment(JButton.CENTER);
        incrementLossesButton.setVerticalAlignment(JButton.CENTER);
        incrementLossesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	webServiceInteface.increaseLosses();
                updateLabels(webServiceInteface, winsLabel, lossesLabel, tiesLabel);
            }
        });

        
        JButton incrementTiesButton = new JButton("+1 Tie");
        incrementTiesButton.setHorizontalAlignment(JButton.CENTER);
        incrementTiesButton.setVerticalAlignment(JButton.CENTER);
        incrementTiesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	webServiceInteface.increaseTies();
                updateLabels(webServiceInteface, winsLabel, lossesLabel, tiesLabel);
            }
        });
        
        JButton resetButton = new JButton("Reset Scores");
        resetButton.setHorizontalAlignment(JButton.CENTER);
        resetButton.setVerticalAlignment(JButton.CENTER);
        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	webServiceInteface.resetScores();
                updateLabels(webServiceInteface, winsLabel, lossesLabel, tiesLabel);
            }
        });

        panel.add(winsLabel);
        panel.add(lossesLabel);
        panel.add(tiesLabel);
        panel.add(incrementWinsButton);
        panel.add(incrementLossesButton);
        panel.add(incrementTiesButton);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(resetButton);
        panel.add(new JLabel()); // Empty label for spacing

        outerPanel.add(panel); // Add the content panel to the outer panel
        frame.add(outerPanel); // Add the outer panel to the frame
        frame.setVisible(true);
	}

    private static void updateLabels (ScoreInterface webServiceInteface, JLabel winsLabel, JLabel lossesLabel, JLabel tiesLabel) {
    	winsLabel.setText(webServiceInteface.getWins());
        lossesLabel.setText(webServiceInteface.getLosses());
        tiesLabel.setText(webServiceInteface.getTies());
    }
}

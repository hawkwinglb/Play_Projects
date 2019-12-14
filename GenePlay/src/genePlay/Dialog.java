package genePlay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Dialog {
	
	private JDialog dialogue;
	
	public void MakeDialog(){
		JFrame frame = new JFrame();
		dialogue = new JDialog(frame, "Enter input", true);
		dialogue.setLayout(new FlowLayout());
		JButton button = new JButton("O.K.");
	}

}

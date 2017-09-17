package webBrowser;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

public class ReadFile extends JFrame{
	
	private JTextField addressBar;
	private JEditorPane display;
	private JButton homeButton;
	private Icon homeIcon;
	
	public ReadFile() {
		super("Ginger");
		
		homeIcon = new ImageIcon(getClass().getResource("homeIcon.jpg"));
		homeButton = new JButton();
		homeButton.setBounds(0, 0, 50, 50);
		
		int offset = homeButton.getInsets().left;
		homeButton.setIcon(resizeIcon((ImageIcon) homeIcon, homeButton.getWidth() - offset, homeButton.getHeight() - offset));
		
		homeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				loadPage("https://www.google.ro/?gws_rd=ssl");
				
			}
		});
		
		add(homeButton);
		
		addressBar = new JTextField("type in a URL");
		addressBar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {	
				loadPage("https://www." + e.getActionCommand());
			}
		});
		
		addressBar.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				addressBar.setText("");
				
			}
		});
		
		addressBar.setBounds(homeButton.getWidth(), homeButton.getHeight()/2+homeButton.getHeight()%2, 500, 25);
		add(addressBar);
		
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(new HyperlinkListener() {
			
			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if(e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					loadPage(e.getURL().toString());
				}
			}
		});
		
		add(new JScrollPane(display), BorderLayout.CENTER);
		setSize(800, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	private void loadPage(String userText) {
		try {
			display.setPage(userText);
			addressBar.setText(userText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	    Image img = icon.getImage();  
	    Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	    return new ImageIcon(resizedImage);
	}
	
}

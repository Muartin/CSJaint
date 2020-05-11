import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Paint extends JFrame implements MouseListener {
	int mouseX = 0;
	int mouseY = 0;
	JFrame frame;

	public Paint() {
		setTitle("CSJaint");
    		addMouseListener(this);
    		addMouseMotionListener(this);

   		setSize(1200, 900);
    
 		JButton Select = new JButton("Select");
    		Select.setBounds(110, 10, 100, 50);
    		add(Select);
    		JButton Eraser = new JButton("Eraser");
    		Eraser.setBounds(10, 10, 100, 50);
    		add(Eraser);
    		JButton Clear = new JButton("Clear");
   		Clear.setBounds(210, 10, 100, 50);
    		add(Clear);

    		setLayout(null);
    		setVisible(true);
	}

	public static void main(String[] args) {
		new Paint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		mouseX = e.getX();
		mouseY = e.getY();
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.fillOval(mouseX, mouseY, 30, 30);
	}
}

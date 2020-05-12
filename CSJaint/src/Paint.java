import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Paint extends JFrame implements MouseListener, MouseMotionListener {
	int mouseX = 0;
	int mouseY = 0;
	int prevX = 0;
	int prevY = 0;
	private JFrame frame;
	private JPanel canvas;
	private JPanel toolbar;
	private JButton eraser;
	private JButton draw;
	private JButton clear;

	private BasicBrush brush;

	public Paint() {

		setTitle("CSJaint");
		addMouseListener(this);
		addMouseMotionListener(this);
		setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));
		brush = new BasicBrush(20);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 900);
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
		prevX = mouseX;
		prevY = mouseY;
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

	public void mouseMoved(MouseEvent e) {

	}

	public void mouseDragged(MouseEvent e) {
		prevX = mouseX;
		prevY = mouseY;
		mouseX = e.getX();
		mouseY = e.getY();
		repaint();

	}

	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		brush.draw(g2d, prevX, mouseX, prevY, mouseY);
	}
}

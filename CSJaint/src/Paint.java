import java.awt.Point;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;

public class Paint extends JFrame implements MouseListener, MouseMotionListener, KeyListener {

	// Points to keep track of current and previous mouse locations respectively
	Point curMouse;
	Point prevMouse;

	// TODO: actually implement this stuff in a useful way
	private JFrame frame;
	private JPanel canvas;
	private JPanel toolbar;
	private JButton eraser;
	private JButton draw;
	private JButton clear;

	// Creates a BasicBrush object which stores brush data
	private BasicBrush brush;

	public Paint() {

		setTitle("CSJaint");
		addMouseListener(this);
		addMouseMotionListener(this);
		addKeyListener(this);

		// set initial mouse positions all to zero
		curMouse = new Point(0, 0);
		prevMouse = new Point(0, 0);
		brush = new BasicBrush(20);

		setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 900);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Paint();
	}

	public void paint(Graphics g) {
//		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		brush.draw(g2d, prevMouse, curMouse);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {

		// basic drawing method
		curMouse.setLocation(e.getX(), e.getY());
		prevMouse.setLocation(curMouse);
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
		prevMouse.setLocation(curMouse);
		curMouse.setLocation(e.getX(), e.getY());
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyChar();
		if (key == '[') {
			brush.setSize(brush.getSize() - 1);
		}
		if (key == ']') {
			brush.setSize(brush.getSize() + 1);
		}
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
			System.out.println("undo");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}
}

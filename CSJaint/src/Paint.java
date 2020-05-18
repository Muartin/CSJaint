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
//menu imports
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Paint extends JPanel implements MouseListener, MouseMotionListener, KeyListener{

  // TODO: actually implement this stuff in a useful way
  
  // Creates a BasicBrush object which stores brush data
  Point prevMouse;
  Point curMouse;
  //Creates a BasicBrush object which stores brush data
  private BasicBrush brush;
  
  JPanel panel = new JPanel();

  public Paint() {

    panel.setName("CSJaint");
    
    brush = new BasicBrush(20);
    
    addMouseListener(this);
    addMouseMotionListener(this);
    addKeyListener(this);
    
    curMouse = new Point();
    prevMouse = new Point();
    brush = new BasicBrush(20);
    
    setSize(900,900);
    setVisible(true);

    setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
    setSize(1200, 900);
    setVisible(true);

  }
  
  public static void main(String[] args) {
    
    JFrame frame = new JFrame();
    frame.add(new Paint());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setBounds(100,100,900,900);
    
    JMenuBar menuBar = new JMenuBar();
    JMenu menu = new JMenu("Menu");
    menuBar.add(menu);
    JMenuItem item = new JMenuItem("Option One");
    menu.add(item);
    frame.setJMenuBar(menuBar);
    
    frame.setVisible(true);
   
  }
  
  public void paintComponent(Graphics g) {
    //super.paintComponent(g);
    int startCount = 0;
    Graphics2D g2d = (Graphics2D) g;
    // big dumb stupid so that the program doesn't draw a dot in the upper left hand corner when the program starts.
    if (startCount == 0 && prevMouse.getX() == 0 && prevMouse.getY() == 0 && curMouse.getX() == 0 && curMouse.getY() == 0) 
      startCount++;
    else 
      brush.draw(g2d, prevMouse, curMouse);
  }

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
    if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
      System.out.println("undo");
    }
  }

  @Override
  public void keyReleased(KeyEvent e) {
    // TODO Auto-generated method stub
  }
}

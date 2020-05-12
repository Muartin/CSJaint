import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;

public class BasicBrush {
	private int size;

	public BasicBrush(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		if(size < 1) {
			size = 1;
		}
		if(size > 300) {
			size = 300;
		}
		this.size = size;
	}

	public void draw(Graphics2D g2d, Point prevMouse, Point curMouse) {
		g2d.setStroke(new BasicStroke(size, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.drawLine(prevMouse.x, prevMouse.y, curMouse.x, curMouse.y);
	}
}

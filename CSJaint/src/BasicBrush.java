import java.awt.BasicStroke;
import java.awt.Graphics2D;

public class BasicBrush {
	int diameter;

	public BasicBrush(int diameter) {
		this.diameter = diameter;
	}

	public void draw(Graphics2D g2d, int prevX, int mouseX, int prevY, int mouseY) {
		g2d.setStroke(new BasicStroke(diameter, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		g2d.drawLine(prevX, prevY, mouseX, mouseY);
	}
}

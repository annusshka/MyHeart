import java.awt.*;
import java.awt.geom.Path2D;

public class Heart {
    private int x;
    private int y;
    private Color color;

    private int sizeCoeff;
    private final double EPS = 0.00001;

    public Heart(final int x, final int y, final Color color, final int coeff) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.sizeCoeff = coeff;
    }

    public void setX(final int x) {
        this.x = x;
    }

    public int getX() {
        return this.x;
    }

    public void setY(final int y) {
        this.y = y;
    }

    public int getY() {
        return this.y;
    }

    public void setColor(final Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }

    public void setSizeCoeff(final int coeff) {
        this.sizeCoeff = coeff;
    }

    public int getSizeCoeff() {
        return this.sizeCoeff;
    }

    private static Shape drawHeart(final int x, final int y, final int coeff, final double eps) {
        Path2D line = new Path2D.Double();
        line.moveTo(x - 2, y);
        for (double dx = -2; dx <= 2;) {
            double dy = Math.sqrt(1-Math.pow(Math.abs(dx)-1, 2));
            line.lineTo(x + dx * coeff, y - dy * coeff);
            dx += eps;
        }
        for (double dx = 2; dx >= -2;) {
            double dy = Math.acos(1 - Math.abs(dx))-Math.PI;
            line.lineTo(x + dx * coeff, y - dy * coeff);
            dx -= eps;
        }
        line.closePath();
        return line;
    }

    void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        g.setColor(this.color);
        g.fill(drawHeart(this.x, this.y, sizeCoeff, this.EPS));
    }
}

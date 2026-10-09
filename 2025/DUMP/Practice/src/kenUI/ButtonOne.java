package kenUI;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.Timer;

public class ButtonOne extends JButton {
	private static final long serialVersionUID = 1L;

	// 0 = normal, 1 = hover
	private float progress = 0f;

	// 0 = released, 1 = pressed
	private float pressProgress = 0f;

	// Our own hover flag (doesn't depend on the model's timing)
	private boolean hovering = false;

	// Colors
	private final Color normalColor = new Color(13, 110, 253);
	private final Color hoverColor = new Color(10, 88, 202);

	// Animation speeds
	private static final float HOVER_STEP = 0.05f;
	private static final float PRESS_STEP = 0.1f;

	private Timer timer;

	public ButtonOne() {

		setBorderPainted(false);
		setFocusPainted(false);
		setContentAreaFilled(false);
		setOpaque(false);

		timer = new Timer(10, e -> {

			float hoverTarget = hovering ? 1f : 0f;
			float pressTarget = getModel().isPressed() ? 1f : 0f;

			progress = moveToward(progress, hoverTarget, HOVER_STEP);
			pressProgress = moveToward(pressProgress, pressTarget, PRESS_STEP);

			repaint();

			// Stop only when BOTH animations have arrived
			if (progress == hoverTarget && pressProgress == pressTarget) {
				timer.stop();
			}
		});

		addMouseListener(new MouseAdapter() {

			@Override
			public void mouseEntered(MouseEvent e) {
				hovering = true;
				timer.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hovering = false;
				timer.start();
			}

			@Override
			public void mousePressed(MouseEvent e) {
				timer.start();
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				timer.start();
			}
		});

		// Safety net: restart whenever the button model changes (pressed, armed, etc.)
		addChangeListener(e -> timer.start());
	}

	// Moves a value toward a target by 'step' without overshooting
	private float moveToward(float current, float target, float step) {
		if (current < target) {
			return Math.min(current + step, target);
		} else if (current > target) {
			return Math.max(current - step, target);
		}
		return current;
	}

	@Override
	protected void paintComponent(Graphics g) {

		Graphics2D g2 = (Graphics2D) g.create();

		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		// Blend between normal and hover color
		int red = (int) (normalColor.getRed() + (hoverColor.getRed() - normalColor.getRed()) * progress);
		int green = (int) (normalColor.getGreen() + (hoverColor.getGreen() - normalColor.getGreen()) * progress);
		int blue = (int) (normalColor.getBlue() + (hoverColor.getBlue() - normalColor.getBlue()) * progress);

		g2.setColor(new Color(red, green, blue));

		// Press effect: button moves down up to 4px
		int shift = (int) (pressProgress * 4);

		// Height is reduced by 4 so the shifted button never gets clipped
		g2.fillRoundRect(0, shift, getWidth(), getHeight() - 4, 30, 30);

		// Draw text (also shifted so it moves with the button)
		g2.setColor(Color.WHITE);
		g2.setFont(getFont());

		FontMetrics metrics = g2.getFontMetrics();
		int textWidth = metrics.stringWidth(getText());
		int textX = (getWidth() - textWidth) / 2;
		int textY = ((getHeight() - 4) - metrics.getHeight()) / 2 + metrics.getAscent() + shift;

		g2.drawString(getText(), textX, textY);

		g2.dispose();
	}
}
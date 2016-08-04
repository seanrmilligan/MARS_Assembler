package mars.jupiter.factory;

import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by Sean on 2016-08-04.
 */
public class ButtonFactory {
	public static Button button(String imageDirectory, String tooltipText) {
		Button button = new Button();
		button.setGraphic(new ImageView(new Image(imageDirectory)));
		button.setTooltip(new Tooltip(tooltipText));
		button.setMinHeight(32);
		button.setMinWidth(32);
		
		return button;
	}
}

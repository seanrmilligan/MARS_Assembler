package mars.jupiter.factory;

import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;

/**
 * Created by Sean on 2016-07-30.
 */
public class MenuFactory {
	public static MenuItem menuitem (String displayText, boolean useMnemonic) {
		MenuItem item = new MenuItem(displayText);
		item.setMnemonicParsing(useMnemonic);
		
		return item;
	}
	
	public static MenuItem menuitem (String displayText, boolean useMnemonic, KeyCode key) {
		MenuItem item = new MenuItem(displayText);
		item.setAccelerator(new KeyCodeCombination(key));
		item.setMnemonicParsing(useMnemonic);
		
		return item;
	}
	
	public static MenuItem menuitem (String displayText, boolean useMnemonic, KeyCode key, KeyCombination.Modifier combo) {
		MenuItem item = new MenuItem(displayText);
		item.setAccelerator(new KeyCodeCombination(key, combo));
		item.setMnemonicParsing(useMnemonic);
		
		return item;
	}
}

package mars.jupiter;

import javafx.application.Application;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Sean on 2016-07-16.
 */
public class JupiterUI extends Application {
	
	private BorderPane jupiterPane;
	
	private VBox topVBox;
	private MenuBar menubar;
	private Menu fileMenu, editMenu, runMenu, settingsMenu, toolsMenu, helpMenu;
	private MenuItem newMenuItem, openMenuItem, closeMenuItem, closeAllMenuItem, saveMenuItem, saveAsMenuItem,
			saveAllMenuItem, dumpMemoryMenuItem, printMenuItem, exitMenuItem;
	private MenuItem undoMenuItem, redoMenuItem, cutMenuItem, copyMenuItem, pasteMenuItem, findReplaceMenuItem,
			selectAllMenuItem;
	private MenuItem assembleMenuItem, goMenuItem, stepMenuItem, backstepMenuItem, pauseMenuItem, stopMenuItem,
			resetMenuItem, clearAllBreakPointsMenuItem, toggleAllBreakPointsMenuItem;
	private MenuItem showLabelsViewCheckMenuItem, programArgumentsCheckMenuItem, popupForSyscallsCheckMenuItem,
			displayAddressInHexCheckMenuItem, displayValueInHexCheckMenuItem, assembleFileOnOpenCheckMenuItem,
			assembleAllFilesInDirectoryCheckMenuItem, treatWarningsAsErrorsCheckMenuItem, initializePCtoGlobalMain,
			permitPseudoInstructionsCheckMenuItem, delayedBranchingCheckMenuItem, selfModifyingCodeCheckMenuItem,
			editorMenuItem, highlightMenuItem, exceptionHandleMenuItem, memoryConfigMenuItem;
	private MenuItem bhtSimulatorMenuItem, dataCacheSimulatorMenuItem, bitmapDisplayMenuItem, floatingPointRepMenuItem,
			scavengerHuntMenuItem, introToolsMenuItem, marsBotMenuItem, instructionCounterMenuItem,
			memoryReferenceVisualizerCheckMenuItem, mmioVisualizerCheckMenuItem, instructionStatisticsMenuItem,
			keyboardAndDisplaySimulatorMenuItem, screenMagnifierMenuItem, digitalLabSimulatorMenuItem;
		
	private ToolBar toolbar;
	
	public void init() {
		this.jupiterPane = new BorderPane();
		this.topVBox = new VBox();
		
	}
	
	@Override
	public void start(Stage primaryStage) {
		
	}
}

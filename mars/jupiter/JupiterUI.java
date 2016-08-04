package mars.jupiter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import mars.Images;
import mars.Text;
import mars.jupiter.factory.ButtonFactory;
import mars.jupiter.factory.MenuFactory;

/**
 * Created by Sean on 2016-07-16.
 */
public class JupiterUI extends Application implements MainGUI {
	private Stage primaryStage;
	private BorderPane jupiterPane;
	
	private VBox operations;
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
	private MenuItem helpMenuItem, aboutMenuItem;
	
	private ToolBar toolbar;
	private Button newButton, openButton, saveButton, saveAsButton, dumpMemoryButton, printButton, undoButton,
			redoButton, cutButton, copyButton, pasteButton, findReplaceButton, assembleButton, runButton,
			forwardStepButton, backwardStepButton, pauseButton, stopButton, resetButton, helpButton;
	
	private Accordion accordion;
	
	private TitledPane editTitledPane;
	private TabPane editTabPane;
	private TitledPane executeTitledPane;
	private BorderPane executePane;
	
	@Override
	public void init() {
		this.jupiterPane = new BorderPane();
		this.operations = new VBox();
		
		this.initMenus();
		this.initToolbar();
		
		this.operations.getChildren().addAll(this.menubar, this.toolbar);
		
		this.accordion = new Accordion();
		this.editTabPane = new TabPane();
		this.editTitledPane = new TitledPane("Edit", this.editTabPane);
		this.executePane = new BorderPane();
		this.executeTitledPane = new TitledPane("Execute", this.executePane);
		
		this.accordion.getPanes().addAll(this.editTitledPane, this.executeTitledPane);
		
		this.jupiterPane.setTop(this.operations);
		this.jupiterPane.setCenter(this.accordion);
	}
	
	@Override
	public void start(Stage primaryStage) {
		this.accordion.setExpandedPane(this.editTitledPane);
		this.primaryStage = primaryStage;
		this.primaryStage.setScene(new Scene(this.jupiterPane));
		this.primaryStage.setMaximized(true);
		this.primaryStage.show();
	}
	
	private void initMenus() {
		this.menubar = new MenuBar();
		
		// Create all the menus
		this.fileMenu = new Menu(Text.FILE_MENU_STR);
		this.editMenu = new Menu(Text.EDIT_MENU_STR);
		this.runMenu = new Menu(Text.RUN_MENU_STR);
		this.settingsMenu = new Menu(Text.SETTINGS_MENU_STR);
		this.toolsMenu = new Menu(Text.TOOLS_MENU_STR);
		this.helpMenu = new Menu(Text.HELP_MENU_STR);
		
		/*
		 * Make all the menu items for all of the menus
		 * Uses convenience method to save lines of code spent on common operations such as instantiating the object,
		 * turning on mnemonic parsing, assigning an accelerator, and setting a graphic icon
		 */
		
		// Create all the menu items used in the file menu
		this.newMenuItem = MenuFactory.menuitem(Text.NEW_MENUITEM_STR, true, KeyCode.N, KeyCombination.CONTROL_DOWN);
		this.openMenuItem = MenuFactory.menuitem(Text.OPEN_MENUITEM_STR, true, KeyCode.O, KeyCombination.CONTROL_DOWN);
		this.closeMenuItem = MenuFactory.menuitem(Text.CLOSE_MENUITEM_STR, true, KeyCode.W, KeyCombination.CONTROL_DOWN);
		this.closeAllMenuItem = MenuFactory.menuitem(Text.CLOSE_ALL_MENUITEM_STR, true);
		this.saveMenuItem = MenuFactory.menuitem(Text.SAVE_MENUITEM_STR, true, KeyCode.S, KeyCombination.CONTROL_DOWN);
		this.saveAsMenuItem = MenuFactory.menuitem(Text.SAVE_AS_MENUITEM_STR, true);
		this.saveAllMenuItem = MenuFactory.menuitem(Text.SAVE_ALL_MENUITEM_STR, true);
		this.dumpMemoryMenuItem = MenuFactory.menuitem(Text.DUMP_MEMORY_MENUITEM_STR, true, KeyCode.D, KeyCombination.CONTROL_DOWN);
		this.printMenuItem = MenuFactory.menuitem(Text.PRINT_MENUITEM_STR, true);
		this.exitMenuItem = MenuFactory.menuitem(Text.EXIT_MENUITEM_STR, true);
		
		// Create all the menu items used in the edit menu
		this.undoMenuItem = MenuFactory.menuitem(Text.UNDO_MENUITEM_STR, true, KeyCode.Z, KeyCombination.CONTROL_DOWN);
		this.redoMenuItem = MenuFactory.menuitem(Text.REDO_MENUITEM_STR, true, KeyCode.Y, KeyCombination.CONTROL_DOWN);
		this.cutMenuItem = MenuFactory.menuitem(Text.CUT_MENUITEM_STR, true, KeyCode.X, KeyCombination.CONTROL_DOWN);
		this.copyMenuItem = MenuFactory.menuitem(Text.COPY_MENUITEM_STR, true, KeyCode.C, KeyCombination.CONTROL_DOWN);
		this.pasteMenuItem = MenuFactory.menuitem(Text.PASTE_MENUITEM_STR, true, KeyCode.V, KeyCombination.CONTROL_DOWN);
		this.findReplaceMenuItem = MenuFactory.menuitem(Text.FIND_REPLACE_MENUITEM_STR, true, KeyCode.F, KeyCombination.CONTROL_DOWN);
		this.selectAllMenuItem = MenuFactory.menuitem(Text.SELECT_ALL_MENUITEM_STR, true, KeyCode.A, KeyCombination.CONTROL_DOWN);
		
		// Create all menu items used in the run menu
		this.assembleMenuItem = MenuFactory.menuitem(Text.ASSEMBLE_MENUITEM_STR, true, KeyCode.F3);
		this.goMenuItem = MenuFactory.menuitem(Text.GO_MENUITEM_STR, true, KeyCode.F5);
		this.stepMenuItem = MenuFactory.menuitem(Text.STEP_MENUITEM_STR, true, KeyCode.F7);
		this.backstepMenuItem = MenuFactory.menuitem(Text.BACKSTEP_MENUITEM_STR, true, KeyCode.F8);
		this.pauseMenuItem = MenuFactory.menuitem(Text.PAUSE_MENUITEM_STR, true, KeyCode.F9);
		this.stopMenuItem = MenuFactory.menuitem(Text.STOP_MENUITEM_STR, true, KeyCode.F11);
		this.resetMenuItem = MenuFactory.menuitem(Text.RESET_MENUITEM_STR, true, KeyCode.F12);
		this.clearAllBreakPointsMenuItem = MenuFactory.menuitem(Text.CLEAR_ALL_MENUITEM_STR, true, KeyCode.K, KeyCombination.CONTROL_DOWN);
		this.toggleAllBreakPointsMenuItem = MenuFactory.menuitem(Text.TOGGLE_ALL_MENUITEM_STR, true, KeyCode.T, KeyCombination.CONTROL_DOWN);
		
		// Create all menu items used in the settings menu
		this.showLabelsViewCheckMenuItem = new CheckMenuItem(Text.SHOW_LABELS_MENUITEM_STR);
		this.programArgumentsCheckMenuItem = new CheckMenuItem(Text.PROGRAM_ARGS_MENUITEM_STR);
		this.popupForSyscallsCheckMenuItem = new CheckMenuItem(Text.POPUP_SYSCALL_MENUITEM_STR);
		this.displayAddressInHexCheckMenuItem = new CheckMenuItem(Text.DISPLAY_ADDR_HEX_MENUITEM_STR);
		this.displayValueInHexCheckMenuItem = new CheckMenuItem(Text.DISPLAY_VAL_HEX_MENUITEM_STR);
		this.assembleFileOnOpenCheckMenuItem = new CheckMenuItem(Text.ASSEMBLE_ON_OPEN_MENUITEM_STR);
		this.assembleAllFilesInDirectoryCheckMenuItem = new CheckMenuItem(Text.ASSEMBLE_ALL_MENUITEM_STR);
		this.treatWarningsAsErrorsCheckMenuItem = new CheckMenuItem(Text.ASSEMBLE_WARNINGS_MENUITEM_STR);
		this.initializePCtoGlobalMain = new CheckMenuItem(Text.INIT_PC_MAIN_MENUITEM_STR);
		this.permitPseudoInstructionsCheckMenuItem = new CheckMenuItem(Text.PERMIT_PSEUDO_INSTR_MENUITEM_STR);
		this.delayedBranchingCheckMenuItem = new CheckMenuItem(Text.DELAYED_BRANCHING_MENUITEM_STR);
		this.selfModifyingCodeCheckMenuItem = new CheckMenuItem(Text.SELF_MOD_CODE_MENUITEM_STR);
		this.editorMenuItem = MenuFactory.menuitem(Text.EDITOR_MENUITEM_STR, false);
		this.highlightMenuItem = MenuFactory.menuitem(Text.HIGHLIGHT_MENUITEM_STR, false);
		this.exceptionHandleMenuItem = MenuFactory.menuitem(Text.EXCEPTION_MENUITEM_STR, false);
		this.memoryConfigMenuItem = MenuFactory.menuitem(Text.MEMORY_CONFIG_MENUITEM_STR, false);
		
		// Create all menu items used in the tools menu
		this.bhtSimulatorMenuItem = MenuFactory.menuitem(Text.BHT_SIM_MENUITEM_STR, false);
		this.dataCacheSimulatorMenuItem = MenuFactory.menuitem(Text.DATA_CACHE_SIM_MENUITEM_STR, false);
		this.bitmapDisplayMenuItem = MenuFactory.menuitem(Text.BITMAP_DISPLAY_MENUITEM_STR, false);
		this.floatingPointRepMenuItem = MenuFactory.menuitem(Text.FLOATING_POINT_REP_MENUITEM_STR, false);
		this.scavengerHuntMenuItem = MenuFactory.menuitem(Text.SCAVENGER_HUNT_MENUITEM_STR, false);
		this.introToolsMenuItem = MenuFactory.menuitem(Text.INTRO_TO_TOOLS_MENUITEM_STR, false);
		this.marsBotMenuItem = MenuFactory.menuitem(Text.MARS_BOT_MENUITEM_STR, false);
		this.instructionCounterMenuItem = MenuFactory.menuitem(Text.INSTR_COUNTER_MENUITEM_STR, false);
		this.memoryReferenceVisualizerCheckMenuItem = MenuFactory.menuitem(Text.MEMORY_REF_VISUAL_MENUITEM_STR, false);
		this.mmioVisualizerCheckMenuItem = MenuFactory.menuitem(Text.MMIO_VISUALIZER_MENUITEM_STR, false);
		this.instructionStatisticsMenuItem = MenuFactory.menuitem(Text.INSTR_STATS_MENUITEM_STR, false);
		this.keyboardAndDisplaySimulatorMenuItem = MenuFactory.menuitem(Text.KEYBOARD_DISP_SIM_MENUITEM_STR, false);
		this.screenMagnifierMenuItem = MenuFactory.menuitem(Text.SCREEN_MAGNIFIER_MENUITEM_STR, false);
		this.digitalLabSimulatorMenuItem = MenuFactory.menuitem(Text.DIGITAL_LAB_MENUITEM_STR, false);
		
		// Create all menu items used in the help menu
		this.helpMenuItem = MenuFactory.menuitem(Text.HELP_MENUITEM_STR, true, KeyCode.F1);
		this.aboutMenuItem = MenuFactory.menuitem(Text.ABOUT_MENUITEM_STR, false);
		
		/*
		 * Add all menu items to their respective menus
		 */
		this.fileMenu.getItems().addAll(this.newMenuItem, this.openMenuItem, this.closeMenuItem, this.closeAllMenuItem,
				new SeparatorMenuItem(), this.saveMenuItem, this.saveAsMenuItem, this.saveAllMenuItem,
				this.dumpMemoryMenuItem, new SeparatorMenuItem(), this.printMenuItem, new SeparatorMenuItem(),
				this.exitMenuItem);
		this.editMenu.getItems().addAll(this.undoMenuItem, this.redoMenuItem, new SeparatorMenuItem(), this.cutMenuItem,
				this.copyMenuItem, this.pasteMenuItem, new SeparatorMenuItem(), this.findReplaceMenuItem,
				this.selectAllMenuItem);
		this.runMenu.getItems().addAll(this.assembleMenuItem, this.goMenuItem, this.stepMenuItem, this.backstepMenuItem,
				this.pauseMenuItem, this.stopMenuItem, this.resetMenuItem, new SeparatorMenuItem(),
				this.clearAllBreakPointsMenuItem, this.toggleAllBreakPointsMenuItem);
		this.settingsMenu.getItems().addAll(this.showLabelsViewCheckMenuItem, this.programArgumentsCheckMenuItem,
				this.popupForSyscallsCheckMenuItem, this.displayAddressInHexCheckMenuItem,
				this.displayValueInHexCheckMenuItem, new SeparatorMenuItem(), this.assembleFileOnOpenCheckMenuItem,
				this.assembleAllFilesInDirectoryCheckMenuItem, this.treatWarningsAsErrorsCheckMenuItem,
				this.initializePCtoGlobalMain, new SeparatorMenuItem(), this.permitPseudoInstructionsCheckMenuItem,
				this.delayedBranchingCheckMenuItem, this.selfModifyingCodeCheckMenuItem, new SeparatorMenuItem(),
				this.editorMenuItem, this.highlightMenuItem, this.exceptionHandleMenuItem, this.memoryConfigMenuItem);
		this.toolsMenu.getItems().addAll(this.bhtSimulatorMenuItem, this.dataCacheSimulatorMenuItem,
				this.bitmapDisplayMenuItem, this.floatingPointRepMenuItem, this.scavengerHuntMenuItem,
				this.introToolsMenuItem, this.marsBotMenuItem, this.instructionCounterMenuItem,
				this.memoryReferenceVisualizerCheckMenuItem, this.mmioVisualizerCheckMenuItem,
				this.instructionStatisticsMenuItem, this.keyboardAndDisplaySimulatorMenuItem,
				this.screenMagnifierMenuItem, this.digitalLabSimulatorMenuItem);
		this.helpMenu.getItems().addAll(this.helpMenuItem, new SeparatorMenuItem(), this.aboutMenuItem);
		
		this.menubar.getMenus().addAll(this.fileMenu, this.editMenu, this.runMenu, this.settingsMenu, this.toolsMenu,
				this.helpMenu);
	}
	
	private void initToolbar() {
		this.toolbar = new ToolBar();
		
		this.newButton = ButtonFactory.button(Images.NEW_IMAGE, Text.NEW_BUTTON_TOOLTIP);
		this.openButton = ButtonFactory.button(Images.OPEN_IMAGE, Text.OPEN_BUTTON_TOOLTIP);
		this.saveButton = ButtonFactory.button(Images.SAVE_IMAGE, Text.SAVE_BUTTON_TOOLTIP);
		this.saveAsButton = ButtonFactory.button(Images.SAVE_AS_IMAGE, Text.SAVE_AS_BUTTON_TOOLTIP);
		this.dumpMemoryButton = ButtonFactory.button(Images.DUMP_MEMORY_IMAGE, Text.DUMP_MEMORY_BUTTON_TOOLTIP);
		this.printButton = ButtonFactory.button(Images.PRINT_IMAGE, Text.PRINT_BUTTON_TOOLTIP);
		
		this.undoButton = ButtonFactory.button(Images.UNDO_IMAGE, Text.UNDO_BUTTON_TOOLTIP);
		this.redoButton = ButtonFactory.button(Images.REDO_IMAGE, Text.REDO_BUTTON_TOOLTIP);
		this.cutButton = ButtonFactory.button(Images.CUT_IMAGE, Text.CUT_BUTTON_TOOLTIP);
		this.copyButton = ButtonFactory.button(Images.COPY_IMAGE, Text.COPY_BUTTON_TOOLTIP);
		this.pasteButton = ButtonFactory.button(Images.PASTE_IMAGE, Text.PASTE_BUTTON_TOOLTIP);
		this.findReplaceButton = ButtonFactory.button(Images.FIND_REPLACE_IMAGE, Text.FIND_REPLACE_BUTTON_TOOLTIP);
		
		this.assembleButton = ButtonFactory.button(Images.ASSEMBLE_IMAGE, Text.ASSEMBLE_BUTTON_TOOLTIP);
		this.runButton = ButtonFactory.button(Images.RUN_IMAGE, Text.RUN_BUTTON_TOOLTIP);
		this.forwardStepButton = ButtonFactory.button(Images.FORWARD_STEP_IMAGE, Text.FORWARD_STEP_BUTTON_TOOLTIP);
		this.backwardStepButton = ButtonFactory.button(Images.BACK_STEP_IMAGE, Text.BACKWARD_STEP_BUTTON_TOOLTIP);
		this.pauseButton = ButtonFactory.button(Images.PAUSE_IMAGE, Text.PAUSE_BUTTON_TOOLTIP);
		this.stopButton = ButtonFactory.button(Images.STOP_IMAGE, Text.STOP_BUTTON_TOOLTIP);
		this.resetButton = ButtonFactory.button(Images.RESET_IMAGE, Text.RESET_BUTTON_TOOLTIP);
		
		this.helpButton = ButtonFactory.button(Images.HELP_IMAGE, Text.HELP_BUTTON_TOOLTIP);
		
		Separator sep1 = new Separator(), sep2 = new Separator(), sep3 = new Separator();
		sep1.setMinWidth(24);
		sep2.setMinWidth(24);
		sep3.setMinWidth(24);
		
		this.toolbar.getItems().addAll(this.newButton, this.openButton, this.saveButton, this.saveAsButton,
				this.dumpMemoryButton, this.printButton, sep1, this.undoButton, this.redoButton, this.cutButton,
				this.copyButton, this.pasteButton, this.findReplaceButton, sep2, this.assembleButton, this.runButton,
				this.forwardStepButton, this.backwardStepButton, this.pauseButton, this.stopButton, this.resetButton,
				sep3, this.helpButton);
	}
}

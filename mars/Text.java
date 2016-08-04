package mars;

/**
 * Created by Sean on 2016-07-30.
 */
public class Text {
	public static String MARS_SPLASH_TITLE = "MARS: Mips Assembler and Runtime Simulator";
	
	public static String FILE_MENU_STR = "File",
			EDIT_MENU_STR = "Edit",
			RUN_MENU_STR = "Run",
			SETTINGS_MENU_STR = "Settings",
			TOOLS_MENU_STR = "Tools",
			HELP_MENU_STR = "Help";
	
	public static String NEW_MENUITEM_STR = "New",
			OPEN_MENUITEM_STR = "Open",
			CLOSE_MENUITEM_STR = "Close",
			CLOSE_ALL_MENUITEM_STR = "Close All",
			SAVE_MENUITEM_STR = "Save",
			SAVE_AS_MENUITEM_STR = "Save as...",
			SAVE_ALL_MENUITEM_STR = "Save All",
			DUMP_MEMORY_MENUITEM_STR = "Dump Memory...",
			PRINT_MENUITEM_STR = "Print...",
			EXIT_MENUITEM_STR = "Exit";
	
	public static String UNDO_MENUITEM_STR = "Undo",
			REDO_MENUITEM_STR = "Redo",
			CUT_MENUITEM_STR = "Cut",
			COPY_MENUITEM_STR = "Copy",
			PASTE_MENUITEM_STR = "Paste",
			FIND_REPLACE_MENUITEM_STR = "Find / Replace",
			SELECT_ALL_MENUITEM_STR = "Select all";
	
	public static String ASSEMBLE_MENUITEM_STR = "Assemble",
			GO_MENUITEM_STR = "Go",
			STEP_MENUITEM_STR = "Step",
			BACKSTEP_MENUITEM_STR = "Backstep",
			PAUSE_MENUITEM_STR = "Pause",
			STOP_MENUITEM_STR = "Stop",
			RESET_MENUITEM_STR = "Reset",
			CLEAR_ALL_MENUITEM_STR = "Clear all breakpoints",
			TOGGLE_ALL_MENUITEM_STR = "Toggle all breakpoints";
	
	public static String SHOW_LABELS_MENUITEM_STR = "Show Labels Window (symbol table)",
			PROGRAM_ARGS_MENUITEM_STR = "Program arguments provided to MIPS program",
			POPUP_SYSCALL_MENUITEM_STR = "Popup dialog for input syscalls (5, 6, 7, 8, 12)",
			DISPLAY_ADDR_HEX_MENUITEM_STR = "Addresses displayed in hexadecimal",
			DISPLAY_VAL_HEX_MENUITEM_STR = "Values displayed in hexadecimal",
			ASSEMBLE_ON_OPEN_MENUITEM_STR = "Assemble file upon opening",
			ASSEMBLE_ALL_MENUITEM_STR = "Assemble all files in directory",
			ASSEMBLE_WARNINGS_MENUITEM_STR = "Assembler warnings are considered errors",
			INIT_PC_MAIN_MENUITEM_STR = "Initialize Program Counter to global 'main' if defined",
			PERMIT_PSEUDO_INSTR_MENUITEM_STR = "Permit extended (pseudo) instructions and formats",
			DELAYED_BRANCHING_MENUITEM_STR = "Delayed branching",
			SELF_MOD_CODE_MENUITEM_STR = "Self-modifying code",
			EDITOR_MENUITEM_STR = "Editor...",
			HIGHLIGHT_MENUITEM_STR = "Highlighting...",
			EXCEPTION_MENUITEM_STR = "Exception Handler...",
			MEMORY_CONFIG_MENUITEM_STR = "Memory Configuration...";
	
	public static String BHT_SIM_MENUITEM_STR = "BHT Simulator",
			DATA_CACHE_SIM_MENUITEM_STR = "Data Cache Simulator",
			BITMAP_DISPLAY_MENUITEM_STR = "Bitmap Display",
			FLOATING_POINT_REP_MENUITEM_STR = "Floating Point Representation",
			SCAVENGER_HUNT_MENUITEM_STR = "ScavengerHunt",
			INTRO_TO_TOOLS_MENUITEM_STR = "Introduction to Tools",
			MARS_BOT_MENUITEM_STR = "Mars Bot",
			INSTR_COUNTER_MENUITEM_STR = "Instruction Counter",
			MEMORY_REF_VISUAL_MENUITEM_STR = "Memory Reference Visualization",
			MMIO_VISUALIZER_MENUITEM_STR = "CSE 220 Display MMIO Simulator",
			INSTR_STATS_MENUITEM_STR = "Instruction Statistics",
			KEYBOARD_DISP_SIM_MENUITEM_STR = "Keyboard and Display Simulator",
			SCREEN_MAGNIFIER_MENUITEM_STR = "Screen Magnifier",
			DIGITAL_LAB_MENUITEM_STR = "Digital Lab Simulator";
	
	public static String HELP_MENUITEM_STR = "Help",
			ABOUT_MENUITEM_STR = "About";
	
	public static String NEW_BUTTON_TOOLTIP = "Create a new file",
			OPEN_BUTTON_TOOLTIP = "Open a file",
			SAVE_BUTTON_TOOLTIP = "Save current file",
			SAVE_AS_BUTTON_TOOLTIP = "Save current file as...",
			DUMP_MEMORY_BUTTON_TOOLTIP = "Dump machine code or data in an available format",
			PRINT_BUTTON_TOOLTIP = "Print current file",
			UNDO_BUTTON_TOOLTIP = "Undo last edit",
			REDO_BUTTON_TOOLTIP = "Redo last edit",
			CUT_BUTTON_TOOLTIP = "Cut",
			COPY_BUTTON_TOOLTIP = "Copy",
			PASTE_BUTTON_TOOLTIP = "Paste",
			FIND_REPLACE_BUTTON_TOOLTIP = "Find / Replace",
			ASSEMBLE_BUTTON_TOOLTIP = "Assemble current file and clear breakpoints",
			RUN_BUTTON_TOOLTIP = "Run the current program",
			FORWARD_STEP_BUTTON_TOOLTIP = "Run one step of the program",
			BACKWARD_STEP_BUTTON_TOOLTIP = "Undo the last step",
			PAUSE_BUTTON_TOOLTIP = "Pause the currently running program",
			STOP_BUTTON_TOOLTIP = "Stop the currently running program",
			RESET_BUTTON_TOOLTIP = "Reset MIPS memory and registers",
			HELP_BUTTON_TOOLTIP = "Help";
}

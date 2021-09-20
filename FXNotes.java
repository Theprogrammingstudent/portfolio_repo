package application;

//Alex Mulkerrins - 3049679

//  Resources
/** JavaFX - Oracle Docs
 *  https://docs.oracle.com/javase/8/javafx/api/toc.htm
 *  
 *  JavaFX - Text Input control Oracle Docs.
 *  used for cut, copy, paste, delete, Select All, txtMain.clear (New)
 *  https://docs.oracle.com/javase/8/javafx/api/toc.htm
 *  
 *  Platform.exit() for Close and Exit.
 *  
 * */

//The standard imports for javafx.
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;

//Imports for labels and buttons.
import javafx.scene.control.Button;
import javafx.scene.control.Label;

//Imports for components in this application.
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

//Imports for menus.
import javafx.scene.control.MenuBar;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

//Imports for layout.
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

//Quitting.
import javafx.application.Platform;
import javafx.geometry.Insets;

//Imports for file handling.
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.File;
import java.io.FileOutputStream;

//The FileChooser dialog allows the user to pick a file.
import javafx.stage.FileChooser;

//FXNotes Class
public class FXNotes extends Application {
	// Declare all Variables & components that will need class scope.

	// Declare a file instance.
	File file;

	// Declare the top menu bar & menu options/components in the top menu bar.
	MenuBar mBar;
	Menu mnuFile, mnuEdit, mnuHelp;

	// File Menu components
	MenuItem miFileNew, miFileOpen, miFileClose, miFileSave, miFileExit;

	// Edit Menu components.
	MenuItem miEditDelete, miEditCut, miEditCopy, miEditPaste, miEditUndo, 
	miEditRedo, miEditSelectAll;

	// Help Menu components.
	MenuItem miHelpAbout;

	// The main text display area.
	TextArea txtMain;

	// This is the constructor (note - same name as the class file).
	public FXNotes() {

		// Instantiate components.

		// Menu items for the menu bar.
		mBar = new MenuBar();
		mnuFile = new Menu("File");
		mnuEdit = new Menu("Edit");
		mnuHelp = new Menu("Help");

		// File Menu Items
		// New, Open, Close, Save As, Exit.
		miFileNew = new MenuItem("New");
		miFileOpen = new MenuItem("Open");
		miFileClose = new MenuItem("Close");
		miFileSave = new MenuItem("Save As...");
		miFileExit = new MenuItem("Exit");

		// Edit Menu items
		// Delete, Cut, Copy, Paste, Undo, Redo, Select All.
		miEditDelete = new MenuItem("Delete");
		miEditCut = new MenuItem("Cut");
		miEditCopy = new MenuItem("Copy");
		miEditPaste = new MenuItem("Paste");
		miEditUndo = new MenuItem("Undo");
		miEditRedo = new MenuItem("Redo");
		miEditSelectAll = new MenuItem("Select All");

		// Help menu item about.
		// About.
		miHelpAbout = new MenuItem("About");

		// The main text display area.
		txtMain = new TextArea();

	}// Constructor() close.

	@Override
	public void init() {

		// The init method deals with event Handling - This is where we control all
		// event operations.
		// In other words what we want to happen when an option is clicked.

		// File Events

		// create a new text document.
		// invoke newTextFile().
		miFileNew.setOnAction(ae -> newTextFile());

		// Open a text document.
		// Invoke openTextFile().
		miFileOpen.setOnAction(ae -> openTextFile());

		// Close the document.
		// Invoke closeTextFile().
		miFileClose.setOnAction(ae -> closeTextFile());

		// Saving a text document.
		// Invoke saveTextFile().
		miFileSave.setOnAction(ae -> saveTextFile());

		// Quitting the application.
		// Invoke Platform.exit() from imported platform class.
		miFileExit.setOnAction(ae -> Platform.exit());

		// Edit Events

		// miEditDelete - ".deletePreviousChar()" from the textInputControl will either
		// delete the previous char
		// like the normal backspace key or delete any highlighted text you would like
		// to delete.
		miEditDelete.setOnAction(ae -> txtMain.deletePreviousChar());

		// Here we can use the ".cut" ".copy" ".paste" ".undo()" ".redo()" ".selectAll()" method from
		// the TextInputControl class to cut, copy, paste, undo, redo and selectAll.
		miEditCut.setOnAction(ae -> txtMain.cut());
		miEditCopy.setOnAction(ae -> txtMain.copy());
		miEditPaste.setOnAction(ae -> txtMain.paste());
		miEditUndo.setOnAction(ae -> txtMain.undo());
		miEditRedo.setOnAction(ae -> txtMain.redo());
		miEditSelectAll.setOnAction(ae -> txtMain.selectAll());

		// Help/About events
		// Handle events for the Help/About menu item.
		// Invoke showDialogBox
		miHelpAbout.setOnAction(ae -> showDialogBox());

	}

	// Show dialog box is an alert imported above.
	// It show my name and number when selected.
	// It also needs to show the alert using ".show".
	public void showDialogBox() {

		// Just use an alert for this first dialog application.
		Alert alert = new Alert(AlertType.INFORMATION);

		alert.setTitle("Dialog box");
		alert.setHeaderText("Alex Mulkerrins - 3049679");
		alert.setContentText("showDialogBox is an alert.");

		alert.show();
	}// ShowDialogBox Close

	// Methods for the file menu.

	/* newTextFile(), will test if there is any text in
	 * txtMain (Text Area).
	 * 
	 * Code researched from:
	 * https://www.dreamincode.net/forums/topic/243334-checking-if-a-textarea-is-empty/
	 * .getText() - will get the text from the text area.
	 * .trim() - will return a copy of the string text 
	 * without leading or trailing spaces
	 * .length() is the length of the string.
	 *
	 * If there is text then a save prompt dialog box
	 * (explained below)
	 * will appear, after you have decided if you would like to save or not it will
	 * clear the
	 * text area.
	 * Otherwise, the text area is cleared anyway.
	 */
	
	public void newTextFile() {

		if (txtMain.getText().trim().length() != 0) {
			saveCheck();
			txtMain.clear();
		} // if

		else {
			txtMain.clear();
		} // else

	}// newTextFile close

	// openTextFile will deal will opening a ".txt" file to the text editor.
	public void openTextFile() {

		// Create a new filechooser to allow for the selection of a file.
		FileChooser fileChooser = new FileChooser();

		// Set the title.
		fileChooser.setTitle("Open Resource File");

		// Assign a file for the new ".txt".
		File fileToOpen = fileChooser.showOpenDialog(null);

		// If the dialog is confirmed (ok is clicked).
		if (fileToOpen != null) {

			// Try to open a file and display
			// it in the main text area.
			try {
				// Accumulate lines from the file in the string builder.
				StringBuilder sb = new StringBuilder();

				// Use buffered reader to read from the file.
				FileReader fr = new FileReader(fileToOpen);
				BufferedReader buf = new BufferedReader(fr);

				// A string to store lines from the file temporarily.
				String text;

				// Iterate through the file reading one line at a time.
				while ((text = buf.readLine()) != null) {

					text = text + "\n";

					// Append the line of text to the string builder's
					// accumulated text.
					sb.append(text);

				} // while close

				// Done iterating through the file. EOF reached.
				// Add the entire text to txtMain.
				txtMain.setText(sb.toString());

				// Very important. close the file. Done.
				buf.close();

			} // try close

			// Catch any IO exception that might occur so the app doesn't crash.
			catch (IOException ioe) {
				System.out.println("Error opening file: ");
				ioe.printStackTrace();
			} // Catch close
		}

		else
			;// do nothing

	}// openTextFile close

	/* closeTextFile(), will test if there is any text in
	 * txtMain (Text Area).
	 * 
	 * Code researched from:
	 * https://www.dreamincode.net/forums/topic/243334-checking-if-a-textarea-is-empty/
	 * .getText() - will get the text from the text area.
	 * .trim() - will return a copy of the string text 
	 * without leading or trailing spaces
	 * .length() is the length of the string.
	 * 
	 * If there is text, then a save prompt dialog box
	 * (explained below)
	 * will appear, after you have decided if you would like to save or not it will
	 * close the
	 * text editor.
	 * Otherwise, the text editor is closed anyway.
	 */
	
	public void closeTextFile() {

		if (txtMain.getText().trim().length() != 0) {
			saveCheck();
			Platform.exit();
		} // if

		else {
			Platform.exit();
		} // else

	}// closeTextFile close

	// saveTextFile will deal will saving a ".txt" file from the text
	// editor(FXNotes) to your computer.
	public void saveTextFile() {

		// Use a file chooser.
		FileChooser fc = new FileChooser();

		// Create a file to save.
		File fileToSave = fc.showSaveDialog(null);

		// Test to see if the dialog is confirmed and there is a file to save.
		if (fileToSave != null) {

			// Try save the file using the name given.
			try {

				// writing data to a file.
				FileOutputStream fos = new FileOutputStream(fileToSave, true);

				// Declare String "text" to get text in text area.
				String text = txtMain.getText();

				// The file text must be saved as bytes.
				byte[] dataOut = text.getBytes();

				// Now write it to the file.
				fos.write(dataOut);

				// Flush the fos to the file. It might just be buffered.
				fos.flush();

				// Now close it.
				fos.close();

			} // tryClose

			// Catch any IO errors that occur.
			catch (IOException ioe) {
				System.out.println("Error saving file:\n");
				ioe.printStackTrace();
			} // catchClose

		} // ifClose

		else
			;// Do nothing.

	}// saveTextFile close

	
	// I created a method to produce a dialog box asking if the user would like to
	// save there
	// work. If yes, then save text file is invoked. OtherWise don't save and
	// continue the operation.
	// I.E. either newTextFile or closeTextFile.
	public void saveCheck() {
		
		// Create a secondary stage.
		Stage dialogStage = new Stage();

		// Set the title.
		dialogStage.setTitle("Save as");

		// Set width and height.
		dialogStage.setHeight(120);
		dialogStage.setWidth(300);

		// Create controls/components for the dialog layout.
		Label lblSaveWork = new Label("Do you wish to save your work?");

		// Yes and no buttons.
		Button btnYes = new Button("Yes");
		Button btnNo = new Button("No");
		
		// Create a layout and padding for the components on the sides.
		VBox vbMain = new VBox();
		vbMain.setPadding(new Insets(10));

		//Declare some HBox components.
		HBox hbLabel = new HBox();
		HBox hbButtons = new HBox();

		// Add components to the layout.
		hbLabel.getChildren().add(lblSaveWork);
		hbButtons.getChildren().addAll(btnYes, btnNo);

		// Space the label buttons. Apply the spacing to the container.
		hbButtons.setSpacing(10);
		vbMain.setSpacing(10);

		// Add child containers to the parent container.
		vbMain.getChildren().addAll(hbLabel, hbButtons);

		// Size the buttons
		btnNo.setMinWidth(60);
		btnYes.setMinWidth(60);

		// Manage button events
		//Clicking button no will just close the dialog
		btnNo.setOnAction(ae -> dialogStage.close());

		//Clicking yes will invoke the save method/feature on the app and then close dialog.
		btnYes.setOnAction(ae -> {
			saveTextFile();
			dialogStage.close();
		});

		// Create a scene for the dialog box.
		Scene s = new Scene(vbMain);

		// Set the scene for the dialog box.
		dialogStage.setScene(s);

		// show the (dialog) stage and wait for a command.
		dialogStage.showAndWait();
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		// Set the title.
		primaryStage.setTitle("FXNotes V1.0");

		// Set the width and height.
		primaryStage.setWidth(400);
		primaryStage.setHeight(300);

		// Create a layout.
		BorderPane bpMain = new BorderPane();

		// Add components to the layout.
		bpMain.setCenter(txtMain);
		bpMain.setTop(mBar);

		// Add menus to the menu bar.
		mBar.getMenus().add(mnuFile);
		mBar.getMenus().add(mnuEdit);
		mBar.getMenus().add(mnuHelp);

		// The File Menu contents
		// New, Open, Close, Save As, Exit.
		mnuFile.getItems().add(miFileNew);
		mnuFile.getItems().add(miFileOpen);
		mnuFile.getItems().add(miFileClose);
		mnuFile.getItems().add(miFileSave);
		mnuFile.getItems().add(miFileExit);

		// The Edit menu contents
		// Delete, Cut, Copy, Paste, Select All.
		mnuEdit.getItems().add(miEditDelete);
		mnuEdit.getItems().add(miEditCut);
		mnuEdit.getItems().add(miEditCopy);
		mnuEdit.getItems().add(miEditPaste);
		mnuEdit.getItems().add(miEditUndo);
		mnuEdit.getItems().add(miEditRedo);
		mnuEdit.getItems().add(miEditSelectAll);

		// The Help menu contents
		// About.
		mnuHelp.getItems().add(miHelpAbout);

		// Create a scene.
		Scene s = new Scene(bpMain);

		// Set the scene.
		primaryStage.setScene(s);

		//Show the stage
		primaryStage.show();

	}//start method

	//Main method.
	public static void main(String[] args) {
		//Launch the FXNotes.
		launch(args);
	}
}

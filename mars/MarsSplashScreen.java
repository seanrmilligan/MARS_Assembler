package mars;

import javafx.application.Preloader;
import javafx.application.Preloader.StateChangeNotification.Type;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


/*
Copyright (c) 2016,  Sean Milligan

Developed by Sean Milligan (mars@seanrmilligan.com)

Permission is hereby granted, free of charge, to any person obtaining 
a copy of this software and associated documentation files (the 
"Software"), to deal in the Software without restriction, including 
without limitation the rights to use, copy, modify, merge, publish, 
distribute, sublicense, and/or sell copies of the Software, and to 
permit persons to whom the Software is furnished to do so, subject 
to the following conditions:

The above copyright notice and this permission notice shall be 
included in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, 
EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF 
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. 
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR 
ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION 
WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.

(MIT license, http://www.opensource.org/licenses/mit-license.html)
 */

/**
 * Produces MARS splash screen.<br>
 * Adapted from http://www.java-tips.org/content/view/1267/2/<br>
 */

public class MarsSplashScreen extends Preloader {
	
	private static final int splashDuration = 2000; // time in MS to show splash screen

	private static int imageHeight = 215;
	private static int imageWidth = 390;
	
	private Stage preloaderStage;
	private BorderPane splashPane;
	private BackgroundImage backroundImage;
	private Label title;
	private Label copyrightVersionAndDate;
	private Label copyrightHolders;
	
	private long startTimeMilliseconds;

	@Override
	public void init() {
		this.splashPane = new BorderPane();
		this.splashPane.setMinHeight(MarsSplashScreen.imageHeight);
		this.splashPane.setMinWidth(MarsSplashScreen.imageWidth);
		
		this.backroundImage = new BackgroundImage(
			new Image(Globals.imagesPath + "MarsSurfacePathfinder.jpg", MarsSplashScreen.imageWidth, MarsSplashScreen.imageHeight, true, false),
			BackgroundRepeat.NO_REPEAT,
			BackgroundRepeat.NO_REPEAT,
			BackgroundPosition.CENTER,
			new BackgroundSize(MarsSplashScreen.imageWidth, MarsSplashScreen.imageHeight, false, false, false, false)
		);
		
		this.title = new Label("MARS: Mips Assembler and Runtime Simulator");
		this.copyrightVersionAndDate = new Label(Globals.version + " Copyright (c) " + Globals.copyrightYears);
		this.copyrightHolders = new Label(Globals.copyrightHolders);
		
		this.splashPane.setTop(this.title);
		this.splashPane.setCenter(this.copyrightVersionAndDate);
		this.splashPane.setBottom(this.copyrightHolders);
		this.splashPane.setBackground(new Background(this.backroundImage));
	}

	public void start(Stage primaryStage) {
		this.preloaderStage = primaryStage;
		
		this.preloaderStage.setScene(new Scene(this.splashPane));
		this.preloaderStage.show();
		this.preloaderStage.centerOnScreen();
		this.startTimeMilliseconds = System.currentTimeMillis();
	}
	
	@Override
	public void handleStateChangeNotification(StateChangeNotification stateChangeNotification) {
		if (stateChangeNotification.getType() == Type.BEFORE_START) {
			long currentTimeMilliseconds = System.currentTimeMillis();
			
			while(currentTimeMilliseconds - this.startTimeMilliseconds < MarsSplashScreen.splashDuration) {
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					
				}
				
				currentTimeMilliseconds = System.currentTimeMillis();
			}
			
			this.preloaderStage.hide();
		}
	}
}

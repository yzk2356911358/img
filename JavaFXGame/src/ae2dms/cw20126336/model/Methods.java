package ae2dms.cw20126336.model;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import ae2dms.cw20126336.control.GameEngine;
import ae2dms.cw20126336.control.GameObject;
import ae2dms.cw20126336.junit.txtExport;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.effect.Effect;
import javafx.scene.effect.MotionBlur;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;

@SuppressWarnings("deprecation")
public class Methods extends Application{

	private Stage primaryStage;
	private GameEngine gameEngine;
	private GridPane gameGrid;
	private File saveFile;
	private MenuBar menu;

	public static void main(String[] args) {
		launch(args);
	}

	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		menu = new MenuBar();
		MenuItem menuItemSaveGame = new MenuItem("Save Game");
//		menuItemSaveGame.setDisable(true);
		menuItemSaveGame.setOnAction(actionEvent -> saveGame());
		MenuItem menuItemLoadGame = new MenuItem("Load Game");
		menuItemLoadGame.setOnAction(actionEvent -> loadGame());
		MenuItem menuItemExit = new MenuItem("Exit");
		menuItemExit.setOnAction(actionEvent -> closeGame());
		Menu menuFile = new Menu("File");
		menuFile.getItems().addAll(menuItemSaveGame, menuItemLoadGame, new SeparatorMenuItem(), menuItemExit);

		MenuItem menuItemUndo = new MenuItem("Undo");
//		menuItemUndo.setDisable(true);
		menuItemUndo.setOnAction(actionEvent -> undo());
		RadioMenuItem radioMenuItemMusic = new RadioMenuItem("Toggle Music");
		radioMenuItemMusic.setOnAction(actionEvent -> toggleMusic());
		RadioMenuItem radioMenuItemDebug = new RadioMenuItem("Toggle Debug");
		radioMenuItemDebug.setOnAction(actionEvent -> toggleDebug());
		MenuItem menuItemResetLevel = new MenuItem("Reset Level");
		Menu menuLevel = new Menu("Level");
		menuLevel.setOnAction(actionEvent -> {
			try {
				resetLevel();
			} catch (NumberFormatException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		menuLevel.getItems().addAll(menuItemUndo, radioMenuItemMusic, radioMenuItemDebug, new SeparatorMenuItem(),
				menuItemResetLevel);

		MenuItem menuItemGame = new MenuItem("About This Game");
		Menu menuAbout = new Menu("About");
		menuAbout.setOnAction(actionEvent -> showAbout());
		menuAbout.getItems().addAll(menuItemGame);
		menu.getMenus().addAll(menuFile, menuLevel, menuAbout);
		gameGrid = new GridPane();
		GridPane root = new GridPane();
		root.add(menu, 0, 0);
		root.add(gameGrid, 0, 1);
		primaryStage.setTitle("Push ball game");
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(Main.class.getResource("Login.css").toExternalForm());
		primaryStage.show();

		loadDefaultSaveFile(primaryStage);
	}

	void loadDefaultSaveFile(Stage primaryStage) {
		this.primaryStage = primaryStage;
		InputStream in = getClass().getClassLoader().getResourceAsStream("level/SampleGame11.skb");
		initializeGame(in);
		setEventFilter();
	}

	private void initializeGame(InputStream input) {
		gameEngine = new GameEngine(input, true);
		reloadGrid();
	}

	private void setEventFilter() {
		primaryStage.addEventFilter(KeyEvent.KEY_PRESSED, event -> {
			gameEngine.handleKey(event.getCode());
			reloadGrid();
		});
	}

	private void loadGameFile() throws FileNotFoundException {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Open Save File");
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Sokoban save file", "*.skb"));
		saveFile = fileChooser.showOpenDialog(primaryStage);

		if (saveFile != null) {
			if (GameEngine.isDebugActive()) {
				GameEngine.logger.info("Loading save file: " + saveFile.getName());
			}
			initializeGame(new FileInputStream(saveFile));
		}
	}

	private void reloadGrid() {
		if (gameEngine.isGameComplete()) {
			showVictoryMessage();
			return;
		}
		Level currentLevel = gameEngine.getCurrentLevel();
		Level.LevelIterator levelGridIterator = (Level.LevelIterator) currentLevel.iterator();
		gameGrid.getChildren().clear();
		while (levelGridIterator.hasNext()) {
			addObjectToGrid(levelGridIterator.next(), levelGridIterator.getcurrentposition());
		}
		gameGrid.autosize();
		primaryStage.sizeToScene();
	}

	public void showVictoryMessage() {
		String dialogTitle = "Game Over!";
		String dialogMessage = "You completed " + gameEngine.mapSetName + " in " + gameEngine.movesCount + " moves!";
		MotionBlur mb = new MotionBlur(2, 3);
		newDialog(dialogTitle, dialogMessage, mb);
	}
	public void showVictoryMessage2(int gk,int zg,int you) {
		String dialogTitle = "Game Over!";
		String dialogMessage = "你已经完成了关卡"+gk+"当前关卡最高分:"+zg+"你的分数:"+you;
		MotionBlur mb = new MotionBlur(2, 3);
		newDialog(dialogTitle, dialogMessage, mb);
	}

	private void newDialog(String dialogTitle, String dialogMessage, Effect dialogMessageEffect) {
		final Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setResizable(false);
		dialog.setTitle(dialogTitle);
		TextArea textArea = new TextArea(dialogMessage);
		textArea.setWrapText(true);
		textArea.setFont(javafx.scene.text.Font.font(15));
		textArea.setEditable(false);
		VBox dialogVbox = new VBox(20);
		dialogVbox.setAlignment(Pos.CENTER);
		dialogVbox.setBackground(Background.EMPTY);
		dialogVbox.getChildren().add(textArea);
		Scene dialogScene = new Scene(dialogVbox, 300, 176);
		dialog.setScene(dialogScene);
		dialog.show();
	}



	public void closeGame() {
		System.exit(0);
	}

	@SuppressWarnings("static-access")
	public void saveGame() {
		if (GameEngine.currentLevel == null) {
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(primaryStage);
			dialog.setResizable(false);
			dialog.setTitle("Message");
			TextArea textArea = new TextArea("请先开始游戏");
			textArea.setWrapText(true);
			textArea.setFont(javafx.scene.text.Font.font(15));
			textArea.setEditable(false);
			VBox dialogVbox = new VBox(20);
			dialogVbox.setAlignment(Pos.CENTER);
			dialogVbox.setBackground(Background.EMPTY);
			dialogVbox.getChildren().add(textArea);
			Scene dialogScene = new Scene(dialogVbox, 300, 176);
			dialog.setScene(dialogScene);
			dialog.show();
		} else {
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(primaryStage);
			dialog.setResizable(false);
			dialog.setTitle("Message");
			TextArea textArea = new TextArea("保存成功");
			textArea.setWrapText(true);
			textArea.setFont(javafx.scene.text.Font.font(15));
			textArea.setEditable(false);
			VBox dialogVbox = new VBox(20);
			dialogVbox.setAlignment(Pos.CENTER);
			dialogVbox.setBackground(Background.EMPTY);
			dialogVbox.getChildren().add(textArea);
			Scene dialogScene = new Scene(dialogVbox, 300, 176);
			dialog.setScene(dialogScene);
			dialog.show();
			txtExport txtExport = new txtExport();
			try {
				txtExport.creatTxtFile();
				txtExport.writeTxtFile("MapSetName: Example Game!");
				txtExport.writeTxtFile("LevelName: Simple Start");
				txtExport.writeTxtFile(GameEngine.currentLevel.toString());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void loadGame() {
		try {
			loadGameFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void undo() {
	}
	private void addObjectToGrid(GameObject gameObject, Point location) {
		GraphicObject graphicObject = new GraphicObject(gameObject);
		gameGrid.add(graphicObject, location.y, location.x);
	}
	public void resetLevel() throws NumberFormatException, IOException {
		
		Level currentLevel = gameEngine.getNextLevel2();
		Level.LevelIterator levelGridIterator = (Level.LevelIterator) currentLevel.iterator();
		gameGrid.getChildren().clear();
		while (levelGridIterator.hasNext()) {
			addObjectToGrid(levelGridIterator.next(), levelGridIterator.getcurrentposition());
		}
		gameGrid.autosize();
		primaryStage.sizeToScene();
	}

	public void showAbout() {
		String title = "About this game";
		String message = "This is a ball push game, you need to move the ball to push the "
				+ "ball with another ball, has completed the level。By：Jiayin Wang";
		newDialog(title, message, null);
	}

	public void toggleMusic() {
			//引导音乐文件的所在路径
		System.out.println("toggleMusic");
			File f=new File("music/puzzle_theme1.wav");
			//将File类型的路径转成为URL资源路径
			URL cb;
			try {
				cb = f.toURL();
				//通过URL资源路径来构建一个具体的播放器
				AudioClip aau=Applet.newAudioClip(cb);
				aau.play();//进行播放
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("stop");
	}

	public void toggleDebug() {
		gameEngine.toggleDebug();
		reloadGrid();
	}
}

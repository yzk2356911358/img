package ae2dms.cw20126336.model;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.effect.Effect;
import javafx.scene.effect.MotionBlur;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.FileChooser;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import ae2dms.cw20126336.control.GameEngine;
import ae2dms.cw20126336.control.GameObject;
import ae2dms.cw20126336.junit.txtExport;

public class Main extends Application {
	private Stage primaryStage;
	private GameEngine gameEngine;
	private GridPane gameGrid;
	private File saveFile;
	private MenuBar menu;
	private Button start;
	private Button about;
	private Button exit;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.primaryStage = primaryStage;
		menu = new MenuBar();
		MenuItem menuItemSaveGame = new MenuItem("Save Game");
//		menuItemSaveGame.setDisable(true);
		menuItemSaveGame.setOnAction(actionEvent -> saveGame());
		MenuItem menuItemLoadGame = new MenuItem("Load Game");
		menuItemLoadGame.setOnAction(actionEvent -> loadGame());
		// 开始菜单
		MenuItem menuItemStartGame = new MenuItem("Next level");
		menuItemStartGame.setOnAction(actionEvent -> startGame());
		MenuItem menuItemExit = new MenuItem("Exit");
		menuItemExit.setOnAction(actionEvent -> closeGame());
		Menu menuFile = new Menu("File");
		menuFile.getItems().addAll(menuItemSaveGame, menuItemStartGame, menuItemLoadGame, new SeparatorMenuItem(),
				menuItemExit);
		MenuItem menuItemUndo = new MenuItem("Undo");
		menuItemUndo.setDisable(true);
		menuItemUndo.setOnAction(actionEvent -> undo());
		RadioMenuItem radioMenuItemMusic = new RadioMenuItem("Toggle Music");
		radioMenuItemMusic.setOnAction(actionEvent -> toggleMusic());
		RadioMenuItem radioMenuItemDebug = new RadioMenuItem("Toggle Debug");
		radioMenuItemDebug.setOnAction(actionEvent -> toggleDebug());
		// 实现重置功能
		MenuItem menuItemResetLevel = new MenuItem("Reset Level");
		menuItemResetLevel.setOnAction(actionEvent -> resetLevel());
		Menu menuLevel = new Menu("Level");
		menuLevel.setOnAction(actionEvent -> resetLevel());
		menuLevel.getItems().addAll(menuItemUndo, radioMenuItemMusic, radioMenuItemDebug, new SeparatorMenuItem(),
				menuItemResetLevel);
		MenuItem menuItemGame = new MenuItem("About This Game");
		Menu menuAbout = new Menu("About");
		menuAbout.setOnAction(actionEvent -> showAbout());
		menuAbout.getItems().addAll(menuItemGame);
		menu.getMenus().addAll(menuFile, menuLevel, menuAbout);
		gameGrid = new GridPane();
		GridPane root = new GridPane();
		start = new Button("Start Game");
		start.setTranslateX(820);
		start.setTranslateY(110);

		exit = new Button("Exit  Game");
		exit.setTranslateX(820);
		exit.setTranslateY(150);
		primaryStage.getIcons().add(new Image("img/bg.jpg"));
		root.add(menu, 0, 0);
		root.add(gameGrid, 0, 1);
		root.add(start, 0, 2);
		root.add(exit, 0, 3);
		primaryStage.setTitle("Push ball game");
		Scene scene = new Scene(root, 1120, 590);
		primaryStage.setScene(scene);
		scene.getStylesheets().add(Main.class.getResource("Login.css").toExternalForm());
		primaryStage.show();
		start.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				loadDefaultSaveFile(primaryStage);
			}
		});
		exit.setOnAction(actionEvent -> closeGame());
	}

	public void loadDefaultSaveFile(Stage primaryStage) {
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

	private void showVictoryMessage() {
		String dialogTitle = "Game Over!";
		String dialogMessage = "You completed " + gameEngine.mapSetName + " in " + gameEngine.movesCount + " moves!";
		MotionBlur mb = new MotionBlur(2, 3);

		newDialog(dialogTitle, dialogMessage, mb);
	}

	private void newDialog(String dialogTitle, String dialogMessage, Effect dialogMessageEffect) {
		final Stage dialog = new Stage();
		dialog.initModality(Modality.APPLICATION_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setResizable(false);
		dialog.setTitle(dialogTitle);
//		Text text1 = new Text(dialogMessage);
//		text1.setTextAlignment(TextAlignment.CENTER);
//		text1.setFont(javafx.scene.text.Font.font(14));
		TextArea textArea = new TextArea(dialogMessage);
		textArea.setWrapText(true);
		textArea.setFont(javafx.scene.text.Font.font(15));
		textArea.setEditable(false);
//		 if (dialogMessageEffect != null) {
//			text1.setEffect(dialogMessageEffect);
//		}
		VBox dialogVbox = new VBox(20);
		dialogVbox.setAlignment(Pos.CENTER);
		dialogVbox.setBackground(Background.EMPTY);
		dialogVbox.getChildren().add(textArea);
		Scene dialogScene = new Scene(dialogVbox, 300, 176);
		dialog.setScene(dialogScene);
		dialog.show();
	}

	private void addObjectToGrid(GameObject gameObject, Point location) {
		GraphicObject graphicObject = new GraphicObject(gameObject);
		gameGrid.add(graphicObject, location.y, location.x);
	}

	public void closeGame() {
		System.exit(0);

	}

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
			System.out.println(GameEngine.currentLevel.toString());
			System.out.println(GameEngine.currentLevel.getIndex());
			System.out.println(GameEngine.currentLevel.getName());
			System.out.println(GameEngine.currentLevel.getKeeperPosition());
			txtExport txtExport = new txtExport();
			try {
				txtExport.creatTxtFile();
				txtExport.writeTxtFile("MapSetName: Example Game!");
				txtExport.writeTxtFile("LevelName: Simple Start");
				txtExport.writeTxtFile(GameEngine.currentLevel.toString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void startGame() {
		loadDefaultSaveFile(primaryStage);
	}

	public void loadGame() {
		try {
			loadGameFile();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void undo() {
		closeGame();
	}

	public void resetLevel() {
		loadDefaultSaveFile(primaryStage);
	}

	public void showAbout() {
		String title = "About this game";
		String message = "This is a ball push game, you need to move the ball to push the "
				+ "ball with another ball, has completed the level。By：Jiayin Wang";
		newDialog(title, message, null);
	}

	public void toggleMusic() {
		System.out.println("toggleMusic");
	}

	public void toggleDebug() {
		gameEngine.toggleDebug();
		reloadGrid();
	}
}

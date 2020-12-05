package ae2dms.cw20126336.control;

import javafx.scene.input.KeyCode;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import ae2dms.cw20126336.model.FileUtil;
import ae2dms.cw20126336.model.Level;
import ae2dms.cw20126336.model.Methods;
import ae2dms.cw20126336.view.GameGrid;

public class GameEngine {
	public static GameLogger logger;
	public int movesCount = 0;
	public String mapSetName;
	private static boolean debug = false;
	public static Level currentLevel;
	private List<Level> levels;
	private boolean gameComplete = false;
	public static Point keeperPosition;
	public  int t=0;
	public GameEngine(InputStream input, boolean production) {
		try {
			logger = new GameLogger();
			levels = loadGameFile(input);
			currentLevel = getNextLevel();
		} catch (IOException x) {
			System.out.println("Cannot create logger.");
		} catch (NoSuchElementException e) {
			logger.warning("Cannot load the default save file: " + e.getStackTrace());
		}
	}
	public void GameEngine2(InputStream input, boolean production) {
		try {
			logger = new GameLogger();
			levels = loadGameFile(input);
			currentLevel = getNextLevel2();
		} catch (IOException x) {
			System.out.println("Cannot create logger.");
		} catch (NoSuchElementException e) {
			logger.warning("Cannot load the default save file: " + e.getStackTrace());
		}
	}
	

	public static boolean isDebugActive() {
		return debug;
	}

	public void handleKey(KeyCode code) {
		switch (code) {
		case UP:
			move(new Point(-1, 0));
			break;

		case RIGHT:
			move(new Point(0, 1));
			break;

		case DOWN:
			move(new Point(1, 0));
			break;

		case LEFT:
			move(new Point(0, -1));
			break;

		default:
		}
		if (isDebugActive()) {
			System.out.println("暗下了" + code);
		}
	}

	private void move(Point delta) {
		if (isGameComplete()) {
			return;
		}
		keeperPosition = currentLevel.getKeeperPosition();
		GameObject keeper = currentLevel.objectsGrid.getGameObjectAt(keeperPosition);
		Point targetObjectPoint = GameGrid.translatePoint(keeperPosition, delta);
		GameObject keeperTarget = currentLevel.objectsGrid.getGameObjectAt(targetObjectPoint);
		if (GameEngine.isDebugActive()) {
			System.out.println("开始");
			System.out.println("Current level state:");
			System.out.println(currentLevel.toString());
			System.out.println("Keeper pos: " + keeperPosition);
			System.out.println("Movement source obj: " + keeper);
			System.out.printf("Target object: %s at [%s]", keeperTarget, targetObjectPoint);
			System.out.println("结束");
		}

		boolean keeperMoved = false;

		switch (keeperTarget) {

		case WALL:
			break;

		case CRATE:

			GameObject crateTarget = currentLevel.getTargetObject(targetObjectPoint, delta);
			if (crateTarget != GameObject.FLOOR) {
				break;
			}
			currentLevel.objectsGrid.putGameObjectAt(
					currentLevel.objectsGrid.getGameObjectAt(GameGrid.translatePoint(targetObjectPoint, delta)),
					targetObjectPoint);
			currentLevel.objectsGrid.putGameObjectAt(keeperTarget, GameGrid.translatePoint(targetObjectPoint, delta));
			currentLevel.objectsGrid.putGameObjectAt(
					currentLevel.objectsGrid.getGameObjectAt(GameGrid.translatePoint(keeperPosition, delta)),
					keeperPosition);
			currentLevel.objectsGrid.putGameObjectAt(keeper, GameGrid.translatePoint(keeperPosition, delta));
			keeperMoved = true;
			break;
		case FLOOR:
			currentLevel.objectsGrid.putGameObjectAt(
					currentLevel.objectsGrid.getGameObjectAt(GameGrid.translatePoint(keeperPosition, delta)),
					keeperPosition);
			currentLevel.objectsGrid.putGameObjectAt(keeper, GameGrid.translatePoint(keeperPosition, delta));
			keeperMoved = true;
			break;
		default:
			logger.severe("The object to be moved was not a recognised GameObject.");
			throw new AssertionError("This should not have happened. Report this problem to the developer.");
		}

		if (keeperMoved) {
			keeperPosition.translate((int) delta.getX(), (int) delta.getY());
			movesCount++;
			if (currentLevel.isComplete()) {
				if (isDebugActive()) {
					System.out.println("Level complete!");
				}
				try {
					currentLevel = getNextLevel();
				} catch (NumberFormatException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	private List<Level> loadGameFile(InputStream input) {
		List<Level> levels = new ArrayList<>(5);
		int levelIndex = 0;
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(input))) {
			boolean parsedFirstLevel = false;
			List<String> rawLevel = new ArrayList<>();
			String levelName = "";
			while (true) {
				String line = reader.readLine();
				if (line == null) {
					if (rawLevel.size() != 0) {
						Level parsedLevel = new Level(levelName, ++levelIndex, rawLevel);
						levels.add(parsedLevel);
					}
					break;
				}

				if (line.contains("MapSetName")) {
					mapSetName = line.replace("MapSetName: ", "");
					continue;
				}

				if (line.contains("LevelName")) {
					if (parsedFirstLevel) {
						Level parsedLevel = new Level(levelName, ++levelIndex, rawLevel);
						levels.add(parsedLevel);
						rawLevel.clear();
					} else {
						parsedFirstLevel = true;
					}

					levelName = line.replace("LevelName: ", "");
					continue;
				}

				line = line.trim();
				line = line.toUpperCase();
				if (line.matches(".*W.*W.*")) {
					rawLevel.add(line);
				}
			}
		} catch (IOException e) {
			logger.severe("Error trying to load the game file: " + e);
		} catch (NullPointerException e) {
			logger.severe("Cannot open the requested file: " + e);
		}
		return levels;
	}

	public boolean isGameComplete() {
		return gameComplete;
	}

	@SuppressWarnings("static-access")
	public Level getNextLevel() throws NumberFormatException, IOException {
		FileUtil fileUtil = new FileUtil();
		if(t==1)
		{
			int max=0;
			if(fileUtil.fieleexists("1"))
			{
				max=Integer.parseInt(fileUtil.readFile("1"));
				if(max>movesCount)
				{
					fileUtil.addfs("1",""+movesCount);
					Methods main = new Methods();
					main.showVictoryMessage2(t,max,movesCount);
					movesCount=0;
				}else {
					Methods main = new Methods();
					main.showVictoryMessage2(t,max,movesCount);
					movesCount=0;
				}
				
			}else {
				fileUtil.creatTxtFile("1");
				fileUtil.addfs("1",""+movesCount);
				Methods main = new Methods();
				main.showVictoryMessage2(t,0,movesCount);
				movesCount=0;	
			}
			
			
		}else if(t==2)
		{
			int max=0;
			if(fileUtil.fieleexists("2"))
			{
				max=Integer.parseInt(fileUtil.readFile("2"));
				if(max>movesCount)
				{
					fileUtil.addfs("2",""+movesCount);
					Methods main = new Methods();
					main.showVictoryMessage2(t,max,movesCount);
					movesCount=0;
				}else {
					Methods main = new Methods();
					main.showVictoryMessage2(t,max,movesCount);
					movesCount=0;
				}
				
			}else {
				fileUtil.creatTxtFile("2");
				fileUtil.addfs("2",""+movesCount);
				Methods main = new Methods();
				main.showVictoryMessage2(t,0,movesCount);
				movesCount=0;	
			}
		}
		else if(t==3)
		{
			int max=0;
			if(fileUtil.fieleexists("3"))
			{
				max=Integer.parseInt(fileUtil.readFile("3"));
				if(max>movesCount)
				{
					fileUtil.addfs("3",""+movesCount);
					Methods main = new Methods();
					main.showVictoryMessage2(t,max,movesCount);
					movesCount=0;
				}else {
					Methods main = new Methods();
					main.showVictoryMessage2(t,max,movesCount);
					movesCount=0;
				}
				
			}else {
				fileUtil.creatTxtFile("3");
				fileUtil.addfs("3",""+movesCount);
				Methods main = new Methods();
				main.showVictoryMessage2(t,0,movesCount);
				movesCount=0;	
			}
		}
		else if(t==4)
		{
			int max=0;
			if(fileUtil.fieleexists("4"))
			{
				max=Integer.parseInt(fileUtil.readFile("4"));
				if(max>movesCount)
				{
					fileUtil.addfs("4",""+movesCount);
					Methods main = new Methods();
					main.showVictoryMessage2(t,max,movesCount);
					movesCount=0;
				}else {
					Methods main = new Methods();
					main.showVictoryMessage2(t,max,movesCount);
					movesCount=0;
				}
				
			}else {
				fileUtil.creatTxtFile("4");
				fileUtil.addfs("4",""+movesCount);
				Methods main = new Methods();
				main.showVictoryMessage2(t,0,movesCount);
				movesCount=0;	
			}
		}
		else if(t==5)
		{
			int max=0;
			if(fileUtil.fieleexists("5"))
			{
				max=Integer.parseInt(fileUtil.readFile("5"));
				if(max>movesCount)
				{
					fileUtil.addfs("5",""+movesCount);
					Methods main = new Methods();
					main.showVictoryMessage2(t,max,movesCount);
					movesCount=0;
				}else {
					Methods main = new Methods();
					main.showVictoryMessage2(t,max,movesCount);
					movesCount=0;
				}
				
			}else {
				fileUtil.creatTxtFile("5");
				fileUtil.addfs("5",""+movesCount);
				Methods main = new Methods();
				main.showVictoryMessage2(t,0,movesCount);
				movesCount=0;	
			}
		}
		else if(t==6)
		{
			int max=0;
			if(fileUtil.fieleexists("6"))
			{
				max=Integer.parseInt(fileUtil.readFile("6"));
				if(max>movesCount)
				{
					fileUtil.addfs("6",""+movesCount);
					Methods main = new Methods();
					main.showVictoryMessage2(t,max,movesCount);
					movesCount=0;
				}else {
					Methods main = new Methods();
					main.showVictoryMessage2(t,max,movesCount);
					movesCount=0;
				}
				
			}else {
				fileUtil.creatTxtFile("6");
				fileUtil.addfs("6",""+movesCount);
				Methods main = new Methods();
				main.showVictoryMessage2(t,0,movesCount);
				movesCount=0;	
			}
		}
		t++;
		if (currentLevel == null) {
			return levels.get(0);
		}
		int currentLevelIndex = currentLevel.getIndex();
		if (currentLevelIndex < levels.size()) {
			return levels.get(currentLevelIndex + 1);
		}
		gameComplete = true;
		return null;
	}
	public Level getNextLevel2() throws NumberFormatException, IOException {
		return currentLevel;
	}


	public Level getCurrentLevel() {
		return currentLevel;
	}

	public void toggleDebug() {
		debug = !debug;
	}
	
}
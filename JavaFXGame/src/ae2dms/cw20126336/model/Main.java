package ae2dms.cw20126336.model;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage begainStage) throws Exception {
		Button startbutton = new Button("Start  Game");
		startbutton.setPrefWidth(120);
		startbutton.setFont(javafx.scene.text.Font.font(14));
		Button exitbutton = new Button("Exit  Game");
		exitbutton.setPrefWidth(120);
		exitbutton.setFont(javafx.scene.text.Font.font(14));
		Button aboutbutton = new Button("About  Game");
		aboutbutton.setPrefWidth(120);
		aboutbutton.setFont(javafx.scene.text.Font.font(14));
		VBox buttonvbox = new VBox(30);
		buttonvbox.getChildren().addAll(startbutton, aboutbutton, exitbutton);
		buttonvbox.setStyle("-fx-background-image: url(/img/bg.jpg)");
		buttonvbox.setAlignment(Pos.BOTTOM_RIGHT);
		startbutton.setOnAction(event -> {
			Methods open = new Methods();
			try {
				open.start(new Stage());
			} catch (Exception e) {
				e.printStackTrace();
			}
			begainStage.hide();// After clicking on the new interface, whether to close this interface
		});
		aboutbutton.setOnAction(event -> {
			final Stage dialog = new Stage();
			dialog.initModality(Modality.APPLICATION_MODAL);
			dialog.initOwner(begainStage);
			VBox dialogVbox = new VBox(20);
			Text text0 = new Text("SokobanFX is a gamen about pushing boxes\n" + "Person movement: Use arrow keys");
			text0.setTextAlignment(TextAlignment.CENTER);
			text0.setFont(javafx.scene.text.Font.font(14));
			dialogVbox.getChildren().add(text0);
			Scene dialogScene = new Scene(dialogVbox, 300, 200);
			dialog.setScene(dialogScene);
			dialog.setResizable(false);
			dialog.show();
		});
		exitbutton.setOnAction(event -> System.exit(0));
		Scene scene = new Scene(buttonvbox, 600, 640);
		begainStage.setTitle("Start interface");
		begainStage.setScene(scene);
		begainStage.setResizable(false);
		begainStage.show();

	}
	
}

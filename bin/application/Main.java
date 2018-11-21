package application;

import java.io.FileInputStream;

import com.sun.prism.paint.Color;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;

/**
 * Formelrad Application
 * 
 * @author Michel Elias/Dorian Ljuta
 * @version 13.09.2018
 */
public class Main extends Application {
	private int counter = 0;

	@Override
	public void start(Stage primaryStage) {

		try {
			Pane root = new Pane();

			// Creating an image
			Image image = new Image(new FileInputStream("bin\\application\\formelradelektronik.gif"));
			ImageView imageView = new ImageView(image);
			imageView.setX(10);
			imageView.setY(10);
			imageView.setFitHeight(300);
			imageView.setFitWidth(300);
			imageView.setPreserveRatio(true);
			root.getChildren().add(imageView);

			Label lbleistung = new Label("Leistung:");
			lbleistung.relocate(10, 285);
			lbleistung.setFont(Font.font(15));
			root.getChildren().add(lbleistung);

			TextField txLeistung = new TextField();
			txLeistung.relocate(100, 285);
			txLeistung.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txLeistung);

			Label lblSpannung = new Label("Spannung:");
			lblSpannung.relocate(10, 325);
			lblSpannung.setFont(Font.font(15));
			root.getChildren().add(lblSpannung);

			TextField txSpannung = new TextField();
			txSpannung.relocate(100, 325);
			txSpannung.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txSpannung);

			Label lblStrom = new Label("Strom:");
			lblStrom.relocate(10, 365);
			lblStrom.setFont(Font.font(15));
			root.getChildren().add(lblStrom);

			TextField txStrom = new TextField();
			txStrom.relocate(100, 365);
			txStrom.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txStrom);

			Label lblWiderstand = new Label("Widerstand:");
			lblWiderstand.relocate(10, 405);
			lblWiderstand.setFont(Font.font(15));
			root.getChildren().add(lblWiderstand);

			TextField txWiderstand = new TextField();
			txWiderstand.relocate(100, 405);
			txWiderstand.setFont(Font.font("Verdana", 15));
			root.getChildren().add(txWiderstand);

			Button btnBerechnen = new Button();
			btnBerechnen.relocate(100, 445);
			btnBerechnen.setText("Berechnen");
			root.getChildren().add(btnBerechnen);

			btnBerechnen.setOnAction(e -> {

				txLeistung.setStyle("-fx-text-fill: black;");
				txSpannung.setStyle("-fx-text-fill: black;");
				txWiderstand.setStyle("-fx-text-fill: black;");
				txStrom.setStyle("-fx-text-fill: black;");

				if (txLeistung.getText().trim().isEmpty()) {
					txLeistung.setText("NaN");
				} else {
					this.counter++;
				}

				if (txStrom.getText().trim().isEmpty()) {
					txStrom.setText("NaN");
				} else {
					this.counter++;
				}

				if (txWiderstand.getText().trim().isEmpty()) {
					txWiderstand.setText("NaN");
				} else {
					this.counter++;
				}

				if (txSpannung.getText().trim().isEmpty()) {
					txSpannung.setText("NaN");

				} else {
					this.counter++;
				}
				if (this.counter > 2) {
					System.err.println("Mehr als zwei Zahlen angegeben bitte genau nur 2 Zahlen angeben !");
					this.counter = 0;
					txLeistung.setStyle("-fx-text-fill: black;");
					txSpannung.setStyle("-fx-text-fill: black;");
					txWiderstand.setStyle("-fx-text-fill: black;");
					txStrom.setStyle("-fx-text-fill: black;");
					return;
				}

				Calculator myCalculator = new Calculator(Double.parseDouble(txLeistung.getText()),
						Double.parseDouble(txSpannung.getText()), Double.parseDouble(txStrom.getText()),
						Double.parseDouble(txWiderstand.getText()));
				System.out.print("Vorher:  ");
				System.out.println(myCalculator.toString());
				myCalculator.calculate();
				System.out.print("Nachher: ");
				System.out.println(myCalculator.toString());

				txLeistung.setText(Double.toString(myCalculator.getLeistung()));
				txSpannung.setText(Double.toString(myCalculator.getSpannung()));
				txStrom.setText(Double.toString(myCalculator.getStrom()));
				txWiderstand.setText(Double.toString(myCalculator.getWiderstand()));
				this.counter = 0;
			});

			Scene scene = new Scene(root, 330, 490);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("Formelrad");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}

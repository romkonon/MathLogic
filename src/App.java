import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class App extends Application {
    int row = 0;
    int column = 0;
    Stage window;
    public static void main(String[] args){launch();}

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        window.setTitle("MathLogic");
        window.show();

        HBox start = new HBox();
        Scene startScene = new Scene(start,400,50);
        window.setScene(startScene);
        GridPane field = new GridPane();
        Scene scene = new Scene(field);
        TextField tfH = new TextField();
        tfH.setPromptText("column");
        tfH.setFocusTraversable(false);
        TextField tfW = new TextField();
        tfW.setPromptText("row");
        tfW.setFocusTraversable(false);
        Button bStart = new Button("Start");
        start.getChildren().addAll(tfH,tfW,bStart);
        bStart.setOnAction(e->{
            if(!tfW.getText().isEmpty() && !tfH.getText().isEmpty()) {
                row = Integer.parseInt(tfW.getText());
                column = Integer.parseInt(tfH.getText());
                Field fField = new Field(row,column);
                fField.show();
                window.setScene(scene);
            }
            else {
                tfW.setPromptText("Invalid");
                tfH.setPromptText("Invalid");
            }
        });
    }
}

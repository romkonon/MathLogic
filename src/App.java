import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class App extends Application {
    int row = 0;
    int column = 0;
    Stage startWindow;
    public static void main(String[] args){launch();}

    @Override
    public void start(Stage primaryStage) {
        startWindow = primaryStage;
        startWindow.setTitle("MathLogic");
        startWindow.show();

        HBox start = new HBox();
        Scene startScene = new Scene(start,400,50);
        startWindow.setScene(startScene);
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
                GridPane field = new GridPane();
                for(int y = 0; y < column;y++){
                    for (int x = 0; x< row; x++){
                        TextField tf = new TextField();
                        tf.setPrefHeight(50);
                        tf.setPrefWidth(50);
                        tf.setAlignment(Pos.CENTER);
                        tf.setEditable(false);
                        tf.setText("V" + (y + x));//Set vSum

                        field.setRowIndex(tf,x+1);
                        field.setColumnIndex(tf,0);
                        field.getChildren().add(tf);
                    }
                }
                for(int y = 0; y < column;y++){
                    for (int x = 0; x< row; x++){
                        TextField tf = new TextField();
                        tf.setPrefHeight(50);
                        tf.setPrefWidth(50);
                        tf.setAlignment(Pos.CENTER);
                        tf.setEditable(false);
                        tf.setText("H" + (x + y));//Set hSum

                        field.setRowIndex(tf,0);
                        field.setColumnIndex(tf,y+1);
                        field.getChildren().add(tf);
                    }
                }
                for(int i = 0; i<column;i++){
                    for (int j = 0; j<row; j++){
                        Button bt = new Button();
                        bt.setPrefHeight(50);
                        bt.setPrefWidth(50);
                        bt.setAlignment(Pos.CENTER);
                        bt.setText("bt" + j +i);//set value
                        field.setRowIndex(bt,j+1);
                        field.setColumnIndex(bt,i+1);
                        bt.setOnAction(event->{

                        });
                        field.getChildren().add(bt);
                    }
                }
                startWindow.close();
                startWindow.setScene(new Scene(field));
                startWindow.show();
            }
            else {
                tfW.setPromptText("Invalid");
                tfH.setPromptText("Invalid");
            }
        });
    }
}

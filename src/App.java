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
                for(int x = 0; x<column;x++){
                    TextField tf = new TextField();
                    tf.setPrefHeight(50);
                    tf.setPrefWidth(50);
                    tf.setAlignment(Pos.CENTER);
                    tf.setEditable(false);
                    GridPane.setConstraints(tf,x+1,0);
                    tf.setText(fField.vSum[x].toString());
                    field.getChildren().add(tf);
                }
                for(int x = 0; x<row;x++){
                    TextField tf = new TextField();
                    tf.setPrefHeight(50);
                    tf.setPrefWidth(50);
                    tf.setAlignment(Pos.CENTER);
                    tf.setEditable(false);
                    GridPane.setConstraints(tf,0,x+1);
                    tf.setText(fField.hSum[x].toString());
                    field.getChildren().add(tf);
                }
/*                for(int y = 0; y < column;y++){
                    for (int x = 0; x< row; x++){
                        TextField tf = new TextField();
                        tf.setPrefHeight(50);
                        tf.setPrefWidth(50);
                        tf.setAlignment(Pos.CENTER);
                        tf.setEditable(false);
                        tf.setText(fField.vSum[x].toString());//Set vSum
                        field.setRowIndex(tf,x+1);
                        field.setColumnIndex(tf,0);
                        field.getChildren().add(tf);
                    }
                }*/
/*                for(int y = 0; y < column;y++){
                    for (int x = 0; x< row; x++){
                        TextField tf = new TextField();
                        tf.setPrefHeight(50);
                        tf.setPrefWidth(50);
                        tf.setAlignment(Pos.CENTER);
                        tf.setEditable(false);
                        tf.setText(fField.hSum[x].toString());//Set hSum
                        field.setRowIndex(tf,0);
                        field.setColumnIndex(tf,y+1);
                        field.getChildren().add(tf);
                    }
                }*/
                for(int i = 0; i<column;i++){
                    for (int j = 0; j<row; j++){
                        CrdButton crdButton = new CrdButton(j+1,i+1,fField.getNum(j+1,i+1));
                        crdButton.bt.setPrefHeight(50);
                        crdButton.bt.setPrefWidth(50);
                        crdButton.bt.setAlignment(Pos.CENTER);
                        crdButton.bt.setText(crdButton.getValue().toString());//set value
                        GridPane.setConstraints(crdButton.bt,i+1,j+1);
                        crdButton.bt.setStyle("-fx-background-color: #ccff99; ");
                        crdButton.bt.setOnAction(event->{
                            if(fField.user[crdButton.getX()-1][crdButton.getY()-1]){
                                crdButton.bt.setStyle("-fx-background-color: #ffad99; ");
                            }
                            else{
                                crdButton.bt.setStyle("-fx-background-color: #ccff99; ");
                            }
                            fField.turn((crdButton.getX()-1),(crdButton.getY()-1));
                            if(fField.isWin()){
                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("Victory");
                                alert.setHeaderText("You Win");
                                alert.showAndWait();
                                startWindow.close();
                                startWindow.setScene((startScene));
                                startWindow.show();
                            }
                        });
                        field.getChildren().add(crdButton.bt);
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

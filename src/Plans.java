import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Plans extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        Text greet = new Text();
        greet.setText("Here is the Career Plans to the Author-HaitianXu\n 下面为作者徐海天的学习计划");
        greet.setFont(Font.font(30));
        grid.add(greet, 2, 2);

        Text upp = new Text();
        upp.setText("\n (1) review the data structure and Algorithm\n    复习数据结构与算法\n\n (2) learn the Web developing technology\n    学习Web开发技术\n\n (3) improve the Git and Github building\n    巩固git与github学习 ");
        upp.setFont(Font.font(20));
        grid.add(upp, 2, 3);

        Image im = new Image("comp.png");
        ImageView imv = new ImageView();
        imv.setImage(im);
        imv.setFitHeight(300);
        imv.setFitWidth(500);
        grid.add(imv, 4, 3);

        HBox bottom = new HBox();
        bottom.setPadding(new Insets(28, 15, 28, 20));
        bottom.setSpacing(15);
        bottom.setStyle("-fx-background-color: gray");

        Button back = new Button("Back返回");
        back.setPrefSize(150, 20);
        back.setFont(Font.font(20));
        back.setLayoutX(1000);
        back.setOnAction((ActionEvent event)->{
            FirstApp open = new FirstApp();
            try {
                open.start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
            primaryStage.hide();
        });

        bottom.getChildren().add(back);
        bottom.setAlignment(Pos.BOTTOM_RIGHT);
        BorderPane window = new BorderPane();
        window.setBottom(bottom);
        window.setCenter(grid);
        Scene scene = new Scene(window, 1300, 900);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Plans");
        primaryStage.show();
    }
}

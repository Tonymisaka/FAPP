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

public class Author extends Application {

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
        greet.setText("Here is the Introduction to the Author-HaitianXu\n 下面为作者徐海天的简介");
        greet.setFont(Font.font(30));
        grid.add(greet, 2, 2);

        Text upp = new Text();
        upp.setText("\n (1) Name姓名: Haitian XU(徐海天)\n\n (2) School学校: UW-Madison\n\n (3) Major专业: Computer Science\n\n (4) Nationality国籍: China\n\n (5)Preferred programming language编程语言: Java, HTML, CSS, JS");
        upp.setFont(Font.font(20));
        grid.add(upp, 2, 3);

        Image im = new Image("hx.JPG");
        ImageView imv = new ImageView();
        imv.setImage(im);
        imv.setFitHeight(300);
        imv.setFitWidth(300);
        grid.add(imv, 7, 3);

        Image img = new Image("wis.png");
        ImageView imp = new ImageView();
        imp.setImage(img);
        imp.setFitHeight(150);
        imp.setFitWidth(400);
        grid.add(imp, 7, 6);

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
        window.setTop(grid);
        Scene scene = new Scene(window, 1300, 900);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Author");
        primaryStage.show();
    }
}

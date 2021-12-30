import javafx.application.Application;
import javafx.application.HostServices;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.image.Image;

/**
 * This is the first Personal JavaFx APP created by Haitian Xu to show personal info of him
 * @author Haitian Xu
 */
public class FirstApp extends Application
{
    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //UpDesign-personal information
        HBox up = new HBox();
        up.setPadding(new Insets(28, 15, 28, 20));
        up.setSpacing(15);
        up.setStyle("-fx-background-color: gray");

        Button author = new Button("Author作者");
        author.setPrefSize(115, 35);
        author.setFont(Font.font("sans-serif", 18));
        author.setOnAction((ActionEvent event)->{
            Author open = new Author();
            open.start(new Stage());
            primaryStage.hide();
        });

        Button plans  = new Button("Plans计划");
        plans.setPrefSize(115, 35);
        plans.setFont(Font.font("sans-serif", 18));
        plans.setOnAction((ActionEvent event)->{
            Plans open = new Plans();
            open.start(new Stage());
            primaryStage.hide();
        });

        Text title = new Text("               First App第一作 [v0.1]");
        title.setFont(Font.font("Arial", FontWeight.BOLD, 40));
        title.setFill(Color.WHITE);

        up.getChildren().add(author);
        up.getChildren().add(plans);
        up.getChildren().add(title);

        //LeftDesign-Web list
        VBox left = new VBox();
        left.setPadding(new Insets(10));
        left.setSpacing(10);

        Text direct = new Text("Web Direction网页引导");
        direct.setFont(Font.font("Arial", FontWeight.BOLD, 25));

        //baidu
        HBox bd = new HBox();

        Text bbd = new Text("Baidu百度");
        bbd.setFont(Font.font(20));

        Hyperlink baidu = new Hyperlink();
        baidu.setText("http://www.baidu.com/");
        baidu.setFont(Font.font(15));
        baidu.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                HostServices host = FirstApp.this.getHostServices();
                host.showDocument(baidu.getText());
            }
        });
        bd.getChildren().add(bbd);
        bd.getChildren().add(baidu);

        //Google
        HBox ggg = new HBox();

        Text gg = new Text("Google谷歌");
        gg.setFont(Font.font(20));

        Hyperlink google = new Hyperlink();
        google.setText("http://www.google.com/");
        google.setFont(Font.font(15));
        google.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                HostServices host = FirstApp.this.getHostServices();
                host.showDocument(google.getText());
            }
        });

        ggg.getChildren().addAll(gg, google);

        //bilibili
        HBox bili = new HBox();

        Text bbl = new Text("Bilibili主页");
        bbl.setFont(Font.font(20));

        Hyperlink bilibili = new Hyperlink();
        bilibili.setText("https://space.bilibili.com/32387866");
        bilibili.setFont(Font.font(15));
        bilibili.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                HostServices host = FirstApp.this.getHostServices();
                host.showDocument(bilibili.getText());
            }
        });
        bili.getChildren().add(bbl);
        bili.getChildren().add(bilibili);

        //github 主页
        HBox gitb = new HBox();

        Text gitbb = new Text("GitHub主页");
        gitbb.setFont(Font.font(20));

        Hyperlink github = new Hyperlink();
        github.setText("https://tonymisaka.github.io/");
        github.setFont(Font.font(15));
        github.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event){
                HostServices host = FirstApp.this.getHostServices();
                host.showDocument(github.getText());
            }
        });
        gitb.getChildren().add(gitbb);
        gitb.getChildren().add(github);
        left.getChildren().add(direct);
        left.getChildren().add(bd);
        left.getChildren().add(ggg);
        left.getChildren().add(bili);
        left.getChildren().add(gitb);


        //MainDesign-Introduction
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(0, 10, 0, 10));

        Text greet = new Text();
        greet.setText("Welcome to FirstApp by Haitian Xu(徐海天)");
        greet.setFont(Font.font(30));
        grid.add(greet, 0, 0);

        Text leftIn = new Text();
        leftIn.setText(" (1) Left side are the web links to Haitian Xu's main pages\n     左侧为徐海天的个人网页引导");
        leftIn.setFont(Font.font(20));
        grid.add(leftIn, 0, 2);

        Text leftTop = new Text();
        leftTop.setText(" (2) Left Top are the entrance to Haitian Xu's introduction and career plans\n     左上为徐海天的个人介绍与学习计划");
        leftTop.setFont(Font.font(20));
        grid.add(leftTop, 0, 4);

        Image im = new Image("logo.png");
        ImageView imv = new ImageView();
        imv.setImage(im);
        grid.add(imv, 0, 5);

        //bottom-Exit
        HBox bottom = new HBox();

        Button exit = new Button("Exit退出");
        exit.setFont(Font.font(20));
        exit.setOnAction((ActionEvent event)->{
            primaryStage.close();
        });

        bottom.getChildren().add(exit);
        bottom.setAlignment(Pos.BOTTOM_RIGHT);

        BorderPane window = new BorderPane();
        window.setTop(up);
        window.setLeft(left);
        window.setBottom(bottom);
        window.setCenter(grid);

        Scene scene = new Scene(window, 1300, 900);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FirstAPP");
        primaryStage.show();
    }
}

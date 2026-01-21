import java.util.ArrayList;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;

public class MultipleBoardPane extends ScrollPane {
  private ArrayList<Integer[]> boards;

  public MultipleBoardPane() {
    boards = (new Queens()).getBoards();
    drawGUI();
  }

  private void drawGUI() {
    HBox hbBoards = new HBox(10);
    for (int i = 0; i < boards.size(); i++) {
      BoardPane bp = new BoardPane(boards.get(i), i + 1);
      hbBoards.getChildren().add(bp);
    }

    setContent(hbBoards);
  }
}

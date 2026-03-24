import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import controller.FileGameController;
import model.LifeGameModel;
import view.LifeGameView;

/**
 * LifeGame1Go アプリケーションを起動するクラス。
 */
public class Main {

    /**
     * アプリケーションを起動する。
     *
     * @param args コマンドライン引数
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // MVCインスタンスを生成する
            LifeGameModel model = new LifeGameModel(30, 30);
            LifeGameView view = new LifeGameView(model);
            FileGameController controller = new FileGameController(model, view);

            view.setController(controller);

            // 起動する
            JFrame frame = new JFrame("LifeGame1Go");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(view);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}

package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.Timer;

import model.LG1Model;

public class LG1View extends JPanel {
    private int cellSize = 20; // グリッド1マスあたりのサイズpx

    private Timer timer; // 世代更新の間隔

    private JPanel boardPanel;

    // コンストラクタ
    public LG1View(LG1Model model) {
        setLayout(new BorderLayout());
        boardPanel = new JPanel() {
            // 画面描画
            protected void paintComponent(Graphics g) {
                super.paintComponent(g); // 描画前に背景クリアしておかないと前の描画が残ることがある

                for (int r = 0; r < 30; r++) {
                    for (int c = 0; c < 30; c++) {
                        int x = c * cellSize;
                        int y = r * cellSize;

                        if (model.getCell(r, c)) {
                            g.fillRect(x, y, cellSize, cellSize); // 塗りつぶす(生)
                        } else {
                            g.drawRect(x, y, cellSize, cellSize); // 塗りつぶさない(死)
                        }
                    }
                }
            }
        };

        boardPanel.setPreferredSize(new Dimension(600, 600));
        boardPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int col = e.getX() / cellSize;
                int row = e.getY() / cellSize;

                model.toggleCell(row, col);
                boardPanel.repaint();
            }
        });

        add(boardPanel, BorderLayout.CENTER);

        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(startButton);
        buttonPanel.add(stopButton);
        add(buttonPanel, BorderLayout.SOUTH);

        timer = new Timer(200, e -> {
            model.nextGeneration();

            // 全滅なら自動停止する
            if (!model.hasAliveCells()) {
                timer.stop();
            }

            boardPanel.repaint();
        });

        startButton.addActionListener(e -> timer.start());
        stopButton.addActionListener(e -> timer.stop());
    }
}

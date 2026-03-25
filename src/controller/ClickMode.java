package controller;

/**
 * 盤面クリック時の動作モード。
 */
public enum ClickMode {
    TOGGLE("Toggle"),
    GLIDER("Glider"),
    BLOCK("Block"),
    BLINKER("Blinker"),
    GOSPER_GLIDER_GUN("Gosper Glider Gun");

    /** 画面表示用の名前 */
    private final String displayName;

    /**
     * 動作モードを生成する。
     * 
     * @param displayName 画面表示用の名前
     */
    ClickMode(String displayName) {
        this.displayName = displayName;
    }

    /**
     * 画面表示用の名前を返す。
     * 
     * @return 画面に表示する名前
     */
    @Override
    public String toString() {
        return displayName;
    }

    /**
     * 選択されたモードをControllerに適用する。
     * 
     * @param controller コントローラ
     */
    public void apply(LifeGameController controller) {
        switch (this) {
            case TOGGLE -> controller.setToggleMode();
            case GLIDER -> controller.setGliderMode();
            case BLOCK -> controller.setBlockMode();
            case BLINKER -> controller.setBlinkerMode();
            case GOSPER_GLIDER_GUN -> controller.setGosperGliderGunMode();
        }
    }
}

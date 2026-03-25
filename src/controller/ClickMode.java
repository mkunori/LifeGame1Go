package controller;

/**
 * 盤面クリック時の動作モード。
 */
public enum ClickMode {
    TOGGLE("Toggle"), GLIDER("Glider"), BLOCK("Block");

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
}

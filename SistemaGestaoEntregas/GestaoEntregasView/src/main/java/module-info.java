module br.cefetmg.lp2.gestaoentregasview {
    requires javafx.controls;
    requires javafx.fxml;

    opens br.cefetmg.lp2.gestaoentregasview to javafx.fxml;
    exports br.cefetmg.lp2.gestaoentregasview;
}

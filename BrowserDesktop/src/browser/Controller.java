package browser;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable, ChangeListener{

    @FXML
    TextField addressBar;

    @FXML
    WebView webView;

    @FXML
    Button backButton;

    @FXML
    Button forwardButton;

    public void goBack(){
        try {
            webView.getEngine().getHistory().go(-1);
        }
        catch (IndexOutOfBoundsException e){
        }
    }

    public void goForward(){
        try {
            webView.getEngine().getHistory().go(1);
        }
        catch (IndexOutOfBoundsException e){
        }
    }

    public void goToUrl(){
        String url = addressBar.getText();
        if(!url.startsWith("http")) {
            url = "http://" + url;
        }

        webView.getEngine().load(url);
    }

    public void onKeyPressed(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER){
            goToUrl();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Worker worker = webView.getEngine().getLoadWorker();
        worker.stateProperty().addListener(this);

        backButton.setDisable(true);
        forwardButton.setDisable(true);

    }

    @Override
    public void changed(ObservableValue observable, Object oldValue, Object newValue) {
        addressBar.setText(webView.getEngine().getLocation());

        int index = webView.getEngine().getHistory().getCurrentIndex();
        if(index > 0){
            backButton.setDisable(false);
        }

        if(webView.getEngine().getHistory().getEntries().size() > index + 1){
            forwardButton.setDisable(false);
        }
    }
}

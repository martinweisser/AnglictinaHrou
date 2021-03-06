package com.github.martinweisser.AnglictinaHrou;

import java.util.Random;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Hlavní třída aplikace.
 * Obsahuje veškerou logiku aplikace.
 * 
 * @author martinweisser
 *
 */
public class Controller {

    @FXML private ImageView bear;
    @FXML private ImageView flower;
    @FXML private ImageView monkey;
    @FXML private ImageView car;
    @FXML private ImageView house;
    @FXML private ImageView window;

    @FXML private TextFlow bearText;
    @FXML private TextFlow windowText;
    @FXML private TextFlow houseText;
    @FXML private TextFlow carText;
    @FXML private TextFlow monkeyText;
    @FXML private TextFlow flowerText;

    @FXML private TextField tipText;
    @FXML private Label tipLbl;
    @FXML private VBox tipWindow;
    @FXML private VBox statistikaWindow;
    @FXML private TextArea statistika;

    @FXML private Tooltip tooltip;


    private int spatna;
    private int spravna;
    private int nahodne;
    private boolean odpoved;

    /*
     * Metoda zobrazí popis obrázku
     */
    @FXML public void bear() {
        bearText.setVisible(true);
    }

    /*
     * Metoda zobrazí popis obrázku
     */
    @FXML public void window() {
        windowText.setVisible(true);
    }

    /*
     * Metoda zobrazí popis obrázku
     */
    @FXML public void car() {
        carText.setVisible(true);
    }

    /*
     * Metoda zobrazí popis obrázku
     */
    @FXML public void house() {
        houseText.setVisible(true);
    }

    /*
     * Metoda zobrazí popis obrázku
     */
    @FXML public void flower() {
        flowerText.setVisible(true);
    }

    /*
     * Metoda zobrazí popis obrázku
     */
    @FXML public void monkey() {
        monkeyText.setVisible(true);
    }

    /*
     * Metoda skryje popisy obrázků
     */
    @FXML public void viditelnostObrazku() {
        bearText.setVisible(false);
        windowText.setVisible(false);
        carText.setVisible(false);
        flowerText.setVisible(false);
        houseText.setVisible(false);
        monkeyText.setVisible(false);
    }

    /*
     * Metoda náhodně skryje jeden ze šesti obrázků
     */
    @FXML public void hadej() {

        nahodnaCisla();
        zobrazeniObrazku();

        tipWindow.setVisible(true);
        tipText.setEditable(true);
        statistikaWindow.setVisible(true);
        statistika.setEditable(false);

        if (nahodne == 1) {
            bear.setVisible(true);
        }
        if (nahodne == 2) {
            window.setVisible(true);
        }
        if (nahodne == 3) {
            car.setVisible(true);
        }
        if (nahodne == 4) {
            flower.setVisible(true);
        }
        if (nahodne == 5) {
            house.setVisible(true);
        }
        if (nahodne == 6) {
            monkey.setVisible(true);
        }
    }
    /*
     * Metoda pro vyhodnocení správného tipu uživatele
     */
    @FXML public void tipuj() {

        String vstupniText = tipText.getText();
        odpoved = false;

        if (nahodne == 1 && vstupniText.equals("bear")) {
            spravna++;
            odpoved = true;
        } else if (nahodne == 2 && vstupniText.equals("window")) {
            spravna++;
            odpoved = true;
        } else if (nahodne == 3 && vstupniText.equals("car")) {
            spravna++;
            odpoved = true;
        } else if (nahodne == 4 && vstupniText.equals("flower")) {
            spravna++;
            odpoved = true;
        } else if (nahodne == 5 && vstupniText.equals("house")) {
            spravna++;
            odpoved = true;
        } else if (nahodne == 6 && vstupniText.equals("monkey")) {
            spravna++;
            odpoved = true;
        } else {
            spatna++;
            odpoved = false;
        }

        statistika.setText("Správně: " + spravna + "     Špatně: " + spatna);
        tipText.setText("");
        noveOkno();
        zobrazeniObrazku();
        tipWindow.setVisible(false);

    }

    /*
     * Metoda vynuluje a skryje statistiky
     */
    @FXML public void nullStatistiky() {
        spatna = 0;
        spravna = 0;
        statistika.setText("Správně: " + spravna + "     Špatně: " + spatna);
        statistikaWindow.setVisible(false);
    }

    /*
     * Metoda zobrazí tooltip
     */
    @FXML public void napovedaHadej() {
        tooltip.setText("Uhodni anglický název jednoho náhodně vybraného obrázku!");
    }

    /*
     * Metoda generující náhodné číslo od 1 do 6
     */
    public void nahodnaCisla() {
        Random cislo = new Random();
        nahodne = cislo.nextInt(6) + 1;
    }

    /*
     * Metoda, která zobrazí nové okno
     */
    public void noveOkno() {

        StackPane newScene = new StackPane();

        if (odpoved) {
            Label about = new Label("Výborně! Uhodl jsi!");
            newScene.getChildren().add(about);
        } else {
            Label about = new Label("Bohužel, odpověděl jsi nesprávně!");
            newScene.getChildren().add(about);
        }

        Scene scene = new Scene(newScene, 300, 100);
        Stage newWindow = new Stage();

        newWindow.setTitle("Tvá odpověď!");
        newWindow.setScene(scene);
        newWindow.setAlwaysOnTop(true);
        newWindow.centerOnScreen();
        newWindow.initModality(Modality.WINDOW_MODAL);
        newWindow.setX(500);
        newWindow.setY(300);

        newWindow.show();
    }

    /*
     * Metoda pro zobrazení/skrytí všech obrázků
     */
    public void zobrazeniObrazku() {
        if (!bear.isVisible() || !window.isVisible() || !flower.isVisible() || !car.isVisible() || !monkey.isVisible() || !house.isVisible()) {

            bear.setVisible(true);
            window.setVisible(true);
            car.setVisible(true);
            flower.setVisible(true);
            house.setVisible(true);
            monkey.setVisible(true);

        } else {

            bear.setVisible(false);
            window.setVisible(false);
            car.setVisible(false);
            flower.setVisible(false);
            house.setVisible(false);
            monkey.setVisible(false);
        }
    }

}
package com.example.pizzaactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class BestellungsAnzeigeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestellungs_anzeige);

        // Hole die Extras aus dem Intent
        Bundle extras = getIntent().getExtras();

        // Greife auf die Werte zu
        String sorte = extras.getString("Sorte: ");
        String groesse = extras.getString("Grösse: ");
        String zusaetzlicheZutaten = extras.getString("Zusätzliche Zutaten: ");
        Double gesamtpreis = extras.getDouble("Gesamtpreis: ", 0.0);

        // Finde das TextView-Element für die Bestellungsanzeige
        TextView orderDetailsTextView = findViewById(R.id.order_details_text_view);

        // Setze den Text des TextViews
        String orderDetails = "Zusammenfassung der Bestellung:\n\n"+"Sorte: " + sorte + "\nGrösse: " + groesse + "\nZusätzliche Zutaten: " + zusaetzlicheZutaten + "\n\nGesamtpreis: " + gesamtpreis + " CHF";
        orderDetailsTextView.setText(orderDetails);
    }
}
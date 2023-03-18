package com.example.pizzaactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class PizzaOrderActivity extends AppCompatActivity {
    private RadioGroup radioGroup1, radioGroup2;
    private CheckBox checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7, checkBox8, checkBox9, checkBox10;
    private Button submitOrderButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizza_order);

        radioGroup1 = findViewById(R.id.radioGroup1);
        radioGroup2 = findViewById(R.id.radioGroup2);
        checkBox1 = findViewById(R.id.checkBox1);
        checkBox2 = findViewById(R.id.checkBox2);
        checkBox3 = findViewById(R.id.checkBox3);
        checkBox4 = findViewById(R.id.checkBox4);
        checkBox5 = findViewById(R.id.checkBox5);
        checkBox6 = findViewById(R.id.checkBox6);
        checkBox7 = findViewById(R.id.checkBox7);
        checkBox8 = findViewById(R.id.checkBox8);
        checkBox9 = findViewById(R.id.checkBox9);
        checkBox10 = findViewById(R.id.checkBox10);
        submitOrderButton = findViewById(R.id.submit_order_button);

        submitOrderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectedPizzaId = radioGroup1.getCheckedRadioButtonId();
                int selectedSizeId = radioGroup2.getCheckedRadioButtonId();

                // Text der ausgewählten Pizza und Größe abrufen
                RadioButton selectedPizza = findViewById(selectedPizzaId);
                RadioButton selectedSize = findViewById(selectedSizeId);
                String pizza = selectedPizza.getText().toString();
                String size = selectedSize.getText().toString();

                // Preis anhand der Größe berechnen
                double totalPrice = 0;
                if (size.equals("10cm")) {
                    totalPrice = 10;
                } else if (size.equals("15cm")) {
                    totalPrice = 15;
                } else if (size.equals("20cm")) {
                    totalPrice = 20;
                }

                // Bestellübersicht anzeigen
                String message = getString(R.string.order_summary, pizza, size);

                // Zusätzliche Zutaten
                // Preis für zusätzliche Zutaten hinzufügen
                String additionalToppings = "";
                if (checkBox1.isChecked()) {
                    additionalToppings += "\n- Vegi (+1 CHF)";
                    totalPrice += 1;
                }
                if (checkBox2.isChecked()) {
                    additionalToppings += "\n- Peperoni (+1 CHF)";
                    totalPrice += 1;
                }
                if (checkBox3.isChecked()) {
                    additionalToppings += "\n- Pilze (+1 CHF)";
                    totalPrice += 1;
                }
                if (checkBox4.isChecked()) {
                    additionalToppings += "\n- Oliven (+1 CHF)";
                    totalPrice += 1;
                }
                if (checkBox5.isChecked()) {
                    additionalToppings += "\n- Zwiebeln (+1 CHF)";
                    totalPrice += 1;
                }
                if (checkBox6.isChecked()) {
                    additionalToppings += "\n- Paprika (+1 CHF)";
                    totalPrice += 1;
                }
                if (checkBox7.isChecked()) {
                    additionalToppings += "\n- Extra Käse (+1 CHF)";
                    totalPrice += 1;
                }
                if (checkBox8.isChecked()) {
                    additionalToppings += "\n- Schinken (+1 CHF)";
                    totalPrice += 1;
                }
                if (checkBox9.isChecked()) {
                    additionalToppings += "\n- Ananas (+1 CHF)";
                    totalPrice += 1;
                }
                if (checkBox10.isChecked()) {
                    additionalToppings += "\n- Thunfisch (+2 CHF)";
                    totalPrice += 2;
                }

                // Erstelle das Intent-Objekt für die nächste Activity
                Intent intent = new Intent(PizzaOrderActivity.this, BestellungsAnzeigeActivity.class);

                // Füge die Bestellungsdaten als Extras hinzu
                intent.putExtra("Sorte: ", pizza);
                intent.putExtra("Grösse: ", size);
                intent.putExtra("Zusätzliche Zutaten: ", additionalToppings);
                intent.putExtra("Gesamtpreis: ", totalPrice);

                // Starte die neue Activity
                startActivity(intent);
            }
        });
    }
}

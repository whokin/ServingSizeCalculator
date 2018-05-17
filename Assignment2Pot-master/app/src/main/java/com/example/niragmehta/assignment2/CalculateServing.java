package com.example.niragmehta.assignment2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculateServing extends AppCompatActivity implements TextWatcher {

    private static final String EXTRA_POT_NAME = "The pot's name";
    private static final String EXTRA_POT_WEIGHT = "The pot's weight";
    public static final String THE_POT_INDEX = "The pot's index";
    private String potName;
    private int emptyPotWeight;
    private int wtOfFoodnum;

    private EditText wtWithFood;
    private EditText numServings;
    private TextView wtOfFood;
    private TextView servingWeightLabel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_serving);

        TextView txtViewPotName = findViewById(R.id.textViewPotName);
        TextView txtViewWeightEmpty = findViewById(R.id.textViewWeightEmpty);

        extractDataFromIntent();

        goBack();

        txtViewPotName.setText(potName);
        txtViewWeightEmpty.setText("" + emptyPotWeight);

        wtWithFood=findViewById(R.id.PTWtWithFood);
        numServings=findViewById(R.id.PTnumServings);
        wtOfFood=findViewById(R.id.txtViewfoodWeight);
        servingWeightLabel=findViewById(R.id.txtViewServingWt);

        Button deleteButton=findViewById(R.id.btnDeletePot);

        wtWithFood.addTextChangedListener(this);
        numServings.addTextChangedListener(this);

        deletePot(deleteButton);
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void afterTextChanged(Editable editable) {
        try {
            Integer.parseInt(editable.toString());
        }
        catch (Exception e){Toast.makeText(getApplicationContext(),

                "Text Field is empty or is a string",
                Toast.LENGTH_SHORT).show();
                return;
        }

        int check=Integer.parseInt(editable.toString());

        if(check<0)
            editable.replace(0,editable.length(),"");
        if(check==0)
        {
            //Clear both labels
            if(editable==wtWithFood.getEditableText())
                wtOfFood.setText("");
            else if(editable==numServings.getEditableText())
                servingWeightLabel.setText("");
        }


        try {

            if(editable==wtWithFood.getEditableText())
            {

                //update weight with food label
                int temp=Integer.parseInt(wtWithFood.getText().toString());
                temp=temp-emptyPotWeight;

                wtOfFoodnum=temp;
                wtOfFood.setText(""+wtOfFoodnum);

                //update number of servings label too
                temp=Integer.parseInt(numServings.getText().toString());
                temp=wtOfFoodnum/temp;
                servingWeightLabel.setText(""+temp);
            }

            else if(editable==numServings.getEditableText())
            {
                int temp=Integer.parseInt(numServings.getText().toString());

                temp=wtOfFoodnum/temp;
                servingWeightLabel.setText(""+temp);
            }
        }
        catch (Exception e){
        }

    }

    public void deletePot(Button button) {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setResult(Activity.RESULT_OK, getIntent());
                finish();
            }
        });
    }


    public static Intent makeIntent(Context context, String potName, int potWeight, int position) {
        Intent intent = new Intent(context, CalculateServing.class);
        intent.putExtra(EXTRA_POT_NAME,potName);
        intent.putExtra(EXTRA_POT_WEIGHT, potWeight);
        intent.putExtra(THE_POT_INDEX, position);
        return intent;
    }

    private void extractDataFromIntent() {
        Intent intent = getIntent();
        potName = intent.getStringExtra(EXTRA_POT_NAME);
        emptyPotWeight = intent.getIntExtra(EXTRA_POT_WEIGHT, 0);
    }

    public void goBack(){
        Button button=findViewById(R.id.btnBack);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}

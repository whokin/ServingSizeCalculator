package com.example.niragmehta.assignment2;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddPot extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_pot);

        EditText txtpotName=findViewById(R.id.editTextPotName);
        EditText txtpotWeight=findViewById(R.id.editTextPotWeight);

        cancel();
        OkAndValidate(txtpotName,txtpotWeight);

    }

    public void OkAndValidate(final EditText txtpotName, final EditText txtpotWeight)
    {
        Button buttonOK = findViewById(R.id.btnOk);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int potWeight;
                String potName;
                potName = txtpotName.getText().toString();
                if(potName.equals(""))
                {
                    Toast.makeText(getApplicationContext(),
                            "The name entered is empty",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                try {
                    Integer.parseInt(txtpotWeight.getText().toString());
                }
                catch (Exception e)
                {
                    Toast.makeText(getApplicationContext(),
                            "The text you have entered in weight field is not a number",
                            Toast.LENGTH_LONG).show();
                    return;
                }
                potWeight = Integer.parseInt(txtpotWeight.getText().toString());

                if(potWeight<0)
                {
                    Toast.makeText(getApplicationContext(),
                            "The number you have entered is less than 0\n" +
                                    "add a whole number",
                            Toast.LENGTH_LONG).show();
                    return;
                }

                //Add Inten to transfer potName and potWeight data over to PotList
                Intent intent = new Intent();

                intent.putExtra("The pot name", potName);
                intent.putExtra("The pot weight", potWeight);
                setResult(Activity.RESULT_OK, intent);
                finish();
            }
        });
    }

    public void cancel()
    {
        Button buttonCancel=findViewById(R.id.btnCancel);
        buttonCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }



    public static Intent makeIntent(Context context) {
        return new Intent(context, AddPot.class);
    }
}

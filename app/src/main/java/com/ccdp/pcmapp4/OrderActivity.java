package com.ccdp.pcmapp4;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.ccdp.pcmapp4.utils.OrderSpreadsheetWebService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class OrderActivity extends AppCompatActivity {

    private EditText nameInputField,emailInputField,phonenumberInputField,ordertypeInputField,orderdescInputField;
    private ProgressDialog progressDialog;
    private RadioGroup rbOrderGroup;
    private RadioButton rbOrder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://docs.google.com/forms/d/e/")
                .build();

        final OrderSpreadsheetWebService spreadsheetWebService = retrofit.create(OrderSpreadsheetWebService.class);

        nameInputField = (EditText) findViewById(R.id.order_name);
        emailInputField = (EditText) findViewById(R.id.order_email);
        phonenumberInputField = (EditText) findViewById(R.id.order_phonenumber);
        ordertypeInputField = (EditText) findViewById(R.id.order_ordertype);
        //rbOrderGroup = (RadioGroup) findViewById(R.id.rb_ordertype);
        orderdescInputField = (EditText) findViewById(R.id.order_desc);


        findViewById(R.id.btn_test1).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String nameInput = nameInputField.getText().toString();
                        String emailInput = emailInputField.getText().toString();
                        String phonenumberInput = phonenumberInputField.getText().toString();
                        String ordertypeInput = ordertypeInputField.getText().toString();
                        String orderdescInput = orderdescInputField.getText().toString();
                        Call<Void> completeQuestionnaireCall = spreadsheetWebService.completeQuestionnaire(nameInput, emailInput, phonenumberInput, ordertypeInput, orderdescInput);
                        completeQuestionnaireCall.enqueue(callCallback);
                        Toast.makeText(getApplicationContext(),
                                "Pemasanan telah disubmit silahkan menunggu konfirmasi dari tim kami", Toast.LENGTH_LONG).show();

                    }
                }
        );
    }
    private final Callback<Void> callCallback = new Callback<Void>() {
        @Override
        public void onResponse(Call<Void> call, Response<Void> response) {
            Log.d("XXX", "Pemasanan telah disubmit silahkan tunggu konfirmasi dari tim kami " + response);
        }

        @Override
        public void onFailure(Call<Void> call, Throwable t) {
            Log.e("XXX", "Failed", t);
        }
    };
}
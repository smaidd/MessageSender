package com.example.mgmcartofior.messagesender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText mMessage;
    private TextView mMessageRecived;
    private TextView mTextViewmsj;
    public static final String TAG = "message";
    public static final String recived = "recived";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mMessage = findViewById(R.id.editText_msj);
        mTextViewmsj = findViewById(R.id.textview_message);
        mMessageRecived = findViewById(R.id.message_recived);

    }

    public void btnSendOnClick(View view) {
        if (mMessage != null) {
            String msg = mMessage.getText().toString();
            if (!msg.isEmpty()) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(recived, "Message recived");
                intent.putExtra(TAG, msg);
                startActivity(intent);
            }
        }
    }

    protected void onStart() {
        super.onStart();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String msj = bundle.getString(MainActivity.TAG);
            String recived = bundle.getString(MainActivity.recived);
            if (!msj.isEmpty()) {
                mTextViewmsj.setText(msj);
                mMessageRecived.setText(recived);
            }
        }
    }
}

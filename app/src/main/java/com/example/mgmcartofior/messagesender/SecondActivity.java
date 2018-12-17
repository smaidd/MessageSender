package com.example.mgmcartofior.messagesender;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {
    private TextView mTextView;
    private EditText mMessaje;
    private TextView mRecived;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();
    }

    private void initView() {
        mTextView = findViewById(R.id.textView_msj);
        mMessaje = findViewById(R.id.editText2);
        mRecived = findViewById(R.id.message_recived2);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            String msj = bundle.getString(MainActivity.TAG);
            String recived = bundle.getString(MainActivity.recived);
            if (!msj.isEmpty()) {
                mTextView.setText(msj);
                mRecived.setText(recived);
            }
        }
    }

    public void btnSendOnClick(View view) {
        if (mMessaje != null) {
            String msg = mMessaje.getText().toString();
            if (!msg.isEmpty()) {
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra(MainActivity.TAG, msg);
                intent.putExtra(MainActivity.recived,"Message recived");
                startActivity(intent);
            }
        }
    }
}

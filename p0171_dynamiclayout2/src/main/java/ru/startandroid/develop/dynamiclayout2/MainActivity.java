package ru.startandroid.develop.dynamiclayout2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    LinearLayout llMain;
    RadioGroup rgGravity;
    EditText etName;
    Button btnCreate;
    Button btnClear;

    final int wrapContent = LinearLayoutCompat.LayoutParams.WRAP_CONTENT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        llMain = (LinearLayout) findViewById(R.id.llMain);
        rgGravity = (RadioGroup) findViewById(R.id.rgGravity);
        etName = (EditText) findViewById(R.id.etName);

        btnCreate = (Button) findViewById(R.id.btnCreate);
        btnCreate.setOnClickListener(this);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCreate:
                // Create layout params
                LinearLayout.LayoutParams lParams = new LinearLayout.LayoutParams(wrapContent, wrapContent);
                switch (rgGravity.getCheckedRadioButtonId()) {
                    case R.id.rbLeft:
                        lParams.gravity = Gravity.LEFT;
                        break;
                    case R.id.rbRight:
                        lParams.gravity = Gravity.RIGHT;
                        break;
                    case R.id.rbCenter:
                        lParams.gravity = Gravity.CENTER_HORIZONTAL;
                        break;
                }

                Button btnNew = new Button(this);
                btnNew.setText(etName.getText().toString());
                llMain.addView(btnNew, lParams);
                break;

            case R.id.btnClear:
                llMain.removeAllViews();
                Toast.makeText(this, "Removed", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}

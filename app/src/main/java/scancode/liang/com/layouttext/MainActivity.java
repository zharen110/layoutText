package scancode.liang.com.layouttext;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    int reclen = 0;
    Button bt;
    Button btStart,btEnd;
    EditText ett;

    Handler handler;
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            if(handler!=null) {
                reclen++;
                ett.setText("" + reclen);
                handler.postDelayed(this, 100);
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ett = (EditText) findViewById(R.id.editText);
        bt = (Button) findViewById(R.id.button);
        btStart = (Button) findViewById(R.id.btStart);
        btEnd = (Button) findViewById(R.id.btEnd);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SecondActivity.class);
                intent.putExtra("data","哈哈我来了");
                startActivity(intent);
            }
        });


        btStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btStart.setEnabled(false);
                btEnd.setEnabled(true);
                handler = new Handler();
                handler.postDelayed(runnable,100);
            }
        });

        btEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btStart.setEnabled(true);
                btEnd.setEnabled(false);
                handler.removeCallbacks(runnable);
                handler = null;
            }
        });
    }
}

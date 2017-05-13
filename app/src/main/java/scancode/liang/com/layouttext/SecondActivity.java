package scancode.liang.com.layouttext;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/5/12.
 */
public class SecondActivity extends Activity {
    TextView ttv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ttv = (TextView) findViewById(R.id.ttv1);
        Intent intent = getIntent();
        ttv.setText(intent.getStringExtra("data").toString());

    }
}

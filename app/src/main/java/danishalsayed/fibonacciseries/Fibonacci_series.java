package danishalsayed.fibonacciseries;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;


public class Fibonacci_series extends ActionBarActivity {
    EditText number_field;
    TextView result_display;
    //TextView notification;
    Button button1;

    public ArrayList<Integer> fibonacci(int n){
        int check=0;
        ArrayList<Integer>series=new ArrayList<Integer>();
        series.add(1);
        series.add(1);
        while(check!=n-2){
            int sum=series.get(series.size() - 1)+series.get(series.size() - 2);
            series.add(sum);
            check++;
        }
        return series;
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fibonacci_series);
        number_field=(EditText)findViewById(R.id.number_field);
        result_display=(TextView)findViewById(R.id.result_display);
        //notification=(TextView)findViewById(R.id.notification);
        button1=(Button)findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<Integer>result=new ArrayList<Integer>();
                String input=number_field.getText().toString();
                int n=Integer.parseInt(input);
                if (n>0)
                result=fibonacci(n);
                String display="";
                for (int i=0;i<n;i++)
                    display=display+" "+result.get(i).toString();
                result_display.setText(display.subSequence(0,display.length()));
                result_display.setTextColor(-1);
               // notification.setVisibility(View.VISIBLE);

            }
        });

    }




    @Override

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fibonacci_series, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

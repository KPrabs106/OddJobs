package hackgt.oddjobs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class CategoryActivity extends Activity {

    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        path = getIntent().getStringExtra("path");
    }

    public void catOnClick(View view)
    {
        switch(view.getId())
        {
            case R.id.iv_cat1:
                // Code for cat1 click
                Intent cat1_int = new Intent(view.getContext(),FormFillActivity.class);
                startActivityForResult(cat1_int,0);
                break;

            case R.id.iv_cat2:
                // Code for cat2 click
                Intent cat2_int = new Intent(view.getContext(),FormFillActivity.class);
                startActivityForResult(cat2_int,0);
                break;

            case R.id.iv_cat3:
                // Code for cat3 click
                Intent cat3_int = new Intent(view.getContext(),FormFillActivity.class);
                startActivityForResult(cat3_int,0);
                break;
            case R.id.iv_cat4:
                // Code for cat4 click
                Intent cat4_int = new Intent(view.getContext(),FormFillActivity.class);
                startActivityForResult(cat4_int,0);
                break;
            case R.id.iv_cat5:
                // Code for cat4 click
                Intent cat5_int = new Intent(view.getContext(),FormFillActivity.class);
                startActivityForResult(cat5_int,0);
                break;
            case R.id.iv_cat6:
                // Code for cat4 click
                Intent cat6_int = new Intent(view.getContext(),FormFillActivity.class);
                startActivityForResult(cat6_int,0);
                break;
            case R.id.iv_cat7:
                // Code for cat4 click
                Intent cat7_int = new Intent(view.getContext(),FormFillActivity.class);
                startActivityForResult(cat7_int,0);
                break;
            case R.id.iv_cat8:
                // Code for cat4 click
                Intent cat8_int = new Intent(view.getContext(),FormFillActivity.class);
                startActivityForResult(cat8_int,0);
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_category, menu);
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
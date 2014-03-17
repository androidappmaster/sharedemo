package es.appmaster.sharedemo;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import es.appmaster.sharedemo.dialog.AboutDialog;
import es.appmaster.sharedemo.manager.ShareManager;

/**
 * Example main activity
 *
 * @author manolovn
 */
public class MainActivity extends ActionBarActivity {

    private EditText shareEditText;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    private void initComponents() {
        shareEditText = (EditText)findViewById(R.id.share_edittext);
        shareButton = (Button)findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String shareContent = shareEditText.getText().toString();
                shareIt(shareContent);
            }
        });
    }

    private void shareIt(String shareContent) {
        Intent shareIntent = ShareManager.getInstance(MainActivity.this).generateShareIntent(shareContent);
        startActivity(shareIntent);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_about) {
            new AboutDialog().show(getSupportFragmentManager(), "ABOUT_DIALOG");
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}

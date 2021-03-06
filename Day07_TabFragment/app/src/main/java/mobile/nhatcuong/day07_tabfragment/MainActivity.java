package mobile.nhatcuong.day07_tabfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ActionBar.TabListener {
    private List<Fragment> fragments = new ArrayList<>();
    private TabFragment tabFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActionBar bar = getSupportActionBar();
        bar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        for (int i = 0; i < 4; i++) {
            ActionBar.Tab tab = bar.newTab();
            tab.setText("tab " + (i + 1));
            tab.setTabListener(this);
            bar.addTab(tab);
        }
        ActionBar.Tab tab = bar.newTab();
        tab.setText("tab " + (6));
        tab.setTabListener(this);
        bar.addTab(tab);
        bar.setDisplayOptions(1);
    }

    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if (fragments.size() > tab.getPosition()) {
            fragments.get(tab.getPosition());
        }
        tabFragment = new TabFragment();
        Bundle bundler = new Bundle();
        bundler.putInt("index", tab.getPosition());
        tabFragment.setArguments(bundler);
        fragments.add(tabFragment);
        fragmentTransaction.replace(android.R.id.content, tabFragment);
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {
        if(fragments.size() > tab.getPosition()){
            fragmentTransaction.remove(fragments.get(tab.getPosition()));
        }

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction fragmentTransaction) {

    }

    public void clickToInput(View view) {
        EditText username = findViewById(R.id.edtUsername);
        Toast.makeText(this, "welcome" + username.getText().toString(), Toast.LENGTH_LONG).show();

    }
}

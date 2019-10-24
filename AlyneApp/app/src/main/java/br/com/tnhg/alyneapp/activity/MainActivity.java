package br.com.tnhg.alyneapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import br.com.tnhg.alyneapp.fragment.AmigosFragment;
import br.com.tnhg.alyneapp.fragment.EventosFragment;
import br.com.tnhg.alyneapp.fragment.MeusFragment;
import br.com.tnhg.alyneapp.R;
import br.com.tnhg.alyneapp.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private TabHost tabHost;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.pager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new AmigosFragment(), getString(R.string.amigos));
        viewPagerAdapter.addFragment(new EventosFragment(), getString(R.string.proximos_eventos));
        viewPagerAdapter.addFragment(new MeusFragment(), getString(R.string.meus_eventos));
        viewPager.setAdapter(viewPagerAdapter);



        final TabLayout.Tab amigosTab = tabLayout.newTab();
        final TabLayout.Tab proximosTab = tabLayout.newTab();
        final TabLayout.Tab meusTab = tabLayout.newTab();

        amigosTab.setText(getString(R.string.amigos));
        proximosTab.setText( getString(R.string.proximos_eventos));
        meusTab.setText(getString(R.string.meus_eventos));

        tabLayout.addTab(meusTab,0);
        tabLayout.addTab(amigosTab,1);
        tabLayout.addTab(proximosTab,2);

        tabLayout.setupWithViewPager(viewPager);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        viewPager.setCurrentItem(1);

    }

    public void clickSend(View view) {
        Intent myIntent = new Intent(this, EventFormActivity.class);
        startActivity(myIntent);
    }

}

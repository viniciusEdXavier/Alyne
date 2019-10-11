package br.com.tnhg.alyneapp;

import android.os.Bundle;
import android.widget.TabHost;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabHost tabHost;

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        viewPager = (ViewPager)findViewById(R.id.pager);

        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new AmigosFragment(), getString(R.string.amigos));
        viewPagerAdapter.addFragment(new DataFragment(), getString(R.string.proximos_eventos));
        viewPagerAdapter.addFragment(new EventosFragment(), getString(R.string.meus_eventos));
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

    }
}

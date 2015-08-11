package com.vergelmercado.application.tabfragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;


import com.vergelmercado.application.R;
import com.vergelmercado.application.adapters.FragmentPageAdapter;
import com.vergelmercado.application.interfaces.UpdateTabFragment;
import com.vergelmercado.application.utils.TabFactory;

import java.util.ArrayList;
import java.util.List;

public class TabMainFragment extends Fragment implements
        OnTabChangeListener, OnPageChangeListener {

    private ViewPager vp;
    private TabHost th;
    private FragmentPageAdapter pageAdapter;
    private List<Fragment> fragmentList;

    private View view;

    @Override
    public View onCreateView(LayoutInflater layout, ViewGroup group, Bundle bundle) {

        super.onCreateView(layout, group, bundle);

        view = layout.inflate(R.layout.fragment_main,group,false);

        vp = (ViewPager) view.findViewById(R.id.viewpager);

        initTabHost();

        List<Fragment> fragments = getFragments();
        pageAdapter = new FragmentPageAdapter(
                getChildFragmentManager(), fragments);
        vp.setAdapter(pageAdapter);
        vp.setOnPageChangeListener(TabMainFragment.this);
        vp.setOffscreenPageLimit(2);

        if (bundle != null) {
            th.setCurrentTabByTag(bundle.getString("tab"));
        }

        getActivity().getActionBar().setTitle("Node Conversion Tool");

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("tab", th.getCurrentTabTag());
    }

    @Override
    public void onStart(){
        super.onStart();
    }

    private List<Fragment> getFragments() {
        // TODO Auto-generated method stub

        fragmentList = new ArrayList<Fragment>();

        FirstFragment ff = FirstFragment.newInstance("Fragment 1");

        SecondFragment sf = SecondFragment.newInstance("Fragment 2");
        fragmentList.add(ff);
        fragmentList.add(sf);

        return fragmentList;
    }

    private void initTabHost() {
        // TODO Auto-generated method stub
        th = (TabHost) view.findViewById(android.R.id.tabhost);
        th.setVisibility(View.VISIBLE);
        th.setup();

        this.addTab(this, th,
                th.newTabSpec("Fragment 1").setIndicator("Fragment 1"));
        this.addTab(this, th,
                th.newTabSpec("Fragment 2").setIndicator("Fragment 2"));

        th.setOnTabChangedListener(this);


    }

    private void addTab(TabMainFragment c, TabHost tabHost,
                        TabHost.TabSpec tabSpec) {
        tabSpec.setContent(new TabFactory(getActivity()));
        tabHost.addTab(tabSpec);
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
        // TODO Auto-generated method stub
        int pos = vp.getCurrentItem();
        th.setCurrentTab(pos);

    }

    @Override
    public void onPageSelected(int arg0) {
        // TODO Auto-generated method stub

        if(arg0 == 1){
            UpdateTabFragment fragment = (UpdateTabFragment) pageAdapter.instantiateItem(vp, arg0);
            if (fragment != null) {
                fragment.UpdateData();
            }
        }

    }

    @Override
    public void onTabChanged(String arg0) {
        // TODO Auto-generated method stub

        int pos = th.getCurrentTab();
        vp.setCurrentItem(pos, true);
    }

    /*
    KEY NOTES FOR TRANSITION ANIMATION

    getSupportFragmentManager()
                .beginTransaction().
                replace(
                R.id.main_container,
                new HomeFragment(),
                        HomeFragment.class.getCanonicalName()).commit();

                Fragment viewFragment;

                android.support.v4.app.FragmentTransaction fragmentTransaction =
                        getSupportFragmentManager()
                                .beginTransaction()
                                .addToBackStack(
                                        MainActivityFragment.class
                                                .getCanonicalName())
                                .setCustomAnimations(R.anim.enterfromright,
                                        R.anim.exittoleft, R.anim.enterfromleft,
                                        R.anim.exittoright);

                                        viewFragment = new HistoryListFragment();
                                fragmentTransaction.addToBackStack("").
                                        replace(R.id.main_container, viewFragment,
                                                HistoryListFragment.class.getCanonicalName())
                                        .commit();



     */

}

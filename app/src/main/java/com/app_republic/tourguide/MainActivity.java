package com.app_republic.tourguide;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static String ARG_LIST;
    private static String ARG_SECTION;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ARG_LIST = getString(R.string.list);
        ARG_SECTION = getString(R.string.section_number);

        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        ViewPager mViewPager = findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = findViewById(R.id.tabLayout);
        tabLayout.setupWithViewPager(mViewPager);
    }

    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        public static PlaceholderFragment newInstance(int sectionNumber, ArrayList<Attraction> list) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION, sectionNumber);
            args.putParcelableArrayList(ARG_LIST, list);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            assert getArguments() != null;
            ArrayList<Attraction> list = getArguments().getParcelableArrayList(getString(R.string.list));
            RecyclerView recyclerView = rootView.findViewById(R.id.recyclerview);
            listAdapter adapter = new listAdapter(getActivity(), list);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(adapter);


            return rootView;
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {

            ArrayList<Attraction> list = new ArrayList<>();
            //adding items to the current list based on the selected tab
            switch (position) {
                case 0:
                    list.add(new Attraction(getString(R.string.hotel_name1), R.drawable.amb, getString(R.string.hotel_desc1), new Location(35.713952, -0.610544)));
                    list.add(new Attraction(getString(R.string.hotel_name2), R.drawable.liberte, getString(R.string.hotel_desc2), new Location(35.701480, -0.641049)));
                    list.add(new Attraction(getString(R.string.hotel_name3), R.drawable.meridien, getString(R.string.hotel_desc3), new Location(35.701480, -0.641049)));
                    list.add(new Attraction(getString(R.string.hotel_name4), R.drawable.sheraton, getString(R.string.hotel_desc4), new Location(35.701480, -0.641049)));

                    return PlaceholderFragment.newInstance(position + 1, list);
                case 1:
                    list.add(new Attraction(getString(R.string.beach_name1), R.drawable.picture, getString(R.string.beach_desc1), new Location(35.701480, -0.641049)));
                    list.add(new Attraction(getString(R.string.beach_name2), R.drawable.picture, getString(R.string.beach_desc2), new Location(35.701480, -0.641049)));
                    list.add(new Attraction(getString(R.string.beach_name3), R.drawable.picture, getString(R.string.beach_desc3), new Location(35.701480, -0.641049)));
                    list.add(new Attraction(getString(R.string.beach_name4), R.drawable.picture, getString(R.string.beach_desc4), new Location(35.701480, -0.641049)));

                    return PlaceholderFragment.newInstance(position + 1, list);
                case 2:
                    list.add(new Attraction(getString(R.string.restaurant_name1), R.drawable.picture, getString(R.string.restaurant_desc1), new Location(35.701480, -0.641049)));
                    list.add(new Attraction(getString(R.string.restaurant_name2), R.drawable.picture, getString(R.string.restaurant_desc2), new Location(35.701480, -0.641049)));
                    list.add(new Attraction(getString(R.string.restaurant_name3), R.drawable.picture, getString(R.string.restaurant_desc3), new Location(35.701480, -0.641049)));
                    list.add(new Attraction(getString(R.string.restaurant_name4), R.drawable.picture, getString(R.string.restaurant_desc4), new Location(35.701480, -0.641049)));

                    return PlaceholderFragment.newInstance(position + 1, list);
                case 3:
                    list.add(new Attraction(getString(R.string.museum_name1), R.drawable.picture, getString(R.string.museum_desc1), new Location(35.701480, -0.641049)));
                    list.add(new Attraction(getString(R.string.museum_name2), R.drawable.picture, getString(R.string.museum_desc2), new Location(35.701480, -0.641049)));
                    list.add(new Attraction(getString(R.string.museum_name3), R.drawable.picture, getString(R.string.museum_desc3), new Location(35.701480, -0.641049)));

                    return PlaceholderFragment.newInstance(position + 1, list);

                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 4;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getApplicationContext().getString(R.string.hotels_title);
                case 1:
                    return getApplicationContext().getString(R.string.beaches_title);
                case 2:
                    return getApplicationContext().getString(R.string.restaurants_title);
                case 3:
                    return getApplicationContext().getString(R.string.museums_title);

                default:
                    return null;
            }
        }
    }
}

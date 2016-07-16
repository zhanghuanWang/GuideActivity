package com.ywg.verticalguide;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A placeholder fragment containing a simple view.
 */
public class DemoFragment extends Fragment {
    /**
     * The fragment argument representing the section number for this
     * fragment.
     */
    private static final String ARG_SECTION_NUMBER = "section_number";

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static DemoFragment newInstance(int sectionNumber) {
        DemoFragment fragment = new DemoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        int resId = 0;
        switch (sectionNumber) {
            case 1:
                resId = R.layout.layout_guide_page1;
                break;
            case 2:
                resId = R.layout.layout_guide_page2;
                break;
            case 3:
                resId = R.layout.layout_guide_page3;
                break;
        }
        args.putInt("resId", resId);
        fragment.setArguments(args);
        return fragment;
    }

    public DemoFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(getArguments().getInt("resId"), container, false);
        return rootView;
    }


}
package homephoto.homephotoapp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class PicturePage extends Fragment {

    String albumName;
    int resourceId;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            albumName = getArguments().getString("name");
            resourceId = getArguments().getInt("id");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_picture_page, container, false);
        initializeView();
        return view;
    }

    public void initializeView() {
        // initialize tool bar
        Toolbar toolbar = ((MainActivity) getActivity()).findViewById(R.id.toolbar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        TextView titleBar =  ((MainActivity) getActivity()).findViewById(R.id.title_bar_text);
        titleBar.setText(albumName);

        // initialize navigation bar
        BottomNavigationView bottomNavigationView = getActivity().findViewById(R.id.bottom_navigation);
        View ideasIcon = getActivity().findViewById(R.id.nav_bar_ideas);
        View cameraIcon = getActivity().findViewById(R.id.nav_bar_camera);
        ideasIcon.setEnabled(false);
        cameraIcon.setEnabled(false);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.nav_bar_albums:
                                ((MainActivity) getActivity()).changeFragment(new AlbumsPage(), "albumsPage");
                            case R.id.nav_bar_ideas:
                            case R.id.nav_bar_camera:
                        }
                        return true;
                    }
                });

        ImageView enlargedPicture = view.findViewById(R.id.enlarged_picture);
        enlargedPicture.setImageResource(resourceId);
    }
}

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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumsPage extends Fragment {

    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.albums_page, container, false);
        initializeView();
        return view;
    }

    public void initializeView() {
        Toolbar toolbar =  ((MainActivity) getActivity()).findViewById(R.id.toolbar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        TextView titleBar =  ((MainActivity) getActivity()).findViewById(R.id.title_bar_text);
        titleBar.setText(R.string.albums_page_title);

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
                            case R.id.nav_bar_ideas:
                                ((MainActivity) getActivity()).changeFragment(new SpecificAlbumPage(), "");
                            case R.id.nav_bar_camera:
                        }
                        return true;
                    }
                });

        //create album list view and its adapter
        ArrayList<AlbumCell> albumCellList = new ArrayList<>();
        AlbumCell ex1 = new AlbumCell("bob", R.drawable.placeholder_picture);
        AlbumCell ex2 = new AlbumCell("joe", R.drawable.placeholder_picture);
        albumCellList.add(ex1);
        albumCellList.add(ex2);
        albumCellList.add(ex1);
        albumCellList.add(ex2);
        albumCellList.add(ex1);
        albumCellList.add(ex2);
        albumCellList.add(ex1);
        ListView albumCellLeftLV = view.findViewById(R.id.albums_list_left_col);
        ListView albumCellRightLV = view.findViewById(R.id.albums_list_right_col);
        final AlbumCellAdapter albumCellAdapterLeft = new AlbumCellAdapter(getActivity(), albumCellList);
        final AlbumCellAdapter albumCellAdapterRight = new AlbumCellAdapter(getActivity(), albumCellList);
        albumCellLeftLV.setAdapter(albumCellAdapterLeft);
        albumCellRightLV.setAdapter(albumCellAdapterRight);

    }

}

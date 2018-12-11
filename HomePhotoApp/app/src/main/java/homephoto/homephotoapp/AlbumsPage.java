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
import android.widget.GridView;
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
        // initialize tool bar
        Toolbar toolbar = ((MainActivity) getActivity()).findViewById(R.id.toolbar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        TextView titleBar =  ((MainActivity) getActivity()).findViewById(R.id.title_bar_text);
        titleBar.setText(R.string.albums_page_title);

        toolbar.setOnMenuItemClickListener(
                new Toolbar.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.title_bar_settings:
                            case R.id.title_bar_add:
//                                ((MainActivity) getActivity()).changeFragment(new AlbumsPage(), "albumsPage");
                            case R.id.title_bar_edit:
                        }
                        return true;
                    }
                }
        );

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
                            case R.id.nav_bar_camera:
                        }
                        return true;
                    }
                });

        // create sample album list view and its adapter
        ArrayList<AlbumCell> albumCellList = new ArrayList<>();
        AlbumCell album_one = new AlbumCell("Raleigh 2009", R.drawable.album_cover_1);
        AlbumCell album_two = new AlbumCell("Tacoma 2014", R.drawable.album_cover_2);
        AlbumCell album_three = new AlbumCell("Loudon County 2017", R.drawable.album_cover_3);
        AlbumCell album_four = new AlbumCell("Derek's move home to Raleigh!", R.drawable.album_cover_4);
        AlbumCell album_five = new AlbumCell("Carol's Tacoma cutie", R.drawable.album_cover_5);
        albumCellList.add(album_one);
        albumCellList.add(album_two);
        albumCellList.add(album_three);
        albumCellList.add(album_four);
        albumCellList.add(album_five);
        GridView albumCellGV = view.findViewById(R.id.albums_grid);
        final AlbumCoverAdapter albumCoverAdapter = new AlbumCoverAdapter(getActivity(), albumCellList);
        albumCellGV.setAdapter(albumCoverAdapter);
    }
}

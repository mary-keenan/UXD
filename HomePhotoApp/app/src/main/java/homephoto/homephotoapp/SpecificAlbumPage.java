package homephoto.homephotoapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;


public class SpecificAlbumPage extends Fragment {

    public static final String TAG = "SPECIFIC_ALBUMS_PAGE";

    private String albumName;
    View view;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            albumName = getArguments().getString("name");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.specific_album_page, container, false);
        initializeView();
        return view;
    }

    public void initializeView() {
        // initialize tool bar
        Toolbar toolbar = ((MainActivity) getActivity()).findViewById(R.id.toolbar);
        ((MainActivity) getActivity()).setSupportActionBar(toolbar);
        TextView titleBar =  ((MainActivity) getActivity()).findViewById(R.id.title_bar_text);
        titleBar.setText(albumName);
        Menu menu = toolbar.getMenu();
        MenuItem addItem = menu.findItem(R.id.title_bar_add);
        addItem.setTitle("bob"); //TODO problem here -- not working
        // https://stackoverflow.com/questions/33284812/android-change-navigation-drawer-menu-items-text-programmatically

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
                                ((MainActivity) getActivity()).changeFragment(new AlbumsPage(), "albumsPage");
                            case R.id.nav_bar_ideas:
                            case R.id.nav_bar_camera:
                        }
                        return true;
                    }
                });

        // create sample album list view and its adapter
        ArrayList<AlbumCell> albumCellList = new ArrayList<>();
        AlbumCell album_one = new AlbumCell("", R.drawable.album_picture_1);
        AlbumCell album_two = new AlbumCell("", R.drawable.album_picture_2);
        AlbumCell album_three = new AlbumCell("", R.drawable.album_picture_3);
        AlbumCell album_four = new AlbumCell("", R.drawable.album_cover_4);
        AlbumCell album_five = new AlbumCell("", R.drawable.album_cover_5);
        albumCellList.add(album_one);
//        albumCellList.add(album_two);
//        albumCellList.add(album_three);
//        albumCellList.add(album_four);
//        albumCellList.add(album_five);
        GridView albumCellGV = view.findViewById(R.id.specific_album_grid);
        final AlbumCellAdapter albumCellAdapter = new AlbumCellAdapter(getActivity(), albumCellList, albumName);
        albumCellGV.setAdapter(albumCellAdapter);

    }
}

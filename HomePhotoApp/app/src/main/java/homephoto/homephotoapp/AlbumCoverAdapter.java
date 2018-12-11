package homephoto.homephotoapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;


public class AlbumCoverAdapter extends ArrayAdapter<AlbumCell> {

    public AlbumCoverAdapter(Context context, ArrayList<AlbumCell> albumCells) {
        super(context, 0, albumCells);
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final AlbumCell albumCell = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.album_cover_item, parent, false);
        }

        final TextView albumName = view.findViewById(R.id.album_name);
        albumName.setText(albumCell.getName());

        final ImageButton albumCover = view.findViewById(R.id.album_cover);
        albumCover.setImageResource(albumCell.getAlbumCoverResId());

        //if the picture or name is clicked, go to SpecificAlbumPage fragment
        albumName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAlbum(albumName);
            }
        });
        albumCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAlbum(albumName);
            }
        });

        return view;
    }

    public void selectAlbum(TextView albumName) {
        SpecificAlbumPage specificAlbumFragment = new SpecificAlbumPage();
        Bundle bundle = new Bundle();
        bundle.putString("name", (String) albumName.getText());
        specificAlbumFragment.setArguments(bundle);
        ((MainActivity) getContext()).changeFragment(specificAlbumFragment, "specificAlbumPage"); //changes fragments
    }
}

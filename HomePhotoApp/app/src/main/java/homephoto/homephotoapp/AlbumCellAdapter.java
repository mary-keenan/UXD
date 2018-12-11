package homephoto.homephotoapp;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;

import java.util.ArrayList;


public class AlbumCellAdapter extends ArrayAdapter<AlbumCell> {

    String albumName;

    public AlbumCellAdapter(Context context, ArrayList<AlbumCell> albumCells, String name) {
        super(context, 0, albumCells);
        albumName = name;
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final AlbumCell albumCell = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.album_cell_item, parent, false);
        }

        final ImageButton picture = view.findViewById(R.id.album_cell);
        picture.setImageResource(albumCell.getAlbumCoverResId());

        //if the picture is clicked, go to SpecificPhotoPage fragment
        picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PicturePage picturePage = new PicturePage();
                Bundle bundle = new Bundle();
                bundle.putString("name", albumName);
                bundle.putInt("id", albumCell.getAlbumCoverResId());
                picturePage.setArguments(bundle);
                ((MainActivity) getContext()).changeFragment(picturePage, "picturePage");
            }
        });

        return view;
    }
}

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


public class AlbumCellAdapter extends ArrayAdapter<AlbumCell> {

    public AlbumCellAdapter(Context context, ArrayList<AlbumCell> albumCells) {
        super(context, 0, albumCells);
    }

    @Override
    public View getView(final int position, View view, ViewGroup parent) {
        final AlbumCell albumCell = getItem(position);

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.album_cell_item, parent, false);
        }

        final TextView albumName = view.findViewById(R.id.album_name);
        albumName.setText(albumCell.getName());

        final ImageButton albumCover = view.findViewById(R.id.album_cover);
        albumCover.setImageResource(albumCell.getAlbumCoverResId());

        //if cell is clicked, go to SpecificAlbumPage fragment
        albumName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SpecificAlbumPage specificAlbumFragment = new SpecificAlbumPage();
                Bundle bundle = new Bundle();
                String albumNameTrimmed = ((String) albumName.getText()).replace("#","").replace(" ","");
                bundle.putString("name", albumNameTrimmed);
                specificAlbumFragment.setArguments(bundle);
                ((MainActivity) getContext()).changeFragment(new SpecificAlbumPage(), "expandedHashtagPage"); //changes fragments
            }
        });



        return view;
    }
}

package homephoto.homephotoapp;

import android.content.Context;
import android.widget.ImageButton;

/**
 * Created by mary on 11/16/16.
 */
public class AlbumCell {
    private String albumName;
    private int albumCoverResId;

    public AlbumCell(String albumName, int albumCoverId) {
        this.albumName = albumName;
        this.albumCoverResId = albumCoverId;
    }

    public String getName() {
        return albumName;
    }

    public void setName(String name) {
        this.albumName = name;
    }

    public int getAlbumCoverResId() {
        return albumCoverResId;
    }

    public void setAlbumCoverResId(int resourceId) {
        this.albumCoverResId = resourceId;
    }
}

package cz.czechitas.gifomat;

import com.google.gson.annotations.SerializedName;

public class Gif {
    @SerializedName("image_original_url")
    public String url;

    @SerializedName("image_frames")
    public Integer cas;
}

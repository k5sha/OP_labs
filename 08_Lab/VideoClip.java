public class VideoClip extends Music {
    private String videoFormat;
    private int resolution;
    private long likes;

    public VideoClip(String title, String artist, int durationInSeconds, String videoFormat, int resolution) {
        super(title, artist, durationInSeconds);
        this.videoFormat = videoFormat;
        this.resolution = resolution;
    }

    public VideoClip(String title, String artist, int durationInSeconds, String videoFormat, int resolution, long likes) {
        super(title, artist, durationInSeconds);
        this.videoFormat = videoFormat;
        this.resolution = resolution;
        this.likes = likes;
    }

    public long getLikes() {
        return likes;
    }

    public void setLikes(long likes) {
        this.likes = likes;
    }

    public void increaseLikes(){
        this.likes++;
    }

    public void decreaseLikes(){
        this.likes--;
    }

    public String getVideoFormat() {
        return videoFormat;
    }

    public void setVideoFormat(String videoFormat) {
        this.videoFormat = videoFormat;
    }

    public int getResolution() {
        return resolution;
    }

    public void setResolution(int resolution) {
        this.resolution = resolution;
    }

    @Override
    public String toString() {
        return "VideoClip{" +
                "title='" + getTitle() + '\'' +
                ", artist='" + getArtist() + '\'' +
                ", durationInSeconds=" + getDurationInSeconds() +
                ", videoFormat='" + videoFormat + '\'' +
                ", resolution=" + resolution +
                '}';
    }
}
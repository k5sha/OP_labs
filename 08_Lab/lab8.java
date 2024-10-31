public class lab8 {
    public static void main(String[] args) {
        System.out.println("===== Music =====");
        Music music = new Music("Felix Cartal", "Over It", 207);
        System.out.println(music);
        System.out.println(music.equals(music));

        System.out.println("===== Video =====");
        VideoClip videoClip =new VideoClip(
                "Big Dawgs",
                "Hanumankind",
                191,
                "MP4",
                1080,
                100
        );
        System.out.println(videoClip);

        System.out.println(videoClip.getTitle());
        System.out.println(videoClip.getArtist());
        System.out.println(videoClip.getDurationInSeconds());

        System.out.println(videoClip.getVideoFormat());
        System.out.println(videoClip.getResolution());

        System.out.println("===== Likes =====");
        System.out.println(videoClip.getLikes());
        System.out.println("Increase likes by one");
        videoClip.increaseLikes();
        System.out.println(videoClip.getLikes());

        System.out.println("===== Video2 =====");
        VideoClip videoClip2 = new VideoClip(
                "Title2",
                "Artist2",
                100,
                "MP4",
                1080
        );
        System.out.println(videoClip2);
    }
}

package origami.video;

import origami.Origami;

public class VideoCapture extends org.opencv.videoio.VideoCapture {
    //TODO: annoying when playing with IP Cameras
//    static {
//        Origami.registerVideoHandler("http", new HttpVideoHandler());
//        Origami.registerVideoHandler("https", new HttpVideoHandler());
//    }

    private String _filename;
    private String filename;

    @Override
    public boolean open(String filename, int apiPreference) {
        this._filename = filename;
        _filename = getFilename(filename);
        return super.open(_filename, apiPreference);
    }

    private String getFilename(String filename) {
        String _filename = filename;
        if (filename.contains("://")) {
            String prefix = filename.substring(0, filename.indexOf("://"));
            _filename = filename.substring(filename.indexOf("://") + 3);
            VideoHandler handler = Origami.getVideoHandler(prefix);
            if (handler == null) {
                // System.out.printf("Please register a video handler for: %s\n", prefix);
                return filename;
            } else {
                _filename = handler.getFilename(filename);
                System.out.printf("Found filename: %s for prefix: %s\n", _filename, prefix);
            }
        }
        return _filename;
    }

    @Override
    public boolean open(String filename) {
        this._filename = filename;
        this._filename = getFilename(filename);
        return super.open(_filename);
    }

}

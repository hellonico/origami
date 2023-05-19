package origami.utils;

import com.sun.nio.file.SensitivityWatchEventModifier;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class FileWatcher extends Thread {
    protected File file;

    public File getFile() {
        return file;
    }
    public void setFile(File _file) {
        if(this.file != _file) {
            this.file = _file;
            this.stopThread();
            this.start();
        }
    }

    private AtomicBoolean stop = new AtomicBoolean(false);

    public FileWatcher(File file) {
        this.file = file;
    }


    public boolean isStopped() {
        return stop.get();
    }

    public void stopThread() {
        stop.set(true);
    }

    public void doOnChange() {
        try {

            List<String> list = Files.readAllLines(Paths.get(file.getAbsolutePath()));
            String content = String.join(System.lineSeparator(), list);
            doOnChangeContent(content);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void doOnChangeContent(String content) {

    }


    @Override
    public void run() {
        try (WatchService watcher = FileSystems.getDefault().newWatchService()) {
            Path path = file.getAbsoluteFile().getParentFile().toPath();
//             path.register(watcher, StandardWatchEventKinds.ENTRY_MODIFY);
            // https://stackoverflow.com/questions/9588737/is-java-7-watchservice-slow-for-anyone-else
            path.register(watcher, new WatchEvent.Kind[] { StandardWatchEventKinds.ENTRY_MODIFY },
                    SensitivityWatchEventModifier.HIGH);
            System.out.printf("Started: %s", path.getFileName());
            while (!isStopped()) {
                WatchKey key;
                try {
                    key = watcher.poll(500, TimeUnit.MILLISECONDS);
                } catch (InterruptedException e) {
                    return;
                }
                if (key == null) {
                    Thread.yield();
                    continue;
                }

                for (WatchEvent<?> event : key.pollEvents()) {
                    WatchEvent.Kind<?> kind = event.kind();

                    @SuppressWarnings("unchecked")
                    WatchEvent<Path> ev = (WatchEvent<Path>) event;
                    Path filename = ev.context();

                    if (kind == StandardWatchEventKinds.OVERFLOW) {
                        Thread.yield();
                        continue;
                    } else if (kind == java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY
                            && filename.toString().equals(file.getName())) {
                        doOnChange();
                    }
                    boolean valid = key.reset();
                    if (!valid) {
                        break;
                    }
                }
                Thread.yield();
            }
        } catch (Exception e) {
            // Log or rethrow the error
            e.printStackTrace();
        }
    }
}
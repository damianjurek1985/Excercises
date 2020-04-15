package thread;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.nio.file.FileVisitResult.CONTINUE;
import static java.nio.file.FileVisitResult.TERMINATE;

public class FindFiles {
    private PathMatcher pmatcher;
    private Path startDir;

    private FindFiles(){}

    public static FindFiles in(String dir) {
        FindFiles ff = new FindFiles();
        ff.startDir = Paths.get(dir);
        return ff;
    }

    public FindFiles withName(String glob) {
        pmatcher = FileSystems.getDefault().getPathMatcher("glob:" + glob);
        return this;
    }

    public List<String> withText(String regex) throws IOException {
        final List<String> list = new ArrayList<>();
        final Matcher rematch = Pattern.compile(regex).matcher("");

        Files.walkFileTree(startDir, new SimpleFileVisitor<Path>() {
            public FileVisitResult visitFile(Path file, BasicFileAttributes a) throws IOException {
                if (Thread.currentThread().isInterrupted()) {
                    return TERMINATE;
                }
                if (a.isRegularFile() && pmatcher.matches(file.getFileName())) {
                    String cont = new String(Files.readAllBytes(file), Charset.defaultCharset());
                    if (rematch.reset(cont).find()) {
                        list.add("" + file.toRealPath());
                    }
                }
                return CONTINUE;
            }

            public FileVisitResult visitFileFailed(Path file, IOException exc) {
                System.out.println(file + " " + exc);
                return CONTINUE;
            }
        });
        return list;
    }

    public static void main(String[] args) throws IOException {
        FindFiles findFiles = FindFiles.in("D:\\PROJEKTY JAVA\\Excercises(DAMIAN)");
        System.out.println(findFiles.withName("findfile").withText(""));

    }
}

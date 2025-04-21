import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor {
    private String keyword;
    private List<File> matchedFiles = new ArrayList<>();

    public SearchVisitor(String keyword) {
        this.keyword = keyword.toLowerCase();
    }

    @Override
    public void visit(File file) {
        if (file.getName().toLowerCase().contains(keyword)) {
            matchedFiles.add(file);
        }
    }

    @Override
    public void visit(Directory directory) {
    }

    public List<File> getMatchedFiles() {
        return matchedFiles;
    }
}

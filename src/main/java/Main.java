public class Main {
    public static void main(String[] args) {
        Directory root = new Directory("root");
        File file1 = new File("report.doc", 2);
        File file2 = new File("photo.jpg", 5);
        File file3 = new File("notes.txt", 1);

        Directory subDir = new Directory("documents");
        File file4 = new File("essay.doc", 3);

        subDir.addElement(file4);
        root.addElement(file1);
        root.addElement(file2);
        root.addElement(file3);
        root.addElement(subDir);

        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size: " + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor("doc");
        root.accept(searchVisitor);
        System.out.println("Files matching 'doc':");
        for (File f : searchVisitor.getMatchedFiles()) {
            System.out.println("- " + f.getName());
        }
    }
}

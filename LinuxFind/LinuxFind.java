package LinuxFind;
import java.util.ArrayList;
import java.util.List;

class File {
    public String name;
    public int size;
    public int type;
    public boolean isFile;
    List<File> children;

    public File(String name, int size, int type, boolean isFile) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.isFile = false;
        this.children = new ArrayList<>();

    }
}
abstract class Filter {
   public abstract boolean match(File file);
}

class SizeFilter extends Filter {

    public int size;

    public SizeFilter(int size) {
        this.size = size;
    }

    @Override
    public boolean match(File file) {
        
        return file.size > this.size;
    }
    
}

class TypeFilter extends Filter {
    public int type;

    public TypeFilter(int type) {
        this.type = type;
    }

    @Override
    public boolean match(File file) {
        return file.type == this.type;
    }

    
}

class LinuxFind {

    public List<File> result = new ArrayList<>();

    public void findWtihFilters(File directory, List<Filter> filters) {
        if (directory.children == null) return;
        if (directory.isFile) {
            boolean matched = true;
            for (Filter filter : filters) {
                if (!filter.match(directory)) {
                    matched = false;
                }
                if (matched) result.add(directory);
            }
        } else {
            for (File child : directory.children) {
                findWtihFilters(child, filters);
            }
            
        }

    }

}
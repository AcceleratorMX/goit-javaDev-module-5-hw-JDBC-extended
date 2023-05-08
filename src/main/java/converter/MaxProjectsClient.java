package converter;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MaxProjectsClient {
    private String name;
    private int projectCount;

    @Override
    public String toString() {
        return "name='" + name + '\'' + " | projectCount=" + projectCount + "\n";
    }
}
